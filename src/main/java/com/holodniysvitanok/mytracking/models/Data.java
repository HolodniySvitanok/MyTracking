/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holodniysvitanok.mytracking.models;

import com.holodniysvitanok.mytracking.globalresource.Resource;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@XmlRootElement(name = "Conf")
public class Data {

    private boolean startHide;
    private String postUrl; 
    private int timeBetweenRequest; 
    private int poolSize; 

    private String searchWord1; 
    private String searchWord2; 
    private String searchWord3; 

    private String textWord1;
    private String testWord2;
    private String textWord3;
    private String notFoundText;

    private String charSet; 
    private List<Order> orders = new ArrayList(); 

    public Data() {
    }

    public Data(boolean startHide, String postUrl, int timeBetweenRequest, int poolSize, String searchWord1, String searchWord2, String searchWord3, String textWord1, String testWord2, String textWord3, String notFoundText, String charSet) {
        this.startHide = startHide;
        this.postUrl = postUrl;
        this.timeBetweenRequest = timeBetweenRequest;
        this.poolSize = poolSize;
        this.searchWord1 = searchWord1;
        this.searchWord2 = searchWord2;
        this.searchWord3 = searchWord3;
        this.textWord1 = textWord1;
        this.testWord2 = testWord2;
        this.textWord3 = textWord3;
        this.notFoundText = notFoundText;
        this.charSet = charSet;
    }

    public String getNotFoundText() {
        return notFoundText;
    }

    @XmlElement
    public void setNotFoundText(String notFoundText) {
        this.notFoundText = notFoundText;
    }

    public String geTtextWord1() {
        return textWord1;
    }

    @XmlElement
    public void setTextWord1(String textWord1) {
        this.textWord1 = textWord1;
    }

    public String getTestWord2() {
        return testWord2;
    }

    @XmlElement
    public void setTestWord2(String testWord2) {
        this.testWord2 = testWord2;
    }

    public String getTextWord3() {
        return textWord3;
    }

    @XmlElement
    public void setTextWord3(String textWord3) {
        this.textWord3 = textWord3;
    }

    public String getSearchWord1() {
        return searchWord1;
    }

    @XmlElement
    public void setSearchWord1(String searchWord1) {
        this.searchWord1 = searchWord1;
    }

    public String getSearchWord2() {
        return searchWord2;
    }

    @XmlElement
    public void setSearchWord2(String searchWord2) {
        this.searchWord2 = searchWord2;
    }

    public String getSearchWord3() {
        return searchWord3;
    }

    @XmlElement
    public void setSearchWord3(String searchWord3) {
        this.searchWord3 = searchWord3;
    }

    public boolean isStartHide() {
        return startHide;
    }

    @XmlElement
    public void setStartHide(boolean startHide) {
        this.startHide = startHide;
    }

    public String getPostUrl() {
        return postUrl;
    }

    @XmlElement
    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public int getTimeBetweenRequest() {
        return timeBetweenRequest;
    }

    @XmlElement
    public void setTimeBetweenRequest(int timeBetweenRequest) {
        this.timeBetweenRequest = timeBetweenRequest;
    }

    public int getPoolSize() {
        return poolSize;
    }

    @XmlElement
    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public String getCharSet() {
        return charSet;
    }

    @XmlElement
    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @XmlElement(name = "order")
    @XmlElementWrapper(name = "orders")
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrders(Order order) {
        orders.add(order);
    }

    public void deleteOrder(Order order) {
        orders.remove(order);
    }

    public void setDef() {
        this.postUrl = Resource.RESOURCE_URL;
        this.timeBetweenRequest = Resource.TIME_BETWEEN_REQUEST;
        this.poolSize = Resource.POOL_SIZE;
        this.searchWord1 = Resource.SEARCH_WORD_1;
        this.searchWord3 = Resource.SEARCH_WORD_3;
        this.searchWord2 = Resource.SEARCH_WORD_2;
        this.charSet = Resource.CHARSET;
        this.textWord1 = Resource.TEXT_WORD_1;
        this.testWord2 = Resource.TEXT_WORD_2;
        this.textWord3 = Resource.TEXT_WORD_3;
    }

}
