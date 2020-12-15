app=adminlab-1.0.0.jar
pid=$(ps -ef | grep $app | grep -v grep | awk '{ print $2 }')
if [ ! -z "$pid" ]; then
  echo kill -9 $pid
  kill -9 $pid
fi
