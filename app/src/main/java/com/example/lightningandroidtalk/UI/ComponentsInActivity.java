package com.example.lightningandroidtalk.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.lightningandroidtalk.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComponentsInActivity extends AppCompatActivity {

    ComponentAdapter componentAdapter;
    List<String> components = new ArrayList<>(Arrays.asList("TextView", "Button", "Switch", "Spinner"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components_in);

        System.out.println(components);

        RecyclerView rv = findViewById(R.id.componentRV);
        componentAdapter = new ComponentAdapter(this);
        rv.setAdapter(componentAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        componentAdapter.setListItems(components);

//        Spinner
    }




}