package com.elbauldelprogramador

import org.scalacheck.Prop._

object fixtures {
  val l = Array(4, 5, 3, 2, 1, 6, 7)
}

// BDD tests
class ArraySpec extends BddSpec {
  import fixtures._
  s"An Array $l" - {
    "When computing two sums with target 12" - {
      "Should return indexes 1 and 6" in {
        val result = Arrays.twoSums(l, 12)
        assertResult(Some(1 -> 6))(result)
      }
    }
  }
  "An Empty Array" - {
    "When computing two sums with target 12" - {
      "Should return None" in {
        val result = Arrays.twoSums(Array.empty[Int], 12)
        assertResult(None)(result)
      }
    }
  }
}
