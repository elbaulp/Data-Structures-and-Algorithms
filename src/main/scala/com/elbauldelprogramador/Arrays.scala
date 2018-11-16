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

import org.slf4j.LoggerFactory
import scala.annotation.{ switch, tailrec }
import scala.collection.immutable.HashMap

/**
 * Defines common opperations on Arrays
 *
 * Time complexity of Array:
 *     Head | Tail | Apply | Update
 *       C  |  L   |   C   |   C
 *
 */
object Arrays {
  val log = LoggerFactory.getLogger(this.getClass.getSimpleName)

  /**
   * Compute indices of the two numbers such that they
   * add up to a specific target.
   *
   * Assumptions: Each input would have exactly one solution,
   * the same element can not be used twice.
   *
   * This has efficiency of O(n)
   *
   * @param a Array with the elements
   * @param t target to compute
   * @return Indexes of the two numbers summing t
   */
  def twoSums(a: Array[Int], t: Int): Option[(Int, Int)] = {
    @tailrec
    def go(m: HashMap[Int, Int], i: Range): Option[(Int, Int)] = {

      (i.headOption: @switch) match {
        case None ⇒ None
        case Some(h) ⇒
          (m get (t - a(h)): @switch) match {
            case Some(x) ⇒
              log debug s"Getting Some($x)"
              Some(x -> h)
            case None ⇒ go(m + (a(h) -> h), i.tail)
          }
      }
    }

    if (a.indices.isEmpty) None
    else go(HashMap.empty[Int, Int], a.indices)
  }

  /**
   * Given n non-negative integers a1, a2, ..., an, where each represents a point at
   * coordinate (i, ai), n vertical lines are drawn such that the two endpoints of line
   * i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container such
   * that the container contains the most water.
   *
   * Efficiency: O(n)
   *
   * @param a Array of line heights
   * @return Maximum area
   */
  def maxArea(a: Array[Int]): Int = {
    @tailrec
    def go(l: Int, r: Int)(max: Int): Int = {
      if (l >= r) max
      else {
        val currArea = math.min(a(l), a(r)) * (r - l)
        val area = math.max(max, currArea)
        log debug s"Current area for $l and $r is $currArea"
        log debug s"Max area till now is $area"
        if (a(l) < a(r)) go(l + 1, r)(area)
        else go(l, r - 1)(area)
      }
    }
    go(0, a.size - 1)(0)
  }
}
