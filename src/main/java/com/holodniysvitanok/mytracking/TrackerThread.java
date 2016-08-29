/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holodniysvitanok.mytracking;

import com.holodniysvitanok.mytracking.context.Context;
import com.holodniysvitanok.mytracking.gui.MyModelForJTable;
import com.holodniysvitanok.mytracking.models.Data;
import com.holodniysvitanok.mytracking.models.Order;
import com.holodniysvitanok.mytracking.service.Tracker;

/**
 *
 * @author Admin
 */
public class TrackerThread implements Runnable { // 

    private Context context;
    private Data data;
    private Order order;
    private MyModelForJTable tableModel;
    
    public TrackerThread(Context context, Data data, Order order, MyModelForJTable tableModel) {
        this.context = context;
        this.tableModel = tableModel;
        this.order = order;
        this.data = data;
    }

    @Override
    public void run() {
        new Tracker(context, data, tableModel, order).lookForTrack(); 
    }

}
