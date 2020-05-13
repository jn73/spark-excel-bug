import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.scalatest.{FunSpec, Matchers}

class SparkExcelTest extends FunSpec with Matchers {

  val sess: SparkSession = SparkSession.builder().appName("test").master("local[3]")
    .config(new SparkConf())
    .getOrCreate()

  describe("SparkExcel") {
    it("should read excel files") {
      val df = sess.read.format("com.crealytics.spark.excel")
        .option("header", "true")
        .load("src/test/resources/excel1.xlsx")

      val rows = df.collect()

      rows should have size(3)

    }
  }

}
