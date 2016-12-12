package com.example

import com.twitter.finagle.http.Status.Ok
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class UserServiceTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new Server)

  "User Service" should {
    "ping" in {
      server.httpGet(
        path = "/ping",
        andExpect = Ok,
        withBody = "pong")
    }
  }
}
