# K-NN Text Classifier

This Java application is designed to classify a collection of text documents using the k-nearest neighbors (k-NN) method. It consists of two main modules:

## 1. Feature Extraction Module
This module operates on the provided text dataset. It extracts features from each text document, representing them as vectors of selected feature values. At least 10 features are chosen to ensure independence from the number of objects/texts in the database and to represent individual objects consistently. Among these features, there should be at least two textual features, independent of the number of objects/texts in the database.

### Data Source
The dataset used for feature extraction and classification can be found at: [Reuters-21578 Text Categorization Collection](https://kdd.ics.uci.edu/databases/reuters21578/reuters21578.html)

## 2. K-NN Classifier Module
This module operates exclusively on the feature vectors representing texts, rather than on the documents directly before feature extraction. The classifier accepts the following parameters:
- The value of k.
- The proportions for splitting the vector set into training and test sets (e.g., 60/40, 30/70, 50/50) deterministically. This means that for several consecutive experiments, the training/test set contains exactly the same elements (i.e., vectors/texts).
- The set of features used for classification (not every classification needs to consider all features extracted from the texts).
- The metric and/or similarity measure applied in the k-NN method.

## User Interface
The application provides a user-friendly interface for inputting classification parameters and presenting results.

## Technologies Used
- JDK LTS (19)
- Java
- JavaFx

## Usage
1. Clone this repository.
2. Compile and run the Java application.
3. Input parameters for the classification task via the user interface.
4. View the classification results.

## Classification Task
The application is designed to classify texts categorized under "places" with labels including west-germany, usa, france, uk, canada, and japan. These labels are the only ones in this category.

## Note
Ensure that the necessary JDK LTS version is installed on your system before running the application.
