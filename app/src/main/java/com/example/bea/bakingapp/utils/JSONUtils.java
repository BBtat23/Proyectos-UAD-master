package com.example.bea.bakingapp.utils;

import com.example.bea.bakingapp.data.Ingredients;
import com.example.bea.bakingapp.data.Recipe;
import com.example.bea.bakingapp.data.Steps;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONUtils {

    //Get recipe object from Json
    public static List<Recipe> getRecipeJSONUtils(String recipeURLString) throws JSONException {
        int idRecipe;
        String nameRecipe;
        int servingsRecipe;
        //Array{} || Object[]
        // We start with an Array so we create a new JSONArray
        JSONArray jsonArrayRecipe = new JSONArray(recipeURLString);
        //We create the object that we will add to the ArrayList
        Recipe objectRecipe = null;
        //We create an ArrayList that will be an ArrayList of Recipe objects
        List<Recipe> recipes = new ArrayList<>();
        //We get the object of the Array (id,name,servings)
        for (int i = 0; i < jsonArrayRecipe.length();i++){
            JSONObject recipeObject = jsonArrayRecipe.getJSONObject(i);
            idRecipe = recipeObject.getInt("id");
            nameRecipe = recipeObject.getString("name");
            servingsRecipe = recipeObject.getInt("servings");
            //We create a new Recipe object with the values that we get from json
            objectRecipe = new Recipe(idRecipe,nameRecipe,servingsRecipe);
            //We add the object to the ArrayList
            recipes.add(objectRecipe);
        }
        //We return ArrayList
        return recipes;
    }

    //Get ingredients object from Json
    public static List<Ingredients> getIngredientsJSONUtils(String ingredientsURLString) throws JSONException {
        int quantityIngredients;
        String measureIngredients;
        String ingredientIngredients;
        //Array{} || Object[]
        // We start with an Array so we create a new JSONArray
        JSONArray jsonArrayRecipe = new JSONArray(ingredientsURLString);
        //We create the object that we will add to the ArrayList
        Ingredients objectIngredients = null;
        //We create an ArrayList that will be an ArrayList of Ingredients objects
        List<Ingredients> ingredients = new ArrayList<>();
        //We get the object of the Array (ingredients)
        for (int i = 0; i < jsonArrayRecipe.length(); i++){
            JSONObject ingredientsObject = jsonArrayRecipe.getJSONObject(i);
            //We get another Array from ingredients object
            JSONArray ingredientsArray = ingredientsObject.getJSONArray("ingredients");
            for (int j = 0; j < ingredientsArray.length(); j++){
                //We get the object of the Array (quantity, measure, ingredient)
                JSONObject ingredientsJSONObject = ingredientsArray.getJSONObject(j);
                quantityIngredients = ingredientsJSONObject.getInt("quantity");
                measureIngredients = ingredientsJSONObject.getString("measure");
                ingredientIngredients = ingredientsJSONObject.getString("ingredient");
                //We create a new Ingredients object with the values that we get from json
                objectIngredients = new Ingredients(quantityIngredients,measureIngredients,ingredientIngredients);
                //We add the object to the ArrayList
                ingredients.add(objectIngredients);
            }
        }
        //We return ArrayList
        return ingredients;
    }

    public static List<Steps> getStepsJSONUtils(String stepsURLString) throws JSONException {
        int idSteps;
        String shortDescriptionSteps;
        String descriptionSteps;
        String videoUrlSteps;
        String thumbnailUrlSteps;

        JSONArray jsonArraySteps = new JSONArray(stepsURLString);
        Steps objectSteps = null;
        List<Steps> steps = new ArrayList<>();
        for (int i = 0; i < jsonArraySteps.length(); i++ ){
            JSONObject stepsJsonObject = jsonArraySteps.getJSONObject(i);
            JSONArray stepsJsonArray = stepsJsonObject.getJSONArray("steps");
            for (int j = 0; j < stepsJsonArray.length(); j++){
                JSONObject stepsObject = stepsJsonArray.getJSONObject(j);
                idSteps = stepsObject.getInt("id");
                shortDescriptionSteps = stepsObject.getString("shortDescription");
                descriptionSteps = stepsObject.getString("description");
                videoUrlSteps = stepsObject.getString("videoURL");
                thumbnailUrlSteps = stepsObject.getString("thumbnailURL");

                objectSteps = new Steps(idSteps,shortDescriptionSteps,descriptionSteps,videoUrlSteps,thumbnailUrlSteps);
                steps.add(objectSteps);
            }

        }
        return steps;
    }
}
