<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        /* Add your CSS styles here */
        /* Centering the form */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>
<body>
    <div class="login-section">
        <form id="signupForm" action="registerStudent" method="post">
            <h2>Sign Up</h2>
            <label for="signupUsername">Username:</label>
            <input type="text" id="signupUsername" name="signupUsername" required>
            <label for="signupPassword">Password:</label>
            <input type="password" id="signupPassword" name="signupPassword" required>
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
            <p id="errorMessage" style="color: red;"></p> <!-- Error message element -->
            <button type="submit" onclick="return signup()">Sign Up</button>
            <p id="signupLink">Already have an account? <a href="index.html">Log in here</a></p>
        </form>
    </div>
    <script src="script.js"></script>
</body>
</html>