package edu.wit.senderp.inventorytrack;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Print extends AppCompatActivity {
    ArrayList<Customer> numberList = new ArrayList<>();
    ArrayList<String> subList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        loadJSONFROMAsset();

        CustomerAdapter customerAdapter = new CustomerAdapter(this, numberList);
       ListView list = findViewById(R.id.customers);
       list.setAdapter(customerAdapter);


    }
    public String loadJSONFROMAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("customers.json");
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj != null) {
                    JSONArray subArray = obj.getJSONArray("activeRentals");
                    Customer newCustomer = new Customer(null, null, "No active Rentals", 0);
                        newCustomer.setcName(obj.getString("name"));
                        newCustomer.setBalance(obj.getString("balance"));
                        if (subArray != null) {
                            for (int j = 0; j < subArray.length(); j++) {
                                JSONObject subObj = subArray.getJSONObject(j);
                                if (subObj != null && obj.getBoolean("isActive")) {
                                   subList.add(subObj.getString("equipmentID"));
                                }
                            }
                        }
                        numberList.add(newCustomer);

                }
            }



            //Toast.makeText(getApplicationContext(), numberList.toString(), Toast.LENGTH_LONG).show();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
