package com.example

import com.example.laws.discipline.EqTests

class PersonSpec extends MySpec {
  // TODO #17: Write tests for additional Eq instances defined in Person using
  //           Discipline and the 'checkAll' method

  checkAll("Eq[Person].byId", EqTests[Person](Person.Instances.eqById).ruleSet)
  checkAll("Eq[Person].byName", EqTests[Person](Person.Instances.eqByName).ruleSet)
}
