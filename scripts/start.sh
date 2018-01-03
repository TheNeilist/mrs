#!/usr/bin/env bash

BUILD_ID=pleaseDontKillMeMRS
nohup java -jar /var/lib/jenkins/workspace/mrs/target/mrs-0.0.1.jar < /dev/null &
MRS_PID=$!
echo MRS_PID > /tmp/mrs-pid
echo "started mrs PID $MRS_PID"