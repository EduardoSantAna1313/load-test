package simulations

import io.gatling.javaapi.core.Body
import io.gatling.javaapi.core.ChainBuilder
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.ScenarioBuilder
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status
import io.gatling.javaapi.http.HttpProtocolBuilder
import org.example.HelloWorldHttpBuilder
import org.example.HelloWorldSteps

class HelloWorldSimulation (

    httpProtocol: HttpProtocolBuilder = HelloWorldHttpBuilder.build(),

    private val execGetHello: ChainBuilder =
        // create hello world
        exec(
            http("POST")
            .post ("/hello")
                .body(createBody())
            .check(
                status().`is`(201),
                bodyString().saveAs("responseBody"),
                jsonPath("$.id").saveAs("ID")
            )
        )
        // Print the response body
        .exec{ session ->
            println(session.get("responseBody"))
            session
        }

        // GET/{id}
        .exec(http("GET/{id}").get{s -> "/hello/${s.getString("ID")}"}.check(status().`is`(200)))

        // GET
        .exec(http("GET").get("/hello").check(status().`is`(200)))

        // PUT/{id}
        .exec(
            http("PUT/{id}").put{s -> "/hello/${s.getString("ID")}"}
                .body(createBody())
                .check(status().`is`(201)))

        // DELETE/{id}
        .exec(http("DELETE/{id}").delete{s -> "/hello/${s.getString("ID")}"}.check(status().`is`(204)))

    ,

    helloWorldScenario: ScenarioBuilder = scenario("Hello World Scenario").exec(execGetHello)

) : Simulation() {

    init {

        val steps = HelloWorldSteps.defaultSteps()

        setUp(
            helloWorldScenario.injectOpen(steps)
        )
        .protocols(httpProtocol)
    }

    companion object {

        fun createBody(): Body.WithString = StringBody("""
            {
                "message": "bla"
            }
        """.trimIndent())

    }

}