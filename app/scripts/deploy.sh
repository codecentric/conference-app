#!/bin/sh

VERSION=$1
ENVIRONMENT=$2

echo "Deploying Version $VERSION to $ENVIRONMENT"

APP_HOME=/opt/conference-app
REPOSITORY=http://54.93.92.96:8081/artifactory/simple/libs-release-local

if[ "$ENVIRONMENT" == "JAVALAND_PROD_A" ]
then
  SERVER="54.93.219.237"
elif[ "$ENVIRONMENT" == "JAVALAND_STAGING" ]
then
  SERVER="52.28.10.112"
elif[ "$ENVIRONMENT" == "JAVALAND_TEST" ]
then
  SERVER="52.28.14.105"
else
  echo "Stopping Deployment, please provide valide ENVIRONMENT variable"
fi
 
echo "Stopping Java Process on $SERVER"
ssh ubuntu@$SERVER "killall java" || true

echo "Downloading new Version"
ssh ubuntu@$SERVER "rm -rf $APP_HOME/conference-app*.war"
ssh ubuntu@$SERVER "killall java" || true

ssh ubuntu@$SERVER "cd $APP_HOME && sudo wget $REPOSITORY/de/codecentric/conference-app/$VERSION/conference-app-$VERSION.war"

echo "Copying Environment specific Properties"
scp app/config/test.properties "ubuntu@$SERVER:$APP_HOME/application.properties"

sleep 2

echo "Starting Spring Boot App"
ssh -f ubuntu@$SERVER "nohup java -jar $APP_HOME/conference-app-$VERSION.war &"

