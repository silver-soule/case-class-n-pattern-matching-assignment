package com.knoldus.kip.service

import com.knoldus.kip.RamDatabase
import com.knoldus.kip.models.{Scorecard, Student}

trait Postman {

  def getTheFirstAddressOfFirstYearPerformance(id: Int): String = {
    RamDatabase.getById(id).flatMap(_.scoreCards.headOption.map(_.student.getAddress())).getOrElse("na")
  }

}


