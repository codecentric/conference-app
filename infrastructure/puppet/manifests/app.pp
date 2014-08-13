class ale::application(
  $java_version         = 7,
  $manage_mysql_binding = true,
) {
  
  # manage the used Java version
  if ( $java_version == 6 ) {
    
    package { "openjdk-7-jdk" :
      ensure => absent,
    }
    package { "openjdk-6-jre-lib" :
      ensure => present,
    }

  } elsif ( $java_version == 7 ) {
    
    package { "openjdk-7-jdk" :
      ensure => present,
    }
    package { "openjdk-6-jre-lib" :
      ensure => absent,
    }

  } else {
    err("Java version $java_version is not supported")
  }
  
  # manage Tomcat
  package { "tomcat7" :
    ensure => installed,
  }

  service { "tomcat7" :
    ensure => running,
    require => Package["tomcat7"],
  }

  if ( $manage_mysql_binding ) {

    class { "mysql::bindings" :
      java_enable => true,
    }

    file { "/usr/share/tomcat7/lib/mysql-connector-java.jar" :
      ensure  => link,
      target  => "/usr/share/java/mysql-connector-java.jar",
      require => [ Package["tomcat7"], Class["mysql::bindings"] ],
    }

  }
  
}

class ale::database(
  $username = undef,
  $password = undef,
  $db_name  = 'ale',
) {

  $users = {
    "${username}@localhost" => {
      ensure        => present,
      password_hash => mysql_password($password),
    },
    "${username}@%" => {
      ensure        => present,
      password_hash => mysql_password($password),
    }
  }

  $databases = {
    "$db_name" => {
      ensure  => 'present',
      charset => 'utf8',
    }
  }

  $grants = {
    "${username}@localhost/${db_name}.*" => {
      ensure     => 'present',
      options    => ['GRANT'],
      privileges => ['ALL'],
      table      => "${db_name}.*",
      user       => "${username}@localhost",
    },
    '${username}@%/${db_name}.*' => {
      ensure     => 'present',
      options    => ['GRANT'],
      privileges => ['ALL'],
      table      => "${db_name}.*",
      user       => "${username}@%",
    }
  }

  class { "mysql::server" :
    users             => $users,
    databases         => $databases,
    grants            => $grants,
    override_options  => {
      'mysqld' => {
        'bind-address' => '0.0.0.0',
      }
    }
  }

}

class { 'ale::database' : 
  username => 'ale-admin',
  password => 'ale2014krakau',
  db_name  => 'ale',
}

class { 'ale::application' :
  java_version         => 7,
  manage_mysql_binding => true,
}

Class['ale::database'] -> Class['ale::application']
