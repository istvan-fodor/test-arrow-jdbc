Comment out line 18 to go with TLS. Add `--add-opens=java.base/java.nio=ALL-UNNAMED` to MAVEN_OPTS, then run with `mvn compile exec:java`.

To connect through TLS, set the `USE_TLS` system variable to any value (for example `export USE_TLS=1`). 

This code is supposed to work with the [Arrow RS Flight SQL example](https://github.com/apache/arrow-rs/blob/master/arrow-flight/examples/flight_sql_server.rs)

Expected output (besides tons of log messages) is `Hello, FlightSQL!`

