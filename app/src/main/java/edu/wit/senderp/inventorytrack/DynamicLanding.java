package edu.wit.senderp.inventorytrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DynamicLanding extends AppCompatActivity {
    ArrayList<Item> itemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_landing);
        // Aval Items //
        loadJSONFROMAsset();
        SummaryAdapter summaryAdapter = new SummaryAdapter(this, itemList);
        ListView list = findViewById(R.id.aval_inv);
        list.setAdapter(summaryAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                findViewById(R.id.item_desc).setVisibility(View.VISIBLE);
            }
        });
        // End Aval Items //

        // Add button //
        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DynamicLanding.this, AddActivity.class);
                DynamicLanding.this.startActivityForResult(i, 100);
            }
        });
        // End Add //

        ///////////////////

        // Rent button //

        // End Rent //
        ////////////////////

        // Lookup Button //
        findViewById(R.id.lookup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DynamicLanding.this, Lookup.class);
                DynamicLanding.this.startActivity(i);
            }
        });
        // End Lookup //
        ///////////////////

        // Print Manifest/Records //
        findViewById(R.id.print).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DynamicLanding.this, Print.class);
                DynamicLanding.this.startActivity(i);
            }
        });
    }
        // End Print //
        ///////////////////

        // Current Inventory Parsing //
        public String loadJSONFROMAsset () {
    String json = null;
            try {
                InputStream is = getAssets().open("inventory.json");
                int size = is.available();

                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
                JSONArray jsonArray = new JSONArray(json);

                for (int i = 0; i < jsonArray.length(); i++) {
                    Item newItem = new Item(null, 0.0, 0, null, null);
                    JSONObject obj = jsonArray.getJSONObject(i);
                    if (obj != null) {
                        newItem.setName("Name: " + obj.getString("name"));
                        newItem.setQuantity(obj.getInt("qty"));
                        newItem.setBrand("Company: " + obj.getString("company"));
                        newItem.setDescription(obj.getString("about"));
                        itemList.add(newItem);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return json;
            //End Current //
            ///////////////////
        }
    }
