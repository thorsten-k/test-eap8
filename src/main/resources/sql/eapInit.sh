#!/bin/bash
# Automaticall generated script for SQL restore

export PGPASSWORD=docker

psql -U postgres -h localhost -c "SELECT pg_terminate_backend(pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = 'eap' AND pid <> pg_backend_pid();"
psql -U postgres -h localhost -c "SELECT pg_terminate_backend(pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = 'template1' AND pid <> pg_backend_pid();"

psql -U postgres -h localhost -c "DROP DATABASE IF EXISTS eap;"
psql -U postgres -h localhost -c "DROP USER IF EXISTS eap;"

psql -U postgres -h localhost -c "CREATE USER eap WITH PASSWORD 'tmp';"
psql -U postgres -h localhost -c "ALTER ROLE eap CONNECTION LIMIT 0;"
psql -U postgres -h localhost -c "ALTER USER eap WITH PASSWORD 'eap';"

psql -U postgres -h localhost -c "CREATE DATABASE eap OWNER eap ENCODING 'UTF8';"
psql -U postgres -h localhost -d eap -c "REVOKE CREATE ON SCHEMA public FROM PUBLIC;"
psql -U postgres -h localhost -d eap -c "GRANT CREATE ON SCHEMA public TO eap;"

psql -U postgres -h localhost -c "ALTER ROLE eap CONNECTION LIMIT -1;"

unset PGPASSWORD
