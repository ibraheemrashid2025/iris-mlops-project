def call(String status) {
    def subject = "MLOps Pipeline Alert: Build ${status.toUpperCase()} (Build #${env.BUILD_NUMBER})"
    def body = """
        <h3>MLOps Project Notification</h3>
        <p><b>Project:</b> ${env.JOB_NAME}</p>
        <p><b>Status:</b> ${status.toUpperCase()}</p>
        <p><b>Build URL:</b> <a href='${env.BUILD_URL}'>Click here to view build</a></p>
        <br>
        <p><i>This is an automated message from your Jenkins Pipeline.</i></p>
    """

    // Asli email bhejne ki command
    emailext (
        to: 'ibraheemrashid65@gmail.com', // Yahan apna email likhein
        subject: subject,
        body: body,
        mimeType: 'text/html',
        attachLog: true, // Ye build logs ko email ke sath attach kar dega
        attachmentsPattern: 'data/*.csv' // Agar aap dataset attach karna chahte hain
    )
    
    echo "Email notification sent for status: ${status}"
}