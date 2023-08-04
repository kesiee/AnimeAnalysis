import com.utilities.Configuration.anime_dataset_path
import com.utilities.Structures.anime_dataset_schema


object MainTry {
  def main(args: Array[String]): Unit = {
    val fieldsX=anime_dataset_schema.fields
    fieldsX.foreach(x=>println(x.name))

  }
}