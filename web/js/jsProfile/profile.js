/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function editUsername() {
    var username = document.getElementById("username").value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "../UserController?action=editUsername", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Username updated successfully!");
            } else {
                alert("Failed to update username. Please try again.");
            }
        }
    };
    
    xhr.send("username=" + encodeURIComponent(username));
}

function changePassword() {
    // Implement password change logic here
}

function editEmail() {
    var email = document.getElementById("email").value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "../UserController?action=editEmail", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Email updated successfully!");
            } else {
                alert("Failed to update email. Please try again.");
            }
        }
    };
    
    xhr.send("email=" + encodeURIComponent(email));
}

function editDob() {
    var dob = document.getElementById("dob").value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "../UserController?action=editDob", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Date of birth updated successfully!");
            } else {
                alert("Failed to update date of birth. Please try again.");
            }
        }
    };
    
    xhr.send("dob=" + encodeURIComponent(dob));
}

function editGender() {
    var gender = document.getElementById("gender").value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "../UserController?action=editGender", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Gender updated successfully!");
            } else {
                alert("Failed to update gender. Please try again.");
            }
        }
    };
    
    xhr.send("gender=" + encodeURIComponent(gender));
}
/*
function saveDescription() {
    var description = document.getElementById("description").value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "../UserController?action=saveDescription", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("description=" + encodeURIComponent(description));
}
*/
