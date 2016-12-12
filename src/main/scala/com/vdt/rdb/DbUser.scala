package com.vdt.rdb

import java.util.Optional

import Db.ctx._
import org.joda.time.DateTime

import scala.concurrent.Future

case class User(id: Long, email: String, password: String, dateCreated: DateTime)

object DbUser {
  val users = quote {
    querySchema[User]("usr",
      _.email -> "email",
      _.password -> "password",
      _.dateCreated -> "date_created"
    )
  }

  val getByIdQuery = quote {
    (id: Long) =>
      for {
        u <- query[User]
          .filter(_.id == id)
          .take(1)
      } yield {
        (u.id, u.email, u.dateCreated)
      }
  }


  def getById(id: Long) =
    Db.ctx.run(getByIdQuery)


}
