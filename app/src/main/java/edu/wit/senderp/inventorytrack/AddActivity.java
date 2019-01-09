package edu.wit.senderp.inventorytrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AutoText;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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
               try {
                   File inventoryJSON = new File("C://Users//senderp//AndroidStudioProjects//InventoryTrack//app//src//main//assets//inventory.json");
                   String strFileJson = AddActivity.getStringFromFile(inventoryJSON.toString());
                   JSONObject jsonObj = new JSONObject(strFileJson);


                   jsonObj.put("name", name);
                   jsonObj.put("value", value);
                   jsonObj.put("quantity", quantity);
                   jsonObj.put("brand", brand);
                   jsonObj.put("description", desc);
                   // put tags arraylist here //

                   writeJsonFile(inventoryJSON, jsonObj.toString());
                   //finish();

                   //toast message //


               }
               catch (Exception e) {
                   e.printStackTrace();
               }
            }
        });


    }
    public static String getStringFromFile(String filePath) throws Exception {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        String ret = convertStreamToString(fin);
        //Make sure you close all streams.
        fin.close();
        return ret;
    }

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public static void writeJsonFile(File file, String json) {
        BufferedWriter bufferedWriter = null;
        try {

            if (!file.exists()) {
                Log.e("App", "file not exist");
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
