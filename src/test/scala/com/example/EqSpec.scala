package com.example

import com.example.laws.discipline.EqTests

class EqSpec extends MySpec {
  // TODO #16: Write tests for every Eq instance (Int, String and Person)
  //           using Discipline and the 'checkAll' method
  checkAll("Eq[Int]", EqTests[Int].ruleSet)
  checkAll("Eq[String]", EqTests[Int].ruleSet)
  checkAll("Eq[Person]", EqTests[Person].ruleSet)
}