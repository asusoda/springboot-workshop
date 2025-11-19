# Soda Workshop on Spring Boot

Link to slides - https://github.com/asusoda/springboot-workshop/blob/master/Springboot%20Workshop.pdf

## Getting Started

### Using the Spring Initializer (Not Recommended)

1. Go to https://start.spring.io/
2. Click on "Add Dependencies" and add "Spring Web"
3. Click on "Generate"
4. Download the zip file and extract it
5. Open the project in your IDE

### Clone this repository (Recommended)

```
git clone https://github.com/asusoda/springboot-workshop.git
```

And then, open the project in your IDE




## Running the API

```
./mvnw spring-boot:run
```

### GET all users (GET /user)

```
curl --location 'http://localhost:8080/user'
```


### CREATE a user (POST /user)

```
curl --location 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--data '{
    "asurite": "sparky",
    "name": "Sun Devil",
    "number": "3689071223"
}'
```

### UPDATE a user (PUT /user/{asurite})

```
curl --location --request PUT 'http://localhost:8080/user/sparky' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Sparky the Sun-Devil",
    "number": "3689071223"
}'
```

### DELETE a user (DELETE /user)

```
curl --location --request DELETE 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--data '{
    "asurite": "sparky"
}'
```