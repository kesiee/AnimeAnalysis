package com.utilities

import org.apache.spark.sql.Encoders
import org.apache.spark.sql.types.TimestampType

object Structures {
  case class Anime_Dataset(anime_id: Int,
                           Name: String,
                           English_name: String,
                           Other_name: String,
                           Score: Double,
                           Genres: String,
                           Synopsis: String,
                           Type: String,
                           Episodes: Double,
                           Aired: String,
                           Premiered: String,
                           Status: String,
                           Producers: String,
                           Licensors: String,
                           Studios: String,
                           Source: String,
                           Duration: String,
                           Rating: String,
                           Rank: Double,
                           Popularity: Double,
                           Favorites: Double,
                           Scored_By: Double,
                           Members: Double,
                           Image_Url: String)

  case class User_Details(User_ID: Int,
                          Username: String,
                          Gender: String,
                          Birthday: TimestampType,
                          Location: String,
                          Joined: String,
                          Days_Watched: String,
                          Mean_Score: String,
                          Watching: Double,
                          Completed: Double,
                          OnHold: Double,
                          Dropped: Double,
                          Plan_to_Watch: Double,
                          Total_Entries: Double,
                          Rewatched: Double,
                          Episodes_Watched: Double)

  val anime_dataset_schema = Encoders.product[Anime_Dataset].schema


}
