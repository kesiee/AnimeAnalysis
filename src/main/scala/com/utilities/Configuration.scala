package com.utilities

object Configuration {

  //Paths for the Data
  val data_path : String ="/home/shashank/DATA/Anime_2023/"
  val anime_dataset_path: String = data_path + "anime-dataset-2023.csv"
  val user_details_path: String = data_path + "users-details-2023.csv"
  val user_score_path: String = data_path + "users-score-2023.csv"

  val clean_write_path = "/home/shashank/DATA/Anime_2023/clean/"

  val anime_dataset_clean : String = clean_write_path+ "anime_dataset/*.parquet"
  val user_details_clean : String = clean_write_path+ "user_details/*.parquet"
  val user_score_clean : String = clean_write_path+ "user_score/*/*.parquet" //To read all the files in all the folders.

}
