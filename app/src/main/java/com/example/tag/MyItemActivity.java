package com.example.tag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MyItemActivity extends AppCompatActivity {

    private ImageButton editButton;
    private ImageButton findButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_item);

        Bundle extras = getIntent().getExtras();
        String itemName = extras.getString("Item");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(itemName);
        setSupportActionBar(toolbar);


        // Initialize all buttons
        editButton = (ImageButton) findViewById(R.id.editButton);
        findButton = (ImageButton) findViewById(R.id.mapButton);



        // Set listeners to open new intents in Android
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyItemActivity.this, "Edit Item", Toast.LENGTH_SHORT).show();
                Intent findIntent = new Intent(MyItemActivity.this, EditItem.class);
                findIntent.putExtra("Item", itemName);
                startActivity(findIntent);
            }
        });

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyItemActivity.this, "Locate Item", Toast.LENGTH_SHORT).show();
                Intent findIntent = new Intent(MyItemActivity.this, GPSFindActivity.class);
                startActivity(findIntent);
            }
        });
    }
}
