package edu.wit.senderp.inventorytrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SummaryAdapter extends ArrayAdapter<Item> {
    ArrayList<Item> itemsList = new ArrayList<>();

    public SummaryAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cus_aval_inv_list, parent, false);
        }
        // Lookup view for data population
        TextView itemName = convertView.findViewById(R.id.item_name);
        TextView itemQty = convertView.findViewById(R.id.item_quantity);
        TextView itemBrand = convertView.findViewById(R.id.item_brand);
        TextView itemDesc = convertView.findViewById(R.id.item_desc);
        itemName.setText(item.getName());
        itemQty.setText(Integer.toString(item.getQuantity()));
        itemBrand.setText(item.getBrand());
        itemDesc.setText(item.getDescription());

        return convertView;
    }

}