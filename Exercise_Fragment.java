package com.example.befit;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Exercise_Fragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        return inflater.inflate(R.layout.activity_exercise,null);

    }
}
