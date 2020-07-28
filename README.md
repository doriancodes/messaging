# Demo Messaging App

Backend for a Messaging Application in Spring and Java.

## Get Started

To see the app running type on the command line:
`./mvnw clean spring-boot:run`

# TODO
- Add tests (unit and integration)
- Add docs for docker
- Add message queue
- add db constraints
- add data validation, customized exceptions and check that endpoints report the right status

curl -d '{"nickname":"jonas"}' -H "Content-Type: application/json" -X POST http://localhost:8080/users/new
curl -d '{"content":"Good!","senderId":1, "receiverId": 2}' -H "Content-Type: application/json" -X POST http://localhost:8080/messages/user/send

## Proposed improvements
- Add CI, e.g. through travis ci
- Add dev and prod configurations
- add more structure inside the modules and a service layer between repositories 
and controllers

