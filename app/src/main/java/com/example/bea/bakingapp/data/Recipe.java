package com.example.bea.bakingapp.data;

public class Recipe {

    public int mID;
    public String mName;
    public int mServings;

    public Recipe(int iD, String name,int servings){
        mID =iD;
        mName = name;
        mServings = servings;
    }
    public int getID(){return mID;}
    public String getName(){return mName;}
    public int getServings(){return mServings;}

    public void setId(int iD){this.mID = iD;}
    public void setName(String name){this.mName = name;}
    public void setServings(int servings){this.mServings = servings;}

}
