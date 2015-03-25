#!/bin/sh

##########################################
# 
# 
# Start Key: s
# End Key:   e
#

##########################################
# Variables

JENKINS_URL=http://osswdev.codecentric.de/jenkins
TOKEN=SecurityToken
VERSION=$1

if [[ "$#" == "0" ]];
then
  echo "Please provide the VERSION you want to deploy, i.e. 3.0.0-80"
  exit 1
fi

JUNIT_JOB=commit
STATIC_CODE_ANALYSIS_JOB=sonar-analysis
ACCEPTANCE_TEST_JOB=sonar-analysis
PROVISIONING_JOB=deploy-staging


##########################################
# Utility methods

speak() {
  echo "Speak as $1 -> $2"
  say -v $1 $2  
}

check() {
    echo "Checking Jenkins Job $1 for $2"
    speak ava "$2"
    result=`curl --silent -X GET $JENKINS_URL/job/$1/api/json\?pretty\=true | grep color | head -n 1`
    if [[ "$result" == *"red"* ]];
    then 
      echo "Stopping deployment - $2 - Result $result"
      speak tom "Houston, we have a problem!"
      speak ava "Stopping deployment due to problem with $2"
      exit 1
    else
      speak tom "GO"
    fi
}

##########################################
# Main App

while :
do 
    read -n 1 key
    if [[ $key = "s" ]]
    then
      echo "Starting deployment of version $VERSION"
      speak ava "Running last deployment check now"
      
      check $JUNIT_JOB "Unit Tests"
      check $STATIC_CODE_ANALYSIS_JOB "Static Source Code Analysis"
      check $ACCEPTANCE_TEST_JOB "Acceptance Tests"
      check $PROVISIONING_JOB "Server Provisioning"
           
      speak ava "All systems have a GO"
      speak ava "Starting the deployment countdown"
      speak ava "5"
      speak ava "4" 
      speak ava "3"
      speak ava "2"
      speak ava "1"
      
      NOW=$(date +"%H %M ")
      speak ava "It is $NOW"
      speak ava "A new version of the software will now be deployed to the server"
      curl -X POST "$JENKINS_URL/job/deploy-prod/buildWithParameters?token=$TOKEN&VERSION=$VERSION"
      
    fi

done
