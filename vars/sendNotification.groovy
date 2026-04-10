def call(String status) {
    if (status == "failed") {
        echo "Bhai, pipeline fail ho gayi hai! Email alert sent."
        // Asal mein yahan mail command aati hai: mail to: 'abc@test.com', subject: 'Failed'
    }
}
