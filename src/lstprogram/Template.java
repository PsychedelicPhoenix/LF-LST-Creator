/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lstprogram;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;


/**
 *
 * @author andre
 */
public class Template implements Serializable{
    
    private int fieldLength;
    private String docType, templateName;
    private int[] folder1Array, folder2Array, docArray, fieldIndexes;
    private ArrayList<int[]> folderArray;
    
    public Template() {
        
    }
    
    
    public void saveTemplate (Template t, File f) {
        try {
            
            FileOutputStream fos = new FileOutputStream(f.toString() + "\\"+  templateName + ".data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.close();
            fos.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    
    
    public int getFieldLength() {
        return fieldLength;
    }
    
    public void setFieldLength(int a) {
        fieldLength = a;
    }
    
    public String getTemplateName() {
        return templateName;
    }
    
    public void setTemplateName(String s) {
        templateName = s;
    }
    
    public String getDocType() {
        return docType;
    }
    
    public void setDocType(String s) {
        docType = s;
    }
    
    public int[] getFolder1Array() {
        return folder1Array;
    }
    
    public int[] getFolder2Array() {
        return folder2Array;
    }
    
    public int[] getDocArray() {
        return docArray;
    }
    
    public int[] getFieldIndexes() {
        return fieldIndexes;
    }
    
    public void setFolder1Array(int[] ar) {
        folder1Array = ar;
    }
    
    public void setFolder2Array(int[] ar) {
        folder2Array = ar;
    }
    
    public void setDocArray(int[] ar) {
        docArray = ar;
    }
    
    public void setFieldIndexes(int[] ar) {
        fieldIndexes = ar;
    }
    
    public int getFolder1ArrayI(int i) {
        return folder1Array[i];
    }
    
    public int getFolder2ArrayI(int i) {
        return folder2Array[i];
    }
    
    public int getDocArrayI(int i) {
        return docArray[i];
    }
    
    public int getFieldIndexesI(int i) {
        return fieldIndexes[i];
    }
    
    public void setFolderArray(ArrayList<int[]> in) {
        folderArray = in;
    }
    
    public ArrayList<int[]> getFolderArray() {
        return folderArray;
    }
    
}
