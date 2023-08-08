package com.plumbing

import com.utilities.Configuration.{anime_dataset_clean, anime_dataset_path, user_details_clean, user_score_clean}
import com.utilities.Utilities.read_parquet
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

object Main {

  private val conf = new SparkConf()
    .setMaster("local[6]")
    .setAppName("Anime_Analysis")
    .set("spark.executor.memory", "8g")
    .set("spark.driver.memory", "4g")
    .set("spark.memory.offHeap.enabled", "true")
    .set("spark.memory.offHeap.size", "4g")
    .set("spark.sql.parquet.int96RebaseModeInWrite", "LEGACY")

  implicit val spark: SparkSession = new SparkSession
  .Builder()
    .config(conf)
    .getOrCreate()


  def main(args:Array[String]):Unit={


    val anime_dataset_df = read_parquet(anime_dataset_clean)
    val user_details_df = read_parquet(user_details_clean)
    val user_score_df = read_parquet(user_score_clean)

//    anime_dataset_df.drop("English_name","Other_name","Synopsis","Producers","Licensors","Studios","Source","Duration","Image_Url")
//      .join(user_score_df.drop("Name"), usingColumns = Array("anime_id")).orderBy("anime_id")

    anime_dataset_df.drop("English_name","Other_name","Synopsis","Producers","Licensors","Studios","Source","Duration","Image_Url")
      .join(user_score_df, anime_dataset_df("anime_id") === user_score_df("anime_id"), "left_anti").show(1000)


    val sorted_anime=anime_dataset_df.drop("English_name","Other_name","Synopsis","Producers","Licensors","Studios","Source","Duration","Image_Url")
      .sort(col("Score").asc)

    sorted_anime.show(false)
//    println(anime_dataset_df.count())
//    println(user_score_df.select("anime_id").distinct().count())

  }
}
