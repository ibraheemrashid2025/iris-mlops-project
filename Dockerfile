FROM python:3.9-slim
WORKDIR /app
COPY requirements.txt .
RUN pip install --break-system-packages -r requirements.txt
COPY . .
CMD ["python3", "src/train.py"]
