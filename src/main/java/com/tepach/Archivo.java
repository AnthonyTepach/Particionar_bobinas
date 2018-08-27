/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tepach;


import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony Tepach
 */
public class Archivo {
    String[] ficheros;
    
    void cargarFicheros(File file){
        ficheros=file.list();
    }
    String leer(Frame frame){
        String ruta = null;
        FileDialog dialogoArchivo;
        dialogoArchivo = new FileDialog(frame, "Particionar.....", FileDialog.LOAD);
        dialogoArchivo.setVisible(true);
        ruta = dialogoArchivo.getDirectory() + dialogoArchivo.getFile();
        return ruta;
    }
    long numLineas(String f){
    long lNumeroLineas = 0;
    String a;
        try {    
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            while ((a = bf.readLine())!=null) {
                    lNumeroLineas++;
                  }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    return lNumeroLineas;
    }
    String nomTxt(String a){
        File f=new File(a);
        return f.getName();
    }
    String carpetaTxt(String a){
        File f=new File(a);
        return f.getParent()+"\\";
    }
    String[] listArchivos(String a){
        File dir = new File(a);
        return ficheros = dir.list();
    }
}
