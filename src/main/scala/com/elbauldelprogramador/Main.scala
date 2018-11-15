package com.elbauldelprogramador

import org.slf4j.LoggerFactory

object Hello extends Greeting with App {

  private[this] val log = LoggerFactory.getLogger(Hello.getClass.getSimpleName)

  log.debug(greeting)
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
