import pandas as pd
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
import mlflow
import mlflow.sklearn

mlflow.set_tracking_uri("http://localhost:5000")

iris = load_iris()
X = pd.DataFrame(iris.data, columns=iris.feature_names)
y = iris.target

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

with mlflow.start_run():
    rf = RandomForestClassifier(n_estimators=100)
    rf.fit(X_train, y_train)
    
    mlflow.sklearn.log_model(rf, "iris_model")
    print("Model trained and logged to MLflow!")
    print("Testing Jenkins Email Notification and Console Logs!")