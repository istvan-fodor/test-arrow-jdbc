Comment out line 18 to go with TLS. Add `--add-opens=java.base/java.nio=ALL-UNNAMED` to MAVEN_OPTS, then run with `mvn compile exec:java`.

It should print out `Hello, FlightSQL!`

