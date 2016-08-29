/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holodniysvitanok.mytracking.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Order {

    private String name; 
    private String description; 
    private String trackNumber; 
    private Date date; 
    private boolean flagWord1; 
    private boolean flagWord2; 
    private boolean flagWord3; 
    private boolean showMessageWord1;
    private boolean showMessageWord2;
    private boolean showMessageWord3;

    public Order(String date, String name, String description, String trackNumber) throws ParseException {
        this.name = name;
        this.description = description;
        this.trackNumber = trackNumber;
        setDate(date);
    }

    public Order() {
    }

    public String getStatus(Data data) { // ух ;((((
        final String tagStart = "<html><font color=";
        final String tagStop = "</font></html>";
        final String green = "green>";
        final String red = "red>";
        final String yellow = "yellow>";
        final String blue = "blue>";

        if (flagWord1) {
            return tagStart + blue + data.geTtextWord1() + tagStop;
        }
        if (flagWord3) {
            return tagStart + green + data.getTextWord3() + tagStop;
        }
        if (flagWord2) {
            return tagStart + yellow + data.getTestWord2() + tagStop;
        }
        return tagStart + red + data.getNotFoundText() + tagStop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public boolean isFlagWord1() {
        return flagWord1;
    }

    public void setFlagWord1(boolean flagWord1) {
        this.flagWord1 = flagWord1;
    }

    public boolean isFlagWord2() {
        return flagWord2;
    }

    public void setFlagWord2(boolean flagWord2) {
        this.flagWord2 = flagWord2;
    }

    public boolean isFlagWord3() {
        return flagWord3;
    }

    public void setFlagWord3(boolean flagWord3) {
        this.flagWord3 = flagWord3;
    }

    public boolean isShowMessageWord1() {
        return showMessageWord1;
    }

    public void setShowMessageWord1(boolean showMessageWord1) {
        this.showMessageWord1 = showMessageWord1;
    }

    public boolean isShowMessageWord2() {
        return showMessageWord2;
    }

    public void setShowMessageWord2(boolean showMessageWord2) {
        this.showMessageWord2 = showMessageWord2;
    }

    public boolean isShowMessageWord3() {
        return showMessageWord3;
    }

    public void setShowMessageWord3(boolean showMessageWord3) {
        this.showMessageWord3 = showMessageWord3;
    }

    public String getDate() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

    public void setDate(String date) throws ParseException {
        if(date.equals("")){
            this.date = new Date();
            return;
        }
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        this.date = formater.parse(date);
    }

}
