package com.plumbing

import com.utilities.Configuration.{anime_dataset_path, user_details_path, user_score_path}
import com.utilities.Structures.{anime_dataset_schema, user_details_schema, user_score_schema}
import com.utilities.Utilities.load_csv
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
object Main {

  val conf = new SparkConf()
    .setMaster("local[2]")
    .setAppName("Anime_Analysis")
    .set("spark.sql.parquet.int96RebaseModeInWrite", "LEGACY")

  implicit val spark = new SparkSession
    .Builder()
    .config(conf)
    .getOrCreate()

  def main(args:Array[String]):Unit={

  }
}
