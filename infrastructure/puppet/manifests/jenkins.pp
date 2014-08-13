include jenkins

$plugins = [
  'credentials',
  'ssh-credentials',
  'git-client',
  'scm-api',
  'git',
  'jquery',
  'jobConfigHistory',
  'ldap',
  'parameterized-trigger',
  'external-monitor-job',
  'pam-auth',
  'build-pipeline-plugin',
  'disk-usage',
  'monitoring',
  'appdynamics-dashboard',
  'ColumnsPlugin',
  'ec2',
  'ws-cleanup',
  'envinject'
]

jenkins::plugin { $plugins : }

package { 'git' :
  ensure => installed,
}