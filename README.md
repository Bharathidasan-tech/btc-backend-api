# Bckent api-services
Backend API, this will store datetime and amount BTC wallet.

## You can Access API: 

API URL for SAVE: http://localhost:8080/api/btc/wallets
HTTP Method: POST

# 1) Store Record Input example:
         {
            "datetime": "2020-10-05T13:30:05+00:00",
            "amount": 1000	
        }

# Output:

        Status: 201 Created
        {
            "amount": 1000,
            "datetime": "2020-10-05T13:30:05.000+00:00"
        }


# 2) Store Record Input example:
API URL for GET : http://localhost:8080/api/btc/wallets?startDatetime=2019-10-05T13:15:05+00:00&endDatetime=2022-10-05T20:15:05+00:00
HTTP Method: GET
# OUTPUT:
    Status: 200 OK
    [
    [
        1001,
        "2020-10-05T13:30:05.000+00:00"
    ],
    [
        1001,
        "2020-10-05T13:30:05.000+00:00"
    ],
    [
        1000,
        "2021-10-05T14:30:05.000+00:00"
    ],
    [
        2000,
        "2022-01-01T01:30:05.000+00:00"
    ]
]

## Environment:
- Java version: 1.8
- Maven version: 3.*
- H2 in-memory Database
- Spring Boot version: 2.6.2

### Development environment setup

Follow the steps to bring up the development environment in your local and access the app.

1) Install Git, Java, Maven </br>
2) Clone the project using "git clone https://github.com/Bharathidasan-tech/btc-backend-api.git" </br>
3) Build in local and Run the below command 
- install: 
   mvn clean install
- run: 
    java -jar target/btc-backend-api-1.0.jar

4) Access the API at http://localhost:8080/<URI_PATH></br>

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job.)


   [SpringBoot]: <https://projects.spring.io/spring-boot/>
   [ReactJS]: https://reactjs.org/
   [Maven]: <https://maven.apache.org>
   [Git]: <https://git-scm.com>
   [Java]: <https://go.java>
   [Nodejs]: https://nodejs.org/en/
   [Docker]: https://www.docker.com/
   [Kubernetes]: https://kubernetes.io/
