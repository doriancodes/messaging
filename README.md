# Demo Messaging App

Backend for a Messaging Application in Spring and Java.

## Get Started

Make sure that you have `docker` and `docker-compose` installed.
On the command line type 
```$xslt
docker-compose up -d
```
This will make sure that Postgres is running in the background.


To see the app running type on the command line:
```$xslt
./mvnw clean spring-boot:run
```

Now open a browser and test that the app is running correctly by typing:
```$xslt
localhost:8080/hello
```
## API endpoints
### UserController

Endpoints:
```$xslt
# it creates a new user
POST /users/new
```

As a non-user I can create my account by providing my nickname.
```$xslt
curl -d '{"nickname":"dorian"}' -H "Content-Type: application/json" -X POST http://localhost:8080/users/new
```
should return
```$xslt
{"nickname":"dorian"}
```

As users nicknames are unique if I try to save a new user with a nickname that is already in the database I get an error.

**Please note**: This endpoint should return a more graceful message when a nickname is not available 

## MessageController

Endpoints:
```$xslt
# it sends a message to another user identified by their id
POST /messages/user/send

# it finds all messages that the user received
GET  /messages/user/{id}/received

# it finds all messages that the user sent
GET  /messages/user/{id}/sent

# it finds all messages that the user received from a particular user
GET /messages/user/{receiverId}/received/from/{senderId}
```

As a user I can send a message to another user identified by their id.

```$xslt
curl -d '{"content":"Good!","senderId":1, "receiverId": 2}' -H "Content-Type: application/json" -X POST http://localhost:8080/messages/user/send
```

should return
```$xslt
{"content":"Good!","senderId":1,"receiverId":2}
```
**Please note**: this endpoint shouldn't allow you to send a message to yourself.

# TODO
- Add tests (unit and integration)
- add more structure inside the modules and a service layer between repositories 
and controllers

## Proposed improvements
- Add CI, e.g. through travis ci
- Add dev and prod configurations
- Add message queue
- add data validation, customized exceptions and check that endpoints report the right status



