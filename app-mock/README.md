## app-mock

Mock com endpoints basicos para testar gatling

### Endpoints

- POST /hello 201
  - body
     > { "message": "string" }
  - response:
     >   { "id": 1, "message": "Hello World !" }
- GET /hello/1 200
  - response
      >   { "id": 1, "message": "Hello World !" }
- GET /hello 200
  - response
       >   [{ "id": 1, "message": "Hello World !" }]
- PUT /hello/1 201
  - body
      >   { "message": "string" }
  - response:
      >   { "id": 1, "message": "Hello World !" }
- DELETE /hello/1 204
  - response NO_CONTENT