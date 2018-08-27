/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tepach;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;

/**
 *
 * @author Anthony Tepach
 */
public class Dividir {
    public void particiona(String fileLocation, String outputFolder,int cantidad) {
        try {
            int linesPerFile = cantidad +1;
            String filename = FilenameUtils.getBaseName(fileLocation);
            String extension = FilenameUtils.getExtension(fileLocation);
            File fileToRead = new File(fileLocation);
            int fileCounter = 0;
            int counter = 1;
            List<String> newLines = new ArrayList<>();

            LineIterator it = FileUtils.lineIterator(fileToRead);
            try {
                while (it.hasNext()) {
                    String line = it.nextLine();
                    newLines.add(line);
                    counter++;
                    if (counter == linesPerFile
                            || (counter < linesPerFile && !it.hasNext())) {
                        File outputFolderFile = new File(outputFolder);
                        outputFolderFile.mkdirs();

                        String newFileLocation = outputFolder + "/" + filename
                                + "-" + (++fileCounter) + "." + extension;
                        File outputFile = new File(newFileLocation);
                        FileUtils.writeLines(outputFile, newLines);
                        newLines.clear();
                        counter = 1;
                    }
                }
            } finally {
                LineIterator.closeQuietly(it);
               
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
