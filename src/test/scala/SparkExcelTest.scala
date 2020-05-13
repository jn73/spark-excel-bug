import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.scalatest.FunSpec

class SparkExcelTest extends FunSpec {

  val sess: SparkSession = SparkSession.builder().appName("test").master("local[3]")
    .config(new SparkConf())
    .getOrCreate()

  describe("SparkExcel") {
    it("should read excel files") {
      val df = sess.read.format("com.crealytics.spark.excel")
        .option("header", "true")
        .load("src/test/resources/excel1.xlsx")

      val rows = df.collect()

      println("read rows: " + rows)

    }
  }

}
