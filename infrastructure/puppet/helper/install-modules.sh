#!/bin/bash

PUPPET=`which puppet`

if [ -z "$PUPPET" ]; then
  echo "Err: Puppet not installed or not in the path!"
  exit 1
fi

if [ ! -e settings ]; then
  echo "Err: No settings file present!"
  exit 1
fi

source settings

for MODULE in $MODULES; do
  if [ $($PUPPET module list --modulepath $MODULE_PATH | grep $MODULE | wc -l) -eq 1 ]; then
    echo "module '${MODULE}' already installed"
  else
    echo "installing module '${MODULE}' ..."
    puppet module install $MODULE --target-dir $MODULE_PATH
  fi
done

