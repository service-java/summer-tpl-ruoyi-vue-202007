@echo off
echo.
echo [info] run
echo.

cd %~dp0
cd ../service-admin/target

set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -jar %JAVA_OPTS% service-admin.jar

cd bin
pause
