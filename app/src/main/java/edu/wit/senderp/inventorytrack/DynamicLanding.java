package edu.wit.senderp.inventorytrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DynamicLanding extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_landing);

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

        // End Print //
        ///////////////////

        // Current Inventory //

        //End Current //
        ///////////////////
    }
}
