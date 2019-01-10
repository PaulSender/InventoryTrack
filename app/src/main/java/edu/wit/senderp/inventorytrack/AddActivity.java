package edu.wit.senderp.inventorytrack;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AutoText;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // back button //
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // end back //

        // save button //
        findViewById(R.id.save_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    // Variables (NO TAGS) - VERSION 1.1 //
               String name =  ((EditText) findViewById(R.id.name)).getText().toString();
               Double value = Double.parseDouble(((EditText) findViewById(R.id.value)).getText().toString());
               int quantity = Integer.parseInt(((EditText) findViewById(R.id.quantity)).getText().toString());
               String brand   = ((EditText) findViewById(R.id.brand)).getText().toString();
               String desc = ((EditText) findViewById(R.id.description)).getText().toString();

                // End variable declaration //

                // Write to Inventory.JSON //


                   finish();

                   //toast message //



            }
        });


    }

}
