package org.example

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.OpenInjectionStep

class HelloWorldSteps {

    companion object {

        private fun singleCall(): List<OpenInjectionStep> = listOf(
            atOnceUsers(1)
        )

        private fun ntests(n: Int): List<OpenInjectionStep> = listOf(
            atOnceUsers(n)
        )

        private fun stressTest(): List<OpenInjectionStep> = listOf(
            constantUsersPerSec(2.0).during(10), // Aquecendo a aplicação
            constantUsersPerSec(2.0).during(10).randomized(), // preparando
            rampUsersPerSec(6.0).to(300.0).during(30) // THIS IS SPARTAAA!!!
        )

        private fun basic(): List<OpenInjectionStep> = listOf(
            constantUsersPerSec(1.0).during(5), // Aquecendo a aplicação
            nothingFor(2), // wait

            constantUsersPerSec(2.0).during(10).randomized(), // preparando
            nothingFor(2), // wait
            rampUsersPerSec(2.0).to(5.0).during(10) // test
        )

        fun defaultSteps(): List<OpenInjectionStep> {
            val profile = System.getenv("PROFILE")
            if ("SINGLE" === profile)
                return singleCall()

            if ("STRESS" === profile)
                return stressTest()

            if ("BASIC" === profile)
                return basic()

            return ntests(10)
        }

    }

}