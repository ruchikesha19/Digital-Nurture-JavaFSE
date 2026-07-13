# SonarQube Local Setup & Project Quality Inspection

This guide walks you through setting up and running **SonarQube** locally using Docker Compose, and running code quality inspection on **Java (Maven/Gradle)**, **.NET**, **Python**, and **Go** projects.

---

## 🚀 Step 1: Spin up SonarQube via Docker Compose

We use a persistent setup with a **PostgreSQL** database backend. This ensures your project settings, scan histories, and dashboards are retained when the containers are stopped or recreated.

### Prerequisites
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running.
- If you are running Docker on Windows with WSL2, ensure your WSL2 VM has sufficient memory allocated.

### Start the Services
Navigate to the [SonarQube directory](file:///r:/cognizant/Digital-Nurture-JavaFSE/Week-4/SonarQube) in your terminal and run:

```bash
docker compose up -d
```

This starts two containers:
1. **sonarqube**: Accessible at `http://localhost:9000`
2. **sonarqube_db**: PostgreSQL 15 database instance

To check the status of the containers:
```bash
docker compose ps
```

To view logs if something is not starting correctly:
```bash
docker compose logs -f
```

---

## 🔐 Step 2: Access & Configure SonarQube

1. Open your browser and navigate to: **[http://localhost:9000](http://localhost:9000)**
2. Log in using the default credentials:
   - **Username**: `admin`
   - **Password**: `admin`
3. Upon first login, SonarQube will prompt you to change your password. Set a strong password and save it securely.

### Generate a Security Token
To run scans from your terminal, you need a security token:
1. From the top-right corner of the SonarQube console, click on your user profile icon $\rightarrow$ **My Account**.
2. Select the **Security** tab.
3. Under **Generate Tokens**:
   - Provide a name (e.g., `local-scanner`).
   - Select the token type (e.g., `User Token`).
   - Choose an expiration period (e.g., `30 days` or `No expiration`).
   - Click **Generate**.
4. **Copy the token immediately**. It will not be shown to you again.

---

## 🔍 Step 3: Run Analysis on Your Project

Below are the configurations and scanner commands for different programming languages.

### 1. Java Projects (Maven)
For Maven projects, you don't need to install any extra scanner. You can use the `sonar-maven-plugin`.

Run the following command from your Maven project root directory (e.g., `r:\cognizant\Digital-Nurture-JavaFSE\Week-4\Microservices\Edge Services and API Gateway with Spring  Boot 3 and Spring Cloud\Exercise-2-Load-Balancing`):

**On Command Prompt (Windows):**
```cmd
mvn clean verify sonar:sonar -Dsonar.projectKey=my-project-key -Dsonar.projectName="My Project Name" -Dsonar.host.url=http://localhost:9000 -Dsonar.token=YOUR_GENERATED_SONAR_TOKEN
```

**On PowerShell / bash:**
```bash
mvn clean verify sonar:sonar \
  -Dsonar.projectKey="my-project-key" \
  -Dsonar.projectName="My Project Name" \
  -Dsonar.host.url="http://localhost:9000" \
  -Dsonar.token="YOUR_GENERATED_SONAR_TOKEN"
```

> [!TIP]
> Alternatively, you can use the pre-built helper script:
> - **Windows**: [scan-maven.bat](file:///r:/cognizant/Digital-Nurture-JavaFSE/Week-4/SonarQube/scan-maven.bat)
> - **Shell**: [scan-maven.sh](file:///r:/cognizant/Digital-Nurture-JavaFSE/Week-4/SonarQube/scan-maven.sh)

---

### 2. Go Projects
To inspect Go code:
1. Install the `sonar-scanner` CLI tool.
2. In your Go project root, create a file named `sonar-project.properties`:
   ```properties
   sonar.projectKey=my-go-project
   sonar.projectName=My Go Project
   sonar.projectVersion=1.0
   sonar.sources=.
   sonar.host.url=http://localhost:9000
   sonar.token=YOUR_GENERATED_SONAR_TOKEN
   sonar.exclusions=**/*_test.go
   sonar.tests=.
   sonar.test.inclusions=**/*_test.go
   sonar.sourceEncoding=UTF-8
   ```
3. Run the scanner command:
   ```bash
   sonar-scanner
   ```

---

## 🛠️ Step 4: Stop the Services

To stop SonarQube and PostgreSQL containers:
```bash
docker compose down
```

To stop containers and **remove the database volumes** (warning: this resets all configurations and scan data!):
```bash
docker compose down -v
```
