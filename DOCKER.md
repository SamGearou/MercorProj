# Docker Deployment Guide

This guide covers deploying the Object Store Application using Docker and Docker Compose.

## Quick Start

**Quick Start with Prometheus & Alerting:**
```bash
docker-compose up -d
# Access application: http://localhost:8080
# Access Prometheus UI: http://localhost:9090
# Access Alertmanager UI: http://localhost:9093
```

**⚠️ Important:** Before starting, configure Gmail App Password in `alertmanager.yml` (see [ALERT_SETUP.md](ALERT_SETUP.md))

## Prerequisites

- Docker 20.10+ 
- Docker Compose 2.0+

## Docker Compose Setup

The easiest way to run the entire stack (application + database + Prometheus + Alertmanager):

### Quick Start with Docker Compose

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

### Services Included

When using Docker Compose, the following services are available:
- **Application:** http://localhost:8080
- **Prometheus UI:** http://localhost:9090
- **Alertmanager UI:** http://localhost:9093
- **PostgreSQL:** localhost:5432

### Docker Compose Commands

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
docker-compose logs -f alertmanager

# Stop services
docker-compose stop

# Stop and remove containers
docker-compose down

# Stop, remove containers and volumes
docker-compose down -v

# Scale services (if needed)
docker-compose up --scale app=2
```

## Building the Docker Image

Build the Docker image manually:

```bash
# Build the image
docker build -t objectstore-app:latest .
```

### Dockerfile Overview

The project includes a multi-stage Dockerfile that:
- Uses Maven to build the application
- Creates a lean runtime image with only the JAR
- Runs as a non-root user for security
- Includes health checks
- Configurable JVM options

## Running Containers

### Running with Docker Compose (Recommended)

This is the recommended approach as it includes all services:

```bash
docker-compose up -d
```

### Running Standalone Container

Run the container manually (requires external PostgreSQL):

```bash
docker run -d \
  --name objectstore-app \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/objectstore \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=postgres \
  -e LOG_LEVEL=INFO \
  objectstore-app:latest
```

### Docker Commands

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

## Environment Variables

You can configure the application using environment variables:

| Variable | Description | Default |
|----------|-------------|---------|
| `SPRING_DATASOURCE_URL` | PostgreSQL connection URL | `jdbc:postgresql://localhost:5432/objectstore` |
| `SPRING_DATASOURCE_USERNAME` | Database username | `postgres` |
| `SPRING_DATASOURCE_PASSWORD` | Database password | `postgres` |
| `SERVER_PORT` | Application port | `8080` |
| `LOG_LEVEL` | Logging level (ERROR, WARN, INFO, DEBUG, TRACE) | `INFO` |
| `JAVA_OPTS` | JVM options | `-Xmx512m -Xms256m` |

### Example: Running with Custom Environment Variables

```bash
docker run -d \
  --name objectstore-app \
  -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/objectstore \
  -e SPRING_DATASOURCE_USERNAME=myuser \
  -e SPRING_DATASOURCE_PASSWORD=mypassword \
  -e LOG_LEVEL=DEBUG \
  -e SERVER_PORT=8080 \
  -e JAVA_OPTS="-Xmx1024m -Xms512m" \
  objectstore-app:latest
```

## Health Checks

The Docker container includes a health check that monitors the application:

```bash
# Check container health
docker ps

# Inspect health check status
docker inspect --format='{{.State.Health.Status}}' objectstore-app
```

The health check uses the `/health/simple` endpoint and runs every 30 seconds.

## Running Prometheus with Docker

### Option 1: Using Docker Compose (Recommended)

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

### Option 2: Running Prometheus Standalone with Docker

```bash
# Run Prometheus container
docker run -d \
  --name prometheus \
  -p 9090:9090 \
  -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml:ro \
  prom/prometheus:latest
```

## Running Alertmanager with Docker

Alertmanager is included in the `docker-compose.yml` file:

```bash
# Start all services including Alertmanager
docker-compose up -d

# View Alertmanager logs
docker-compose logs -f alertmanager
```

Alertmanager UI will be available at: **http://localhost:9093**

**Note:** Make sure to configure `alertmanager.yml` with your Gmail App Password before starting (see [ALERT_SETUP.md](ALERT_SETUP.md)).

## Logging Configuration

### Setting Log Levels in Docker

You can configure log levels using environment variables:

```bash
# Run with DEBUG logging
docker run -d \
  -p 8080:8080 \
  -e LOG_LEVEL=DEBUG \
  objectstore-app:latest

# Run with ERROR logging (minimal output)
docker run -d \
  -p 8080:8080 \
  -e LOG_LEVEL=ERROR \
  objectstore-app:latest
```

### Viewing Logs

```bash
# View all logs
docker-compose logs -f

# View logs for specific service
docker-compose logs -f app

# View last 100 lines
docker-compose logs --tail=100 app

# Follow logs with timestamps
docker-compose logs -f -t app
```

## Volumes and Data Persistence

Docker Compose creates named volumes for data persistence:

- `postgres_data`: PostgreSQL database data
- `prometheus_data`: Prometheus metrics storage
- `alertmanager_data`: Alertmanager state

### Managing Volumes

```bash
# List volumes
docker volume ls

# Inspect volume
docker volume inspect mercorproj_postgres_data

# Remove volumes (⚠️ This deletes all data)
docker-compose down -v

# Backup PostgreSQL data
docker run --rm \
  -v mercorproj_postgres_data:/data \
  -v $(pwd):/backup \
  alpine tar czf /backup/postgres_backup.tar.gz -C /data .
```

## Networking

Docker Compose creates a bridge network (`objectstore-network`) that allows services to communicate:

- Services can reach each other by service name (e.g., `postgres`, `app`, `prometheus`)
- Ports are exposed to the host machine for external access

### Custom Network Configuration

You can modify the network in `docker-compose.yml`:

```yaml
networks:
  objectstore-network:
    driver: bridge
    ipam:
      config:
        - subnet: 172.20.0.0/16
```

## Troubleshooting

### Container won't start

1. **Check logs:**
   ```bash
   docker-compose logs app
   ```

2. **Verify database connection:**
   ```bash
   docker-compose exec app sh
   # Inside container, test connection
   ```

3. **Check container status:**
   ```bash
   docker-compose ps
   ```

### Port conflicts

If ports are already in use, modify `docker-compose.yml`:

```yaml
ports:
  - "8081:8080"  # Change host port
```

### Database connection issues

1. **Verify PostgreSQL is running:**
   ```bash
   docker-compose ps postgres
   ```

2. **Check database credentials:**
   - Verify environment variables in `docker-compose.yml`
   - Ensure database exists

3. **View PostgreSQL logs:**
   ```bash
   docker-compose logs postgres
   ```

### Rebuilding after code changes

```bash
# Rebuild and restart
docker-compose up --build -d

# Or rebuild specific service
docker-compose build app
docker-compose up -d app
```

### Cleaning up

```bash
# Stop and remove containers
docker-compose down

# Remove containers, networks, and volumes
docker-compose down -v

# Remove images
docker-compose down --rmi all

# Remove everything including volumes
docker-compose down -v --rmi all
```

## Production Considerations

### Security

- The Dockerfile runs as a non-root user
- Health checks are configured
- Sensitive data should use secrets management (not hardcoded)

### Resource Limits

Add resource limits in `docker-compose.yml`:

```yaml
services:
  app:
    deploy:
      resources:
        limits:
          cpus: '1'
          memory: 1G
        reservations:
          cpus: '0.5'
          memory: 512M
```

### Environment-Specific Configuration

Use environment files:

```bash
# Create .env file
cat > .env << EOF
SPRING_DATASOURCE_PASSWORD=secure_password
LOG_LEVEL=INFO
EOF

# Docker Compose will automatically load .env
docker-compose up -d
```

## Additional Resources

- [Docker Documentation](https://docs.docker.com/)
- [Docker Compose Documentation](https://docs.docker.com/compose/)
- [Spring Boot Docker Guide](https://spring.io/guides/gs/spring-boot-docker/)

