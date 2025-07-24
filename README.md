# Kotlin Spring Boot
## Hexagonal API
### Docker containers
- PostgreSQL 14.18

> docker run --name kotlin-postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=blog -d -p 5432:5432 postgres:14.
18

> docker start kotlin-postgres