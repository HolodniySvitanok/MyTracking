/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holodniysvitanok.mytracking;

import com.holodniysvitanok.mytracking.context.ContextXML;
import com.holodniysvitanok.mytracking.context.Context;
import com.holodniysvitanok.mytracking.gui.MainWindow;
import com.holodniysvitanok.mytracking.gui.MyModelForJTable;
import com.holodniysvitanok.mytracking.models.Data;
import com.holodniysvitanok.mytracking.models.Order;
import com.holodniysvitanok.mytracking.service.SimpleLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Admin
 */
public class Application {

    private static Context context;
    private static Data data;
    private static MyModelForJTable model;

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            context = new ContextXML();
            data = context.getConfig();
            model = new MyModelForJTable(data.getOrders(), data);

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MainWindow(context, model).setVisible(!data.isStartHide());
                }
               
            });
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            SimpleLogger.writeToDoc(ex);
            System.exit(-1);
        }

        ExecutorService eServixe = Executors.newFixedThreadPool(data.getPoolSize());

        while (true) { 
            for (Order order : data.getOrders()) { 
                eServixe.execute(new TrackerThread(context, data, order, model));
            }
            try {
                TimeUnit.SECONDS.sleep(data.getTimeBetweenRequest());
            } catch (InterruptedException ex) {
                SimpleLogger.writeToDoc(ex);
            }
        }

    }
}
