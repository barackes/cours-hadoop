package example

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.scalatest._

class NoWordCountProcessorSpec extends FlatSpec with Matchers {


  val sparkConf = new SparkConf()
    .setMaster("local[1]")
    .setAppName("no-word-count-test")

  val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

  it must "count num of students" in {

    import sparkSession.implicits._

    val students = Seq(
      StudentNote("e1","c1",10.0d)
      , StudentNote("e2","c2",10.0d)
      , StudentNote("e1","c1",10.0d)
      , StudentNote("e2","c2",10.0d)
    )


    val studentsDF = students.toDF()

    val result = new NoWordCountProcessor(sparkSession).countStudents(studentsDF)
    assert(2l === result.collect()(0).getLong(0))


  }


}

case class StudentNote(student:String,course:String,note:Double)
