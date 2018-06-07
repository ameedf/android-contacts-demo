package com.ameed.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(
                v -> {
                    Intent addNewActivity = new Intent(this, ContactActivity.class);
                    startActivity(addNewActivity);
                }
        );

        final Button showAllButton = findViewById(R.id.showAllButton);
        showAllButton.setOnClickListener(
                v -> {
                    Intent showAllActivity = new Intent(this, ContactsListActivity.class);
                    startActivity(showAllActivity);
                }
        );


    }
}
