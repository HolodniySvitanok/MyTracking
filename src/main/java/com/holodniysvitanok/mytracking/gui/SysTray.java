package com.holodniysvitanok.mytracking.gui;

import com.holodniysvitanok.mytracking.globalresource.Resource;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SysTray {

    private SystemTray sysTray;
    private TrayIcon trayIcon;

    public SysTray() throws IOException {
        sysTray = SystemTray.getSystemTray();
        trayIcon = new TrayIcon(ImageIO.read(new File("ico.gif")), Resource.TITLE);
        
    }

    public TrayIcon getTrayIcon() {
        return trayIcon;
    }

    public void setTrayIcon(TrayIcon trayIcon) {
        this.trayIcon = trayIcon;
    }

    public void addTray() throws AWTException {
        sysTray.add(trayIcon);
        trayIcon.displayMessage(Resource.TITLE, Resource.TRAY_MESSAGE, TrayIcon.MessageType.NONE);
    }

    public void removeTray() {
        sysTray.remove(trayIcon);
    }

    public void showAction(String str){
        trayIcon.displayMessage(Resource.TITLE, str, TrayIcon.MessageType.INFO);
    }
}
