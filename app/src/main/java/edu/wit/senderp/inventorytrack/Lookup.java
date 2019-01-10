package edu.wit.senderp.inventorytrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Lookup extends AppCompatActivity {
    EditText inputView;
    TextView resultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookup);
        findViewById(R.id.lkup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView = findViewById(R.id.return_item);
                resultView.setText(loadJSONFROMAsset());
            }
        });



    }
    public String loadJSONFROMAsset() {
        String json = null;
        String test = "test";

        try {
            InputStream is = getAssets().open("inventory.json");
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj != null) {
                    inputView = findViewById(R.id.enter_item);

                    if (inputView.getText().toString().equals(obj.getString("name"))) {

                        test = "Name: " +obj.getString("name") + " qty:" + obj.getInt("qty");

                    }
                    else if (inputView.getText().toString().equals(obj.getString("_id"))) {

                        test = "Name: "+ obj.getString("name") + " qty:" + obj.getInt("qty");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return test;
    }
}
