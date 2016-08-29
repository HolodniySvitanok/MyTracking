/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holodniysvitanok.mytracking.service;

import com.holodniysvitanok.mytracking.globalresource.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Admin
 */
public class SimpleLogger {

    public synchronized static void writeToDoc(Exception error) { 
        try {
            File file = new File(Resource.ERROR_FILE);
            if(file.exists()){
                if(file.length() >= Resource.LENGTH_FILE_ERROR){
                    file.delete();
                }
            }
            
            error.printStackTrace(new PrintStream(new FileOutputStream(file, true)));
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
