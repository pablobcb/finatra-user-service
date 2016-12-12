package com.vdt.controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import org.joda.time.DateTime

case class CreateUserRequest(email: String, password: String)
case class CreateUserResponse(id: Int)

case class FindUserResponse(id:Int, email: String, password: String, dateCreated: DateTime)


class UserController extends Controller {

  get("/user/:id") { request: Request =>
  }

  post("/user") { request: CreateUserRequest =>
    response
      .created
      .json({CreateUserResponse(10)})
      .toFuture
  }
}
