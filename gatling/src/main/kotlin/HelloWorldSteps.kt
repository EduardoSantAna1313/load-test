package org.example

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.OpenInjectionStep

class HelloWorldSteps {

    companion object {

        private fun singleCall(): List<OpenInjectionStep> = listOf(
            atOnceUsers(1)
        )

        private fun stressTest(): List<OpenInjectionStep> = listOf(
            constantUsersPerSec(2.0).during(10), // Aquecendo a aplicação
            constantUsersPerSec(2.0).during(10).randomized(), // preparando
            rampUsersPerSec(6.0).to(300.0).during(30) // THIS IS SPARTAAA!!!
        )

        fun defaultSteps(): List<OpenInjectionStep> {
            val profile = System.getenv("PROFILE")
            if ("SINGLE" === profile)
                return singleCall()

            return stressTest()
        }

    }

}