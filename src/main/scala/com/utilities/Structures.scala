package com.utilities

import org.apache.spark.sql.Encoders
import java.sql.Timestamp

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
                          Birthday: Timestamp,
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

  case class User_Score(User_ID: Int,
                        Username: String,
                        anime_id: Int,
                        Name: String,
                        Rating: Int)

  val anime_dataset_schema = Encoders.product[Anime_Dataset].schema
  val user_details_schema = Encoders.product[User_Details].schema
  val user_score_schema=Encoders.product[User_Score].schema


}
