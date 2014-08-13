class { 'java': }
class { 'maven::maven' : } ->
class { 'sonarqube' :
  version => '3.7.4',
}