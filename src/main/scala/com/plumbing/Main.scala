package com.plumbing

import com.utilities.Configuration.anime_dataset_path
import com.utilities.Structures.anime_dataset_schema
import com.utilities.Utilities.load_csv

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
object Main {

  val conf = new SparkConf()
    .setMaster("local[*]")
    .setAppName("Anime_Analysis")

  implicit val spark = new SparkSession
    .Builder()
    .config(conf)
    .getOrCreate()

  def main(args:Array[String]):Unit={
    val df=load_csv(anime_dataset_path,anime_dataset_schema)
    val df2=spark.read.options(Map("header"->"true","inferschema"->"true","multiline"->"true")).csv("/home/shashank/DATA/Anime_2023/users-details-2023.csv")

    df2.printSchema()
    spark.stop()
  }
}
