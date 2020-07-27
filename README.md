# Demo Messaging App

Backend for a Messaging Application in Spring and Java.

## Get Started

To see the app running type on the command line:
`./mvnw clean spring-boot:run`

# TODO
- Add tests (unit and integration)
- Add CI
- Add docs for docker
- Add message queue
- Add more data
- add db constraints
- add more structure inside the modules
- (optional) some front-end with the templating engine

curl -d '{"nickname":"jonas"}' -H "Content-Type: application/json" -X POST http://localhost:8080/users/new
