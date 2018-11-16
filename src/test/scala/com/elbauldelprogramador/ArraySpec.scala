package com.elbauldelprogramador

import org.scalacheck.Prop._

object fixtures {
  val l = Array(4, 5, 3, 2, 1, 6, 7)
}

// BDD tests
class ArraySpec extends BddSpec {
  import fixtures._

  "TwoSum Problem" - {
    "When computing two sums with target 12" - {
      "Should return indexes 1 and 6" in {
        val result = Arrays twoSums (l, 12)
        assertResult(Some(1 -> 6))(result)
      }
    }
    "When computing two sums with an empty Array" - {
      "Should return None" in {
        val result = Arrays twoSums (Array.empty[Int], 12)
        assertResult(None)(result)
      }
    }
  }

  "MaxArea Probem" - {
    s"When computing max area on ${l.mkString}" - {
      "Should equal to 25" in {
        assertResult(25)(Arrays maxArea l)
      }
    }
    s"When computing max area on an empty Array" - {
      "Should equal to 0" in {
        assertResult(0)(Arrays maxArea Array.empty[Int])
      }
    }
    s"When computing max area on one-element Array" - {
      "Should equal to 0" in {
        assertResult(0)(Arrays maxArea Array(1))
      }
    }
  }
}
