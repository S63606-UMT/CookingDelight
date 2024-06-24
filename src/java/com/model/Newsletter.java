/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;
import java.time.LocalDate;
/**
 *
 * @author saifu
 */
public class Newsletter {
    private String email;
    private LocalDate created;

    public Newsletter(String email, LocalDate created) {
        this.email = email;
        this.created = created;
    }

    public Newsletter(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
    
    
}
