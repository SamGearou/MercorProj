# Object Store Application

A Java Spring Boot application that acts as an object store for text data, with REST API endpoints for reading and writing data to a PostgreSQL database.

**Quick Start with Prometheus & Alerting:**
```bash
docker-compose up -d
# Access application: http://localhost:8080
# Access Prometheus UI: http://localhost:9090
# Access Alertmanager UI: http://localhost:9093
```

**⚠️ Important:** Before starting, configure Gmail App Password in `alertmanager.yml` (see [ALERT_SETUP.md](ALERT_SETUP.md))

## Features

- RESTful API for storing and retrieving text objects
- PostgreSQL database backend
- Automatic database schema creation
- Unique key-based storage with automatic updates
- Timestamp tracking (created_at, updated_at)
- Prometheus metrics for monitoring (endpoint latency, request counts, business metrics)
- Comprehensive logging with configurable log levels

## Prerequisites

### For Local Development
- Java 11 or higher
- Maven 3.6+
- PostgreSQL 14+ (or compatible version)
- macOS, Linux, or Windows

### For Docker Deployment
- Docker 20.10+ and Docker Compose 2.0+ (optional, for containerized deployment)

## Database Setup

### Installing PostgreSQL

#### macOS (using Homebrew)

```bash
# Install PostgreSQL 14
brew install postgresql@14

# Start PostgreSQL service (will auto-start on login)
brew services start postgresql@14
```

#### Linux (Ubuntu/Debian)

```bash
# Update package list
sudo apt update

# Install PostgreSQL
sudo apt install postgresql postgresql-contrib

# Start PostgreSQL service
sudo systemctl start postgresql
sudo systemctl enable postgresql
```

#### Windows

Download and install PostgreSQL from [https://www.postgresql.org/download/windows/](https://www.postgresql.org/download/windows/)

### Creating the Database

1. **Connect to PostgreSQL** (as your default user):
   ```bash
   # macOS (Homebrew)
   /opt/homebrew/opt/postgresql@14/bin/psql -d postgres
   
   # Linux
   sudo -u postgres psql
   
   # Windows (use psql from PostgreSQL installation)
   psql -U postgres
   ```

2. **Create the database**:
   ```sql
   CREATE DATABASE objectstore;
   ```

3. **Create the user** (if not using default postgres user):
   ```sql
   CREATE USER postgres WITH PASSWORD 'postgres' SUPERUSER;
   GRANT ALL PRIVILEGES ON DATABASE objectstore TO postgres;
   ```

4. **Verify the database**:
   ```sql
   \l
   ```
   You should see `objectstore` in the list.

### Database Configuration

The application is configured to connect to PostgreSQL with the following default settings (in `src/main/resources/application.properties`):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/objectstore
spring.datasource.username=postgres
spring.datasource.password=postgres
```

**To change these settings**, edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Running the Application

### Option 1: Using Maven (Recommended for Development)

1. **Navigate to the project directory**:
   ```bash
   cd /path/to/MercorProj
   ```

2. **Ensure PostgreSQL is running**:
   ```bash
   # macOS (Homebrew)
   brew services list | grep postgresql@14
   
   # Linux
   sudo systemctl status postgresql
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`

### Option 2: Using the JAR File

1. **Build the application**:
   ```bash
   mvn clean package
   ```

2. **Run the JAR**:
   ```bash
   java -jar target/MercorProj-1.0-SNAPSHOT.jar
   ```

### Option 3: Using IDE

1. Open the project in your IDE (IntelliJ IDEA, Eclipse, etc.)
2. Run the `ObjectStoreApplication` class
3. The application will start automatically

### Option 4: Using Docker

The application can be run in a Docker container with PostgreSQL included.

#### Prerequisites
- Docker and Docker Compose installed

#### Quick Start with Docker Compose

The easiest way to run the entire stack (application + database):

```bash
# Build and start all services
docker-compose up --build

# Or run in detached mode
docker-compose up -d --build

# View logs
docker-compose logs -f app

# Stop all services
docker-compose down

# Stop and remove volumes (clears database data)
docker-compose down -v
```

The application will be available at `http://localhost:8080` and PostgreSQL at `localhost:5432`.

#### Building the Docker Image

Build the Docker image manually:

```bash
# Build the image
docker build -t objectstore-app:latest .

# Run the container (requires external PostgreSQL)
docker run -d \
  --name objectstore-app \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/objectstore \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=postgres \
  -e LOG_LEVEL=INFO \
  objectstore-app:latest
```

#### Docker Environment Variables

You can configure the application using environment variables:

| Variable | Description | Default |
|----------|-------------|---------|
| `SPRING_DATASOURCE_URL` | PostgreSQL connection URL | `jdbc:postgresql://localhost:5432/objectstore` |
| `SPRING_DATASOURCE_USERNAME` | Database username | `postgres` |
| `SPRING_DATASOURCE_PASSWORD` | Database password | `postgres` |
| `SERVER_PORT` | Application port | `8080` |
| `LOG_LEVEL` | Logging level (ERROR, WARN, INFO, DEBUG, TRACE) | `INFO` |
| `JAVA_OPTS` | JVM options | `-Xmx512m -Xms256m` |

#### Docker Commands

```bash
# Build the image
docker build -t objectstore-app .

# Run container with custom environment variables
docker run -d \
  -p 8080:8080 \
  -e LOG_LEVEL=DEBUG \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/objectstore \
  objectstore-app

# View container logs
docker logs -f objectstore-app

# Execute commands in running container
docker exec -it objectstore-app sh

# Stop and remove container
docker stop objectstore-app
docker rm objectstore-app

# Remove image
docker rmi objectstore-app
```

#### Docker Compose Commands

```bash
# Start services (includes Prometheus)
docker-compose up

# Start in background
docker-compose up -d

# Rebuild and start
docker-compose up --build

# View logs
docker-compose logs -f

# View logs for specific service
docker-compose logs -f app
docker-compose logs -f postgres
docker-compose logs -f prometheus

# Stop services
docker-compose stop

# Stop and remove containers
docker-compose down

# Stop, remove containers and volumes
docker-compose down -v

# Scale services (if needed)
docker-compose up --scale app=2
```

**Note:** When using Docker Compose, the following services are available:
- **Application:** http://localhost:8080
- **Prometheus UI:** http://localhost:9090
- **PostgreSQL:** localhost:5432

#### Health Check

The Docker container includes a health check that monitors the application:

```bash
# Check container health
docker ps

# Inspect health check status
docker inspect --format='{{.State.Health.Status}}' objectstore-app
```

### Configuring Log Levels

The application supports different log levels (ERROR, WARN, INFO, DEBUG, TRACE). You can configure logging in several ways:

#### Method 1: Environment Variable

Set the `LOG_LEVEL` environment variable before starting the application:

```bash
# Set log level to DEBUG
export LOG_LEVEL=DEBUG
mvn spring-boot:run

# Or set it inline
LOG_LEVEL=DEBUG mvn spring-boot:run

# Set log level to ERROR (less verbose)
LOG_LEVEL=ERROR mvn spring-boot:run
```

#### Method 2: Command Line Argument

Pass the log level as a system property:

```bash
# Using Maven
mvn spring-boot:run -Dlogging.level.root=DEBUG

# Using JAR
java -jar target/MercorProj-1.0-SNAPSHOT.jar --logging.level.root=DEBUG

# Set application-specific log level
java -jar target/MercorProj-1.0-SNAPSHOT.jar --logging.level.com.mercor.objectstore=DEBUG
```

#### Method 3: Application Properties

Edit `src/main/resources/application.properties`:

```properties
# Set root log level
logging.level.root=DEBUG

# Set application-specific log level
logging.level.com.mercor.objectstore=DEBUG
```

#### Available Log Levels

- **ERROR**: Only error messages (highest priority)
- **WARN**: Warning and error messages
- **INFO**: Informational, warning, and error messages (default)
- **DEBUG**: Detailed debugging information
- **TRACE**: Very detailed tracing information (most verbose)

#### Log Level Examples

```bash
# Production mode (minimal logging)
LOG_LEVEL=WARN mvn spring-boot:run

# Development mode (detailed logging)
LOG_LEVEL=DEBUG mvn spring-boot:run

# Troubleshooting mode (very detailed)
LOG_LEVEL=TRACE mvn spring-boot:run
```

#### Viewing Logs

Logs are output to the console by default. The log format includes:
- Timestamp
- Thread name
- Log level
- Logger name
- Message

Example log output:
```
2026-01-02 15:55:32.123 [main] INFO  c.m.o.ObjectStoreApplication - Starting Object Store Application...
2026-01-02 15:55:32.456 [main] INFO  c.m.o.c.TextObjectController - TextObjectController initialized
2026-01-02 15:55:33.789 [http-nio-8080-exec-1] INFO  c.m.o.c.TextObjectController - Creating or updating object with key=test-key
```

## Verifying the Application

Once the application is running, you should see output similar to:

```
Started ObjectStoreApplication in X.XXX seconds
Tomcat started on port(s): 8080 (http)
```

The database table `text_objects` will be automatically created on first startup.

## Running Tests

The project includes comprehensive unit tests for both the service and controller layers. The tests use JUnit 5, Mockito, and Spring Boot Test.

### Running All Tests

To run all tests in the project:

```bash
mvn test
```

This will:
- Compile the test code
- Run all unit tests
- Display a summary of test results

**Expected output:**
```
Tests run: 24, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

### Running Specific Test Classes

You can run individual test classes:

```bash
# Run service layer tests only
mvn test -Dtest=TextObjectServiceTest

# Run controller layer tests only
mvn test -Dtest=TextObjectControllerTest
```

### Running Specific Test Methods

To run a specific test method within a test class:

```bash
mvn test -Dtest=TextObjectServiceTest#testSave_NewObject
```

### Test Coverage

The project includes the following test suites:

#### TextObjectServiceTest (10 tests)
- Tests for creating new objects
- Tests for updating existing objects
- Tests for retrieving objects by key
- Tests for listing all objects
- Tests for checking object existence
- Tests for deleting objects
- Edge cases (empty keys, null content)

#### TextObjectControllerTest (14 tests)
- REST API endpoint tests using MockMvc
- Request validation tests
- Success and error response tests
- HTTP status code verification
- JSON response validation

### Running Tests in IDE

Most IDEs provide built-in test runners:

**IntelliJ IDEA:**
1. Right-click on a test class or method
2. Select "Run 'TestName'"
3. Or use the green play button next to test methods

**Eclipse:**
1. Right-click on a test class
2. Select "Run As" → "JUnit Test"

### Test Output

When tests run successfully, you'll see output like:

```
[INFO] Running com.mercor.objectstore.service.TextObjectServiceTest
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.mercor.objectstore.controller.TextObjectControllerTest
[INFO] Tests run: 14, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] Results:
[INFO] Tests run: 24, Failures: 0, Errors: 0, Skipped: 0
```

### Skipping Tests During Build

If you need to skip tests during the build process:

```bash
# Skip tests when packaging
mvn clean package -DskipTests

# Skip tests and compilation
mvn clean package -Dmaven.test.skip=true
```

**Note:** It's recommended to run tests before committing code to ensure everything works correctly.

## API Endpoints

### Base URL
```
http://localhost:8080/api/objects
```

### Health Check Endpoints

The service provides multiple health check endpoints for monitoring and status verification.

#### 1. Custom Health Check (with Database Status)

**GET** `/health`

Returns a comprehensive health status including database connectivity.

**Response** (200 OK when healthy):
```json
{
  "status": "UP",
  "service": "Object Store API",
  "database": "UP"
}
```

**Response** (503 Service Unavailable when unhealthy):
```json
{
  "status": "DOWN",
  "service": "Object Store API",
  "database": "DOWN",
  "databaseError": "Connection refused"
}
```

**Example using curl**:
```bash
curl http://localhost:8080/health
```

#### 2. Simple Health Check

**GET** `/health/simple`

Returns a simple status check without database verification.

**Response** (200 OK):
```json
{
  "status": "UP"
}
```

**Example using curl**:
```bash
curl http://localhost:8080/health/simple
```

#### 3. Spring Boot Actuator Health

**GET** `/actuator/health`

Spring Boot Actuator's built-in health endpoint.

**Response** (200 OK):
```json
{
  "status": "UP"
}
```

**Example using curl**:
```bash
curl http://localhost:8080/actuator/health
```

**Note:** The health check endpoints are useful for:
- Monitoring tools and load balancers
- Kubernetes liveness/readiness probes
- CI/CD pipeline health checks
- Quick service status verification

#### 4. Prometheus Metrics

**GET** `/actuator/prometheus`

Exposes application metrics in Prometheus format for monitoring and alerting.

**Response** (200 OK):
```
# HELP http_requests_total Total number of HTTP requests
# TYPE http_requests_total counter
http_requests_total{application="objectstore",method="POST",status="200",uri="/api/objects"} 5.0

# HELP http_request_duration_seconds HTTP request latency
# TYPE http_request_duration_seconds summary
http_request_duration_seconds{application="objectstore",quantile="0.5"} 0.023
http_request_duration_seconds{application="objectstore",quantile="0.95"} 0.045
http_request_duration_seconds{application="objectstore",quantile="0.99"} 0.089

# HELP objectstore_objects_created_total Total number of objects created
# TYPE objectstore_objects_created_total counter
objectstore_objects_created_total{application="objectstore"} 10.0
```

**Example using curl**:
```bash
curl http://localhost:8080/actuator/prometheus
```

**Available Metrics:**

- **HTTP Metrics:**
  - `http_requests_total` - Total number of HTTP requests (tagged by method, URI, status)
  - `http_request_duration_seconds` - Request latency (with percentiles: 0.5, 0.95, 0.99)
  - `http_requests_errors` - Total number of HTTP errors (4xx, 5xx)

- **Business Metrics:**
  - `objectstore_objects_created_total` - Total objects created
  - `objectstore_objects_updated_total` - Total objects updated
  - `objectstore_objects_deleted_total` - Total objects deleted
  - `objectstore_objects_retrieved_total` - Total objects retrieved

- **Endpoint Metrics:**
  - `objectstore_api_seconds` - API endpoint latency (tagged by endpoint)
  - `objectstore_api_create_or_update_seconds` - Create/update endpoint latency
  - `objectstore_api_get_by_key_seconds` - Get by key endpoint latency
  - `objectstore_api_get_all_seconds` - Get all endpoint latency
  - `objectstore_api_delete_seconds` - Delete endpoint latency

**Prometheus Configuration:**

The project includes a `prometheus.yml` configuration file that's ready to use. When running with Docker Compose, Prometheus is automatically configured to scrape metrics from the application.

#### Running Prometheus Locally

##### Option 1: Using Docker Compose (Recommended)

Prometheus is included in the `docker-compose.yml` file and will start automatically:

```bash
# Start all services including Prometheus
docker-compose up -d

# Check Prometheus is running
docker-compose ps

# View Prometheus logs
docker-compose logs -f prometheus
```

Prometheus UI will be available at: **http://localhost:9090**

##### Option 2: Running Prometheus Standalone

If you want to run Prometheus separately (without Docker Compose):

1. **Download Prometheus:**
   ```bash
   # macOS (using Homebrew)
   brew install prometheus
   
   # Or download from https://prometheus.io/download/
   ```

2. **Run Prometheus:**
   ```bash
   # Navigate to project directory
   cd /path/to/MercorProj
   
   # Run Prometheus with the included config
   prometheus --config.file=prometheus.yml --storage.tsdb.path=./prometheus-data
   ```

3. **Access Prometheus UI:**
   - Open http://localhost:9090 in your browser

##### Option 3: Using Docker (Standalone)

```bash
# Run Prometheus container
docker run -d \
  --name prometheus \
  -p 9090:9090 \
  -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml:ro \
  prom/prometheus:latest
```

#### Using Prometheus UI

Once Prometheus is running, you can query metrics using the Prometheus Query Language (PromQL):

1. **Open Prometheus UI:** http://localhost:9090

2. **Example Queries:**

   **Request Rate (requests per second):**
   ```promql
   rate(http_requests_total[5m])
   ```

   **Request Latency (95th percentile):**
   ```promql
   histogram_quantile(0.95, rate(http_request_duration_seconds_bucket[5m]))
   ```

   **Total Objects Created:**
   ```promql
   objectstore_objects_created_total
   ```

   **Error Rate:**
   ```promql
   rate(http_requests_errors[5m])
   ```

   **API Endpoint Latency:**
   ```promql
   rate(objectstore_api_seconds_sum[5m]) / rate(objectstore_api_seconds_count[5m])
   ```

   **Request Count by Method:**
   ```promql
   sum by (method) (rate(http_requests_total[5m]))
   ```

   **Request Count by Status:**
   ```promql
   sum by (status) (http_requests_total)
   ```

3. **Viewing Targets:**
   - Navigate to **Status → Targets** to verify the application is being scraped
   - The `objectstore` target should show as **UP**

4. **Graphing Metrics:**
   - Enter a query in the "Expression" field
   - Click **Execute**
   - Switch to **Graph** tab to see the visualization
   - Use the time range selector to adjust the time window

#### Prometheus Alerting

The project includes Prometheus Alertmanager for email notifications. Alerts are configured in `alert_rules.yml` and sent via email.

##### Setup Email Alerts

1. **Configure Gmail App Password** (see [ALERT_SETUP.md](ALERT_SETUP.md) for detailed instructions):
   - Enable 2-Step Verification on your Gmail account
   - Generate an App Password at https://myaccount.google.com/apppasswords
   - Update `alertmanager.yml` with your App Password

2. **Start Services:**
   ```bash
   docker-compose up -d
   ```

3. **Access Alertmanager UI:** http://localhost:9090/alerts

##### Test Alert

A test alert is configured that fires immediately to verify email notifications:

- **Alert Name:** TestAlert
- **Purpose:** Verify alerting is working
- **Email Recipient:** samgearou@gmail.com
- **Fires:** Immediately when Prometheus starts

##### Available Alerts

- **TestAlert**: Fires immediately (for testing email setup)
- **HighErrorRate**: Error rate > 5% for 2 minutes
- **CriticalErrorRate**: Error rate > 20% for 1 minute
- **HighLatency**: 95th percentile latency > 1s for 5 minutes
- **CriticalLatency**: 95th percentile latency > 5s for 2 minutes
- **ServiceDown**: Service unavailable for 1 minute
- **LowRequestRate**: Request rate < 0.01 req/s for 10 minutes
- **HighMemoryUsage**: JVM heap > 90% for 5 minutes

##### Viewing Alerts

- **Prometheus Alerts:** http://localhost:9090/alerts
- **Alertmanager UI:** http://localhost:9093
- **Alert Status:** Check Alertmanager for active/firing alerts

For more details, see [ALERT_SETUP.md](ALERT_SETUP.md)

#### Prometheus Configuration File

The `prometheus.yml` file includes:

- **Scrape interval:** 15 seconds (10 seconds for application metrics)
- **Retention:** 30 days (when using Docker Compose)
- **Targets:**
  - Prometheus self-monitoring (localhost:9090)
  - Object Store Application (app:8080)

You can customize the configuration by editing `prometheus.yml`.

#### 5. Metrics Endpoint

**GET** `/actuator/metrics`

Lists all available metric names.

**Example using curl**:
```bash
# List all metrics
curl http://localhost:8080/actuator/metrics

# Get specific metric
curl http://localhost:8080/actuator/metrics/http.requests.total
```

## Example curl Requests

Here are practical curl examples you can use to interact with the API. Make sure the application is running on `http://localhost:8080` before executing these commands.

### 0. Check Service Health

```bash
# Comprehensive health check (includes database status)
curl http://localhost:8080/health

# Simple health check
curl http://localhost:8080/health/simple

# Spring Boot Actuator health check
curl http://localhost:8080/actuator/health
```

**Expected Response:**
```json
{
  "status": "UP",
  "service": "Object Store API",
  "database": "UP"
}
```

### 1. Create a New Text Object

```bash
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "my-first-key", "content": "This is my first text object"}'
```

**Expected Response:**
```json
{
  "id": 1,
  "key": "my-first-key",
  "content": "This is my first text object",
  "createdAt": "2026-01-02T15:41:43.123456",
  "updatedAt": null
}
```

### 2. Create Another Text Object

```bash
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "my-second-key", "content": "This is my second text object with different content"}'
```

### 3. Get a Text Object by Key

```bash
curl http://localhost:8080/api/objects/my-first-key
```

**Expected Response:**
```json
{
  "id": 1,
  "key": "my-first-key",
  "content": "This is my first text object",
  "createdAt": "2026-01-02T15:41:43.123456",
  "updatedAt": null
}
```

### 4. Get All Text Objects

```bash
curl http://localhost:8080/api/objects
```

**Expected Response:**
```json
[
  {
    "id": 1,
    "key": "my-first-key",
    "content": "This is my first text object",
    "createdAt": "2026-01-02T15:41:43.123456",
    "updatedAt": null
  },
  {
    "id": 2,
    "key": "my-second-key",
    "content": "This is my second text object with different content",
    "createdAt": "2026-01-02T15:42:00.123456",
    "updatedAt": null
  }
]
```

### 5. Update an Existing Text Object

```bash
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "my-first-key", "content": "This is the updated content for my first key"}'
```

**Expected Response:**
```json
{
  "id": 1,
  "key": "my-first-key",
  "content": "This is the updated content for my first key",
  "createdAt": "2026-01-02T15:41:43.123456",
  "updatedAt": "2026-01-02T15:45:00.123456"
}
```

### 6. Delete a Text Object

```bash
curl -X DELETE http://localhost:8080/api/objects/my-second-key
```

**Expected Response:** HTTP 204 No Content (empty response body)

### 7. Try to Get a Non-Existent Object

```bash
curl -v http://localhost:8080/api/objects/non-existent-key
```

**Expected Response:** HTTP 404 Not Found

### 8. Try to Delete a Non-Existent Object

```bash
curl -v -X DELETE http://localhost:8080/api/objects/non-existent-key
```

**Expected Response:** HTTP 404 Not Found

### 9. Create Object with Special Characters

```bash
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "special-chars-key", "content": "Content with special chars: !@#$%^&*() and newlines\nand tabs\t"}'
```

### 10. Create Object with JSON Content

```bash
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "json-content-key", "content": "{\"name\": \"John\", \"age\": 30}"}'
```

### 11. Pretty Print JSON Responses

To get formatted JSON output, pipe the response through `jq` (if installed):

```bash
curl http://localhost:8080/api/objects | jq
```

Or use Python for formatting:

```bash
curl http://localhost:8080/api/objects | python -m json.tool
```

### 12. Save Response to File

```bash
curl http://localhost:8080/api/objects -o response.json
```

### 13. Include Response Headers

```bash
curl -i http://localhost:8080/api/objects
```

### 14. Verbose Output (for debugging)

```bash
curl -v -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "debug-key", "content": "Debug content"}'
```

### 15. Test with Invalid Request (Missing Key)

```bash
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"content": "Missing key field"}'
```

**Expected Response:** HTTP 400 Bad Request

### 16. Test with Invalid Request (Empty Key)

```bash
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "", "content": "Empty key"}'
```

**Expected Response:** HTTP 400 Bad Request

### Quick Test Sequence

Run this sequence to test all operations:

```bash
# 1. Create an object
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "test-key", "content": "Initial content"}'

# 2. Retrieve it
curl http://localhost:8080/api/objects/test-key

# 3. Update it
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "test-key", "content": "Updated content"}'

# 4. Get all objects
curl http://localhost:8080/api/objects

# 5. Delete it
curl -X DELETE http://localhost:8080/api/objects/test-key

# 6. Verify it's deleted (should return 404)
curl -v http://localhost:8080/api/objects/test-key
```

### 1. Create or Update a Text Object

**POST** `/api/objects`

Creates a new text object or updates an existing one if the key already exists.

**Request Body**:
```json
{
  "key": "my-unique-key",
  "content": "This is the text content to store"
}
```

**Response** (200 OK):
```json
{
  "id": 1,
  "key": "my-unique-key",
  "content": "This is the text content to store",
  "createdAt": "2026-01-02T15:41:43",
  "updatedAt": null
}
```

**Example using curl**:
```bash
curl -X POST http://localhost:8080/api/objects \
  -H "Content-Type: application/json" \
  -d '{"key": "example-key", "content": "Hello, World!"}'
```

### 2. Get a Text Object by Key

```bash
curl -X GET http://localhost:8080/api/objects/example-key \                                          03:49:53 PM
  -H "Content-Type: application/json"
```

Retrieves a text object by its unique key.

**Response** (200 OK):
```json
{
  "id": 1,
  "key": "example-key",
  "content": "Hello, World!",
  "createdAt": "2026-01-02T15:41:43",
  "updatedAt": null
}
```

**Response** (404 Not Found) if key doesn't exist:
```
(empty response)
```

**Example using curl**:
```bash
curl http://localhost:8080/api/objects/example-key
```

### 3. Get All Text Objects

```bash
curl -X GET http://localhost:8080/api/objects \                                                      03:49:53 PM
  -H "Content-Type: application/json"
```

Retrieves all text objects stored in the database.

**Response** (200 OK):
```json
[
  {
    "id": 1,
    "key": "example-key",
    "content": "Hello, World!",
    "createdAt": "2026-01-02T15:41:43",
    "updatedAt": null
  },
  {
    "id": 2,
    "key": "another-key",
    "content": "Another text object",
    "createdAt": "2026-01-02T15:42:00",
    "updatedAt": "2026-01-02T15:43:00"
  }
]
```

**Example using curl**:
```bash
curl http://localhost:8080/api/objects
```

### 4. Delete a Text Object

**DELETE** `/api/objects/{key}`

Deletes a text object by its unique key.

**Response** (204 No Content) if successful

**Response** (404 Not Found) if key doesn't exist

**Example using curl**:
```bash
curl -X DELETE http://localhost:8080/api/objects/example-key
```

## Database Management

### Viewing Data Directly

Connect to the database:

```bash
# macOS (Homebrew)
PGPASSWORD=postgres /opt/homebrew/opt/postgresql@14/bin/psql -U postgres -d objectstore

# Linux
sudo -u postgres psql -d objectstore
```

Then run SQL queries:

```sql
-- View all objects
SELECT * FROM text_objects;

-- View specific object
SELECT * FROM text_objects WHERE key = 'example-key';

-- Count objects
SELECT COUNT(*) FROM text_objects;
```

### Managing PostgreSQL Service

#### macOS (Homebrew)

```bash
# Start PostgreSQL
brew services start postgresql@14

# Stop PostgreSQL
brew services stop postgresql@14

# Restart PostgreSQL
brew services restart postgresql@14

# Check status
brew services list | grep postgresql@14
```

#### Linux

```bash
# Start PostgreSQL
sudo systemctl start postgresql

# Stop PostgreSQL
sudo systemctl stop postgresql

# Restart PostgreSQL
sudo systemctl restart postgresql

# Check status
sudo systemctl status postgresql

# Enable auto-start on boot
sudo systemctl enable postgresql
```

## Troubleshooting

### Application won't start

1. **Check if PostgreSQL is running**:
   ```bash
   # macOS
   brew services list | grep postgresql
   
   # Linux
   sudo systemctl status postgresql
   ```

2. **Verify database connection**:
   ```bash
   # Test connection
   PGPASSWORD=postgres psql -U postgres -d objectstore -c "SELECT 1;"
   ```

3. **Check application logs** for specific error messages

### Connection refused error

- Ensure PostgreSQL is running on port 5432
- Verify database credentials in `application.properties`
- Check if PostgreSQL is listening: `lsof -i :5432` (macOS/Linux)

### Port 8080 already in use

Change the port in `application.properties`:
```properties
server.port=8081
```

### Database doesn't exist

Create it manually:
```sql
CREATE DATABASE objectstore;
```

## Project Structure

```
MercorProj/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/mercor/objectstore/
│   │   │       ├── ObjectStoreApplication.java    # Main application class
│   │   │       ├── controller/
│   │   │       │   └── TextObjectController.java  # REST API endpoints
│   │   │       ├── model/
│   │   │       │   └── TextObject.java            # Entity model
│   │   │       ├── repository/
│   │   │       │   └── TextObjectRepository.java   # Data access layer
│   │   │       └── service/
│   │   │           └── TextObjectService.java      # Business logic
│   │   └── resources/
│   │       └── application.properties              # Configuration
│   └── test/
│       └── java/
│           └── com/mercor/objectstore/
│               ├── controller/
│               │   └── TextObjectControllerTest.java  # Controller unit tests
│               └── service/
│                   └── TextObjectServiceTest.java      # Service unit tests
├── target/                                         # Build output
└── pom.xml                                         # Maven configuration
```

## Technology Stack

- **Java 11**
- **Spring Boot 2.7.14**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL 14+**
- **Maven**

## License

This project is provided as-is for demonstration purposes.