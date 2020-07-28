# Demo Messaging App

Backend for a Messaging Application in Spring and Java.
The App starts already with some preloaded data that you can explore 
through a postgres client with the following configuration:
```$xslt
url = jdbc:postgresql://localhost:5432/messaging
username = db
password = admin
```
as described in the `application.properties` file.

The database schema is pretty simple. There are 2 tables, `users` and `messages`
hereby represented with the preloaded data:

`users`:

| id          | nickname    |
| ----------- | ----------- |
| 1           | bob         |
| 2           | maria       |
| 3           | jay         |
| 4           | valerie     |

`messages`:

| id          | content           | sender_id | receiver_id |
| ----------- | -----------       | --------- | ----------- |
| 1           | Hi, how are you?  | 1         | 2           |
| 2           | Fine and you?     | 2         | 1           |


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

---
### POST /users/new

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
---
### POST /messages/user/send

As a user I can send a message to another user identified by their id.

```$xslt
curl -d '{"content":"Good!","senderId":1, "receiverId": 2}' -H "Content-Type: application/json" -X POST http://localhost:8080/messages/user/send
```

should return
```$xslt
{"content":"Good!","senderId":1,"receiverId":2}
```
**Please note**: this endpoint shouldn't allow you to send a message to yourself.

---
### GET /messages/user/{id}/received

As a user I can view all the messages that I've received

```$xslt
curl  http://localhost:8080/messages/user/1/received
```

should return
```$xslt
[{"content":"Fine and you?","senderId":2,"receiverId":1}]
```
---
### GET /messages/user/{id}/sent

As a user I can view all the messages that I've received

```$xslt
curl  http://localhost:8080/messages/user/1/sent
```

should return
```$xslt
[{"content":"Hi, how are you?","senderId":1,"receiverId":2}]
```
---
### GET "/messages/user/{receiverId}/received/from/{senderId}"

As a user I can view all the messages that I've received from a particular user

```$xslt
curl  http://localhost:8080/messages/user/1/received/from/2
```

should return
```$xslt
[{"content":"Fine and you?","senderId":2,"receiverId":1}]
```
## AdminController

Ideally this API is only accessed by some super user (admin) with the right access priviledges.
It's here assumed that an authorization system is in place.

Endpoints:
```$xslt
# it shows all the users in the system
GET /admin/users

# it shows all the messages in the system
GET  /admin/messages
```
---
### GET /admin/users

As admin I can view all the users in the system

```$xslt
curl  http://localhost:8080/admin/users
```

should return
```$xslt
[{"id":1,"nickname":"bob"},{"id":2,"nickname":"maria"},{"id":3,"nickname":"jay"},{"id":4,"nickname":"valerie"}]
```
---
### GET /admin/messages

As admin I can view all the messages in the system. 

```$xslt
curl  http://localhost:8080/admin/messages
```

should return
```$xslt
[{"id":1,"content":"Hi, how are you?","senderId":1,"receiverId":2},{"id":2,"content":"Fine and you?","senderId":2,"receiverId":1}]
```

**Please note**: in a real life scenario we probably don't want to grant an user the access to all messages in the system as this is ethically questionable. This is only meant as theoretical exercise.

# TODO
- Add tests (unit and integration)

## Proposed improvements
- Add CI, e.g. through travis ci
- Add dev and prod configurations
- Add message queue
- add data validation, customized exceptions and check that endpoints report the right status



