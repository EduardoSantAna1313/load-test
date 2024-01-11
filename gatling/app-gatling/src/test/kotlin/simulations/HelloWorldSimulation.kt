package simulations

import io.gatling.javaapi.core.ChainBuilder
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.ScenarioBuilder
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status
import io.gatling.javaapi.http.HttpProtocolBuilder

class HelloWorldSimulation (

    private val httpProtocol: HttpProtocolBuilder = HelloWorldHttpBuilder.build(),

    private val execGetHello: ChainBuilder = exec(http("/").get("").check(status().`is`(200))),

    private val helloWorldScenario: ScenarioBuilder = scenario("Hello World Scenario").exec(execGetHello)

) : Simulation() {

    init {
        setUp(
            helloWorldScenario.injectOpen(
                constantUsersPerSec(2.0).during(10), // Aquecendo a aplicação
                constantUsersPerSec(2.0).during(10).randomized(), // preparando
                rampUsersPerSec(6.0).to(300.0).during(30) // THIS IS SPARTAAA!!!
            ))
            .protocols(httpProtocol)
    }

}