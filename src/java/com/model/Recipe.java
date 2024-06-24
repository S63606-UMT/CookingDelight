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
    private int prepTime;
    private int cookTime;
    private int serving;
    private String ingredients;
    private String instructions;
    private String chefNote;
    private int userid; // Foreign Key

    public Recipe() {
    }

    public Recipe(String title, String shortDescription, int prepTime, int cookTime, int serving, String ingredients, String instructions, String chefNote, int userid) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.serving = serving;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.chefNote = chefNote;
        this.userid = userid;
    }

    public Recipe(int recipeid, String title, String shortDescription, int prepTime, int cookTime, int serving, String ingredients, String instructions, String chefNote, int userid) {
        this.recipeid = recipeid;
        this.title = title;
        this.shortDescription = shortDescription;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.serving = serving;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.chefNote = chefNote;
        this.userid = userid;
    }
    
    public int getRecipeid() {
        return recipeid;
    }

    public void setRecipeid(int recipeid) {
        this.recipeid = recipeid;
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
    
    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getServing() {
        return serving;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getChefNote() {
        return chefNote;
    }

    public void setChefNote(String chefNote) {
        this.chefNote = chefNote;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
