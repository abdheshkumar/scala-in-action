/*
 * Copyright 2012 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.scalatest.{ Matchers, WordSpec }

class GenerationSpec extends WordSpec with Matchers {

  "Calling next" should {
    "return an empty Generation for a empty Generation" in {
      new Generation().next.aliveCells shouldEqual Set()
    }
    "return a Generation with a horizontal triple for a Generation with a vertical triple" in {
      new Generation(horizontalTriple).next.aliveCells shouldEqual verticalTriple
    }
    "return a Generation with a vertical triple for a Generation with a horizontal triple" in {
      new Generation(verticalTriple).next.aliveCells shouldEqual horizontalTriple
    }
  }

  val horizontalTriple = Set(Cell(-1, 0), Cell(0, 0), Cell(1, 0))

  val verticalTriple = Set(Cell(0, -1), Cell(0, 0), Cell(0, 1))
}
