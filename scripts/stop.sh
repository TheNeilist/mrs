#!/usr/bin/env bash

if [ -a /tmp/mrs-pid ]
        then
                MRS_PID=$(cat /tmp/mrs-pid)
		echo "Killing process $MRS_PID"
                kill -9 $MRS_PID
                rm -f /tmp/mrs-pid
	else
		echo "mrs pid file does not exist"
fi
