/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holodniysvitanok.mytracking.context;

import com.holodniysvitanok.mytracking.models.Data;
import com.holodniysvitanok.mytracking.models.Order;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface Context {

    void setConfig(Data data);

    Data getConfig();

    void addOrder(Order order);

    void deleteOrder(Order order);
    
    void updateOrders(List<Order> orders);
}
