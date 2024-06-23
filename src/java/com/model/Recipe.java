/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author saifu
 */
public class Recipe {
    private int recipeid;
    private String title;
    private String shortDescription;

    public Recipe() {
    }

    public Recipe(String title, String shortDescription) {
        this.title = title;
        this.shortDescription = shortDescription;
    }

    public Recipe(int recipeid, String title, String shortDescription) {
        this.recipeid = recipeid;
        this.title = title;
        this.shortDescription = shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(int recipeid) {
        this.recipeid = recipeid;
    }
}
