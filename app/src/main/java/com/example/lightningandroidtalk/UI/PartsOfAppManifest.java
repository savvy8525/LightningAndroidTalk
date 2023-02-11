package com.example.lightningandroidtalk.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lightningandroidtalk.R;

public class PartsOfAppManifest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_of_app_manifest);

        Button next = findViewById(R.id.nextXML);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartsOfAppManifest.this, PartsOfXML.class);
                startActivity(intent);
            }
        });
    }
}