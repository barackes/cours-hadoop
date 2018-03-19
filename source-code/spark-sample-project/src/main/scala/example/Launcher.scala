package example

import org.apache.spark.sql.SparkSession

/**
  * User: slim
  * Date: 19/03/18
  * Time: 14:32
  *
  * TODO fill me please!
  */
object Launcher extends App{

  val sparkSession = SparkSession.builder().getOrCreate()
  val processor = new NoWordCountProcessor(sparkSession)
  val input = args(0)
  processor.run(input)

}
