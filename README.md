# Anime Analysis 2023

This project is designed to process and analyze a large dataset of anime data using Apache Spark. The data is sourced from [Anime Dataset 2023](https://www.kaggle.com/datasets/dbdmobile/myanimelist-dataset) on Kaggle.

## Dataset

The dataset used in this project includes:

- `anime-dataset-2023.csv`: Contains 40,779 rows of anime data. Due to data leakage in other rows, the actual number of rows processed is more than double.
- `user-details-2023.csv`: Contains 731,290 rows of user details.
- `user-score-2023.csv`: Contains 24,325,191 rows of user scores.

The total size of the dataset is approximately 1.2GB.

## Data Processing

The data is processed and cleaned with minimal data loss, resulting in a cleaned dataset stored in Parquet format. The cleaned dataset includes:

- `anime-dataset`: 24,905 rows
- `user-details`: 731,284 rows
- `user-score`: 24,325,143 rows

The total size of the cleaned dataset is approximately 150MB.

## Features

- Load CSV files with a specified schema
- Handle mismatched rows and write them to a separate file for further inspection
- Split large CSV files into smaller ones for easier processing
- Save processed data in Parquet format for efficient storage and querying

## Usage

1. Set up your Spark environment and ensure you have the necessary libraries installed.
2. Update the paths in the code to point to your input CSV files and desired output directory.
3. Run the main Scala script to process the data. It will load the CSV files, clean and transform the data, and save the results in Parquet format.
