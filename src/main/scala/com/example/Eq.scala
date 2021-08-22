package com.example

trait Eq[A] {
  def eq(x: A, y: A): Boolean
}

object Eq {
 def apply[A: Eq]: Eq[A] = implicitly
  def instance[A](f: (A, A) => Boolean): Eq[A] = (x: A, y: A) => f(x, y)

  implicit val stringInstance: Eq[String] = Eq.instance[String]((s1, s2) => s1.compare(s2) == 0)
  implicit val intInstance: Eq[Int] = Eq.instance[Int]((i1, i2) => i1 == i2)

  implicit val personInstance: Eq[Person] = Eq.instance[Person]((p1, p2) =>
     Eq[Int].eq(p1.id, p2.id) && Eq[String].eq(p1.name, p2.name)
  )

  implicit def optionInstance[A](implicit eqA: Eq[A]): Eq[Option[A]] = (x: Option[A], y: Option[A]) => x match {
    case None => y.isEmpty
    case Some(xValue) => y.nonEmpty && eqA.eq(xValue, y.get)
  }

  object Syntax {
    implicit class EqOps[A](val x: A) extends AnyVal{
      def eqTo(y: A)(implicit eqA: Eq[A]): Boolean = eqA.eq(x, y)
    }
  }
}