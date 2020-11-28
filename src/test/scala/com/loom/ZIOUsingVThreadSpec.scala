package com.loom

import zio.test.Assertion.equalTo
import zio.test._
import zio.test.environment.TestConsole

object ZIOUsingVThreadSpec extends DefaultRunnableSpec {
  def spec: ZSpec[Environment, Failure] = suite("ZIOUsingVThreadSpec")(
    testM("myAppLogic correctly displays output") {
      for {
        _      <- ZIOUsingVThread.myAppLogic
        output <- TestConsole.output
      } yield assert(output)(equalTo(Vector("Hello Loom In ZIO\n")))
    })
}
