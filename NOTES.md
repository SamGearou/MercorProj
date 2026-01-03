Share your code (via zip file or github repo): Github
Share how you designed it
* Spring MVC (model, view, controller) pattern
* Controller endpoints
* Health endpoints
* Model
* Repository
* Service
* Unit tests
  * controller
  * service
  * metrics
* Service components
  * app server (tomcat)
  * postgreSQL database
  * prometheus 
  * alertmanager
* Docker setup
  * containers (isolated)
  * improvements
    * image publishing
    * trusted dockerfile base image (maven:3.8.6-openjdk-11-slim)
      * image scanning for vulnerabilities
* Prometheus
  * scrape configs 
  * basic prometheus architecture
  * prometheus metrics in UI
  * alerting rules (alert_rules.yml)
  * alert emails + alert UI
  * improvements
    * better alerting mechanism for teams
    * no limits/restrictions for high cardinality metrics
    * No dashboards for visualizing metrics trends (Grafana, SignalFx, Datadog, etc)
    * 

Share how you observe the system
* docker container logs
* metrics
  * improvements
    * no historical logs, only point in time. Need to leverage a system for shipping + persisting log data (Humio, Splunk, etc)
    * no alerts on logging (in Humio, you can alert on a pre-defined humio query)

Describe what breaks under load
* Large POST requests of data
  * network throughput
  * DB (50TB+)
* Packet loss/increase latency for high QPS to endpoints
  * 

Describe what changes you made to improve it

Describe what would you do if you have more time
* multi-part upload
  * all data may not fit in RAM
    * server side part collection + part removal once the multi-part upload is complete
* checksums for data integrity
* image publishing to a registry
* CI/CD for new changes
  * tests run in CI environment (and potentially as part of CD)
    * hermetic builds (Bazel)
* database metrics 
  * persistent connections
  * Disk utilization
  * read/write QPS
  * DB query latency
* Metrics
  * recording rules (for custom metrics that are expensive to compute each time)
  * Downsampling (reduced granularity)
  * Data sanitation
    * PII, and other critical information shouldn't be visible in metrics and logs
* Historical alerting data
* metric "priorities" during high cardinality situations during a sev
* tagging for docker containers + auto-promotion
  * canary deployments
* RBAC permissions for service containers, DB, etc
* What happens when containers crash? No restarts of containers
  * K8s with deployments + pods
    * K8s pod liveness/readiness probes
    * deployment/pod metrics
    * argocd for rollout
* Security
  * restrict SSH access to hosts (privileged roles, etc)
  * kernel/sysctl tuning on hosts (swap space, tcp buffer sizes, tcp dump locations, etc)
  * containers running with least-privilege
* API rate limiting
* Video/image support in addition to text
* Blob store rather than SQL database for storage
* Integration testing against the current application + dependencies
  * K8s - Sonobuoy (K8s_conformance, custom plugins, etc)
* Support for ARM and AMD images/builds