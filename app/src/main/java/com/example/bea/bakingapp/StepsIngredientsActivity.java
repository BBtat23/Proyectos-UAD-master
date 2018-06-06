package com.example.bea.bakingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.bea.bakingapp.stepsFragment.StepsFragment;

public class StepsIngredientsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steps_ingredients_main);

        //New StepsFragment instance
        StepsFragment stepsFragment = new StepsFragment();

        //Use a FragmentManager and transaction to add the fragment to the screen
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Fragment transaction
        fragmentManager.beginTransaction()
                .add(R.id.steps_container,stepsFragment)
                .commit();


    }
}
