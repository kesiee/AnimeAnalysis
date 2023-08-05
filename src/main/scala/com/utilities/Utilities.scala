package com.utilities

import org.apache.spark.sql.{DataFrame, SparkSession}

object Utilities {

  def write_parque(df: DataFrame, path: String): Unit = {
    df.write
      .mode("overwrite")
      .parquet(path)
  }

  def read_parquet(path:String)(implicit spark:SparkSession):DataFrame={
    spark.read
      .options(Map("header"->"true" , "inferschema" -> "true"))
      .parquet(path)
  }

  def read_csv(path: String)(implicit spark: SparkSession): DataFrame = {
    spark.read
      .option("maxrowsinmemory", 1000)
      .options(Map("header" -> "true", "inferschema" -> "true"))
      .csv(path)
  }

}
