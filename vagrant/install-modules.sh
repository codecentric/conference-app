#!/bin/bash

PUPPET=`which puppet`
MODULE_PATH='/vagrant/modules_ext'
MODULES='puppetlabs-mysql'

if [ -z "$PUPPET" ]; then
  echo "Err: Puppet not installed or not in the path!"
  exit 1
fi

if [ ! -e $MODULE_PATH ]; then
  mkdir $MODULE_PATH
fi

for MODULE in $MODULES; do
  if [ $($PUPPET module list --modulepath $MODULE_PATH | grep $MODULE | wc -l) -eq 1 ]; then
    echo "module '${MODULE}' already installed"
  else
    echo "installing module '${MODULE}' ..."
    puppet module install $MODULE --target-dir $MODULE_PATH
  fi
done
