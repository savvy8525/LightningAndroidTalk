package com.example.lightningandroidtalk.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.lightningandroidtalk.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TooManyListenersException;

public class ComponentsInActivity extends AppCompatActivity {

    private EditText editText;
    String editTextString;
    ComponentAdapter componentAdapter;
    List<String> components = new ArrayList<>(Arrays.asList("TextView", "Button", "Switch", "Spinner"));


    @SuppressLint("UseSwitchCompatOrMaterialCode")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components_in);

        editText = findViewById(R.id.editText);
        editTextString = editText.getText().toString();

//        System.out.println(components);

        RecyclerView rv = findViewById(R.id.componentRV);
        componentAdapter = new ComponentAdapter(this);
        rv.setAdapter(componentAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        componentAdapter.setListItems(components);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView rv = findViewById(R.id.componentRV);
        componentAdapter = new ComponentAdapter(this);
        rv.setAdapter(componentAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        componentAdapter.setListItems(components);
    }

    public void addToRV(String string) {
        if(string != null) {
            components.add(string);
        }

    }

    public void deleteFromRV(String string) {
        if(string != null) {

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_components_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add:
                editText= findViewById(R.id.editText);
                editTextString = editText.getText().toString();
                    addToRV(editTextString);
                componentAdapter.setListItems(components);
                return true;
            case R.id.delete:
                editText= findViewById(R.id.editText);
                editTextString = editText.toString();
                    deleteFromRV(editTextString);
                    componentAdapter.setListItems(components);
                    System.out.println(components);
                return true;
            case R.id.toast:
                Toast.makeText(this, "Thank you for listening!", Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }




}