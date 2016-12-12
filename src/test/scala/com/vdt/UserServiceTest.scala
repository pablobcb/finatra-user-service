package com.vdt

import com.twitter.finagle.http.Status.Ok
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class UserServiceTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new Server)

  "User Service" should {

    "201 with 'id'" in {
      //server.httpGet( path = "/user", andExpect = Ok, withBody = "pong")
    }
  }
}
