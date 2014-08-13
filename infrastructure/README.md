## Infrastructure Setup

### Build Server

The following Software is installed on the build server.

* Jenkins Server (Master)
* Jenkins Slave
* Nginx
* Sonar
* Nexus

### Installation

#### Jenkins Server

Install Jenkins Server including Plugins.

```
sudo puppet module install rtyler-jenkins
sudo puppet apply puppet/jenkins.pp
```

#### Sonar

Install Sonar SQM Server

```
sudo puppet module install maestrodev-sonarqube
sudo puppet apply puppet/sonar.pp
```

#### Nginx

Install Nginx as Proxy Server for Jenkins, Nexus and Sonar.

```
sudo puppet module install jfryman-nginx
sudo puppet apply puppet/nginx.pp
sudo cp puppet/proxy.conf /etc/nginx/conf.d/proxy.conf  
```

#### Nexus

Install Nexus as Artefact Server

```
# create nexus user
sudo su
useradd nexus
cd /usr/local/

# download nexus
wget http://www.sonatype.org/downloads/nexus-latest-bundle.tar.gz

# unzip and configure nexus
tar xvfz nexus-latest-bundle.tar.gz
ln -s nexus-2.8.1-01/ nexus
chown nexus:nexus -R /usr/local/nexus/
ln -s /usr/local/nexus/bin/nexus /etc/init.d/nexus
chmod 755 /etc/init.d/nexus
update-rc.d nexus defaults

# start nexus service
service nexus start

# check logs
tail -f /usr/local/nexus/logs/wrapper.log
```
