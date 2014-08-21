package org.ale.thot.selenium;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.util.List;

import org.ale.thot.selenium.pages.Pages;
import org.ale.thot.selenium.steps.StaticSessionSteps;
import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.util.StringUtils;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class WebApplicationTest extends JUnitStories {

	// default
	private static String serverUrl = "http://localhost:8080";
	private static final String SYSTEM_PROPERTY = "server.url";

	private WebDriverBackedSelenium selenium = createSelenium();

	private WebDriverBackedSelenium createSelenium() {
		WebDriver webDriver = new FirefoxDriver();
		if (StringUtils.hasText(System.getProperty(SYSTEM_PROPERTY))) {
			serverUrl = System.getProperty(SYSTEM_PROPERTY);
		}
		WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(
				webDriver, serverUrl);
		return selenium;
	}

	@Override
	public Configuration configuration() {
		SeleniumContext seleniumContext = new SeleniumContext();
		Class<? extends Embeddable> embeddableClass = this.getClass();
		return new SeleniumConfiguration()
				.useSelenium(selenium)
				.useSeleniumContext(seleniumContext)
				.useStepMonitor(
						new SeleniumStepMonitor(selenium, seleniumContext,
								new SilentStepMonitor()))
				.useStoryLoader(new LoadFromClasspath(embeddableClass))
				.useStoryReporterBuilder(
						new StoryReporterBuilder()
								.withCodeLocation(
										codeLocationFromClass(embeddableClass))
								.withDefaultFormats()
								.withFormats(CONSOLE, TXT, HTML, XML));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		Pages pages = new Pages(selenium,
				SeleniumConfiguration.defaultConditionRunner(selenium), "/thot-app");
		return new InstanceStepsFactory(configuration(), TEAR_DOWN_WEB_DRIVER,
				new StaticSessionSteps(pages));
	}

	public Object TEAR_DOWN_WEB_DRIVER = this;

	@AfterStories
	public void tearWebDriverDown() {
		selenium.getWrappedDriver().close();
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(
				codeLocationFromClass(this.getClass()).getFile(),
				asList("**/stories/*.story"), null);
	}

}
