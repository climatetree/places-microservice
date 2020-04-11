<h1>PostgreSQL Setup Instructions</h1>

To locally create the database schema and populate tables, follow these steps:
1. Download and install postgres on your machine from https://www.postgresql.org/download/ or from https://postgresapp.com/ (faster)
2. Open the terminal or command prompt and enter psql using the command "psql -U <username>"
3. Enter your password
4. Once connected, create a new database using "CREATE DATABASE <dbname>"
5. Exit psql using "exit" command
6. From the command line in the root of this project folder run the postgres sql script in this repository using
  "psql -U <username> -d <dbname> -a -f ./src/main/resources/6510-full-db.sql"
  
  Tutorial for mac: https://www.youtube.com/watch?v=5AOkxqFaYEE
  
  
