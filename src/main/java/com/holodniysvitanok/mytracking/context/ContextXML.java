/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holodniysvitanok.mytracking.context;

import com.holodniysvitanok.mytracking.models.Data;
import com.holodniysvitanok.mytracking.globalresource.Resource;
import com.holodniysvitanok.mytracking.models.Order;
import com.holodniysvitanok.mytracking.service.SimpleLogger;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Admin
 */
public class ContextXML implements Context {

    private JAXBContext context;

    public ContextXML() {
        try {
            context = JAXBContext.newInstance(Data.class);
        } catch (JAXBException ex) {
            SimpleLogger.writeToDoc(ex);
            System.exit(-1);
        }
    }

    
    
    @Override
    public void setConfig(Data data) {
        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(data, new File(Resource.DATA_FILE));
        } catch (JAXBException ex) {
            SimpleLogger.writeToDoc(ex);
        }
    }

    @Override
    public synchronized Data getConfig() {
        Data data = readConfig();
        if (data == null) {
            defualtConfig();
            data = readConfig();
        }
        return data;
    }

    @Override
    public synchronized void addOrder(Order order) {
        Data config = getConfig();
        config.addOrders(order);
        setConfig(config);
    }

    @Override
    public synchronized void deleteOrder(Order order) {
        Data config = getConfig();
        config.deleteOrder(order);
        setConfig(config);
    }

    @Override
    public synchronized void updateOrders(List<Order> orders) {
        Data config = getConfig();
        config.setOrders(orders);
        setConfig(config);
    }

    private Data readConfig() {

        Unmarshaller unmarshaller = null;
        Data data = null;
        try {
            unmarshaller = context.createUnmarshaller();
            data = (Data) unmarshaller.unmarshal(new File(Resource.DATA_FILE));
        } catch (JAXBException ex) {
            SimpleLogger.writeToDoc(ex);
        }
        return data;
    }

    private void defualtConfig() {
        Data data = new Data(
                Resource.START_HIDE,
                Resource.RESOURCE_URL,
                Resource.TIME_BETWEEN_REQUEST,
                Resource.POOL_SIZE,
                Resource.SEARCH_WORD_1,
                Resource.SEARCH_WORD_2,
                Resource.SEARCH_WORD_3,
                Resource.TEXT_WORD_1,
                Resource.TEXT_WORD_2,
                Resource.TEXT_WORD_3,
                Resource.NOT_FOUND_TEXT,
                Resource.CHARSET);
        setConfig(data);
    }

}
