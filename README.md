# Projeto Palíndromos
#### Autor: Leonardo Laranjeira de Oliveira

## Descrição
```
Serviço responsável em processar, verificar e listar palíndromos
 -----------------------
|Java 17                |
|Spring Boot 3.2.3      |
|Swagger - OpenApi 2.3.0|
|MapStruct 1.5.5.Final  |
|H2 Database            |
 -----------------------
```

## Profile de execução do projeto em ambiente local:
```
SPRING.PROFILES.ACTIVE=dev
```

## H2 Console:
#### [H2 Console](http://localhost:8080/h2-console)
```
JDBC URL: jdbc:h2:file:/data/palindromo
username: admin
password: 1234
```

## Swagger:
#### [Swagger-LOCAL](http://localhost:8080/api/palindromos/v1/swagger-ui/index.html)

## Exemplos Curl:

#### POST /palindromos
````
curl --location 'http://localhost:8080/api/palindromos/v1/palindromo' \
--header 'Content-Type: application/json' \
--data '[
 "OSSO",
 "AZFZZZA"
]'
````

#### GET /palindromos
````
curl --location 'http://localhost:8080/api/palindromos/v1/palindromo'
````

## Collection Postman
```Disponível para importação a collection contendo os dois endpoints```

[Palindromo.postman_collection.json](src%2Fmain%2Fresources%2Fcollection%2FPalindromo.postman_collection.json)