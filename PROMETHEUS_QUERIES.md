# Prometheus Query Examples

This document provides example PromQL queries for monitoring the Object Store application.

## Accessing Prometheus UI

1. Start the application with Docker Compose:
   ```bash
   docker-compose up -d
   ```

2. Open Prometheus UI: http://localhost:9090

3. Enter queries in the "Expression" field and click "Execute"

## HTTP Request Metrics

### Request Rate (requests per second)
```promql
rate(http_requests_total[5m])
```

### Request Rate by Method
```promql
sum by (method) (rate(http_requests_total[5m]))
```

### Request Rate by Status Code
```promql
sum by (status) (rate(http_requests_total[5m]))
```

### Request Rate by Endpoint
```promql
sum by (uri) (rate(http_requests_total[5m]))
```

### Total Request Count
```promql
sum(http_requests_total)
```

### Error Rate (4xx and 5xx)
```promql
rate(http_requests_errors[5m])
```

### Error Percentage
```promql
(rate(http_requests_errors[5m]) / rate(http_requests_total[5m])) * 100
```

## Request Latency Metrics

### Average Request Latency
```promql
rate(http_request_duration_seconds_sum[5m]) / rate(http_request_duration_seconds_count[5m])
```

### 50th Percentile (Median) Latency
```promql
histogram_quantile(0.50, rate(http_request_duration_seconds_bucket[5m]))
```

### 95th Percentile Latency
```promql
histogram_quantile(0.95, rate(http_request_duration_seconds_bucket[5m]))
```

### 99th Percentile Latency
```promql
histogram_quantile(0.99, rate(http_request_duration_seconds_bucket[5m]))
```

### Maximum Latency
```promql
http_request_duration_seconds_max
```

### Latency by Endpoint
```promql
histogram_quantile(0.95, sum by (uri, le) (rate(http_request_duration_seconds_bucket[5m])))
```

## Business Metrics

### Total Objects Created
```promql
objectstore_objects_created_total
```

### Total Objects Updated
```promql
objectstore_objects_updated_total
```

### Total Objects Deleted
```promql
objectstore_objects_deleted_total
```

### Total Objects Retrieved
```promql
objectstore_objects_retrieved_total
```

### Object Creation Rate
```promql
rate(objectstore_objects_created_total[5m])
```

### Object Update Rate
```promql
rate(objectstore_objects_retrieved_total[5m])
```

### Total Operations
```promql
objectstore_objects_created_total + objectstore_objects_updated_total + objectstore_objects_deleted_total
```

## API Endpoint Metrics

### Average API Endpoint Latency
```promql
rate(objectstore_api_seconds_sum[5m]) / rate(objectstore_api_seconds_count[5m])
```

### Create/Update Endpoint Latency (95th percentile)
```promql
histogram_quantile(0.95, rate(objectstore_api_create_or_update_seconds_bucket[5m]))
```

### Get by Key Endpoint Latency (95th percentile)
```promql
histogram_quantile(0.95, rate(objectstore_api_get_by_key_seconds_bucket[5m]))
```

### Get All Endpoint Latency (95th percentile)
```promql
histogram_quantile(0.95, rate(objectstore_api_get_all_seconds_bucket[5m]))
```

### Delete Endpoint Latency (95th percentile)
```promql
histogram_quantile(0.95, rate(objectstore_api_delete_seconds_bucket[5m]))
```

## JVM Metrics

### Memory Usage
```promql
jvm_memory_used_bytes{area="heap"}
```

### Memory Usage Percentage
```promql
(jvm_memory_used_bytes{area="heap"} / jvm_memory_max_bytes{area="heap"}) * 100
```

### Thread Count
```promql
jvm_threads_live_threads
```

### GC Pause Time
```promql
rate(jvm_gc_pause_seconds_sum[5m])
```

## System Metrics

### CPU Usage
```promql
system_cpu_usage
```

### Process CPU Usage
```promql
process_cpu_usage
```

## Useful Dashboard Queries

### Request Rate Dashboard
```promql
sum(rate(http_requests_total[5m])) by (method, status)
```

### Top 5 Slowest Endpoints
```promql
topk(5, histogram_quantile(0.95, rate(http_request_duration_seconds_bucket[5m])))
```

### Success vs Error Requests
```promql
sum by (status) (rate(http_requests_total[5m]))
```

### Operations per Minute
```promql
sum(rate(objectstore_objects_created_total[1m]) + rate(objectstore_objects_updated_total[1m]) + rate(objectstore_objects_deleted_total[1m])) * 60
```

## Alerting Examples

### High Error Rate Alert
```promql
(rate(http_requests_errors[5m]) / rate(http_requests_total[5m])) > 0.05
```

### High Latency Alert
```promql
histogram_quantile(0.95, rate(http_request_duration_seconds_bucket[5m])) > 1
```

### Low Request Rate Alert
```promql
rate(http_requests_total[5m]) < 0.1
```

## Tips

1. **Time Ranges:** Adjust the time range in brackets `[5m]` based on your needs:
   - `[1m]` - 1 minute
   - `[5m]` - 5 minutes
   - `[15m]` - 15 minutes
   - `[1h]` - 1 hour

2. **Aggregation:** Use `sum()`, `avg()`, `max()`, `min()` to aggregate metrics

3. **Grouping:** Use `by (label)` to group metrics by specific labels

4. **Filtering:** Use `{label="value"}` to filter metrics

5. **Graph View:** Switch to the "Graph" tab to visualize metrics over time

