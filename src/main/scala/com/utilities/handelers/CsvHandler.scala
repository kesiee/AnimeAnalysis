package com.utilities.handelers

import com.opencsv.CSVReader
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

import java.io.FileReader
import java.sql.Timestamp
import java.text.SimpleDateFormat
import scala.collection.JavaConverters.asScalaBufferConverter
import scala.collection.mutable

object CsvHandler {

  //Why not use spark api read csv?
  //The data bleeds into other rows even with multiline enabled cause of
  // the Synopsis column which contains large Strings with escape chars, newline etc
  def load_csv(path: String, schema: StructType)(implicit spark: SparkSession): DataFrame = {
    //This reads the csv as a table of Strings and outs as a Java linked list
    //hence has to be converted to Scala Buffer.
    def opencsv_entries(): mutable.Buffer[Array[String]] = {
      val reader = new CSVReader(new FileReader(path))
      val myEntries = reader.readAll()
      myEntries.asScala
    }
    def typefix(array: Array[String], schema: StructType): Option[Row] = {
      if (array.length != schema.length) {
        None // Skip this row if the lengths don't match
      }
      else {
        val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
        val rowSeq: Seq[Any] = array.zip(schema.fields).map { case (value, field) =>
            field.dataType match {
              case IntegerType => if (value != "UNKNOWN" && value.nonEmpty) value.toInt else 0
              case DoubleType => if (value != "UNKNOWN" && value.nonEmpty) value.toDouble else 0.0
              case TimestampType => if (value != "UNKNOWN" && value.nonEmpty) new Timestamp(format.parse(value).getTime) else null
              case StringType => value.replaceAll("\n", "").replaceAll("\r", "")
              case _ => value
            }

        }
        Some(Row.fromSeq(rowSeq))
      }
    }

    val rdd = spark.sparkContext.parallelize(opencsv_entries())
    val header = rdd.first() //done to remove the header cause it contains the column names.
    val data = rdd.filter(row => !(row sameElements header))

    val rowRDD = data.flatMap(array => typefix(array, schema)) // Use flatMap to filter out None values
    spark.createDataFrame(rowRDD, schema)
  }

}
