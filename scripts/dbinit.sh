# Se crea la base de datos de votante
PGPASSWORD="admin1234" psql -h localhost -p 5432 -U admin -f init.sql admin
