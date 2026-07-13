@echo off
setlocal enabledelayedexpansion

echo ========================================================
echo        SonarQube Maven Scanner Automator
echo ========================================================
echo.

:: Ask for Project Directory
set /p PROJ_DIR="Enter project directory path (Press Enter for current directory): "
if "%PROJ_DIR%"=="" set PROJ_DIR=%CD%

if not exist "%PROJ_DIR%" (
    echo Error: Directory %PROJ_DIR% does not exist.
    exit /b 1
)

:: Ask for Project Key
set /p PROJ_KEY="Enter SonarQube Project Key: "
if "%PROJ_KEY%"=="" (
    echo Error: Project Key is required.
    exit /b 1
)

:: Ask for SonarQube Token
set /p SONAR_TOKEN="Enter your SonarQube token: "
if "%SONAR_TOKEN%"=="" (
    echo Error: SonarQube token is required.
    exit /b 1
)

:: Project Name can default to Key
set /p PROJ_NAME="Enter SonarQube Project Name (Press Enter to use Project Key): "
if "%PROJ_NAME%"=="" set PROJ_NAME=%PROJ_KEY%

echo.
echo Scanning project in: %PROJ_DIR%
echo Project Key:        %PROJ_KEY%
echo Project Name:       %PROJ_NAME%
echo.

cd /d "%PROJ_DIR%"
call mvn clean verify sonar:sonar -Dsonar.projectKey="%PROJ_KEY%" -Dsonar.projectName="%PROJ_NAME%" -Dsonar.host.url="http://localhost:9000" -Dsonar.token="%SONAR_TOKEN%"

if %ERRORLEVEL% equ 0 (
    echo.
    echo ========================================================
    echo Scan completed successfully!
    echo Check results at: http://localhost:9000/dashboard?id=%PROJ_KEY%
    echo ========================================================
) else (
    echo.
    echo Scan failed with error level %ERRORLEVEL%.
)

pause
