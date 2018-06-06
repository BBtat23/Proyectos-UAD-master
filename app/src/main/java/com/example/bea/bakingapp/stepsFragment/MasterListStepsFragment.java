package com.example.bea.bakingapp.stepsFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bea.bakingapp.R;

// This fragment displays the MediaPlayer, Recipe step instruction and Navigation in one large list
public class MasterListStepsFragment extends Fragment {

    //Mandatory empty constructor
    public MasterListStepsFragment(){};

    //Inflates views

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_steps_master_list,container,false);

        return rootView;
    }
}
