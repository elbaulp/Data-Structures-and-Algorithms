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
              log info s"Getting Some($x)"
              Some(x -> h)
            case None ⇒ go(m + (a(h) -> h), i.tail)
          }
      }
    }

    if (a.indices.isEmpty) None
    else go(HashMap.empty[Int, Int], a.indices)
  }
}
