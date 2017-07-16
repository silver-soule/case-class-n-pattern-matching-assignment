package com.knoldus.kip

import com.knoldus.kip.models._

/**
  * Created by Neelaksh on 15/7/17.
  */
object Values {

  val MAX_MARKS100 = 100
  val subjectMCADM1: Subject = Subject(1,"Discrete Mathematics", 35, MAX_MARKS100)
  val subjectMCACO1: Subject = Subject(2,"Computer Organization", 79, MAX_MARKS100)
  val subjectMCABN1: Subject = Subject(3,"Basic Networking", 81, MAX_MARKS100)

  val subjectMCADM2: Subject = Subject(1,"Discrete Mathematics", 55, MAX_MARKS100)
  val subjectMCACO2: Subject = Subject(2,"Computer Organization", 29, MAX_MARKS100)
  val subjectMCABN2: Subject = Subject(3,"Basic Networking", 61, MAX_MARKS100)

  val subjectBTechCG1: Subject = Subject(3,"Computer Graphics", 59, MAX_MARKS100)
  val subjectBTechCA1: Subject = Subject(4,"Computer Architecture", 91, MAX_MARKS100)
  val subjectBTechAN1: Subject = Subject(5,"Advanced Networking", 38, MAX_MARKS100)

  val subjectBTechCG2: Subject = Subject(3,"Computer Graphics", 79, MAX_MARKS100)
  val subjectBTechCA2: Subject = Subject(4,"Computer Architecture",  91, MAX_MARKS100)
  val subjectBTechAN2: Subject = Subject(5,"Advanced Networking", 88, MAX_MARKS100)

  val subjectListMcaWithOneFailure1: List[Subject] = List(subjectMCADM1, subjectMCACO1, subjectMCABN1)
  val subjectListMcaWithOneFailure2: List[Subject] = List(subjectMCADM2, subjectMCACO2, subjectMCABN2)
  val subjectListBtechWithOneFailure1: List[Subject] = List(subjectBTechCG1, subjectBTechCA1, subjectBTechAN1)
  val subjectListBtechWithZeroFailure1: List[Subject] = List(subjectBTechCG2, subjectBTechCA2, subjectBTechAN2)

  val courseAndSubjectsMCA1: Course = Course(1,"MCA-3", "MCA", subjectListMcaWithOneFailure1)
  val courseAndSubjectsMCA2: Course = Course(2,"MCA-3", "MCA", subjectListMcaWithOneFailure2)

  val courseAndSubjectsBTech1: Course = Course(3,"BTech-4", "BTech", subjectListBtechWithOneFailure1)
  val courseAndSubjectsBTech2: Course = Course(4,"BTech-4", "BTech", subjectListBtechWithZeroFailure1)

  val student1: Student = Student(1,"Ashish",None, "Tomer", 1, Some(24), 'm', "1032017071102", Some("C-138,sec-22"))
  val student2: Student = Student(2,"Gaurav",None,"Mishra", 4, Some(26), 'm', "1082017071102", None)
  val student3: Student = Student(3,"Harshit",Some("Wait for it"),"Daga", 2, Some(25), 'm', "1032017071103", None)
  val student4: Student = Student(4,"Girish",None,"Bharti", 8, Some(27), 'm', "1082017071102", None)

  val scorecardAshish: Scorecard = Scorecard(1,student1, subjectListMcaWithOneFailure1)
  val scorecardGaurav: Scorecard = Scorecard(2,student2, subjectListMcaWithOneFailure2)
  val scorecardHarshit: Scorecard = Scorecard(3,student3, subjectListBtechWithOneFailure1)
  val scorecardGirish: Scorecard = Scorecard(4,student4, subjectListBtechWithZeroFailure1)

  val scorecardListWithTwoFailures: List[Scorecard] = List(scorecardAshish, scorecardHarshit)
  val scorecardListWithThreeFailures: List[Scorecard] = List(scorecardAshish, scorecardHarshit, scorecardGaurav)
  val scoreCardListWithZeroFailure: List[Scorecard] = List(scorecardGirish)

  //val coursePerformance1: CoursePerformance = CoursePerformance(1,2016,courseAndSubjectsMCA1,scorecardListWithTwoFailures)
  //RamDatabase.add()

}
