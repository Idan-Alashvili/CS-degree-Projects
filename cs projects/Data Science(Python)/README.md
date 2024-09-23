# Handball League Table Prediction

## Project Overview
This project aims to predict the league table of a handball season based on player statistics from the same season. The goal is to analyze how individual player statistics affect team standings and to compare the predicted league table with the actual one.

## Project Structure

- **Data/**: Contains all the databases used in the project.
  - `modified_field_player_detail_2020_2021.csv`
  - `modified_field_player_detail_2021_2022.csv`
  - `modified_field_player_detail_2022_2023.csv`
  - `modified_field_player_detail_2023_2024.csv`
  - `modified_Goalkeeper_2020_2021.csv`
  - `modified_Goalkeeper_2021_2022.csv`
  - `modified_Goalkeeper_2022_2023.csv`
  - `modified_Goalkeeper_2023_2024.csv`
  - `Overall_standings_2020_2021_modified.csv`
  - `Overall_standings_2021_2022_modified.csv`
  - `Overall_standings_2022_2023_modified.csv`
  - `Overall_standings_2023_2024_modified.csv`

- **Presentation**: Includes the presentation slides for the project.

- **Report**: Contains the project report with detailed explanations and results.

## Data Processing

1. **Data Collection**: 
   - Gathered data from official handball bundesliga and used scraping to a csv file.
   - The data including field player stats, goalkeeper stats and overall team standings.

2. **Data Cleaning**:
   - Handled missing values and ensured that all relevant columns are in numeric format.
   - Removed any non-numeric columns and potential leakage columns.

3. **Feature Engineering**:
   - Created features from the raw data that are relevant for predicting team standings.
   - Ensured that the features used in the model are aligned with the target variable.

## Model

- **Machine Learning Model**:
  - **Algorithm**: RandomForestRegressor
  - **Training**: Trained the model on data from the 2020/21, 2021/22, and 2022/23 seasons.
  - **Prediction**: Predicted the league table for the 2023/24 season based on player stats for that season.

- **Evaluation**:
  - **Metrics**: Mean Absolute Error (MAE) and R-squared (R^2) scores.
  - **Comparison**: Compared the predicted league table with the actual league table for the 2023/24 season.

## Results

- **Findings**:
  - Analyzed how individual player statistics impact team performance and standings.
  - Compared the accuracy of the predicted league table with the actual league table.

## Presentation

- The presentation slides are available in the `presentation/` folder. They cover the project overview, methodology, results, and key findings.

## Project Report

- The detailed project report is available in the `report/` folder. It includes an in-depth explanation of the data processing, feature engineering, model training, evaluation, and results.

## How to Run

1. **Install Dependencies**:
   - Ensure you have the necessary libraries installed.
2. **Run the Analysis**:
   - Execute the provided Jupyter notebooks or Python scripts to perform the data processing, model training, and evaluation.

3. **View Results**:
   - Check the output files or the provided reports for the results of the analysis.

## Acknowledgments

- Thanks to the contributors and sources from which the data was obtained.

