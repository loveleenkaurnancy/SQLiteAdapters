package com.kitkatstudio.sqliteadapters;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kitkatstudio.sqliteadapters.fragments.ShowFragment;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content, new ShowFragment()).commit();
    }
}
