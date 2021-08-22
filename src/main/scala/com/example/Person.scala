package com.example

case class Person(name: String, id: Int)

object Person {
  object Instances {
     implicit val eqByName : Eq[Person] = Eq.instance((p1, p2) => {
       Eq[String].eq(p1.name, p2.name)
     })
     implicit val eqById : Eq[Person] = Eq.instance{(p1, p2) =>
       Eq[Int].eq(p1.id, p2.id)
     }
  }
}