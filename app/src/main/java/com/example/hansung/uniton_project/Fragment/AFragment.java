package com.example.hansung.uniton_project.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.hansung.uniton_project.R;

public class AFragment extends Fragment
{
    private LayoutInflater inflater;

    public AFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        this.inflater=inflater;
        View layout;
        layout = inflater.inflate(R.layout.fragment_a, container, false);
        return layout;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String text)
    {


    }

}
