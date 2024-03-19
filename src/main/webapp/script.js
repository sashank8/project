// Add the following function for password confirmation check
function signup() {
    var signupPassword = document.getElementById("signupPassword").value;
    var confirmPassword = document.getElementById("confirmPassword").value;

    if (signupPassword !== confirmPassword) {
        document.getElementById("errorMessage").textContent = "Passwords do not match.";
        return false; // Prevent form submission
    }

    return true; // Allow form submission
}
