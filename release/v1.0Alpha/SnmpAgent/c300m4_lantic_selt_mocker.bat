@echo off

title SNMP Aget Simulator V1.0 Alpha

if DEFINED JAVA_HOME goto AFTER_DEFINED

    set JAVA_HOME=fill in here
    
:AFTER_DEFINED


set JAVA=%JAVA_HOME%\bin\java

:Set_classpath
set classpath=%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;

setlocal enabledelayedexpansion

set MAIN_LIB=.\lib
for /f  %%a in ('dir /b "%MAIN_LIB%"') do (
set "classpath=!classpath!;%MAIN_LIB%\%%a"
)


set JAVA_OPTS=-classic -Xdebug -Xnoagent -XX:+PrintGCDetails -verbose:gc -Xloggc:..\log\gc.log -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8789,server=y,suspend=n %JAVA_OPTS%

%JAVA% %JAVA_OPTS% -Xms128m -Xmx768m cdd.zte.nesimulator.linetest.C300MV4LanticSeltAgentStarter 0

pause
