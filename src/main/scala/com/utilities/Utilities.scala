package com.utilities

import org.apache.spark.sql.{DataFrame, SparkSession}

object Utilities {

  def write_parquet(df: DataFrame, path: String): Unit = {
    df.write
      .mode("overwrite")
      .parquet(path)
  }

  def read_parquet(path:String)(implicit spark:SparkSession):DataFrame={
    spark.read
      .options(Map("header"->"true" , "inferSchema" -> "true"))
      .parquet(path)
  }

  def read_csv(path: String)(implicit spark: SparkSession): DataFrame = {
    spark.read
      .option("maxRowsInMemory", 1000)
      .options(Map("header" -> "true", "inferSchema" -> "true"))
      .csv(path)
  }

}
