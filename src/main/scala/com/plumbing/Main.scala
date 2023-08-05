package com.plumbing

import com.utilities.Configuration.{anime_dataset_clean, user_details_clean, user_score_clean}

import com.utilities.Utilities.{read_parquet}

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Main {

  val conf = new SparkConf()
    .setMaster("local[6]")
    .setAppName("Anime_Analysis")
    .set("spark.executor.memory", "8g")
    .set("spark.driver.memory", "4g")
    .set("spark.memory.offHeap.enabled", "true")
    .set("spark.memory.offHeap.size", "4g")
    .set("spark.sql.parquet.int96RebaseModeInWrite", "LEGACY")

  implicit val spark = new SparkSession
  .Builder()
    .config(conf)
    .getOrCreate()


  def main(args:Array[String]):Unit={


    val anime_dataset_df=read_parquet(anime_dataset_clean)
    val user_details_df=read_parquet(user_details_clean)
    val user_score_df=read_parquet(user_score_clean)

  }
}
