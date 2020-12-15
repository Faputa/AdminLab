app=adminlab-1.0.0.jar
d0=$(dirname $0)
nohup java -jar $d0/$app >/dev/null 2>&1 &
