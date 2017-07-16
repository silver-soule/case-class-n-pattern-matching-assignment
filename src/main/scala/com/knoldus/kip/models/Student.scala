package com.knoldus.kip.models

case class Subject(id: Int, name: String,
                   obtainedMarks: Int,maxMarks: Int) extends ModelIdentifier


case class Student(id: Int, firstName: String, middleName: Option[String], lastName: String,
                   rollNumber: Int,
                   age: Option[Int],
                   gender: Char,
                   enrollemntNumber: String,
                   address: Option[String]) extends ModelIdentifier{

  def getAddress()  : String  = {
    address.fold("NA")((a)=>a)
  }

  def getMiddleName() : String =  middleName.map(_.split(" ")(0)).getOrElse("")

}

case class Course(id:Int, name:String, Category:String,
                  subjects:List[Subject]) extends ModelIdentifier


case class Scorecard(id:Int, student:Student, subjects: List[Subject],
                     total:Float, percentage:Float,grade:String) extends ModelIdentifier{

  def getSubjectWithMaxScore(): Subject = {
    subjects.maxBy(_.obtainedMarks)
  }

  def getSubjectWithMinScore(): Subject = {
    subjects.minBy(_.obtainedMarks)
  }

  def getStudentList(scorecards:List[Scorecard]) : List[String] = {
    for { scorecard <- scorecards
       subject = scorecard.getSubjectWithMaxScore()
    } yield scorecard.student.firstName + subject.name + subject.obtainedMarks
  }
}

object Scorecard {
  //def apply(student: Student, subject: Subject): Scorecard = ???{}
  def apply(id:Int,nameOfStudent: Student, subjects: List[Subject]): Scorecard = {
    val totalMarksObtained = subjects.foldLeft(0.toFloat)((a: Float, b: Subject) => a + b.obtainedMarks)
    val maxTotalMarks = subjects.foldLeft(0.toFloat)((a: Float, b: Subject) => a + b.maxMarks)
    val avgMarks = totalMarksObtained / maxTotalMarks
    val percentage = avgMarks * 100
    val grade = getGrade(percentage)
    new Scorecard(id,nameOfStudent, subjects, totalMarksObtained, percentage, grade)
  }

  def getGrade(percentage: Float): String = {
    if (percentage >= 95) {
      "A+"
    }
    else if (percentage >= 90) {
      "A"
    }
    else if (percentage >= 85) {
      "B+"
    }
    else if (percentage >= 80) {
      "B"
    }
    else if (percentage >= 70) {
      "C+"
    }
    else if (percentage >= 60) {
      "C"
    }
    else if (percentage >= 50) {
      "D+"
    }
    else if (percentage >= 40) {
      "D"
    }
    else {
      "F"
    }
  }


}
case class CoursePerformance(id: Int, year:Int, course:Course,
                             scoreCards:List[Scorecard]) extends ModelIdentifier