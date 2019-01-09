package edu.wit.senderp.inventorytrack;

import org.json.JSONException;
import org.json.JSONObject;

public class ItemUtil {
    public static String toJson(Item item) {
        try {
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("name", item.getName());
            jsonobj.put("value", item.getValue());
            jsonobj.put("quantity",item.getQuantity());
            jsonobj.put("brand", item.getQuantity());
            jsonobj.put("description", item.getDescription());

            return jsonobj.toString();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
