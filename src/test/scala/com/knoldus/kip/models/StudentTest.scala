package com.knoldus.kip.models
import com.knoldus.kip.Values._
//import com.knoldus.kip.service
/**
  * Created by Neelaksh on 15/7/17.
  */
class StudentTest extends org.scalatest.FunSuite {

  test("find max Marks subject"){
    assert(scorecardAshish.getSubjectWithMaxScore() == subjectMCABN1)
  }

  test("find min marks subject"){
    assert(scorecardAshish.getSubjectWithMinScore() == subjectMCADM1)
  }

  test("get middle name"){
    assert(student3.getMiddleName()=="Wait")
    assert(student1.getMiddleName()=="")
  }

  test("get address"){
    assert(student1.getAddress() == "C-138,sec-22")
    assert(student2.getAddress() == "NA")
  }
}
