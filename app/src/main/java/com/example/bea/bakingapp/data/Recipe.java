package com.example.bea.bakingapp.data;

import java.util.ArrayList;

public class Recipe {

    public int mID;
    public String mName;
    public int mServings;
    public ArrayList<Ingredients> mIngredientsArrayList;
    public ArrayList<Steps> mStepsArrayList;
    public Recipe(int iD, String name,int servings, ArrayList<Ingredients> ingredientsArrayList, ArrayList<Steps> stepsArrayList){
        mID =iD;
        mName = name;
        mServings = servings;
        mStepsArrayList = stepsArrayList;
        mIngredientsArrayList = ingredientsArrayList;
    }
    public int getID(){return mID;}
    public String getName(){return mName;}
    public int getServings(){return mServings;}
    public ArrayList<Steps> getStepsArrayList(){return mStepsArrayList;}
    public ArrayList<Ingredients> getIngredientsArrayList(){return mIngredientsArrayList;}

    public void setId(int iD){this.mID = iD;}
    public void setName(String name){this.mName = name;}
    public void setServings(int servings){this.mServings = servings;}

}
