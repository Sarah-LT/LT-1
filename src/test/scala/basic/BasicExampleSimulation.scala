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

		val headers_1 = Map(
			"Keep-Alive" -> "115")

		val headers_3 = Map(
			"Keep-Alive" -> "115",
			"Content-Type" -> "application/x-www-form-urlencoded")

		val headers_6 = Map(
			"Accept" -> "application/json, text/javascript, */*; q=0.01",
			"Keep-Alive" -> "115",
			"X-Requested-With" -> "XMLHttpRequest")

		val scn = scenario("Scenario name")
			.exec(
				http("request_1")
					.get("/")
					.headers(headers_1)
					.check(status.is(302)))
			.pause(0 milliseconds, 100 milliseconds)
			.exec(
				http("request_2")
					.get("/public/login.html")
					.headers(headers_1))
			.pause(12, 13)
			.feed(csv("user_information.csv"))


	setUp(scn.inject(rampUsers(10) during  (10))).protocols(httpProtocol)

}
