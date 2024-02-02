# Gatling load tests

Exemplo de teste de carga com gatling.

## Pre-requisitos

Verifique os itens abaixo antes de iniciar o projeto:

 - JDK >17
 - Kotlin
 - Maven
 - Docker

## Setup

Siga os passos abaixo para executar os testes em ambiente local:

1. Rode o app-mock executando o script: 
    ```sh
    app-mock/run.sh
   ```

1. Rode os testes com gatlin usando o plugin maven:
    ```sh
   mvn gatling:test
    ```
