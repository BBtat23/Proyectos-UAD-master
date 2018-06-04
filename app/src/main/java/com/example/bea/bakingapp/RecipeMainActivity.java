package com.example.bea.bakingapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bea.bakingapp.adapter.RecipeAdapter;
import com.example.bea.bakingapp.data.Ingredients;
import com.example.bea.bakingapp.data.Recipe;
import com.example.bea.bakingapp.data.Steps;
import com.example.bea.bakingapp.utils.JSONUtils;
import com.example.bea.bakingapp.utils.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RecipeMainActivity extends AppCompatActivity implements RecipeAdapter.ListItemClickListener{
    private String BASE_API = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    private List<Recipe> mRecipe = new ArrayList<>();
    private RecipeAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerViewRecipe);
        mAdapter = new RecipeAdapter(this, mRecipe,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        new RecipeAsynctask().execute();
        new StepsAsynctask().execute();
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
//        Toast.makeText(RecipeMainActivity.this,"List Item clicked: " + clickedItemIndex, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(RecipeMainActivity.this,StepsIngredientsActivity.class);
        startActivity(intent);

    }

    //Create a new AsyncTask
    public class RecipeAsynctask extends AsyncTask<Void, Void, List<Recipe>> {

        @Override
        protected List<Recipe> doInBackground(Void... voids) {

            //Create URL
            URL urlApi = NetworkUtils.buildUrlApi();
            //Pass URL to the connection of internet
            try {
                String urlApiConnection = NetworkUtils.getResponseFromHttpUrl(urlApi);
                //Pass the string above to get RecipeJSON
                List<Recipe> recipeJson = JSONUtils.getRecipeJSONUtils(urlApiConnection);
                //Return
                return recipeJson;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Recipe> recipes) {
            mAdapter.swapData(recipes);
        }
    }

    public class IngredientsAsynctask extends AsyncTask<Void, Void, List<Ingredients>> {

        @Override
        protected List<Ingredients> doInBackground(Void... voids) {

            URL urlApi = NetworkUtils.buildUrlApi();

            try {
                String urlApiConnection = NetworkUtils.getResponseFromHttpUrl(urlApi);
                List<Ingredients> ingredientsJson = JSONUtils.getIngredientsJSONUtils(urlApiConnection);

                return ingredientsJson;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Ingredients> ingredients) {
            super.onPostExecute(ingredients);
        }
    }

    public class StepsAsynctask extends AsyncTask<Void, Void, List<Steps>> {

        @Override
        protected List<Steps> doInBackground(Void... voids) {

            URL urlApi = NetworkUtils.buildUrlApi();

            try {
                String urlApiConnection = NetworkUtils.getResponseFromHttpUrl(urlApi);
                List<Steps> stepsJson = JSONUtils.getStepsJSONUtils(urlApiConnection);

                return stepsJson;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Steps> steps) {
            super.onPostExecute(steps);
        }
    }
}
