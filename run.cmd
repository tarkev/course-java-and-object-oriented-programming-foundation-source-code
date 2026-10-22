@echo off
rem Compile all examples with the JDK and run one of them.
rem Usage: run.cmd module01.lesson17.example01.Main
cd /d "%~dp0"
if "%~1"=="" (
    echo Usage: run.cmd ^<main class^>, for example: run.cmd module01.lesson17.example01.Main
    echo See README.md for every example's main class.
    exit /b 1
)
if not exist target\classes mkdir target\classes
dir /s /b src\main\java\*.java > target\sources.txt
javac --release 21 -d target\classes @target\sources.txt || exit /b 1
java -cp target\classes %*
