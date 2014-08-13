# puppet module install maestrodev-sonarqube

class { 'java': }
class { 'maven::maven' : } ->
class { 'sonarqube' :
  version => '3.7.4',
}
