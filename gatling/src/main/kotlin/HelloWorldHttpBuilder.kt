package org.example

import io.gatling.javaapi.http.HttpDsl
import io.gatling.javaapi.http.HttpProtocolBuilder

class HelloWorldHttpBuilder {

    companion object {
        fun build(): HttpProtocolBuilder {
            return HttpDsl.http.baseUrl("http://localhost:8080")
        }
    }

}