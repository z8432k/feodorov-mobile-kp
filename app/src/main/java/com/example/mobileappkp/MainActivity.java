package com.example.mobileappkp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobileappkp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bindings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindings = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindings.getRoot());

        bindings.callGithub.setOnClickListener((View view) -> {
            Intent intent = new Intent(this, CommitsList.class);

            intent.putExtra("USER_NAME", bindings.user.getText());
            intent.putExtra("REPO", bindings.repo.getText());
            startActivity(intent);
        });
    }
}