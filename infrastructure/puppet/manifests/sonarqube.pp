class sonar_server(
  $manage_java      = true,
  $openjdk_version  = '7',
  $sonar_version    = '4.3.2',
) {

  # install Java if needed
  if $manage_java {
    package { "openjdk-${openjdk_version}-jdk" :
      ensure => installed,
    }
    # install before SonarQube itself
    Package["openjdk-${openjdk_version}-jdk"] -> Class['sonarqube']
  }

  # set up database
  class { "mysql::server" :
    databases     => {
      'sonar' => {
        ensure  => 'present',
        charset => 'utf8',
      }
    },
    users => {
      "sonar@localhost" => {
        ensure => 'present',
        password_hash => mysql_password('sonar'),
      }
    },
    grants => {
      'sonar@localhost/sonar.*' => {
        ensure     => 'present',
        options    => ['GRANT'],
        privileges => ['ALL'],
        table      => 'sonar.*',
        user       => 'sonar@localhost',
      }
    }
  }

  Class['mysql::server'] -> Class['sonarqube']

  class { 'sonarqube' :
    version => $sonar_version,
    jdbc    => {
      url       => 'jdbc:mysql://localhost:3306/sonar?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true',
      username  => 'sonar',
      password  => 'sonar',
    }
  }

  sonarqube::plugin { 'sonar-build-breaker-plugin' :
    ensure     => 'present',
    groupid    => 'org.codehaus.sonar-plugins',
    artifactid => 'sonar-build-breaker-plugin',
    version    => '1.1',
    notify     => Service['sonar'],
  }

}

include sonar_server
