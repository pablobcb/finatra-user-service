package com.vdt.rdb


import io.getquill.{PostgresAsyncContext, SnakeCase}

object Db {
  lazy val ctx = new PostgresAsyncContext[SnakeCase]("ctx")
}
