package com.elbauldelprogramador

import org.scalatest.{ Matchers, PropSpec }
import org.scalatest.prop.GeneratorDrivenPropertyChecks

abstract class CheckSpec extends PropSpec with GeneratorDrivenPropertyChecks with Matchers
