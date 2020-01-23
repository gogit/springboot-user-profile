https://medium.com/@pradeep_thomas/persistence-redefined-using-spring-boot-and-a-single-api-72f3bfd5d160

## Building it

Clone the repo and build it using

user-profile$ mvn clean package

## Running the microservice

user-profile$ java -jar target/user-profile-0.0.1-SNAPSHOT.jar

## Change the password

HTTP POST

http://localhost:8083/api/change-password

<b>Header</b>

Pass the JWT token

Authorization Bearer JhbGciOiJIUzI1NiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWyiwuVrJSKsnIzMsuSUxX0lHKTCxRsjI0Nbc0sDAzMDDXUUqtKIAJWJqBBEqLU4vyEnNTgfq88jPylGoB5dZMxEYAAAA.8X7yRVuPdqvJiYfr_tz3jKy_kwALhLXiIBLVIcOtjtc 

<b>Body</b>

{
	"username": "John",
	"password": "TestPass6789"
}
