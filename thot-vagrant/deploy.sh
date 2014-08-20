#!/bin/bash

cp ../thot-app/target/thot.war .

ssh -i ~/.vagrant.d/insecure_private_key vagrant@192.168.33.100 "sudo cp /vagrant/thot.war /var/lib/tomcat7/webapps/"
ssh -i ~/.vagrant.d/insecure_private_key vagrant@192.168.33.100 "sudo service tomcat7 restart"

rm thot.war
