package com.example.hansung.uniton_project.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.hansung.uniton_project.R;

public class FragmentActivity extends AppCompatActivity
{
    private RelativeLayout innerRelativeLayout;
    private AFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        findViews();
    }

    private void findViews()
    {
        innerRelativeLayout = (RelativeLayout) findViewById(R.id.inner_relative_layout);
        fragment = new AFragment();
        addRegionButtons(innerRelativeLayout);
    }

    private void addRegionButtons(RelativeLayout layout)
    {
        if(layout != null)
        {
            RegionButtonListener regionButtonListener = new RegionButtonListener(FragmentActivity.this, fragment);

            String[] strArr = new String[20];


            //TODO: 반복할 부분
            Button button = new Button(FragmentActivity.this);
            button.setOnClickListener(regionButtonListener);
            button.setTextColor(getApplication().getResources().getColor(R.color.textGray));
            button.setText("서울");
            button.setBackgroundColor(0x00FFFFFF);
            layout.addView(button);

        }
    }


}


class RegionButtonListener implements View.OnClickListener
{
    private Context mContext;
    private AFragment fragment;

    public RegionButtonListener(Context context, AFragment fragment)
    {
        mContext = context;
        this.fragment = fragment;
    }

    @Override
    public void onClick(View v)
    {
        Button button = (Button)v;
        String text = button.getText().toString();
        fragment.onButtonPressed(text);
    }
}