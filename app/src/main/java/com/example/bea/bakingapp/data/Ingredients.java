package com.example.bea.bakingapp.data;

public class Ingredients {

    private int mQuantity = 0;
    private String mMeasure;
    private String mIngredient;

    public Ingredients(int quantity, String measure, String ingredient){
        mQuantity=quantity;
        mIngredient=ingredient;
        mMeasure=measure;
    }
    public int getQuantity(){return mQuantity;}
    public String getIngredient(){return mIngredient;}
    public String getMeasure(){return mMeasure;}

    public void setQuantity(int quantity){this.mQuantity = quantity;}
    public void setMeasure (String measure){this.mMeasure = measure;}
    public void setIngredient(String ingredient){this.mIngredient = ingredient;}
}
