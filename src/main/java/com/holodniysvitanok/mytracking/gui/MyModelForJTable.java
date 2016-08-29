/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holodniysvitanok.mytracking.gui;

import com.holodniysvitanok.mytracking.globalresource.Resource;
import com.holodniysvitanok.mytracking.models.Data;
import com.holodniysvitanok.mytracking.models.Order;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class MyModelForJTable extends AbstractTableModel {

    private List<Order> orders;
    private Data data;
    private SysTray sysTray;
    
    public MyModelForJTable(List<Order> orders, Data data) {
        this.data = data;
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return Resource.DATE_ORDER;
            case 1:
                return Resource.NAME_ORDER;
            case 2:
                return Resource.TRACK_ORDER;
            case 3:
                return Resource.DESCRIPTION_ORDER;
            case 4:
                return Resource.STATUS_ORDER;
            default:
                return "";
        }
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return orders.get(rowIndex).getDate();
            case 1:
                return orders.get(rowIndex).getName();
            case 2:
                return orders.get(rowIndex).getTrackNumber();
            case 3:
                return orders.get(rowIndex).getDescription();
            case 4:
                return orders.get(rowIndex).getStatus(data);
            default:
                return "";
        }
    }

    public void setTray(SysTray sysTray) {
        this.sysTray = sysTray;
    }
    
    public SysTray getTray(){
        return sysTray;
    }
}
