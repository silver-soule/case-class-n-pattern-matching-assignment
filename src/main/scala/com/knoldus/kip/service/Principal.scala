package com.knoldus.kip.service

import com.knoldus.kip.RamDatabase
import com.knoldus.kip.models._

trait Principal {


  def findOutIfCSE(id: Int): CoursePerformance = {
    /*
    * returns object of coursePerformance if id is valid and course
    * is cse otherwise error is raised
    * */
    val courseperformance = RamDatabase.getById(id)
    courseperformance.map(_.course.name).getOrElse("") match {
      case "CSE" => courseperformance.get
    }
  }

  def findOutIfAnyCourse(id: Int, courseName: String): CoursePerformance = {
    val expr = RamDatabase.getById(id).map(_.course.name) getOrElse ("na")
    expr match {
      case courseName => RamDatabase.getById(id).get
      //case _ => false
    }
  }

  def expression(mod: Any): String = {
    mod match {
      case _: Student => "Shut up"
      case _: Scorecard => "Hmmm .... "
      case _: Subject => "aha"
      case _ => "!!! ???"
    }
  }

  def getStudentList(scorecards: List[Scorecard]): List[String] = {
    for {scorecard <- scorecards
         subject = scorecard.getSubjectWithMaxScore()
    } yield scorecard.student.firstName + subject.name + subject.obtainedMarks
  }


  def checkScorecard(scorecards: List[Scorecard]) :List[String] = {
    val ssuom = scorecards.flatMap((x)=>x.subjects.map((y)=>(x.student.firstName,y.id,y.obtainedMarks)))
    ssuom.groupBy(_._2).mapValues((x)=>x.maxBy(_._3)._1).values.toList
  }


  def expressionRevisited : PartialFunction[ModelIdentifier, String] = {
    case _: Student => "Shut up"
    case _: Scorecard => "Hmmm .... "
    case _: Subject => "aha"
    //case _: => "!!! ???"

  }


}
