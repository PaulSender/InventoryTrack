package edu.wit.senderp.inventorytrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomerAdapter extends ArrayAdapter<Customer> {
ArrayList<String> subList = new ArrayList<>();
    public CustomerAdapter(Context context, ArrayList<Customer> customers) {
        super(context, 0, customers);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Customer customer = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cus_list, parent, false);
        }
        // Lookup view for data population
        TextView cusName =  convertView.findViewById(R.id.name);
        TextView cBalance =  convertView.findViewById(R.id.balance);

        ListView subList = convertView.findViewById(R.id.sub_list);
        TextView cItems = convertView.findViewById(R.id.itemsout);
        // Populate the data into the template view using the data object
       cusName.setText(customer.cName);
       cBalance.setText(customer.balance);


        // Return the completed view to render on screen
        return convertView;
    }

    }
