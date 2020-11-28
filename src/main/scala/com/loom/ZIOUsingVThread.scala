package com.loom

import java.io.IOException
import java.util.concurrent._
import zio.console._
import zio._
import zio.internal.Platform

import scala.concurrent.ExecutionContext

object ZIOUsingVThread extends zio.App {
  implicit val vThread: ExecutorService = Executors.newVirtualThreadExecutor()
  override val platform: Platform = Platform.fromExecutionContext(ExecutionContext.fromExecutor(vThread))

  val myAppLogic: ZIO[Console, IOException, Unit] = putStrLn(s"Hello Loom In ZIO")

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = {
    myAppLogic.exitCode
  }
}
