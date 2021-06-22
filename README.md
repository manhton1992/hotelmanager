# hotelmanager
Der Hotelmanager ist eine Anwendung, die die Verwaltung des Hotelzimmers ermöglicht

# Description
When the application starts up, three hotel rooms are created with any room number
- One has a minibar and is a double room
- One has a minibar and is a single room
- One does not have a minibar and is a suite
### The data is stored in H2.
- Login to H2-DB:
- http: // localhost: 8080 / h2-console
- JDBC URL: jdbc: h2: file: ./ data / hotel
- Username: hotel
- Password: password

### Prerequisites
What things you need to install the software and how to install them?
- [Java Spring Boot]()
- [JDK 11]()
- [Maven]()
- [H2]()
### Installing
- Clone the project from github
``` sh
git clone git@github.com:manhton1992/hotelmanager.git

- Install
```sh
$ mvn spring-boot:run

 - URIs relative to http://localhost:8080/api
The program has following endpoints:

| Method  | HTTP request | Description |
| ---- | ---------------- | ----------------------------------|
| list  |  GET /rooms| Returns a list of all hotel rooms. |
| list  | GET /rooms:id  | Return a single rom with given id. If there is no activity that has matching id, nothing is returned. |
| insert  |  POST /rooms| Create a new room. The newly created room is returned. |
| delete  |  DELETE /room:id | Delete a room with the given id. The newly deleted room is returned. |
| update  |  PUT /room:id | Update a room with the given id. The newly updated room is returned. |

## Endpoint Document
| Method  | HTTP request |
| ---- | ---------------- | ----------------------------------|

| POST | URL http://localhost:8080/api/rooms |
|       | Data Params : { "size": "SINGLE", "minibar": false } |
|       | Success Response: Code : 201 CREATED |
|       |   Content: { "id": 4, "size": "SINGLE", "minibar": false,
|       |   "created": "2021-03-02T19:50:40.333+00:00" }|
| ---- | ---------------- | ----------------------------------|

| GET | URL http://localhost:8080/api/rooms |
|       | Data Params |
|       | Success Response: Code : 200 OK |
|       |   Content: [{ "id": 1, "size": "DOUBLE", "minibar": true },
|       |   { "id": 2, "size": "SINGLE", "minibar": true },
|       |   { "id": 3, "size": "SUITE", "minibar": false } ]|
| ---- | ---------------- | ----------------------------------|

| GET | URL http://localhost:8080/api/rooms/1 |
|       | Data Params |
|       | Success Response: Code : 200 OK |
|       |   Content: Content: { "id": 1, "size": "DOUBLE", "minibar": true } |
| ---- | ---------------- | ----------------------------------|

| GET | URL http://localhost:8080/api/rooms/101 |
|       | Data Params |
|       | Error Response: Code : 404 Not Found |
|       |   Content: Content: {
|       |   "timestamp": "2021-03-02T20:05:52.213+00:00",
|       |   "status": 404,
|       |   "error": "Not Found",
|       |   "message": "",
|       |   "path": "/api/rooms/100"
|       |   } |
| ---- | ---------------- | ----------------------------------|

| PUST | URL http://localhost:8080/api/rooms/1 |
|       | Data Params { "size": "DOUBLE", "minibar": false }|
|       | Success Response: Code : 200 OK |
|       |   Content: Content: { "id": 1, "size": "DOUBLE", "minibar": false } |
| ---- | ---------------- | ----------------------------------|

| PUST | URL http://localhost:8080/api/rooms/1 |
|       | Data Params { "size": "gfgfgf", "minibar": false }|
|       | Success Response: Code : 400 Bad Request |
|       |   Content: Content: {
|       |   "timestamp": "2021-03-02T20:05:52.213+00:00",
|       |   "status": 400,
|       |   "error": "Bad Request",
|       |   "message": "",
|       |   "path": "/api/rooms/1"
|       |   } |
| ---- | ---------------- | ----------------------------------|

|DELETE | URL http://localhost:8080/api/rooms/1 |
|       | Data Params |
|       | Success Response: Code : 200 OK |
|       |   Content: Content: { "id": 1, "size": "DOUBLE", "minibar": false } |
| ---- | ---------------- | ----------------------------------|

| PUST | URL http://localhost:8080/api/rooms/101 |
|       | Data Params |
|       | Success Response: Code : 404 Not Found |
|       |   Content: Content: {
|       |   "timestamp": "2021-03-02T20:05:52.213+00:00",
|       |   "status": 404,
|       |   "error": "Not Found",
|       |   "message": "",
|       |   "path": "/api/rooms/101"
|       |   } |
| ---- | ---------------- | ----------------------------------|

## Authors

* **Manh Ton Nguyen** 