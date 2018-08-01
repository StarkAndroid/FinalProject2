package com.example.jokeandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class JokeAndroidActivity extends AppCompatActivity {

    TextView jokeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_android);

        jokeTV = findViewById(R.id.androidJoke);

        Intent intent = getIntent();
        if (intent!=null) {
            jokeTV.setText(intent.getStringExtra("joke"));
        } else jokeTV.setText("No joke");

    }
}
