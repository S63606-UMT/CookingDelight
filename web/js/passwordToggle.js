/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function showPassword() {
    const passwordField = document.getElementById("password");
    passwordField.setAttribute("type", "text");
}

function hidePassword() {
    const passwordField = document.getElementById("password");
    passwordField.setAttribute("type", "password");
}

function showNewPassword() {
    const passwordField = document.getElementById("new-password");
    passwordField.setAttribute("type", "text");
}

function hideNewPassword() {
    const passwordField = document.getElementById("new-password");
    passwordField.setAttribute("type", "password");
}

function showOldPassword() {
    const passwordField = document.getElementById("old-password");
    passwordField.setAttribute("type", "text");
}

function hideOldPassword() {
    const passwordField = document.getElementById("old-password");
    passwordField.setAttribute("type", "password");
}

function showCPassword() {
    const passwordField = document.getElementById("confirm-password");
    passwordField.setAttribute("type", "text");
}

function hideCPassword() {
    const passwordField = document.getElementById("confirm-password");
    passwordField.setAttribute("type", "password");
}
