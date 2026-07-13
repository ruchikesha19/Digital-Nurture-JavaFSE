#!/bin/bash

echo "========================================================"
echo "       SonarQube Maven Scanner Automator"
echo "========================================================"
echo

read -p "Enter project directory path (Press Enter for current directory): " PROJ_DIR
if [ -z "$PROJ_DIR" ]; then
    PROJ_DIR=$(pwd)
fi

if [ ! -d "$PROJ_DIR" ]; then
    echo "Error: Directory $PROJ_DIR does not exist."
    exit 1
fi

read -p "Enter SonarQube Project Key: " PROJ_KEY
if [ -z "$PROJ_KEY" ]; then
    echo "Error: Project Key is required."
    exit 1
fi

read -p "Enter your SonarQube token: " SONAR_TOKEN
if [ -z "$SONAR_TOKEN" ]; then
    echo "Error: SonarQube token is required."
    exit 1
fi

read -p "Enter SonarQube Project Name (Press Enter to use Project Key): " PROJ_NAME
if [ -z "$PROJ_NAME" ]; then
    PROJ_NAME=$PROJ_KEY
fi

echo
echo "Scanning project in: $PROJ_DIR"
echo "Project Key:        $PROJ_KEY"
echo "Project Name:       $PROJ_NAME"
echo

cd "$PROJ_DIR"
mvn clean verify sonar:sonar \
  -Dsonar.projectKey="$PROJ_KEY" \
  -Dsonar.projectName="$PROJ_NAME" \
  -Dsonar.host.url="http://localhost:9000" \
  -Dsonar.token="$SONAR_TOKEN"

if [ $? -eq 0 ]; then
    echo
    echo "========================================================"
    echo "Scan completed successfully!"
    echo "Check results at: http://localhost:9000/dashboard?id=$PROJ_KEY"
    echo "========================================================"
else
    echo
    echo "Scan failed."
fi
