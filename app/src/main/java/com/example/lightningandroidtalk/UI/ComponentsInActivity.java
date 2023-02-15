package com.example.lightningandroidtalk.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.lightningandroidtalk.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComponentsInActivity extends AppCompatActivity {

    ComponentAdapter componentAdapter;
    List<String> components = new ArrayList<>(Arrays.asList("TextView", "Button", "Switch", "Spinner"));


    @SuppressLint("UseSwitchCompatOrMaterialCode")
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

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

//        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.switch1);
//        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.switch1);

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    TextView textView  = findViewById(R.id.textView2);
                    textView.setText(R.string.switch_on);
                }else{
                    TextView textView  = findViewById(R.id.textView2);
                    textView.setText(R.string.textview);
                }
            }
        });


    }






}