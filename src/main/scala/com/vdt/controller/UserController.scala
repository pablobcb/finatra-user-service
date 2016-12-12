package com.vdt.controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

case class CreateUserRequest(email: String, password: String)
case class CreateUserResponse(iAAAd: Int)

class UserController extends Controller {

  post("/user") { request: CreateUserRequest =>
    response
      .created
      .json({CreateUserResponse(10)})
      .toFuture
  }
}
