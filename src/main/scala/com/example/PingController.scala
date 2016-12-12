package com.example

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.validation.Max

case class CreateUserRequest(email: String, password: String)
case class CreateUserResponse(iAAAd: Int)

class PingController extends Controller {

  get("/ping") { request: Request =>
    info("ping")
    "pong"
  }


  post("/user") { request: CreateUserRequest =>
    response
      .created
      .json({CreateUserResponse(10)})
      .toFuture
  }
}
