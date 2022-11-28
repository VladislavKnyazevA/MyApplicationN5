package com.vladislavknyazev.myapplicationn5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.View;

import com.vladislavknyazev.myapplicationn4.R;

public class MainActivity extends AppCompatActivity {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }


}