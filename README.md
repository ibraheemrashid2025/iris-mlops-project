
# Content for the README.md file
readme_content = """# 🌸 Iris MLOps End-to-End Pipeline

This project demonstrates a professional-grade **MLOps (Machine Learning Operations)** pipeline for the Iris dataset. It automates the entire lifecycle of a machine learning model, from data ingestion and training to automated testing, versioning, and production deployment using modern DevOps tools.

---

## 🚀 Key Features

* **Automated Training:** Integrated script for training a Logistic Regression model on the Iris dataset.
* **Model Tracking (MLflow):** Every run is logged with parameters and metrics. Includes Model Registry for lifecycle management.
* **CI/CD Pipeline (Jenkins):** Multi-branch pipeline that handles:
    * **Data Ingest & Train:** Automated training on push.
    * **Pre-prod Testing:** Model validation and aliasing.
    * **Production Release:** Automated deployment trigger via Git Tags.
* **Containerization:** Full Docker support for reproducible environments.
* **Smart Notifications:** Custom Jenkins Shared Library for real-time email alerts.
* **Governance:** Automated aliasing in MLflow (`@Challenger`, `@Challenger-post-test`, `@Champion`).

---

## 🛠 Tech Stack

| Tool | Purpose |
| :--- | :--- |
| **Python 3.x** | Core Programming Language |
| **Scikit-learn** | Machine Learning Framework |
| **MLflow** | Experiment Tracking & Model Registry |
| **Jenkins** | CI/CD Automation |
| **Docker** | Environment Isolation & Containerization |
| **Ubuntu (WSL2)** | Development Environment |

---

## 📂 Project Structure

```text
.
├── data/               # Dataset storage
├── src/                # Source code
│   └── train.py        # Model training and MLflow logging script
├── vars/               # Jenkins Shared Library logic (Groovy)
├── Dockerfile          # Container configuration
├── Jenkinsfile         # CI/CD pipeline definition
├── mlflow.db           # SQLite backend for MLflow
└── README.md           # Project documentation
