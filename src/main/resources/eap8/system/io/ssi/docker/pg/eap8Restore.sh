#!/bin/bash
# Automaticall generated script for SQL restore

export PGPASSWORD=docker

psql -U postgres -h localhost -c "SELECT pg_terminate_backend(pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = 'eap8' AND pid <> pg_backend_pid();"
psql -U postgres -h localhost -c "SELECT pg_terminate_backend(pg_stat_activity.pid) FROM pg_stat_activity WHERE pg_stat_activity.datname = 'template1' AND pid <> pg_backend_pid();"

psql -U postgres -h localhost -c "DROP DATABASE IF EXISTS eap8;"
psql -U postgres -h localhost -c "DROP USER IF EXISTS eap8;"

psql -U postgres -h localhost -c "CREATE USER eap8 WITH PASSWORD 'tmp';"
psql -U postgres -h localhost -c "ALTER USER eap8 WITH PASSWORD 'jswnevkjnwEGKJNSKIAJNEV';"

psql -U postgres -h localhost -c "CREATE DATABASE eap8 OWNER eap8 ENCODING 'UTF8';"
psql -U postgres -h localhost -c "ALTER ROLE eap8 CONNECTION LIMIT 0;"

psql -U postgres -h localhost -d eap8 -c "REVOKE CREATE ON SCHEMA public FROM PUBLIC;"
psql -U postgres -h localhost -d eap8 -c "GRANT CREATE ON SCHEMA public TO jeesl;"
psql -U postgres -h localhost -d eap8 -c "CREATE EXTENSION postgis;"
psql -U postgres -h localhost -d eap8 -c "CREATE EXTENSION pg_stat_statements;"

psql -U postgres -h localhost -d eap8 -c "GRANT pg_monitor TO eap8;"

date
# pg_restore -U postgres -h localhost -d eap8 --no-owner -j 4 --no-privileges --role=jeesl -n public "/var/lib/postgresql/dump/eap8.sql"

psql -U postgres -h localhost -c "ALTER ROLE eap8 CONNECTION LIMIT -1;"

date
unset PGPASSWORD

