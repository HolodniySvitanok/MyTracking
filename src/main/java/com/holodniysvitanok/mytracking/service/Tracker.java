/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holodniysvitanok.mytracking.service;

import com.holodniysvitanok.mytracking.context.Context;
import com.holodniysvitanok.mytracking.globalresource.Resource;
import com.holodniysvitanok.mytracking.gui.MyModelForJTable;
import com.holodniysvitanok.mytracking.models.Data;
import com.holodniysvitanok.mytracking.models.Order;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Admin
 */
public class Tracker {

    private Context context;
    private Data data;
    private MyModelForJTable tableModel;
    private Order order;

    public Tracker(Context context, Data data, MyModelForJTable tableModel, Order order) {
        this.context = context;
        this.data = data;
        this.tableModel = tableModel;
        this.order = order;
    }

    private String geHtmltPage() { // загружает страницу с информацией о треке
        String temp = null;
        BufferedReader bReader = null;
        try {
            URL url = new URL(data.getPostUrl() + order.getTrackNumber());
            bReader = new BufferedReader(new InputStreamReader(url.openStream(), data.getCharSet()));
            StringBuilder sb = new StringBuilder();
            while ((temp = bReader.readLine()) != null) {
                sb.append(temp);
            }
            temp = sb.toString();
        } catch (IOException ex) {
            SimpleLogger.writeToDoc(ex);
        } finally {
            if (bReader != null) {
                try {
                    bReader.close();
                } catch (IOException ex) {
                }
            }
        }
        return temp;
    }

    public void lookForTrack() { // метод проверяет ключевые слова в тексте страницы
        String htmlContent = geHtmltPage();
        if (htmlContent.contains(data.getSearchWord1())) {
            order.setFlagWord1(true);
            if (!order.isShowMessageWord1()) {
                tableModel.getTray().showAction("\""+order.getName() + "\" " + Resource.TEXT_WORD_1);
                order.setShowMessageWord1(true);
                update();
            }
            return;
        }
        if (htmlContent.contains(data.getSearchWord2())) {
            order.setFlagWord2(true);
            if (!order.isShowMessageWord2()) {
                tableModel.getTray().showAction("\""+order.getName() + "\" " + Resource.TEXT_WORD_2);
                order.setShowMessageWord2(true);
                update();
            }
            return;
        }
        if (htmlContent.contains(data.getSearchWord3())) {
            order.setFlagWord3(true);
            if (!order.isShowMessageWord3()) {
                tableModel.getTray().showAction("\""+order.getName() + "\" " + Resource.TEXT_WORD_3);
                order.setShowMessageWord3(true);
                update();
            }
        }
    }

    private void update() { // обновляет xml и содержимое JTable
        context.updateOrders(tableModel.getOrders());
        tableModel.fireTableDataChanged();
    }
}
