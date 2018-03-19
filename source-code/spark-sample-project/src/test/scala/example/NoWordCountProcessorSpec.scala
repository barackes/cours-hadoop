package example

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.scalatest._

class NoWordCountProcessorSpec extends FlatSpec with Matchers {

  it must "simply run" in {

    val sparkConf = new SparkConf()
                      .setMaster("local[1]")
                        .setAppName("no-word-count-test")

    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    new NoWordCountProcessor(sparkSession).run()


  }


}
