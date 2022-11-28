package com.vladislavknyazev.myapplicationn4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangeFragment(View view) {
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.button:
                fragment = new FragmentOne();
                break;
            case R.id.button2:
                fragment = new FragmentTwo();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_place, fragment);
        ft.commit();
    }
}