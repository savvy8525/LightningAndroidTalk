package com.example.lightningandroidtalk.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lightningandroidtalk.R;

public class PartsOfXML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_of_xml);

        Button next = findViewById(R.id.nextComponents);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartsOfXML.this, ComponentsInActivity.class);
                startActivity(intent);
            }
        });
    }
}