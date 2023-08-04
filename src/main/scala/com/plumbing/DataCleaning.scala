package com.plumbing
import Main.spark
import com.utilities.Configuration.{anime_dataset_path, clean_write_path, user_details_path, user_score_path}
import com.utilities.Structures.{anime_dataset_schema, user_details_schema, user_score_schema}
import com.utilities.Utilities.{load_csv, write_parque}
object DataCleaning {

  def main(args:Array[String]):Unit= {
//    val anime_dataset_df = load_csv(anime_dataset_path, anime_dataset_schema)
//    val user_details_df = load_csv(user_details_path, user_details_schema)
    val user_score_df = load_csv(user_score_path, user_score_schema)

//    write_parque(anime_dataset_df, clean_write_path + "anime_dataset")
//    write_parque(user_details_df, clean_write_path + "user_details")
    val user_score_df_list = user_score_df.randomSplit(Array.fill(20)(0.05))

    for(df <- user_score_df_list){
      val path=clean_write_path + "user_score/"+java.util.UUID.randomUUID.toString
      write_parque(df, path)
    }

//    write_parque(user_score_df, clean_write_path + "user_score")
  }

}
