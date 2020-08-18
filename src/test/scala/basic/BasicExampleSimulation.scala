package basic

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicExampleSimulation extends Simulation {



		val httpProtocol = http
				.baseUrl("http://excilys-bank-web.cloudfoundry.com")
				.acceptCharsetHeader("ISO-8859-1,utf-8;q=0.7,*;q=0.7")
				.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
				.acceptEncodingHeader("gzip, deflate")
				.acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
				.disableFollowRedirect



		val scn = scenario("Scenario name")

			.exec(
				http("request_2")
					.get("https://www.google.com")
			)


	setUp(scn.inject(rampUsers(10) during  (10))).protocols(httpProtocol)

}
