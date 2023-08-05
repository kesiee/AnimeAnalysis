package com.utilities.handelers

import java.io.{BufferedWriter, FileWriter}

object LargeFileHandler {

  def split_csv(path: String, saveDir: String) = {

    val source = scala.io.Source.fromFile(path)
    val lines = source.getLines()

    var fileCount = 1
    var lineCount = 0
    var writer: BufferedWriter = new BufferedWriter(new FileWriter(s"$saveDir"+s"split/smallFile$fileCount.csv"))

    for (line <- lines) {
      if (lineCount < 2500000) { // Adjust this number based on how many lines you want in each small file
        writer.write(line)
        writer.newLine()
        lineCount += 1
      } else {
        writer.close()
        fileCount += 1
        writer = new BufferedWriter(new FileWriter(s"$saveDir"+s"split/smallFile$fileCount.csv"))
        lineCount = 0
      }
    }

    writer.close()
    source.close()
  }


}
