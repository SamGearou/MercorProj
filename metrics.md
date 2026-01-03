# HELP jvm_gc_max_data_size_bytes Max size of long-lived heap memory pool
# TYPE jvm_gc_max_data_size_bytes gauge
jvm_gc_max_data_size_bytes{application="objectstore",} 5.36870912E8
# HELP jvm_threads_daemon_threads The current number of live daemon threads
# TYPE jvm_threads_daemon_threads gauge
jvm_threads_daemon_threads{application="objectstore",} 17.0
# HELP system_load_average_1m The sum of the number of runnable entities queued to available processors and the number of runnable entities running on the available processors averaged over a period of time
# TYPE system_load_average_1m gauge
system_load_average_1m{application="objectstore",} 0.291015625
# HELP tomcat_sessions_rejected_sessions_total
# TYPE tomcat_sessions_rejected_sessions_total counter
tomcat_sessions_rejected_sessions_total{application="objectstore",} 0.0
# HELP disk_total_bytes Total space for path
# TYPE disk_total_bytes gauge
disk_total_bytes{application="objectstore",path="/app/.",} 9.77896124416E11
# HELP executor_completed_tasks_total The approximate total number of tasks that have completed execution
# TYPE executor_completed_tasks_total counter
executor_completed_tasks_total{application="objectstore",name="applicationTaskExecutor",} 0.0
# HELP system_cpu_count The number of processors available to the Java virtual machine
# TYPE system_cpu_count gauge
system_cpu_count{application="objectstore",} 10.0
# HELP process_files_max_files The maximum file descriptor count
# TYPE process_files_max_files gauge
process_files_max_files{application="objectstore",} 1048576.0
# HELP executor_pool_core_threads The core number of threads for the pool
# TYPE executor_pool_core_threads gauge
executor_pool_core_threads{application="objectstore",name="applicationTaskExecutor",} 8.0
# HELP jvm_buffer_count_buffers An estimate of the number of buffers in the pool
# TYPE jvm_buffer_count_buffers gauge
jvm_buffer_count_buffers{application="objectstore",id="mapped",} 0.0
jvm_buffer_count_buffers{application="objectstore",id="direct",} 10.0
# HELP objectstore_api_delete_seconds_max Delete object endpoint
# TYPE objectstore_api_delete_seconds_max gauge
objectstore_api_delete_seconds_max{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="deleteByKey",} 0.0
# HELP objectstore_api_delete_seconds Delete object endpoint
# TYPE objectstore_api_delete_seconds summary
objectstore_api_delete_seconds_count{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="deleteByKey",} 1.0
objectstore_api_delete_seconds_sum{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="deleteByKey",} 0.017685333
# HELP objectstore_api_get_by_key_seconds_max Get object by key endpoint
# TYPE objectstore_api_get_by_key_seconds_max gauge
objectstore_api_get_by_key_seconds_max{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getByKey",} 0.0
# HELP objectstore_api_get_by_key_seconds Get object by key endpoint
# TYPE objectstore_api_get_by_key_seconds summary
objectstore_api_get_by_key_seconds_count{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getByKey",} 5.0
objectstore_api_get_by_key_seconds_sum{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getByKey",} 0.016999833
# HELP jvm_gc_memory_allocated_bytes_total Incremented for an increase in the size of the (young) heap memory pool after one GC to before the next
# TYPE jvm_gc_memory_allocated_bytes_total counter
jvm_gc_memory_allocated_bytes_total{application="objectstore",} 8.8080384E8
# HELP tomcat_sessions_created_sessions_total
# TYPE tomcat_sessions_created_sessions_total counter
tomcat_sessions_created_sessions_total{application="objectstore",} 0.0
# HELP tomcat_sessions_active_max_sessions
# TYPE tomcat_sessions_active_max_sessions gauge
tomcat_sessions_active_max_sessions{application="objectstore",} 0.0
# HELP process_files_open_files The open file descriptor count
# TYPE process_files_open_files gauge
process_files_open_files{application="objectstore",} 27.0
# HELP http_requests_total Total number of HTTP requests
# TYPE http_requests_total counter
http_requests_total{application="objectstore",method="GET",status="200",uri="/api/objects/{key}",} 3.0
http_requests_total{application="objectstore",method="POST",status="400",uri="/api/objects",} 2.0
http_requests_total{application="objectstore",method="POST",status="200",uri="/api/objects",} 4.0
http_requests_total{application="objectstore",method="GET",status="200",uri="/health/simple",} 182.0
http_requests_total{application="objectstore",method="GET",status="404",uri="/api/objects/{key}",} 2.0
http_requests_total{application="objectstore",method="GET",status="200",uri="/health",} 2.0
http_requests_total{application="objectstore",method="DELETE",status="204",uri="/api/objects/{key}",} 1.0
http_requests_total{application="objectstore",method="GET",status="200",uri="/api/objects",} 3.0
http_requests_total{application="objectstore",method="GET",status="200",uri="/api/objects/",} 3.0
# HELP process_cpu_usage The "recent cpu usage" for the Java Virtual Machine process
# TYPE process_cpu_usage gauge
process_cpu_usage{application="objectstore",} 5.55432126194179E-4
# HELP jvm_buffer_total_capacity_bytes An estimate of the total capacity of the buffers in this pool
# TYPE jvm_buffer_total_capacity_bytes gauge
jvm_buffer_total_capacity_bytes{application="objectstore",id="mapped",} 0.0
jvm_buffer_total_capacity_bytes{application="objectstore",id="direct",} 81920.0
# HELP executor_queue_remaining_tasks The number of additional elements that this queue can ideally accept without blocking
# TYPE executor_queue_remaining_tasks gauge
executor_queue_remaining_tasks{application="objectstore",name="applicationTaskExecutor",} 2.147483647E9
# HELP objectstore_api_seconds API endpoint metrics
# TYPE objectstore_api_seconds summary
objectstore_api_seconds_count{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getByKey",} 5.0
objectstore_api_seconds_sum{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getByKey",} 0.017193875
objectstore_api_seconds_count{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getAll",} 6.0
objectstore_api_seconds_sum{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getAll",} 0.042076999
objectstore_api_seconds_count{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="deleteByKey",} 1.0
objectstore_api_seconds_sum{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="deleteByKey",} 0.017728125
objectstore_api_seconds_count{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="createOrUpdate",} 6.0
objectstore_api_seconds_sum{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="createOrUpdate",} 0.126338416
# HELP objectstore_api_seconds_max API endpoint metrics
# TYPE objectstore_api_seconds_max gauge
objectstore_api_seconds_max{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getByKey",} 0.0
objectstore_api_seconds_max{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getAll",} 0.0
objectstore_api_seconds_max{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="deleteByKey",} 0.0
objectstore_api_seconds_max{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="createOrUpdate",} 0.0
# HELP system_cpu_usage The "recent cpu usage" of the system the application is running in
# TYPE system_cpu_usage gauge
system_cpu_usage{application="objectstore",} 0.0022193883284812063
# HELP objectstore_api_create_or_update_seconds_max Create or update object endpoint
# TYPE objectstore_api_create_or_update_seconds_max gauge
objectstore_api_create_or_update_seconds_max{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="createOrUpdate",} 0.0
# HELP objectstore_api_create_or_update_seconds Create or update object endpoint
# TYPE objectstore_api_create_or_update_seconds summary
objectstore_api_create_or_update_seconds_count{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="createOrUpdate",} 6.0
objectstore_api_create_or_update_seconds_sum{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="createOrUpdate",} 0.126048833
# HELP jvm_classes_unloaded_classes_total The total number of classes unloaded since the Java virtual machine has started execution
# TYPE jvm_classes_unloaded_classes_total counter
jvm_classes_unloaded_classes_total{application="objectstore",} 0.0
# HELP jvm_gc_pause_seconds Time spent in GC pause
# TYPE jvm_gc_pause_seconds summary
jvm_gc_pause_seconds_count{action="end of minor GC",application="objectstore",cause="G1 Evacuation Pause",} 5.0
jvm_gc_pause_seconds_sum{action="end of minor GC",application="objectstore",cause="G1 Evacuation Pause",} 0.061
jvm_gc_pause_seconds_count{action="end of minor GC",application="objectstore",cause="Metadata GC Threshold",} 1.0
jvm_gc_pause_seconds_sum{action="end of minor GC",application="objectstore",cause="Metadata GC Threshold",} 0.01
# HELP jvm_gc_pause_seconds_max Time spent in GC pause
# TYPE jvm_gc_pause_seconds_max gauge
jvm_gc_pause_seconds_max{action="end of minor GC",application="objectstore",cause="G1 Evacuation Pause",} 0.0
jvm_gc_pause_seconds_max{action="end of minor GC",application="objectstore",cause="Metadata GC Threshold",} 0.0
# HELP objectstore_objects_retrieved_total Total number of objects retrieved
# TYPE objectstore_objects_retrieved_total counter
objectstore_objects_retrieved_total{application="objectstore",} 3.0
# HELP jvm_memory_usage_after_gc_percent The percentage of long-lived heap pool used after the last GC event, in the range [0..1]
# TYPE jvm_memory_usage_after_gc_percent gauge
jvm_memory_usage_after_gc_percent{application="objectstore",area="heap",pool="long-lived",} 0.03323301672935486
# HELP http_requests_errors_total Total number of HTTP errors
# TYPE http_requests_errors_total counter
http_requests_errors_total{application="objectstore",method="POST",status="400",uri="/api/objects",} 2.0
http_requests_errors_total{application="objectstore",method="GET",status="404",uri="/api/objects/{key}",} 2.0
# HELP jdbc_connections_min Minimum number of idle connections in the pool.
# TYPE jdbc_connections_min gauge
jdbc_connections_min{application="objectstore",name="dataSource",} 10.0
# HELP jvm_gc_memory_promoted_bytes_total Count of positive increases in the size of the old generation memory pool before GC to after GC
# TYPE jvm_gc_memory_promoted_bytes_total counter
jvm_gc_memory_promoted_bytes_total{application="objectstore",} 1.9022816E7
# HELP jdbc_connections_max Maximum number of active connections that can be allocated at the same time.
# TYPE jdbc_connections_max gauge
jdbc_connections_max{application="objectstore",name="dataSource",} 10.0
# HELP hikaricp_connections_usage_seconds Connection usage time
# TYPE hikaricp_connections_usage_seconds summary
hikaricp_connections_usage_seconds_count{application="objectstore",pool="HikariPool-1",} 24.0
hikaricp_connections_usage_seconds_sum{application="objectstore",pool="HikariPool-1",} 0.239
# HELP hikaricp_connections_usage_seconds_max Connection usage time
# TYPE hikaricp_connections_usage_seconds_max gauge
hikaricp_connections_usage_seconds_max{application="objectstore",pool="HikariPool-1",} 0.0
# HELP http_server_requests_seconds Duration of HTTP server request handling
# TYPE http_server_requests_seconds histogram
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.001",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.001048576",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.001398101",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.001747626",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.002097151",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.002446676",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.002796201",} 6.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.003145726",} 8.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.003495251",} 14.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.003844776",} 29.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.004194304",} 59.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.005592405",} 373.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.006990506",} 508.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.008388607",} 526.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.009786708",} 531.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.011184809",} 533.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.01258291",} 534.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.013981011",} 534.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.015379112",} 534.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.016777216",} 535.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.022369621",} 538.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.027962026",} 539.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.033554431",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.039146836",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.044739241",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.050331646",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.055924051",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.061516456",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.067108864",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.089478485",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.111848106",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.134217727",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.156587348",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.178956969",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.20132659",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.223696211",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.246065832",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.268435456",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.357913941",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.447392426",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.536870911",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.626349396",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.715827881",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.805306366",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.894784851",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="0.984263336",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="1.073741824",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="1.431655765",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="1.789569706",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="2.147483647",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="2.505397588",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="2.863311529",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="3.22122547",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="3.579139411",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="3.937053352",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="4.294967296",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="5.726623061",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="7.158278826",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="8.589934591",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="10.021590356",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="11.453246121",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="12.884901886",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="14.316557651",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="15.748213416",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="17.179869184",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="22.906492245",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="28.633115306",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="30.0",} 540.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",le="+Inf",} 540.0
http_server_requests_seconds_count{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",} 540.0
http_server_requests_seconds_sum{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",} 2.912587706
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.001",} 20.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.001048576",} 25.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.001398101",} 68.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.001747626",} 118.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.002097151",} 154.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.002446676",} 166.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.002796201",} 173.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.003145726",} 177.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.003495251",} 178.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.003844776",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.004194304",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.005592405",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.006990506",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.008388607",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.009786708",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.011184809",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.01258291",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.013981011",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.015379112",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.016777216",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.022369621",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.027962026",} 181.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.033554431",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.039146836",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.044739241",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.050331646",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.055924051",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.061516456",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.067108864",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.089478485",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.111848106",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.134217727",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.156587348",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.178956969",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.20132659",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.223696211",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.246065832",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.268435456",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.357913941",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.447392426",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.536870911",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.626349396",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.715827881",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.805306366",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.894784851",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="0.984263336",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="1.073741824",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="1.431655765",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="1.789569706",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="2.147483647",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="2.505397588",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="2.863311529",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="3.22122547",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="3.579139411",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="3.937053352",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="4.294967296",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="5.726623061",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="7.158278826",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="8.589934591",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="10.021590356",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="11.453246121",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="12.884901886",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="14.316557651",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="15.748213416",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="17.179869184",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="22.906492245",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="28.633115306",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="30.0",} 182.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",le="+Inf",} 182.0
http_server_requests_seconds_count{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",} 182.0
http_server_requests_seconds_sum{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",} 0.325220492
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.001",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.001048576",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.001398101",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.001747626",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.002097151",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.002446676",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.002796201",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.003145726",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.003495251",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.003844776",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.004194304",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.005592405",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.006990506",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.008388607",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.009786708",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.011184809",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.01258291",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.013981011",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.015379112",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.016777216",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.022369621",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.027962026",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.033554431",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.039146836",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.044739241",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.050331646",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.055924051",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.061516456",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.067108864",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.089478485",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.111848106",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.134217727",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.156587348",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.178956969",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.20132659",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.223696211",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.246065832",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.268435456",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.357913941",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.447392426",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.536870911",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.626349396",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.715827881",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.805306366",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.894784851",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="0.984263336",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="1.073741824",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="1.431655765",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="1.789569706",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="2.147483647",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="2.505397588",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="2.863311529",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="3.22122547",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="3.579139411",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="3.937053352",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="4.294967296",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="5.726623061",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="7.158278826",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="8.589934591",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="10.021590356",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="11.453246121",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="12.884901886",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="14.316557651",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="15.748213416",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="17.179869184",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="22.906492245",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="28.633115306",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="30.0",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",le="+Inf",} 2.0
http_server_requests_seconds_count{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",} 2.0
http_server_requests_seconds_sum{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",} 0.010731792
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.001",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.001048576",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.001398101",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.001747626",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.002097151",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.002446676",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.002796201",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.003145726",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.003495251",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.003844776",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.004194304",} 0.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.005592405",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.006990506",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.008388607",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.009786708",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.011184809",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.01258291",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.013981011",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.015379112",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.016777216",} 1.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.022369621",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.027962026",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.033554431",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.039146836",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.044739241",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.050331646",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.055924051",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.061516456",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.067108864",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.089478485",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.111848106",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.134217727",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.156587348",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.178956969",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.20132659",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.223696211",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.246065832",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.268435456",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.357913941",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.447392426",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.536870911",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.626349396",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.715827881",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.805306366",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.894784851",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="0.984263336",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="1.073741824",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="1.431655765",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="1.789569706",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="2.147483647",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="2.505397588",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="2.863311529",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="3.22122547",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="3.579139411",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="3.937053352",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="4.294967296",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="5.726623061",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="7.158278826",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="8.589934591",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="10.021590356",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="11.453246121",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="12.884901886",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="14.316557651",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="15.748213416",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="17.179869184",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="22.906492245",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="28.633115306",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="30.0",} 2.0
http_server_requests_seconds_bucket{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",le="+Inf",} 2.0
http_server_requests_seconds_count{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",} 2.0
http_server_requests_seconds_sum{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",} 0.025383667
# HELP http_server_requests_seconds_max Duration of HTTP server request handling
# TYPE http_server_requests_seconds_max gauge
http_server_requests_seconds_max{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/prometheus",} 0.006649084
http_server_requests_seconds_max{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health/simple",} 0.001348375
http_server_requests_seconds_max{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/health",} 0.0
http_server_requests_seconds_max{application="objectstore",exception="None",method="GET",outcome="SUCCESS",status="200",uri="/actuator/health",} 0.0
# HELP objectstore_objects_updated_total Total number of objects updated
# TYPE objectstore_objects_updated_total counter
objectstore_objects_updated_total{application="objectstore",} 1.0
# HELP jvm_gc_overhead_percent An approximation of the percent of CPU time used by GC activities over the last lookback period or since monitoring began, whichever is shorter, in the range [0..1]
# TYPE jvm_gc_overhead_percent gauge
jvm_gc_overhead_percent{application="objectstore",} 0.0
# HELP jvm_memory_committed_bytes The amount of memory in bytes that is committed for the Java virtual machine to use
# TYPE jvm_memory_committed_bytes gauge
jvm_memory_committed_bytes{application="objectstore",area="nonheap",id="CodeHeap 'non-profiled nmethods'",} 8650752.0
jvm_memory_committed_bytes{application="objectstore",area="nonheap",id="Compressed Class Space",} 1.0354688E7
jvm_memory_committed_bytes{application="objectstore",area="nonheap",id="Metaspace",} 7.5153408E7
jvm_memory_committed_bytes{application="objectstore",area="nonheap",id="CodeHeap 'non-nmethods'",} 2555904.0
jvm_memory_committed_bytes{application="objectstore",area="heap",id="G1 Eden Space",} 1.572864E8
jvm_memory_committed_bytes{application="objectstore",area="heap",id="G1 Survivor Space",} 1.1534336E7
jvm_memory_committed_bytes{application="objectstore",area="nonheap",id="CodeHeap 'profiled nmethods'",} 2.5100288E7
jvm_memory_committed_bytes{application="objectstore",area="heap",id="G1 Old Gen",} 1.01711872E8
# HELP jvm_gc_live_data_size_bytes Size of long-lived heap memory pool after reclamation
# TYPE jvm_gc_live_data_size_bytes gauge
jvm_gc_live_data_size_bytes{application="objectstore",} 1.7650144E7
# HELP process_start_time_seconds Start time of the process since unix epoch.
# TYPE process_start_time_seconds gauge
process_start_time_seconds{application="objectstore",} 1.767399002173E9
# HELP jvm_threads_peak_threads The peak live thread count since the Java virtual machine started or peak was reset
# TYPE jvm_threads_peak_threads gauge
jvm_threads_peak_threads{application="objectstore",} 23.0
# HELP http_request_duration_seconds_max HTTP request latency
# TYPE http_request_duration_seconds_max gauge
http_request_duration_seconds_max{application="objectstore",} 0.001
# HELP http_request_duration_seconds HTTP request latency
# TYPE http_request_duration_seconds summary
http_request_duration_seconds{application="objectstore",quantile="0.5",} 9.8304E-4
http_request_duration_seconds{application="objectstore",quantile="0.95",} 9.8304E-4
http_request_duration_seconds{application="objectstore",quantile="0.99",} 9.8304E-4
http_request_duration_seconds_count{application="objectstore",} 202.0
http_request_duration_seconds_sum{application="objectstore",} 0.509
# HELP hikaricp_connections_creation_seconds_max Connection creation time
# TYPE hikaricp_connections_creation_seconds_max gauge
hikaricp_connections_creation_seconds_max{application="objectstore",pool="HikariPool-1",} 0.012
# HELP hikaricp_connections_creation_seconds Connection creation time
# TYPE hikaricp_connections_creation_seconds summary
hikaricp_connections_creation_seconds_count{application="objectstore",pool="HikariPool-1",} 39.0
hikaricp_connections_creation_seconds_sum{application="objectstore",pool="HikariPool-1",} 0.329
# HELP hikaricp_connections_acquire_seconds Connection acquire time
# TYPE hikaricp_connections_acquire_seconds summary
hikaricp_connections_acquire_seconds_count{application="objectstore",pool="HikariPool-1",} 24.0
hikaricp_connections_acquire_seconds_sum{application="objectstore",pool="HikariPool-1",} 0.012419916
# HELP hikaricp_connections_acquire_seconds_max Connection acquire time
# TYPE hikaricp_connections_acquire_seconds_max gauge
hikaricp_connections_acquire_seconds_max{application="objectstore",pool="HikariPool-1",} 0.0
# HELP tomcat_sessions_active_current_sessions
# TYPE tomcat_sessions_active_current_sessions gauge
tomcat_sessions_active_current_sessions{application="objectstore",} 0.0
# HELP jvm_threads_live_threads The current number of live threads including both daemon and non-daemon threads
# TYPE jvm_threads_live_threads gauge
jvm_threads_live_threads{application="objectstore",} 21.0
# HELP executor_pool_max_threads The maximum allowed number of threads in the pool
# TYPE executor_pool_max_threads gauge
executor_pool_max_threads{application="objectstore",name="applicationTaskExecutor",} 2.147483647E9
# HELP process_uptime_seconds The uptime of the Java virtual machine
# TYPE process_uptime_seconds gauge
process_uptime_seconds{application="objectstore",} 5411.545
# HELP jvm_buffer_memory_used_bytes An estimate of the memory that the Java virtual machine is using for this buffer pool
# TYPE jvm_buffer_memory_used_bytes gauge
jvm_buffer_memory_used_bytes{application="objectstore",id="mapped",} 0.0
jvm_buffer_memory_used_bytes{application="objectstore",id="direct",} 81920.0
# HELP logback_events_total Number of log events that were enabled by the effective log level
# TYPE logback_events_total counter
logback_events_total{application="objectstore",level="info",} 53.0
logback_events_total{application="objectstore",level="debug",} 0.0
logback_events_total{application="objectstore",level="warn",} 5.0
logback_events_total{application="objectstore",level="trace",} 0.0
logback_events_total{application="objectstore",level="error",} 0.0
# HELP disk_free_bytes Usable space for path
# TYPE disk_free_bytes gauge
disk_free_bytes{application="objectstore",path="/app/.",} 9.22993025024E11
# HELP jvm_memory_used_bytes The amount of used memory
# TYPE jvm_memory_used_bytes gauge
jvm_memory_used_bytes{application="objectstore",area="nonheap",id="CodeHeap 'non-profiled nmethods'",} 8593408.0
jvm_memory_used_bytes{application="objectstore",area="nonheap",id="Compressed Class Space",} 9330688.0
jvm_memory_used_bytes{application="objectstore",area="nonheap",id="Metaspace",} 7.2650144E7
jvm_memory_used_bytes{application="objectstore",area="nonheap",id="CodeHeap 'non-nmethods'",} 1337088.0
jvm_memory_used_bytes{application="objectstore",area="heap",id="G1 Eden Space",} 4.5088768E7
jvm_memory_used_bytes{application="objectstore",area="heap",id="G1 Survivor Space",} 1.1534336E7
jvm_memory_used_bytes{application="objectstore",area="nonheap",id="CodeHeap 'profiled nmethods'",} 2.5060224E7
jvm_memory_used_bytes{application="objectstore",area="heap",id="G1 Old Gen",} 1.784184E7
# HELP hikaricp_connections_min Min connections
# TYPE hikaricp_connections_min gauge
hikaricp_connections_min{application="objectstore",pool="HikariPool-1",} 10.0
# HELP executor_active_threads The approximate number of threads that are actively executing tasks
# TYPE executor_active_threads gauge
executor_active_threads{application="objectstore",name="applicationTaskExecutor",} 0.0
# HELP application_started_time_seconds Time taken (ms) to start the application
# TYPE application_started_time_seconds gauge
application_started_time_seconds{application="objectstore",main_application_class="com.mercor.objectstore.ObjectStoreApplication",} 2.535
# HELP tomcat_sessions_expired_sessions_total
# TYPE tomcat_sessions_expired_sessions_total counter
tomcat_sessions_expired_sessions_total{application="objectstore",} 0.0
# HELP objectstore_objects_created_total Total number of objects created
# TYPE objectstore_objects_created_total counter
objectstore_objects_created_total{application="objectstore",} 3.0
# HELP hikaricp_connections_idle Idle connections
# TYPE hikaricp_connections_idle gauge
hikaricp_connections_idle{application="objectstore",pool="HikariPool-1",} 10.0
# HELP hikaricp_connections_timeout_total Connection timeout total count
# TYPE hikaricp_connections_timeout_total counter
hikaricp_connections_timeout_total{application="objectstore",pool="HikariPool-1",} 0.0
# HELP objectstore_api_get_all_seconds Get all objects endpoint
# TYPE objectstore_api_get_all_seconds summary
objectstore_api_get_all_seconds_count{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getAll",} 6.0
objectstore_api_get_all_seconds_sum{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getAll",} 0.041718043
# HELP objectstore_api_get_all_seconds_max Get all objects endpoint
# TYPE objectstore_api_get_all_seconds_max gauge
objectstore_api_get_all_seconds_max{application="objectstore",class="com.mercor.objectstore.controller.TextObjectController",exception="none",method="getAll",} 0.0
# HELP application_ready_time_seconds Time taken (ms) for the application to be ready to service requests
# TYPE application_ready_time_seconds gauge
application_ready_time_seconds{application="objectstore",main_application_class="com.mercor.objectstore.ObjectStoreApplication",} 2.561
# HELP jvm_classes_loaded_classes The number of classes that are currently loaded in the Java virtual machine
# TYPE jvm_classes_loaded_classes gauge
jvm_classes_loaded_classes{application="objectstore",} 14248.0
# HELP hikaricp_connections_active Active connections
# TYPE hikaricp_connections_active gauge
hikaricp_connections_active{application="objectstore",pool="HikariPool-1",} 0.0
# HELP jvm_threads_states_threads The current number of threads
# TYPE jvm_threads_states_threads gauge
jvm_threads_states_threads{application="objectstore",state="timed-waiting",} 4.0
jvm_threads_states_threads{application="objectstore",state="terminated",} 0.0
jvm_threads_states_threads{application="objectstore",state="new",} 0.0
jvm_threads_states_threads{application="objectstore",state="runnable",} 6.0
jvm_threads_states_threads{application="objectstore",state="blocked",} 0.0
jvm_threads_states_threads{application="objectstore",state="waiting",} 11.0
# HELP hikaricp_connections Total connections
# TYPE hikaricp_connections gauge
hikaricp_connections{application="objectstore",pool="HikariPool-1",} 10.0
# HELP tomcat_sessions_alive_max_seconds
# TYPE tomcat_sessions_alive_max_seconds gauge
tomcat_sessions_alive_max_seconds{application="objectstore",} 0.0
# HELP jvm_memory_max_bytes The maximum amount of memory in bytes that can be used for memory management
# TYPE jvm_memory_max_bytes gauge
jvm_memory_max_bytes{application="objectstore",area="nonheap",id="CodeHeap 'non-profiled nmethods'",} 1.22912768E8
jvm_memory_max_bytes{application="objectstore",area="nonheap",id="Compressed Class Space",} 1.073741824E9
jvm_memory_max_bytes{application="objectstore",area="nonheap",id="Metaspace",} -1.0
jvm_memory_max_bytes{application="objectstore",area="nonheap",id="CodeHeap 'non-nmethods'",} 5836800.0
jvm_memory_max_bytes{application="objectstore",area="heap",id="G1 Eden Space",} -1.0
jvm_memory_max_bytes{application="objectstore",area="heap",id="G1 Survivor Space",} -1.0
jvm_memory_max_bytes{application="objectstore",area="nonheap",id="CodeHeap 'profiled nmethods'",} 1.22908672E8
jvm_memory_max_bytes{application="objectstore",area="heap",id="G1 Old Gen",} 5.36870912E8
# HELP objectstore_objects_deleted_total Total number of objects deleted
# TYPE objectstore_objects_deleted_total counter
objectstore_objects_deleted_total{application="objectstore",} 1.0
# HELP spring_data_repository_invocations_seconds_max Duration of repository invocations
# TYPE spring_data_repository_invocations_seconds_max gauge
spring_data_repository_invocations_seconds_max{application="objectstore",exception="None",method="findByKey",repository="TextObjectRepository",state="SUCCESS",} 0.0
spring_data_repository_invocations_seconds_max{application="objectstore",exception="None",method="save",repository="TextObjectRepository",state="SUCCESS",} 0.0
spring_data_repository_invocations_seconds_max{application="objectstore",exception="None",method="findAll",repository="TextObjectRepository",state="SUCCESS",} 0.0
spring_data_repository_invocations_seconds_max{application="objectstore",exception="None",method="existsByKey",repository="TextObjectRepository",state="SUCCESS",} 0.0
spring_data_repository_invocations_seconds_max{application="objectstore",exception="None",method="deleteByKey",repository="TextObjectRepository",state="SUCCESS",} 0.0
# HELP spring_data_repository_invocations_seconds Duration of repository invocations
# TYPE spring_data_repository_invocations_seconds summary
spring_data_repository_invocations_seconds_count{application="objectstore",exception="None",method="findByKey",repository="TextObjectRepository",state="SUCCESS",} 9.0
spring_data_repository_invocations_seconds_sum{application="objectstore",exception="None",method="findByKey",repository="TextObjectRepository",state="SUCCESS",} 0.076164667
spring_data_repository_invocations_seconds_count{application="objectstore",exception="None",method="save",repository="TextObjectRepository",state="SUCCESS",} 4.0
spring_data_repository_invocations_seconds_sum{application="objectstore",exception="None",method="save",repository="TextObjectRepository",state="SUCCESS",} 0.019418124
spring_data_repository_invocations_seconds_count{application="objectstore",exception="None",method="findAll",repository="TextObjectRepository",state="SUCCESS",} 6.0
spring_data_repository_invocations_seconds_sum{application="objectstore",exception="None",method="findAll",repository="TextObjectRepository",state="SUCCESS",} 0.024213749
spring_data_repository_invocations_seconds_count{application="objectstore",exception="None",method="existsByKey",repository="TextObjectRepository",state="SUCCESS",} 1.0
spring_data_repository_invocations_seconds_sum{application="objectstore",exception="None",method="existsByKey",repository="TextObjectRepository",state="SUCCESS",} 0.007275458
spring_data_repository_invocations_seconds_count{application="objectstore",exception="None",method="deleteByKey",repository="TextObjectRepository",state="SUCCESS",} 1.0
spring_data_repository_invocations_seconds_sum{application="objectstore",exception="None",method="deleteByKey",repository="TextObjectRepository",state="SUCCESS",} 0.00518825
# HELP hikaricp_connections_pending Pending threads
# TYPE hikaricp_connections_pending gauge
hikaricp_connections_pending{application="objectstore",pool="HikariPool-1",} 0.0
# HELP executor_queued_tasks The approximate number of tasks that are queued for execution
# TYPE executor_queued_tasks gauge
executor_queued_tasks{application="objectstore",name="applicationTaskExecutor",} 0.0
# HELP hikaricp_connections_max Max connections
# TYPE hikaricp_connections_max gauge
hikaricp_connections_max{application="objectstore",pool="HikariPool-1",} 10.0
# HELP executor_pool_size_threads The current number of threads in the pool
# TYPE executor_pool_size_threads gauge
executor_pool_size_threads{application="objectstore",name="applicationTaskExecutor",} 0.0