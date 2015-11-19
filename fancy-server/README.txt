This is how you start a service with multiple instances:

java com.mirwais.eval.eureka.FancyServerApplication -Dserver.port=9001 -Deureka.instance.metadataMap.instance=instance1
java com.mirwais.eval.eureka.FancyServerApplication -Dserver.port=9002 -Deureka.instance.metadataMap.instance=instance2
...