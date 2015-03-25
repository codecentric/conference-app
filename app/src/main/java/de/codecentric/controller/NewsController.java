package de.codecentric.controller;

import de.codecentric.dao.NewsDao;
import de.codecentric.domain.News;
import de.codecentric.model.NewsFormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/admin/news")
public class NewsController {

    @Autowired
    private NewsDao newsDao;

    @ModelAttribute("newsFormData")
    public NewsFormData getNewsFormData() {
        return new NewsFormData();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getNews(Map<String, Object> modelMap) {
        modelMap.put("newsList", newsDao.getAllNews());
        return "createNews";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView saveNews(ModelMap modelMap, @ModelAttribute("newsFormData") NewsFormData formData) {

        modelMap.put("newsFormData", formData);

        News news = new News();
        news.setText(formData.getText());

        newsDao.saveNews(news);

        return new ModelAndView("redirect:/currentSessions");
    }
}
