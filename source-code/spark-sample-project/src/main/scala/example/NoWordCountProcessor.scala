package example

import org.apache.spark.sql.{DataFrame, SparkSession}

class NoWordCountProcessor(val sparkSession: SparkSession) {

  import org.apache.spark.sql.functions._

  def run(input:String) : Unit = {
    val studentsDF = sparkSession.read.csv(input)
    countStudents(studentsDF).show()
  }

  def countStudents(studentsDF:DataFrame)  = {
    studentsDF.agg(countDistinct("student").as("number_of_students"))
  }

}


