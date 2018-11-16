/*
 * Copyright (C) 2018  Alejandro Alcalde
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.elbauldelprogramador

import org.scalacheck.Gen

// Thanks to http://blog.ssanj.net/posts/2016-07-06-how-to-run-scalacheck-from-scalatest-and-generate-html-reports.html
// for help me use scalacheck from scalatest
class ArrayProps extends CheckSpec {
  import fixtures._

  implicit override val generatorDrivenConfig =
    PropertyCheckConfig(
      minSize = 100,
      maxSize = 1000)

  val smallInt = Gen.choose(0, 100)
  val positiveList = Gen.containerOf[Array, Int](Gen choose (1, 1000000) suchThat (_ > 0))

  property("TwoSum: x(i) + x(j) === target") {
    forAll { (x: Array[Int], smallInt: Int) ⇒
      val a = Arrays twoSums (x, smallInt)
      a match {
        case None ⇒ a shouldBe None
        case Some((i, j)) ⇒ x(i) + x(j) shouldBe smallInt
      }
    }
  }

  property("MaxArea: always > 0 for non-empty Arrays") {
    forAll { positiveList: Array[Int] ⇒
      Arrays maxArea (positiveList) should be > 0
    }
  }
}
