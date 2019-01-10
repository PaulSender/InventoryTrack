package edu.wit.senderp.inventorytrack;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
    public String balance;
    public String cName;
    public String nameOfItem;
    public int qty;

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }



    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }



    public Customer(String balance, String cName,String nameOfItem, int qty) {
        this.cName = cName;
        this.balance = balance;
        this.nameOfItem = nameOfItem;
        this.qty = qty;

    }




}
