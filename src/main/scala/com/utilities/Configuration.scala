package com.utilities

object Configuration {

  //Paths for the Data
  val data_path="/home/shashank/DATA/Anime_2023/"
  val anime_dataset_path=data_path + "anime-dataset-2023.csv"
  val user_details_path=data_path + "users-details-2023.csv"
  val user_score_path=data_path + "users-score-2023.csv"

  val clean_write_path="/home/shashank/DATA/Anime_2023/clean/"

  val anime_dataset_clean=clean_write_path+ "anime_dataset/*.parquet"
  val user_details_clean=clean_write_path+ "user_details/*.parquet"
  val user_score_clean=clean_write_path+ "user_score/*/*.parquet"

}
