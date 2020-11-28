package com.loom

import java.time.Instant
import java.util.concurrent._

import scala.concurrent.{ExecutionContext, Future}

object VThreadInScala extends App {

  implicit val vThread = Executors.newVirtualThreadExecutor()
    .withDeadline(Instant.now().plusSeconds(1))
  implicit val ec = ExecutionContext.fromExecutor(vThread)
  val k = Future(println("H"))
  while(!k.isCompleted){}
}
