package com.example.buds;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewEvent extends AppCompatActivity {

    private EditText editTexttitle;
    private EditText editTextdescription;
    private EditText editTextlocation;
    private NumberPicker numberPickerdate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addevent);

        editTexttitle = findViewById(R.id.event_title);
        editTextdescription=findViewById(R.id.event_description);
        editTextlocation=findViewById(R.id.event_location);
        numberPickerdate=findViewById(R.id.event_date);

        numberPickerdate.setMinValue(1);
        numberPickerdate.setMaxValue(32);

    }
    public void saveEvent(View v) {
        String title = editTexttitle.getText().toString();
        String description = editTextdescription.getText().toString();
        String location = editTextlocation.getText().toString();
        int date = numberPickerdate.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty() || location.trim().isEmpty()){
            Toast.makeText(this, "Insert Complete Title,Description and Location", Toast.LENGTH_SHORT).show();
            return;

        }
        CollectionReference eventRef= FirebaseFirestore.getInstance()
                .collection("EventsAdded");
        eventRef.add(new Event(title,description,location,date));
        Toast.makeText(this, "Event Added", Toast.LENGTH_SHORT).show();
        finish();
    }

}

