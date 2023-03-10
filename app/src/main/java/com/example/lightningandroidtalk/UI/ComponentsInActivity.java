package com.example.lightningandroidtalk.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.lightningandroidtalk.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TooManyListenersException;

public class ComponentsInActivity extends AppCompatActivity {


    private EditText editDateText;
    private EditText editText;
    private String date;
    private String editTextString;
    private ComponentAdapter componentAdapter;
    private List<String> components = new ArrayList<>(Arrays.asList("TextView", "Button", "Switch", "Spinner"));
    private String format = "MM/dd/yyyy";
    private SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
    private final Calendar calendar = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener calendarDP;


    @SuppressLint("UseSwitchCompatOrMaterialCode")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components_in);

        editText = findViewById(R.id.editText);
        editDateText = findViewById(R.id.editDateText);

        editTextString = editText.getText().toString();
//        String format = "MM/dd/yyyy";
//        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        editDateText.setText(sdf.format(new Date()));

        RecyclerView rv = findViewById(R.id.componentRV);
        componentAdapter = new ComponentAdapter(this);
        rv.setAdapter(componentAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        componentAdapter.setListItems(components);

        Button next = findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView2);
                textView.setText(R.string.pressed);
            }
        });


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    TextView textView = findViewById(R.id.textView2);
                    textView.setText(R.string.switch_on);
                }else{
                    TextView textView = findViewById(R.id.textView2);
                    textView.setText(R.string.textview);
                }
            }
        });

        editDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String originalDate = editDateText.getText().toString();

                try {
                    calendar.setTime(Objects.requireNonNull(sdf.parse(originalDate)));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                new DatePickerDialog(ComponentsInActivity.this, calendarDP, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        calendarDP = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDate();
            }
        };

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

            for(int i = 0; i < components.size(); i++) {

                if(string.equalsIgnoreCase(components.get(i))) {
                    components.remove(i);
//                    System.out.println(components.get(i));
                }
            }

        }
    }

    public void updateDate() {
        editDateText.setText(sdf.format(calendar.getTime()));
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
                editTextString = editText.getText().toString();
                deleteFromRV(editTextString);
                componentAdapter.setListItems(components);
                return true;
            case R.id.toast:
                Toast.makeText(this, "Thank you for listening!", Toast.LENGTH_LONG).show();
                return true;
        }

        return false;
    }




}