package com.example.bea.bakingapp.stepsFragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bea.bakingapp.R;
import com.example.bea.bakingapp.StepsActivity;

public class StepsFragment extends Fragment {

    //Mandatory constructor for instantiating the fragment
    public StepsFragment(){
    }

    /**
     * Inflates the fragment layout and sets any image resources
     * */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //Inflate the Steps descrption fragment layout
        View rootView = inflater.inflate(R.layout.fragment_steps_part,container,false);

        //Get a reference to the ImageView in the fragment layout
        TextView textView = (TextView) rootView.findViewById(R.id.steps_list);

        //Set the image resource to display
        textView.setText("prueba");

        //Set a click listener on the textView
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),StepsActivity.class);
                startActivity(intent);
            }
        });

        //Return root view
        return rootView;
    }
}
