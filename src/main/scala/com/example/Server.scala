package com.example

import com.example.controller.PingController
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters, LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.json.modules.FinatraJacksonModule
import com.twitter.finatra.json.utils.CamelCasePropertyNamingStrategy

object ServerMain extends Server

object CustomJacksonModule extends FinatraJacksonModule {
  override val propertyNamingStrategy = CamelCasePropertyNamingStrategy
}

class Server extends HttpServer {

  override def defaultFinatraHttpPort = ":9999"
  override def jacksonModule = CustomJacksonModule
  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[PingController]
  }

}
