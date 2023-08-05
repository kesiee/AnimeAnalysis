package com.plumbing
import Main.spark
import com.utilities.Configuration.{anime_dataset_path, clean_write_path, data_path, user_details_path, user_score_path}
import com.utilities.LargFileHandler.split_csv
import com.utilities.Structures.{anime_dataset_schema, user_details_schema, user_score_schema}
import com.utilities.Utilities.{load_csv, write_parque}
object DataCleaning {

  def main(args:Array[String]):Unit= {
//    val anime_dataset_df = load_csv(anime_dataset_path, anime_dataset_schema)
//    val user_details_df = load_csv(user_details_path, user_details_schema)

//    write_parque(anime_dataset_df, clean_write_path + "anime_dataset")
//    write_parque(user_details_df, clean_write_path + "user_details")

    split_csv(user_score_path,data_path)
    val files = new java.io.File(data_path+"split").listFiles.filter(_.getName.endsWith(".csv"))
    for (file <- files) {
      val user_score_df = load_csv(file.getPath, user_score_schema)
      // Process df...
      write_parque(user_score_df, clean_write_path + "user_score" + file.getName.stripSuffix(".csv"))
    }


  }

}
