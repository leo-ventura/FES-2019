# getting the latest version of mysql available
FROM mysql:latest

# setting our database name as an environment variable
# exposing the mysql password here simplify our process
# and, since it's only being run locally, doesn't affect
# our security
ENV MYSQL_ROOT_PASSWORD mysql-root
ENV MYSQL_DATABASE VoceAluga

# adding our script to initialize the database to the directory
# where every initialization file is put
ADD init.sql /docker-entrypoint-initdb.d/

# exposing port 3306
EXPOSE 3306
