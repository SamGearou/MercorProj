# Alert Setup Guide

## Gmail App Password Setup

To send emails via Gmail, you need to use an App Password (not your regular Gmail password).

### Steps to Create Gmail App Password:

1. **Enable 2-Step Verification** (if not already enabled):
   - Go to https://myaccount.google.com/security
   - Enable 2-Step Verification

2. **Generate App Password**:
   - Go to https://myaccount.google.com/apppasswords
   - Select "Mail" and "Other (Custom name)"
   - Enter "Prometheus Alertmanager" as the name
   - Click "Generate"
   - Copy the 16-character password (no spaces)

3. **Update Alertmanager Configuration**:
   - Edit `alertmanager.yml`
   - Replace `your-app-password` with your generated App Password
   - Save the file

4. **Restart Alertmanager**:
   ```bash
   docker-compose restart alertmanager
   ```

## Testing Alerts

### Test Alert Rule

A test alert is included in `alert_rules.yml` that will fire immediately:

```yaml
- alert: TestAlert
  expr: vector(1)
  for: 0s
```

This alert will:
- Fire immediately when Prometheus starts
- Send an email to samgearou@gmail.com
- Verify that alerting is working correctly

### Viewing Alerts

1. **Prometheus UI**: http://localhost:9090/alerts
2. **Alertmanager UI**: http://localhost:9093

### Manual Alert Testing

You can also trigger alerts by:

1. **High Error Rate**: Make requests that return errors
2. **High Latency**: Add delays to the application
3. **Service Down**: Stop the application container

## Alert Rules

The following alerts are configured:

- **TestAlert**: Fires immediately (for testing)
- **HighErrorRate**: Error rate > 5% for 2 minutes
- **CriticalErrorRate**: Error rate > 20% for 1 minute
- **HighLatency**: 95th percentile latency > 1s for 5 minutes
- **CriticalLatency**: 95th percentile latency > 5s for 2 minutes
- **ServiceDown**: Service unavailable for 1 minute
- **LowRequestRate**: Request rate < 0.01 req/s for 10 minutes
- **HighMemoryUsage**: JVM heap > 90% for 5 minutes

## Email Configuration

Emails are sent to: **samgearou@gmail.com**

To change the recipient, edit `alertmanager.yml`:
```yaml
receivers:
  - name: 'email-notifications'
    email_configs:
      - to: 'your-email@example.com'
```

## Troubleshooting

### Alerts not firing:
1. Check Prometheus UI: http://localhost:9090/alerts
2. Verify alert rules are loaded
3. Check Prometheus logs: `docker-compose logs prometheus`

### Emails not sending:
1. Verify Gmail App Password is correct
2. Check Alertmanager logs: `docker-compose logs alertmanager`
3. Verify SMTP settings in `alertmanager.yml`
4. Check Alertmanager UI: http://localhost:9093

### Test email manually:
```bash
# Check Alertmanager status
curl http://localhost:9093/api/v1/status

# View alert configuration
curl http://localhost:9093/api/v1/alerts
```

