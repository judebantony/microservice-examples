CREATE KEYSPACE IF NOT EXISTS jude_cassandra WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE jude_cassandra;

CREATE TABLE products (
   name TEXT,
   description TEXT,
   price  INT,
   quantity  INT,
   imageUrl TEXT,
   PRIMARY KEY (name, description, price))
   WITH CLUSTERING ORDER BY (name ASC, price ASC, quantity ASC);

