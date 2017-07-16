package com.knoldus.kip.service

import org.scalatest.FunSuite
//import com.knoldus.kip.Values._

/**
  * Created by Neelaksh on 15/7/17.
  */
class PostmanTest extends FunSuite {

  val postman = new{} with Postman{}
  val student1id = 1
  val student3id = 3
  test("testGetTheFirstAddressOfFirstYearPerformance") {
    assert(postman.getTheFirstAddressOfFirstYearPerformance(student1id) == "C-138,sec-22")
    assert(postman.getTheFirstAddressOfFirstYearPerformance(student3id)=="na")
  }

}
