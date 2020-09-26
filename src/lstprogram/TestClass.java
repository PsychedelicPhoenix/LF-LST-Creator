/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lstprogram;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;


public class TestClass extends JFrame implements ActionListener{
    
    public void actionPerformed(ActionEvent ev) {
        System.out.println("master actionPerformed method");
    }
    
    public TestClass() {
        setupGUI();
        temp = new Template();
    }
      /*  
    public static void main(String[] args) {
        //TestClass test = new TestClass();
        //test.setupGUI();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestClass().setVisible(true);
            }
        });        
    }
        */
    class addField implements ActionListener {
        public addField() {
        }
        public void actionPerformed(ActionEvent ev) {
            System.out.println("add field button pushed");            
            addFieldMethod();            
        }
    }
    
    private void addFieldMethod() {
        fieldCount++;
        addFieldtoAllModelArray();
        System.out.println("FieldCount: " + fieldCount);
        /*
        System.out.println("comboBoxCount: " + comboBoxCount);
            System.out.println("initial comboBoxPos" + comboBoxPos);
            
            GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
            //GridBagConstraints gbc0 = layout.getConstraints(comboBox1);
            //gbcCopy = gbc0;
            //comboBoxPos = gbcCopy.gridy;
            //System.out.println("comboBoxPos: " + comboBoxPos);
                        
            Component[] comps = bottomPanel.getComponents();

            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                if (comboBoxPos < gbc1.gridy) {
                    System.out.println(comp + " gridy: " + gbc1.gridy);
                    bottomPanel.remove(comp);
                    gbc1.gridy++;
                    System.out.println(gbc1.gridy);
                    bottomPanel.add(comp,gbc1);
                }
                //System.out.println("Component : " + comp + " , with GBC: " + gbc);
                //System.out.println("gridx: " + gbc.gridx + "gridy: " + gbc.gridy);
            }
            
            comboBoxCount++;
            System.out.println("comboBoxCount: " + comboBoxCount);
            fieldCount++;
            addFieldtoAllModelArray();
            
            addModelToArray(modelArrayList);
            
            gbcCopy.gridy++;
            comboBoxPos++;
            System.out.println("gbcCopy: " + gbcCopy.gridy);
            bottomPanel.add(new JComboBox(modelArrayList.get(modelArrayList.size()-1)),gbcCopy);
            gbc2.gridy++;
            
            bottomPanel.revalidate();
            bottomPanel.repaint();
            
            System.out.println(EventQueue.isDispatchThread());
            */
    }
    
    private void deleteFieldMethod() {
        if (fieldCount>1) {
            removeFieldFromAllModelArray();
            fieldCount--;
        }
        System.out.println("FieldCount: " + fieldCount);
        /*
        System.out.println("comboBoxCount: " + comboBoxCount);
        System.out.println("initial comboBoxPos" + comboBoxPos);
            
        if (fieldCount>1) {
            GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
                              
            Component[] comps = bottomPanel.getComponents();

            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                if (comboBoxPos == gbc1.gridy) {
                    bottomPanel.remove(comp);
                }
            }
            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                
                if (comboBoxPos < gbc1.gridy) {
                    System.out.println(comp + " gridy: " + gbc1.gridy);
                    bottomPanel.remove(comp);
                    gbc1.gridy--;
                    System.out.println(gbc1.gridy);
                    bottomPanel.add(comp,gbc1);
                }
            }
            
            comboBoxCount--;
            comboBoxPos--;
            System.out.println("comboBoxCount: " + comboBoxCount);
            gbcCopy.gridy--;
            System.out.println("gbcCopy: " + gbcCopy.gridy);
            
            
            
            System.out.println("ModelArrayList size: " + modelArrayList.size());
            modelArrayList.remove(modelArrayList.size()-1);
            System.out.println("ArrayList size: " + modelArrayList.size());
            removeFieldFromAllModelArray();
            fieldCount--;
            gbc2.gridy--;
            
            
            bottomPanel.revalidate();
            bottomPanel.repaint();
            
            System.out.println(EventQueue.isDispatchThread());
        } else {
            System.out.println("can't remove combobox");
        }
        */
    }
    
    private void removeFieldFromAllModelArray() {
        for (int i = 0; i<modelArrayList.size(); i++) {
            modelArrayList.get(i).removeElementAt(modelArrayList.get(i).getSize()-1);
        }
        for (int i = 0; i< folderModelArrayList.size(); i++ ) {
            for (int j = 0; j< folderModelArrayList.get(i).size(); j++) {
                folderModelArrayList.get(i).get(j).removeElementAt(folderModelArrayList.get(i).get(j).getSize()-1);
            }
        }
        for (int i = 0; i<folderOneModelArrayList.size(); i++) {
            folderOneModelArrayList.get(i).removeElementAt(folderOneModelArrayList.get(i).getSize()-1);
        }
        for (int i = 0; i<folderTwoModelArrayList.size(); i++) {
            folderTwoModelArrayList.get(i).removeElementAt(folderTwoModelArrayList.get(i).getSize()-1);
        }
        for (int i = 0; i<docModelArrayList.size(); i++) {
            docModelArrayList.get(i).removeElementAt(docModelArrayList.get(i).getSize()-1);
        }
    }
    
    class addLine implements ActionListener {
        public addLine() {
        
        }
        public void actionPerformed(ActionEvent ev) {
            System.out.println("addLine button pushed");
            addLineMethod();
        }
    }
    
    private void addLineMethod() {
        System.out.println("comboBoxCount: " + comboBoxCount);
            System.out.println("initial comboBoxPos" + comboBoxPos);
            System.out.println("fieldCount: " + fieldCount);
            
            GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
            //GridBagConstraints gbc0 = layout.getConstraints(comboBox1);
            //gbcCopy = gbc0;
            //comboBoxPos = gbcCopy.gridy;
            //System.out.println("comboBoxPos: " + comboBoxPos);
                        
            Component[] comps = bottomPanel.getComponents();

            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                if (comboBoxPos < gbc1.gridy) {
                    System.out.println(comp + " gridy: " + gbc1.gridy);
                    bottomPanel.remove(comp);
                    gbc1.gridy++;
                    System.out.println(gbc1.gridy);
                    bottomPanel.add(comp,gbc1);
                }
                //System.out.println("Component : " + comp + " , with GBC: " + gbc);
                //System.out.println("gridx: " + gbc.gridx + "gridy: " + gbc.gridy);
            }
            
            comboBoxCount++;
            System.out.println("comboBoxCount: " + comboBoxCount);
            addModelToArray(modelArrayList);
            
            gbcCopy.gridy++;
            comboBoxPos++;
            System.out.println("gbcCopy: " + gbcCopy.gridy);
            bottomPanel.add(new JComboBox(modelArrayList.get(modelArrayList.size()-1)),gbcCopy);
            gbc2.gridy++;
            
            bottomPanel.revalidate();
            bottomPanel.repaint();
            
            System.out.println(EventQueue.isDispatchThread());
    }
    
    private void removeLineMethod() {
        System.out.println("comboBoxCount: " + comboBoxCount);
            System.out.println("initial comboBoxPos" + comboBoxPos);
            System.out.println("initial fieldCount" + fieldCount);
            
        if (comboBoxCount>1) {
            GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
                              
            Component[] comps = bottomPanel.getComponents();

            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                if (comboBoxPos == gbc1.gridy) {
                    bottomPanel.remove(comp);
                }
            }
            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                
                if (comboBoxPos < gbc1.gridy) {
                    System.out.println(comp + " gridy: " + gbc1.gridy);
                    bottomPanel.remove(comp);
                    gbc1.gridy--;
                    System.out.println(gbc1.gridy);
                    bottomPanel.add(comp,gbc1);
                }
            }
            
            comboBoxCount--;
            comboBoxPos--;
            System.out.println("comboBoxCount: " + comboBoxCount);
            gbcCopy.gridy--;
            System.out.println("gbcCopy: " + gbcCopy.gridy);
            
            
            
            System.out.println("ModelArrayList size: " + modelArrayList.size());
            modelArrayList.remove(modelArrayList.size()-1);
            System.out.println("ArrayList size: " + modelArrayList.size());
            gbc2.gridy--;
            
            
            bottomPanel.revalidate();
            bottomPanel.repaint();
            
            System.out.println(EventQueue.isDispatchThread());
        } else {
            System.out.println("can't remove combobox");
        }
    }
    
    class deleteField implements ActionListener {
        public deleteField() {
        
        }
        public void actionPerformed(ActionEvent ev) {
            System.out.println("delete button pushed");
            deleteFieldMethod();
        }
    }
        
    class removeLine implements ActionListener {
        public removeLine() {
            
        }
        public void actionPerformed(ActionEvent ev) {
            System.out.println("removeLine Button pushed");
            removeLineMethod();
        }
    }
    
    class addFieldFolderOne implements ActionListener {
        public addFieldFolderOne() {
            
        }
        public addFieldFolderOne(JButton add, JButton delete, GridBagConstraints comboBox) {
            
        }
        public void actionPerformed(ActionEvent ev) {
            System.out.println("addFolderOneButton pushed");
            //addComboBoxHorizontatl(add, delete, comboBox, modelArrayList);
            addComboBoxHorizontal(addComboBoxFolderOneButton, folderOneDeleteButton, gbc0, folderOneModelArrayList);
            
            
            
            //GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
            //GridBagConstraints gbc = layout.getConstraints(addComboBoxFolderOneButton);
            //GridBagConstraints gbcDel = layout.getConstraints(folderOneDeleteButton);
            /*
            int folderOneComboBoxXPos = gbc0.gridx;
            int folderOneComboBoxYPos = gbc0.gridy;
            System.out.println("xpos: " + folderOneComboBoxXPos);
            System.out.println("ypos: " + folderOneComboBoxYPos);
                   
            bottomPanel.remove(addComboBoxFolderOneButton);
            gbcAdd0.gridx++;
            bottomPanel.add(addComboBoxFolderOneButton, gbcAdd0);
            
            bottomPanel.remove(folderOneDeleteButton);
            gbcDel0.gridx++;
            bottomPanel.add(folderOneDeleteButton,gbcDel0);
                        
            updateModelArray(folderOneModelArrayList);
            gbc0.gridx++;
            bottomPanel.add(new JComboBox(folderOneModelArrayList.get(folderOneModelArrayList.size()-1)), gbc0);
            System.out.println("xpos: " + gbc0.gridx);
            System.out.println("ypos: " + gbc0.gridy);
            System.out.println("folderOneModelArrayList size: " + folderOneModelArrayList.size());
            bottomPanel.revalidate();
            bottomPanel.repaint();
            */
           
        }
    }
    
    class deleteFieldFolderOne implements ActionListener {
        public deleteFieldFolderOne() {
            
        }
        public void actionPerformed(ActionEvent ev) {
            System.out.println("deleteFieldFolderOneButton pushed");
            deleteComboBoxHorizontal(addComboBoxFolderOneButton, folderOneDeleteButton, gbc0, folderOneModelArrayList);            
            /*
            if (gbc0.gridx>1) {
                GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
                Component[] comps = bottomPanel.getComponents();
                
                for (int i = 0; i < comps.length; i++) {
                    Component comp = comps[i];
                    GridBagConstraints gbc = layout.getConstraints(comp);
                    
                    if (gbc.gridy == gbc0.gridy && gbc.gridx == gbc0.gridx) {
                        System.out.println("gbc0(x,y): " + gbc0.gridx + ", " + gbc0.gridy);
                        System.out.println(comp + " gridx: " + gbc.gridx);
                        bottomPanel.remove(comp);
                        gbc.gridx--;
                        System.out.println("new gridx: " + gbc.gridx);                      
                    } 
                    
                }
                System.out.println("folderOneModelArrayList size: " + folderOneModelArrayList.size());
                folderOneModelArrayList.remove(folderOneModelArrayList.size()-1);
                System.out.println("folderOneModelArrayList size: " + folderOneModelArrayList.size());
                
                //GridBagConstraints gbc = layout.getConstraints(addComboBoxFolderOneButton);
                bottomPanel.remove(addComboBoxFolderOneButton);
                gbcAdd0.gridx--;
                bottomPanel.add(addComboBoxFolderOneButton,gbcAdd0);
                //GridBagConstraints gbcDel = layout.getConstraints(folderOneDeleteButton);
                bottomPanel.remove(folderOneDeleteButton);
                gbcDel0.gridx--;
                bottomPanel.add(folderOneDeleteButton,gbcDel0);
                
                gbc0.gridx--;
                bottomPanel.revalidate();
                bottomPanel.repaint();
                
            } else {
                System.out.println("can't remove field");
            }
            */
        }
    }
    
    class addFieldFolderTwo implements ActionListener {
        public addFieldFolderTwo() {
            
        }
        public void actionPerformed(ActionEvent ev) {
            System.out.println("addFolderTwoButton pushed");
            
            addComboBoxHorizontal(addComboBoxFolderTwoButton,folderTwoDeleteButton , gbc1, folderTwoModelArrayList);
            
            
            /*
            //GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
            //GridBagConstraints gbc = layout.getConstraints(addComboBoxFolderTwoButton);
            
            bottomPanel.remove(addComboBoxFolderTwoButton);
            gbcAdd1.gridx++;
            bottomPanel.add(addComboBoxFolderTwoButton, gbcAdd1);
            
            bottomPanel.remove(folderTwoDeleteButton);
            gbcDel1.gridx++;
            bottomPanel.add(folderTwoDeleteButton,gbcDel1);
            
            updateModelArray(folderTwoModelArrayList);
            gbc1.gridx++;
            bottomPanel.add(new JComboBox(folderTwoModelArrayList.get(folderTwoModelArrayList.size()-1)), gbc1);
            
            bottomPanel.revalidate();
            bottomPanel.repaint();
            */
        }
    }
    
    class deleteFieldFolderTwo implements ActionListener {
        public deleteFieldFolderTwo() {
            
        }
        public void actionPerformed(ActionEvent ev) {
            System.out.println("deleteFieldFolderTwoButton pushed");
            deleteComboBoxHorizontal(addComboBoxFolderTwoButton, folderTwoDeleteButton, gbc1, folderTwoModelArrayList);
            /*
            if (gbc1.gridx>1) {
                GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
                Component[] comps = bottomPanel.getComponents();
                
                for (int i = 0; i < comps.length; i++) {
                    Component comp = comps[i];
                    GridBagConstraints gbc = layout.getConstraints(comp);
                    
                    if (gbc.gridy == gbc1.gridy && gbc.gridx == gbc1.gridx) {
                        System.out.println("gbc0(x,y): " + gbc1.gridx + ", " + gbc1.gridy);
                        System.out.println(comp + " gridx: " + gbc.gridx);
                        bottomPanel.remove(comp);
                        gbc.gridx--;
                        System.out.println("new gridx: " + gbc.gridx);                      
                    } 
                    
                }
                System.out.println("folderTwoModelArrayList size: " + folderTwoModelArrayList.size());
                folderTwoModelArrayList.remove(folderTwoModelArrayList.size()-1);
                System.out.println("folderOneModelArrayList size: " + folderTwoModelArrayList.size());
                
                //GridBagConstraints gbc = layout.getConstraints(addComboBoxFolderTwoButton);
                bottomPanel.remove(addComboBoxFolderTwoButton);
                gbcAdd1.gridx--;
                bottomPanel.add(addComboBoxFolderTwoButton,gbcAdd1);
                //GridBagConstraints gbcDel1 = layout.getConstraints(folderOneDeleteButton);
                bottomPanel.remove(folderTwoDeleteButton);
                gbcDel1.gridx--;
                bottomPanel.add(folderTwoDeleteButton,gbcDel1);
                
                gbc1.gridx--;
                bottomPanel.revalidate();
                bottomPanel.repaint();
                
            } else {
                System.out.println("can't remove field");
            }
            */
        }
    }
    
    class addFieldDoc implements ActionListener {
        public addFieldDoc(){           
        }
        public void actionPerformed(ActionEvent evt) {
            System.out.println("add field doc button pushed");
            
            addComboBoxHorizontal(addComboBoxDocButton, docDeleteButton, gbc2, docModelArrayList);
            /*
            bottomPanel.remove(addComboBoxDocButton);
            gbcAdd2.gridx++;
            bottomPanel.add(addComboBoxDocButton, gbcAdd2);
            
            bottomPanel.remove(docDeleteButton);
            gbcDel2.gridx++;
            bottomPanel.add(docDeleteButton,gbcDel2);
            
            updateModelArray(docModelArrayList);
            gbc2.gridx++;
            bottomPanel.add(new JComboBox(docModelArrayList.get(docModelArrayList.size()-1)), gbc2);
            
            bottomPanel.revalidate();
            bottomPanel.repaint();
            */
        }
    }
    
    class deleteFieldDoc implements ActionListener {
        public deleteFieldDoc() {
        }
        public void actionPerformed(ActionEvent evt) {
            System.out.println("delete field doc button pushed");
            
            deleteComboBoxHorizontal(addComboBoxDocButton, docDeleteButton, gbc2, docModelArrayList);
            /*
            if (gbc2.gridx>1) {
                GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
                Component[] comps = bottomPanel.getComponents();
                
                for (int i = 0; i < comps.length; i++) {
                    Component comp = comps[i];
                    GridBagConstraints gbc = layout.getConstraints(comp);
                    GridBagConstraints gbcy = layout.getConstraints(documentComboBox);
                    
                    if (gbc.gridy == gbcy.gridy && gbc.gridx == gbc2.gridx) {
                        System.out.println("gbc2(x,y): " + gbc2.gridx + ", " + gbc2.gridy);
                        System.out.println(comp + " gridx: " + gbc.gridx);
                        bottomPanel.remove(comp);
                        gbc.gridx--;
                        System.out.println("new gridx: " + gbc.gridx);                      
                    } 
                    
                }
                System.out.println("docModelArrayList size: " + docModelArrayList.size());
                docModelArrayList.remove(docModelArrayList.size()-1);
                System.out.println("docModelArrayList size: " + docModelArrayList.size());
                
                //GridBagConstraints gbc = layout.getConstraints(addComboBoxFolderTwoButton);
                bottomPanel.remove(addComboBoxDocButton);
                gbcAdd2.gridx--;
                bottomPanel.add(addComboBoxDocButton,gbcAdd2);
                //GridBagConstraints gbcDel1 = layout.getConstraints(folderOneDeleteButton);
                bottomPanel.remove(docDeleteButton);
                gbcDel2.gridx--;
                bottomPanel.add(docDeleteButton,gbcDel2);
                
                gbc2.gridx--;
                bottomPanel.revalidate();
                bottomPanel.repaint();
                
            } else {
                System.out.println("can't remove field");
            }
            */
        }
    }
    
    private void addComboBoxHorizontal(JButton add, JButton del, GridBagConstraints c, ArrayList<DefaultComboBoxModel> ar ) {
        GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
        GridBagConstraints gbc = layout.getConstraints(add);
        GridBagConstraints gbc1 = layout.getConstraints(del);

        bottomPanel.remove(add);
        gbc.gridx++;
        bottomPanel.add(add, gbc);

        bottomPanel.remove(del);
        gbc1.gridx++;
        bottomPanel.add(del,gbc1);

        addModelToArray(ar);
        c.gridx++;
        bottomPanel.add(new JComboBox(ar.get(ar.size()-1)), c);

        bottomPanel.revalidate();
        bottomPanel.repaint();
        
    }
    
    private void addComboBoxHorizontal2(GridBagConstraints gbc, GridBagConstraints c) {
        System.out.println("gbc0.X: " + gbc0.gridx + "gbc0.Y: " + gbc0.gridy);
        GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
        Component[] comps = bottomPanel.getComponents();
        GridBagConstraints wtf = new GridBagConstraints();
        wtf.gridx = gbc.gridx;
        wtf.gridy = gbc.gridy;
        wtf.weightx = 1;
        wtf.fill = GridBagConstraints.HORIZONTAL;
        wtf.insets = new Insets(4,4,4,4);
        addModelToFolderArray(folderModelArrayList.get(gbc.gridy-2));
        bottomPanel.add(new JComboBox(folderModelArrayList.get(gbc.gridy-2).get(gbc.gridx-1)),wtf);
        //System.out.println("comboBox: " + gbc0.gridy);
        
        for (int i = 0; i < comps.length; i++) {
            Component comp = comps[i];
            GridBagConstraints gbc1 = layout.getConstraints(comp);
            if (gbc.gridy == gbc1.gridy && gbc.gridx<=gbc1.gridx) {
                System.out.println(comp.toString().substring(0, 20) + " gridx: " + gbc1.gridx);
                bottomPanel.remove(comp);
                gbc1.gridx++;
                System.out.println(gbc1.gridx);
                bottomPanel.add(comp,gbc1);
            }
            //System.out.println("Component : " + comp + " , with GBC: " + gbc);
            //System.out.println("gridx: " + gbc.gridx + "gridy: " + gbc.gridy);
        }
        System.out.println("gbc0.X: " + gbc0.gridx + "gbc0.Y: " + gbc0.gridy);
        bottomPanel.revalidate();
        bottomPanel.repaint();
    }
    
    private void removeComboBoxHorizontal2(GridBagConstraints gbc, GridBagConstraints c) {
        if (gbc.gridx-2>1) {
            System.out.println("gbc0.X: " + gbc0.gridx + "gbc0.Y: " + gbc0.gridy);
            GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
            Component[] comps = bottomPanel.getComponents();
            
            //folderModelArrayList.get(gbc.gridy-2).remove(folderModelArrayList.get(gbc.gridx-3));
            folderModelArrayList.get(gbc.gridy-2).remove(folderModelArrayList.get(gbc.gridy-2).get(gbc.gridx-3));
            //bottomPanel.add(new JComboBox(folderModelArrayList.get(gbc.gridy-2).get(gbcComboCopy.gridx-1)),gbcComboCopy);
            //System.out.println("comboBox: " + gbc0.gridy);
            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                if (gbc.gridy == gbc1.gridy && gbc.gridx-2 ==gbc1.gridx) {
                    System.out.println(comp.toString().substring(0, 20) + " gridx: " + gbc1.gridx);
                    bottomPanel.remove(comp);
                    System.out.println(gbc1.gridx);
                }
            }    
            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                
                if (gbc.gridy == gbc1.gridy && gbc.gridx-1<=gbc1.gridx) {
                    System.out.println(comp.toString().substring(0, 20) + " gridx: " + gbc1.gridx);
                    bottomPanel.remove(comp);
                    gbc1.gridx--;
                    System.out.println(gbc1.gridx);
                    bottomPanel.add(comp,gbc1);
                }
                //System.out.println("Component : " + comp + " , with GBC: " + gbc);
                //System.out.println("gridx: " + gbc.gridx + "gridy: " + gbc.gridy);
            }
            System.out.println("gbc0.X: " + gbc0.gridx + "gbc0.Y: " + gbc0.gridy);
            bottomPanel.revalidate();
            bottomPanel.repaint();
            
            
            
        } else {
            JOptionPane.showMessageDialog(bottomPanel, "Can't remove only Folder ComboBox", " error ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void deleteComboBoxHorizontal(JButton add, JButton del, GridBagConstraints c, ArrayList<DefaultComboBoxModel> ar) {
        
            if (c.gridx>1) {
                GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
                Component[] comps = bottomPanel.getComponents();
                
                for (int i = 0; i < comps.length; i++) {
                    Component comp = comps[i];
                    GridBagConstraints gbc = layout.getConstraints(comp);
                    
                    if (gbc.gridy == c.gridy && gbc.gridx == c.gridx) {
                        System.out.println("gbc0(x,y): " + c.gridx + ", " + c.gridy);
                        System.out.println(comp + " gridx: " + gbc.gridx);
                        bottomPanel.remove(comp);
                        gbc.gridx--;
                        System.out.println("new gridx: " + gbc.gridx);                      
                    } 
                    
                }
                System.out.println("ModelArrayList size: " + ar.size());
                ar.remove(ar.size()-1);
                System.out.println("ModelArrayList size: " + ar.size());
                
                GridBagConstraints gbc = layout.getConstraints(add);
                bottomPanel.remove(add);
                gbc.gridx--;
                bottomPanel.add(add,gbc);
                gbc = layout.getConstraints(del);
                bottomPanel.remove(del);
                gbc.gridx--;
                bottomPanel.add(del,gbc);
                
                c.gridx--;
                bottomPanel.revalidate();
                bottomPanel.repaint();
                
            } else {
                System.out.println("can't remove field");
            }
    }
        
    private void addFolder () {
        
        System.out.println();
        System.out.println("comboBoxCount: " + comboBoxCount);
        System.out.println("initial comboBoxPos" + comboBoxPos);
        System.out.println("fieldCount: " + fieldCount);
        System.out.println("folderPos: " + folderPos);
        System.out.println("folderCount " + folderCount);
            
        GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
        Component[] comps = bottomPanel.getComponents();

        for (int i = 0; i < comps.length; i++) {
            Component comp = comps[i];
            GridBagConstraints gbc1 = layout.getConstraints(comp);
            if (folderPos < gbc1.gridy) {
                System.out.println(comp.toString().substring(0, 20) + " gridy: " + gbc1.gridy);
                bottomPanel.remove(comp);
                gbc1.gridy++;
                System.out.println(gbc1.gridy);
                bottomPanel.add(comp,gbc1);
            }
            //System.out.println("Component : " + comp + " , with GBC: " + gbc);
            //System.out.println("gridx: " + gbc.gridx + "gridy: " + gbc.gridy);
        }
        
        folderModelArrayList.add(new ArrayList<DefaultComboBoxModel>());
        folderCount++;
        System.out.println("folderCount " + folderCount);
        addModelToFolderArray(folderModelArrayList.get(folderCount-1));

        //GridBagConstraints x = gbcLabel;
        gbcLabel.gridy++;
        bottomPanel.add(new JLabel("Folder"),gbcLabel);
        System.out.println("label: " + gbcLabel.gridy);
        
        //x = gbc0;
        gbc0.gridy++;
        bottomPanel.add(new JComboBox(folderModelArrayList.get(folderCount-1).get(0)),gbc0);
        System.out.println("comboBox: " + gbc0.gridy);
        
        //x = gbcAdd0;
        gbcAdd0.gridy++;
        JButton add = new JButton("ADD");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked button " + e.getSource().toString());
                GridBagConstraints gbc = layout.getConstraints((Component)e.getSource());
                System.out.println("x: " + gbc.gridx + ", Y: " + gbc.gridy);
                addComboBoxHorizontal2(gbc, gbc0);
            }
        });
        bottomPanel.add(add,gbcAdd0);
        System.out.println("Button" + gbcAdd0.gridy);
        
        //x = gbcDel0;
        gbcDel0.gridy++;
        JButton del = new JButton("Delete");
        del.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
            {
                System.out.println("You clicked button "+e.getSource().toString());
                GridBagConstraints gbc = layout.getConstraints((Component)e.getSource());
                System.out.println("x: " + gbc.gridx + ", Y: " + gbc.gridy);
                removeComboBoxHorizontal2(gbc, gbc0);
            }
        });
        bottomPanel.add(del,gbcDel0);
        System.out.println("Del Button: " + gbcDel0.gridy);
        
        gbcCopy.gridy++;
        comboBoxPos++;
        folderPos++;
        gbc2.gridy++;

        System.out.println("comboBoxCount: " + comboBoxCount);
        System.out.println("comboBoxPos" + comboBoxPos);
        System.out.println("fieldCount: " + fieldCount);
        System.out.println("folderPos: " + folderPos);
        System.out.println("folderCount " + folderCount);
        System.out.println("end of addFolder method");
        System.out.println();
        
        bottomPanel.revalidate();
        bottomPanel.repaint();
        
        
        
    }
    
    private void removeFolder() {
        
        System.out.println();
        System.out.println("comboBoxCount: " + comboBoxCount);
        System.out.println("comboBoxPos" + comboBoxPos);
        System.out.println("fieldCount: " + fieldCount);
        System.out.println("folderPos: " + folderPos);
        System.out.println("folderCount " + folderCount);
        
        if (folderCount>1) {
            GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
            Component[] comps = bottomPanel.getComponents();
            
            
            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                if (folderPos == gbc1.gridy) {
                    System.out.println(comp.toString().substring(0, 20) + " gridy: " + gbc1.gridy);
                    bottomPanel.remove(comp);
                }
            }
            
            for (int i = 0; i < comps.length; i++) {
                Component comp = comps[i];
                GridBagConstraints gbc1 = layout.getConstraints(comp);
                
                if (folderPos < gbc1.gridy) {
                    System.out.println(comp.toString().substring(0, 20) + " gridy: " + gbc1.gridy);
                    bottomPanel.remove(comp);
                    gbc1.gridy--;
                    System.out.println(gbc1.gridy);
                    bottomPanel.add(comp,gbc1);
                }
                
                //System.out.println("Component : " + comp + " , with GBC: " + gbc);
                //System.out.println("gridx: " + gbc.gridx + "gridy: " + gbc.gridy);
            }
        }
        
        
        //GridBagConstraints x = gbcLabel;
        GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
        
        Component comp = bottomPanel.getComponentAt(gbcLabel.gridx, gbcLabel.gridy);
        System.out.println(comp.toString().substring(0, 20) + " gridy: " + gbcLabel.gridy + ", gridY: " + gbcLabel.gridx);
        //bottomPanel.remove(comp);
        gbcLabel.gridy--;
        
        
        //x = gbc0;
        comp = bottomPanel.getComponentAt(gbc0.gridx,gbc0.gridy);
        System.out.println(comp.toString().substring(0, 20) + " gridy: " + gbc0.gridy + ", gridY: " + gbc0.gridx);
        //bottomPanel.remove(comp);
        gbc0.gridy--;
        
        
        //x = gbcAdd0;
        comp = bottomPanel.getComponentAt(gbcAdd0.gridx, gbcAdd0.gridy);
        System.out.println(comp.toString().substring(0, 20) + " gridy: " + gbcAdd0.gridy + ", gridY: " + gbcAdd0.gridx);
        //bottomPanel.remove(comp);
        gbcAdd0.gridy--;
        
        
        //x = gbcDel0;
        comp = bottomPanel.getComponentAt(gbcDel0.gridx, gbcDel0.gridy);
        System.out.println(comp.toString().substring(0, 20) + " gridy: " + gbcDel0.gridy + ", gridY: " + gbcDel0.gridx);
        //bottomPanel.remove(comp);
        gbcDel0.gridy--;
        
        System.out.println("folderModelArrayList Size: " + folderModelArrayList.size());
        folderModelArrayList.remove(folderCount-1);
        System.out.println("folderModelArrayList Size: " + folderModelArrayList.size());
        
        folderCount--;
        folderPos--;
        comboBoxPos--;
        gbc2.gridy--;
        gbcCopy.gridy--;
        
        System.out.println("comboBoxCount: " + comboBoxCount);
        System.out.println("initial comboBoxPos" + comboBoxPos);
        System.out.println("fieldCount: " + fieldCount);
        System.out.println("folderPos: " + folderPos);
        System.out.println("folderCount " + folderCount);
        System.out.println("end of removeFolder method");
        System.out.println();
        
        bottomPanel.revalidate();
        bottomPanel.repaint();
        
    }
    
    class templateNameTextFieldAction implements ActionListener {
        public templateNameTextFieldAction() {
        }
        public void actionPerformed(ActionEvent evt) {
            temp.setTemplateName(templateNameTextField.getText());
            templateNameTitle.setText(temp.getTemplateName());
        }
    }
    
    class docTypeComboBoxAction implements ActionListener {
        public docTypeComboBoxAction() {
        }
        public void actionPerformed(ActionEvent evt) {
            temp.setDocType((String) docTypeComboBox.getSelectedItem());
            System.out.println(docTypeComboBox.getSelectedItem());
        }
    }
    
    class fieldLengthTextFieldAction implements ActionListener {
        public fieldLengthTextFieldAction() {
        }
        public void actionPerformed(ActionEvent evt) {
            
            int inputCheck = 0;
            try {
                temp.setFieldLength(Integer.parseInt(fieldLengthTextField.getText()));
                if (temp.getFieldLength() > 100) {
                    inputCheck = JOptionPane.showConfirmDialog(topPanel, "Field Count over 100?", "check field count", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                }
                if (temp.getFieldLength()<1) {
                    inputCheck = 1;
                    JOptionPane.showMessageDialog(topPanel, "Field Count must be a positive Integer.", "Invalid input", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                inputCheck = 1;
                JOptionPane.showMessageDialog(topPanel, "Enter a Positive Integer.", "Invalid input", JOptionPane.WARNING_MESSAGE);
                System.out.println("enter numeric digits \n Stack Trace: ");
                ex.printStackTrace();
            }
            if (inputCheck == 0) {
                while (fieldCount < temp.getFieldLength()) {
                    addFieldMethod();
                }
                while (fieldCount > temp.getFieldLength()){
                    deleteFieldMethod();
                }
            }
            System.out.println("temp.getfieldlength: " + temp.getFieldLength());
            System.out.println("fieldCount: " + fieldCount);
                  
        }
    }
    
    class lineCountTextFieldAction implements ActionListener {
        public lineCountTextFieldAction() {
            
        }
        public void actionPerformed(ActionEvent evt) {
            int inputCheck = 0;
            try {
                setLineCount(Integer.parseInt(lineCountTextField.getText()));                
                if (getLineCount() > 100) {
                    inputCheck = JOptionPane.showConfirmDialog(topPanel, "Line Count over 100?", "Check Line Count", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                }
                if (getLineCount()<1) {
                    inputCheck = 1;
                    JOptionPane.showMessageDialog(topPanel, "Line Count must be a positive Integer.", "Invalid input", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                inputCheck = 1;
                JOptionPane.showMessageDialog(topPanel, "Enter a Positive Integer.", "Invalid input", JOptionPane.WARNING_MESSAGE);
                System.out.println("enter numeric digits \n Stack Trace: ");
                ex.printStackTrace();
            }
            if (inputCheck == 0) {
                while (comboBoxCount < getLineCount()) {
                    addLineMethod();
                }
                while (comboBoxCount > getLineCount()){
                    removeLineMethod();
                }
            }
        }
    }
    
    class folderCountTextFieldAction implements ActionListener {
        public folderCountTextFieldAction() {
            
        }
        public void actionPerformed(ActionEvent ev) {
            int inputCheck = 0;
            try {
                setFolderCount(Integer.parseInt(folderCountTextField.getText()));                
                if (getFolderCount() > 20) {
                    inputCheck = JOptionPane.showConfirmDialog(topPanel, "Folder Count over 20?", "Check Folder Count", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                }
                if (getFolderCount()<1) {
                    inputCheck = 1;
                    JOptionPane.showMessageDialog(topPanel, "Folder Count must be a positive Integer.", "Invalid input", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                inputCheck = 1;
                JOptionPane.showMessageDialog(topPanel, "Enter a Positive Integer.", "Invalid input", JOptionPane.WARNING_MESSAGE);
                System.out.println("enter numeric digits \n Stack Trace: ");
                ex.printStackTrace();
            }
            if (inputCheck == 0) {
                while (folderCount < getFolderCount()) {
                    addFolder();
                }
                while (folderCount > getFolderCount()){
                    removeFolder();
                }
            }
        }
    }
    
    private int folderInt;
    private void setFolderCount(int x) {
        folderInt = x;
    }
    
    private int getFolderCount() {
        return folderInt;
    }
    
    private void setLineCount(int x) {
        lineCount = x;
    }
    private int getLineCount() {
        return lineCount;
    }
    
    private void reset() {
        this.dispose();
        new TestClass().setVisible(true);
    }
    
    class resetButtonAction implements ActionListener {
        public resetButtonAction() {
        }
        public void actionPerformed(ActionEvent evt) {
            System.out.println("reset Button pushed");
            reset();
            
            
            /*
            temp.setTemplateName(null);
            temp.setFieldLength(0);
            //temp.setDocType(null);
            templateNameTextField.setText("");
            docTypeComboBox.setSelectedItem(docTypes[0]);
            fieldLengthTextField.setText("");
            saveLocationLabel.setText("Path: ");
            //tempFile = ""; tempPath = "";
            */
            
            
            //bottomPanel.removeAll();
            //panel2.removeAll();
            //setupGUI();
            /*
            for (int i = 0; i<modelArrayList.size();i++) {
                modelArrayList.get(i).setSelectedItem(modelArrayList.get(0).getElementAt(0));
            }
            for (int i = 0; i<folderOneModelArrayList.size();i++) {
                folderOneModelArrayList.get(i).setSelectedItem(folderOneModelArrayList.get(0).getElementAt(0));
            }
            for (int i = 0; i<folderTwoModelArrayList.size();i++) {
                folderTwoModelArrayList.get(i).setSelectedItem(folderTwoModelArrayList.get(0).getElementAt(0));
            }
            */
        }
    }
    
    class previewButtonAction implements ActionListener {
        public previewButtonAction() {
        }
        public void actionPerformed(ActionEvent evt) {
            System.out.println("preview Button pushed");
        }
    }
    
    class saveButtonAction implements ActionListener {
        public saveButtonAction() {
        }
        public void actionPerformed(ActionEvent evt) {
            System.out.println("save Button pushed");
            if (evt.getSource() == saveButton) {
                int returnVal = fc0.showSaveDialog(topPanel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    tempFile = fc0.getSelectedFile();
                    saveLocationLabel.setText("Path: " + tempFile.toString());
                    tempPath = Paths.get(tempFile.toString());
                    saveMethod(tempFile);
                }
            }
            System.out.println(tempFile);
            System.out.println(tempPath);
            
        }
    }
    private void saveMethod(File f) {
        
            int[] fieldIndexes = new int[modelArrayList.size()];        
            int[] folder1Array = new int[folderOneModelArrayList.size()];
            int[] folder2Array = new int [folderTwoModelArrayList.size()];
            int[] docArray = new int[docModelArrayList.size()];  
            ArrayList<int[]> folderArray = new ArrayList<>();
            
            temp.setFieldIndexes(fieldIndexes);
            temp.setFolder1Array(folder1Array);
            temp.setFolder2Array(folder2Array);
            temp.setDocArray(docArray);

            temp.setFieldLength(fieldCount);
            temp.setDocType((String) docTypeComboBox.getSelectedItem());
            temp.setTemplateName(templateNameTextField.getText());
            templateNameTitle.setText(temp.getTemplateName());
            
            System.out.println("modelArrayList");
            for (int i =0;i<modelArrayList.size();i++) {
                System.out.println("i: " + i + ", selected item: " + modelArrayList.get(i).getSelectedItem());
                int x = modelArrayList.get(i).getIndexOf(modelArrayList.get(i).getSelectedItem());
                fieldIndexes[i] = x-1;
                System.out.println("fieldIndex[" + i + "]: " + fieldIndexes[i]);
            }
            System.out.println("folderArrayList: ");
            for (int i = 0; i<folderModelArrayList.size(); i++) {
                folderArray.add(new int[folderModelArrayList.get(i).size()]);
                for (int j = 0; j < folderModelArrayList.get(i).size(); j++) {
                    System.out.println(folderModelArrayList.get(i).get(j).getSelectedItem());
                    int x = folderModelArrayList.get(i).get(j).getIndexOf(folderModelArrayList.get(i).get(j).getSelectedItem());
                    System.out.println(x);
                    int[] xx = folderArray.get(i);
                    xx[j] = x-1;
                    System.out.println("index: " + xx[j] );
                    
                }
            }
            temp.setFolderArray(folderArray);
            
            
            System.out.println("folderOneModelArrayList");
            for (int i =0;i<folderOneModelArrayList.size();i++) {
                System.out.println("i: " + i + ", selected item: " + folderOneModelArrayList.get(i).getSelectedItem());
                int x = folderOneModelArrayList.get(i).getIndexOf(folderOneModelArrayList.get(i).getSelectedItem());
                System.out.println(x);
                folder1Array[i] = x-1;
                System.out.println("folder1Array[" + i + "]: " + folder1Array[i]);
            }
            System.out.println("folderTwoModelArrayList");
            for (int i =0;i<folderTwoModelArrayList.size();i++) {
                System.out.println("i: " + i + ", selected item: " + folderTwoModelArrayList.get(i).getSelectedItem());
                int x = folderTwoModelArrayList.get(i).getIndexOf(folderTwoModelArrayList.get(i).getSelectedItem());
                System.out.println(x);
                folder2Array[i] = x-1;
                System.out.println("folder2Array[" + i + "]: " + folder2Array[i]);
            }
            System.out.println("docModelArrayList");
            for (int i =0;i<docModelArrayList.size();i++) {
                System.out.println("i: " + i + ", selected item: " + docModelArrayList.get(i).getSelectedItem());
                int x = docModelArrayList.get(i).getIndexOf(docModelArrayList.get(i).getSelectedItem());
                System.out.println(x);
                docArray[i] = x-1;
                System.out.println("docArray[" + i + "]: " + docArray[i]);
            }
            printTemplateValues();
            //temp.saveTemplate(temp, tempFile);
    }
    
    private void printTemplateValues() {
        temp.getDocArray();
        temp.getFieldIndexes();
        temp.getFolder1Array();
        temp.getFolder2Array();
        temp.getFolderArray();
        
        System.out.println("fieldCount: " + temp.getFieldLength());
        System.out.println("docType: "+temp.getDocType());
        System.out.println("templateName: " + temp.getTemplateName());
        System.out.println("folderArray: " + temp.getFolderArray());
        System.out.println("folderArraySize: " + temp.getFolderArray().size());
        
        System.out.println("folderModelArrayList Size: " + folderModelArrayList.size());
        for (ArrayList<DefaultComboBoxModel> a: folderModelArrayList) {
            System.out.println("folderModelArrayList arrayListSize: "+ a.size());
        }
        
        System.out.println("folder1Array: ");
        System.out.println("folder2Array: ");
        System.out.println("docArray: ");
        System.out.println("fieldIndexes: ");
    }
   
    
    private void setupModelArray() {
        
        String[] fieldValues = {"BLANK", "UNKNOWN", "CUSTOM", "FIELD 1"};
        
        cbm0 = new DefaultComboBoxModel(fieldValues); //folderOneComboBox
        cbm1 = new DefaultComboBoxModel(fieldValues); //folderTwoComboBox
        cbm2 = new DefaultComboBoxModel(fieldValues); //documentComboBox
        cbm3 = new DefaultComboBoxModel(fieldValues); //finalComboBox
        cbm4 = new DefaultComboBoxModel(fieldValues); //comboBox1
                
        modelArrayList = new ArrayList<>();
        folderOneModelArrayList = new ArrayList<>();
        folderTwoModelArrayList = new ArrayList<>();
        docModelArrayList = new ArrayList<>();
        folderModelArrayList = new ArrayList<ArrayList<DefaultComboBoxModel>>();
        folderModelArrayList.add(new ArrayList<DefaultComboBoxModel>());
        folderModelArrayList.get(0).add(cbm0);
        //modelArrayList.add(cbm2);
        modelArrayList.add(cbm3);
        modelArrayList.add(cbm4);
        //folderOneModelArrayList.add(cbm0);
        //folderTwoModelArrayList.add(cbm1);
        docModelArrayList.add(cbm2);
        
    }
    
    private void addFieldtoAllModelArray() {
        for (int i = 0; i<modelArrayList.size(); i++) {
            modelArrayList.get(i).addElement("FIELD" + fieldCount);
        }
        for (int i = 0; i<folderModelArrayList.size(); i++) {
            for (int j = 0; j<folderModelArrayList.get(i).size();j++) {
                folderModelArrayList.get(i).get(j).addElement("FIELD " + fieldCount);
            }
        }
        /*
        for (int i = 0; i<folderOneModelArrayList.size(); i++) {
            folderOneModelArrayList.get(i).addElement("FIELD" + fieldCount);
        }
        for (int i = 0; i<folderTwoModelArrayList.size(); i++) {
            folderTwoModelArrayList.get(i).addElement("FIELD" + fieldCount);
        }
        */
        for (int i = 0; i<docModelArrayList.size();i++) {
            docModelArrayList.get(i).addElement("FIELD" + fieldCount);
        }
    }
    
    private void addModelToArray(ArrayList in) {
        ArrayList<DefaultComboBoxModel> ar = in;     
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        for (int i = 0; i<ar.get(0).getSize(); i++) {
            cbm.addElement(ar.get(0).getElementAt(i));
        }
        ar.add(cbm);
        
    }
    
    private void addModelToFolderArray(ArrayList in) {
        ArrayList<DefaultComboBoxModel> ar = in;
        DefaultComboBoxModel cbm = new DefaultComboBoxModel();
        for (int i = 0; i<folderModelArrayList.get(0).get(0).getSize(); i++) {
            cbm.addElement(folderModelArrayList.get(0).get(0).getElementAt(i));
        }
        ar.add(cbm);
    }
    
    
    
    class testFunction implements ActionListener {
        public testFunction() {
            
        }
        public void actionPerformed(ActionEvent ev) {
            System.out.println("test button pushed");
              
                    /*
                       -1 = BLANK
                        0 = UNKNOWN
                        1 = CUSTOM
                        2 = Field 1
                        3 = Field 2 
                        ....
                    */
                    
            //EventQueue.isDispatchThread();
//            for (int i = 0; i<modelArrayList.size(); i++) {
//                System.out.println(modelArrayList.get(i).getSelectedItem());
//            }


        }
    }
        
    private void buildTopPanel() {
        
        
        fc0 = new JFileChooser();
        fc0.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        fc0.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        
        topPanel = new JPanel();
        
        templateNameLabel = new JLabel("Template Name");
        docTypeLabel = new JLabel("Doc Type");
        fieldCountLabel = new JLabel("Field Count");
        lineCountLabel = new JLabel("Line Count");
        folderCountLabel = new JLabel("Folder Count");
        templateNameTextField = new JTextField();
        docTypeComboBox = new JComboBox<>(docTypes);
        fieldLengthTextField = new JTextField();
        lineCountTextField = new JTextField();
        folderCountTextField = new JTextField();
        resetButton = new JButton("Reset");
        previewButton = new JButton("Preview");
        saveButton = new JButton("Save");
        saveLocationLabel = new JLabel("Path: ");
        
        
        topPanel.setLayout(new GridBagLayout());
        topPanel.setBorder(BorderFactory.createEtchedBorder());
        Dimension dLabel = new Dimension(100,26);
        dButton = new Dimension(120,26);
        Dimension dField = new Dimension(180,26);
        
        templateNameLabel.setPreferredSize(dLabel);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(templateNameLabel,c);
                
        docTypeLabel.setPreferredSize(dLabel);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(docTypeLabel,c);
                
        fieldCountLabel.setPreferredSize(dLabel);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(fieldCountLabel,c);
        
        lineCountLabel.setPreferredSize(dLabel);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(lineCountLabel,c);
        
        folderCountLabel.setPreferredSize(dLabel);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(folderCountLabel,c);
                
        templateNameTextField.setPreferredSize(dField);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(templateNameTextField,c);
        templateNameTextField.addActionListener(new templateNameTextFieldAction());
        
        docTypeComboBox.setPreferredSize(dField);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(docTypeComboBox,c);
        docTypeComboBox.addActionListener(new docTypeComboBoxAction());
        
        fieldLengthTextField.setPreferredSize(dField);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(fieldLengthTextField,c);
        fieldLengthTextField.addActionListener(new fieldLengthTextFieldAction());
        
        lineCountTextField.setPreferredSize(dField);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(lineCountTextField,c);
        lineCountTextField.addActionListener(new lineCountTextFieldAction());
        
        folderCountTextField.setPreferredSize(dField);
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(folderCountTextField,c);
        folderCountTextField.addActionListener(new folderCountTextFieldAction());
        
        resetButton.setPreferredSize(dButton);
        c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(4,4,4,4);
        topPanel.add(resetButton,c);
        resetButton.addActionListener(new resetButtonAction());
        
        //previewButton.setPreferredSize(dButton);
        //c = new GridBagConstraints();
        //c.gridx = 2;
        //c.gridy = 1;
        //c.insets = new Insets(4,4,4,4);
        //c.gridy++;
        //topPanel.add(previewButton,c);
        //previewButton.addActionListener(new previewButtonAction());
        
        saveButton.setPreferredSize(dButton);
        //c = new GridBagConstraints();
        //c.gridx = 2;
        //c.gridy = 2;
        //c.insets = new Insets(4,4,4,4);
        c.gridy++;
        topPanel.add(saveButton,c);
        saveButton.addActionListener(new saveButtonAction());
        
        saveLocationLabel.setPreferredSize(new Dimension(200,26));
        //c = new GridBagConstraints();
        //c.gridx = 2;
        //c.gridy = 3;
        //c.insets = new Insets(4,4,4,4);
        c.gridy++;
        topPanel.add(saveLocationLabel,c);
        
        
        
    }
    
    
    
    
    private void setupGUI() {
        
        comboBoxCount = 1;
        fieldCount = 1;
        folderCount = 1;
        setupModelArray();
        buildTopPanel();
        //comboBox1.setModel(modelArrayList.get(0));
        
        bottomPanel = new JPanel();
        panel2 = new JPanel();
        scrollPanel = new JScrollPane();

        addLineButton = new JButton("ADD LINE");
        removeLineButton = new JButton("REMOVE LINE");
        addFieldButton = new JButton("ADD FIELD");
        removeFieldButton = new JButton("REMOVE FIELD");
        
        addComboBoxFolderOneButton = new JButton("ADD");
        folderOneDeleteButton = new JButton("Delete");
        //addComboBoxFolderTwoButton = new JButton("ADD");
        //folderTwoDeleteButton = new JButton("Delete");
        addComboBoxDocButton = new JButton("ADD");
        docDeleteButton = new JButton("Delete");
        
        documentComboBox = new JComboBox<>(cbm2);
        finalComboBox = new JComboBox<>(cbm3);
        folderOneComboBox = new JComboBox<>(cbm0);
        //folderTwoComboBox = new JComboBox<>(cbm1);
        comboBox1 = new JComboBox<>(cbm4);
        //comboBox2 = new JComboBox<>();

        folderOneLabel = new JLabel("Folder");
        //folderTwoLabel = new JLabel("Folder");
        startFieldsLabel = new JLabel("STARTFIELDS");
        endFieldsLabel = new JLabel("ENDFIELDS");
        startListLabel = new JLabel("STARTLIST");
        endListLabel = new JLabel("ENDLIST");
        documentLabel = new JLabel("Document");
        templateNameTitle = new JLabel("<template name>");

        sep1 = new JSeparator(); 
        sep2 = new JSeparator();
        sep3 = new JSeparator();
        sep4 = new JSeparator();
        sep5 = new JSeparator();
        sep6 = new JSeparator();
        sep7 = new JSeparator();
        sep8 = new JSeparator();
        sep9 = new JSeparator();
        
        
        //Set up panel2 layout
        panel2.setLayout(new GridBagLayout());
        panel2.setBorder(BorderFactory.createEtchedBorder());
        GridBagConstraints c0 = new GridBagConstraints();
        
        addFieldButton.setPreferredSize(dButton);
        c0.gridx = 0;
        c0.gridy = 0;
        c0.insets = new Insets(4,4,4,4);
        panel2.add(addFieldButton,c0);
        addFieldButton.addActionListener(new addField());
        
        removeFieldButton.setPreferredSize(dButton);
        c0.gridx = 0;
        c0.gridy = 1;
        panel2.add(removeFieldButton,c0);
        removeFieldButton.addActionListener(new deleteField());
        
        addLineButton.setPreferredSize(dButton);
        c0.gridx = 0;
        c0.gridy = 2;
        panel2.add(addLineButton,c0);
        addLineButton.addActionListener(new addLine());
        
        removeLineButton.setPreferredSize(dButton);
        c0.gridx = 0;
        c0.gridy = 3;
        panel2.add(removeLineButton,c0);
        removeLineButton.addActionListener(new removeLine());
        
        JButton testButton = new JButton("Test");
            Dimension d = new Dimension (100,100);
            testButton.setPreferredSize(d);
            testButton.setBackground(Color.red); 
            c0.gridx = 0;
            c0.gridy = 4;
            //panel2.add(testButton,c0);
        //testButton.addActionListener(new testFunction());
        
        
        
        //Set up bottomPanel GridBagLayout
        
        bottomPanel.setLayout(new GridBagLayout());
        GridBagConstraints c1;
        Insets inset = new Insets(4,4,4,4);
        
        c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 0;
        c1.weightx = 1.0;
        //c1.weighty = 0.1;
        c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.insets = inset;
        c1.ipady = 17;
        bottomPanel.add(templateNameTitle,c1);

        c1= new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 1;
        c1.weightx = 1;
        //c1.weighty = .05;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.insets = inset;
        bottomPanel.add(sep1,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 2;
        c1.weightx = 1;
        c1.insets = inset;
        bottomPanel.add(folderOneLabel,c1);
        folderPos = c1.gridy;
        gbcLabel = c1;
        
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 2;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = inset;
        bottomPanel.add(folderOneComboBox,c1);
        gbc0=c1;
        
        c1 = new GridBagConstraints();
        c1.gridx = 2;
        c1.gridy = 2;
        c1.weightx =1;
        c1.anchor = GridBagConstraints.LINE_START;
        c1.insets = inset;
        bottomPanel.add(addComboBoxFolderOneButton,c1);
        addComboBoxFolderOneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked button " + e.getSource().toString());
                GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
                GridBagConstraints gbc = layout.getConstraints((Component)e.getSource());
                System.out.println("x: " + gbc.gridx + ", Y: " + gbc.gridy);
                addComboBoxHorizontal2(gbc, gbc0);
            }
        });
        gbcAdd0 = c1;
        
        c1 = new GridBagConstraints();
        c1.gridx = 3;
        c1.gridy = 2;
        c1.weightx =1;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = inset;
        bottomPanel.add(folderOneDeleteButton,c1);
        folderOneDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked button " + e.getSource().toString());
                GridBagLayout layout = (GridBagLayout) bottomPanel.getLayout();
                GridBagConstraints gbc = layout.getConstraints((Component)e.getSource());
                System.out.println("x: " + gbc.gridx + ", Y: " + gbc.gridy);
                removeComboBoxHorizontal2(gbc, gbc0);
            }
        });
        gbcDel0 = c1;
        
        /*
        c1= new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 3;
        c1.weightx = 1;
        c1.insets = inset;
        bottomPanel.add(folderTwoLabel,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 3;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = inset;
        bottomPanel.add(folderTwoComboBox,c1);
        gbc1=c1;
        
        c1 = new GridBagConstraints();
        c1.gridx = 2;
        c1.gridy = 3;
        c1.weightx = 1;
        c1.anchor = GridBagConstraints.LINE_START;
        c1.insets = inset;
        bottomPanel.add(addComboBoxFolderTwoButton,c1);
        addComboBoxFolderTwoButton.addActionListener(new addFieldFolderTwo());
        gbcAdd1 = c1;
        
        c1 = new GridBagConstraints();
        c1.gridx = 3;
        c1.gridy = 3;
        c1.weightx =1;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = inset;
        bottomPanel.add(folderTwoDeleteButton,c1);
        folderTwoDeleteButton.addActionListener(new deleteFieldFolderTwo());
        gbcDel1 = c1;
        */
        
        c1= new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 3;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = inset;
        bottomPanel.add(sep2,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 3;
        //c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.weightx = 1;
        c1.insets = inset;
        bottomPanel.add(startFieldsLabel,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 2;
        c1.gridy = 3;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.insets = inset;
        bottomPanel.add(sep3,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 4;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = inset;
        bottomPanel.add(comboBox1,c1);
        gbcCopy = c1;
        comboBoxPos = gbcCopy.gridy;
        /*
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 6;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = inset;
        bottomPanel.add(comboBox2,c1);
        */
        c1= new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 5;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = inset;
        bottomPanel.add(sep4,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 5;
        c1.weightx =1;
        //c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.insets = inset;
        bottomPanel.add(endFieldsLabel,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 2;
        c1.gridy = 5;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.insets = inset;
        bottomPanel.add(sep5,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 6;
        c1.weightx =1;
        c1.insets = inset;
        bottomPanel.add(documentLabel,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 6;
        c1.weightx =1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = inset;
        bottomPanel.add(documentComboBox,c1);
        gbc2 = c1;
        
        c1 = new GridBagConstraints();
        c1.gridx = 2;
        c1.gridy = 6;
        c1.weightx = 1;
        c1.anchor = GridBagConstraints.LINE_START;
        c1.insets = inset;
        bottomPanel.add(addComboBoxDocButton,c1);
        addComboBoxDocButton.addActionListener(new addFieldDoc());
        gbcAdd2 = c1;
        
        c1 = new GridBagConstraints();
        c1.gridx = 3;
        c1.gridy = 6;
        c1.weightx =1;
        c1.anchor = GridBagConstraints.CENTER;
        c1.insets = inset;
        bottomPanel.add(docDeleteButton,c1);
        docDeleteButton.addActionListener(new deleteFieldDoc());
        gbcDel2 = c1;
        
        
        c1= new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 7;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = inset;
        bottomPanel.add(sep6,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 7;
        c1.weightx = 1;
        //c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.insets = inset;
        bottomPanel.add(startListLabel,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 2;
        c1.gridy = 7;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.insets = inset;
        bottomPanel.add(sep7,c1);
        
        
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 8;
        c1.weightx = 1;
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = inset;
        bottomPanel.add(finalComboBox,c1);
        
        c1 = new GridBagConstraints();
        c1.gridx = 0;
        c1.gridy = 9;
        c1.weightx = 1;
        c1.weighty = 1;
        c1.fill = GridBagConstraints.BOTH;
        c1.insets = inset;
        bottomPanel.add(sep8,c1);
        
        c1= new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 9;
        c1.weightx = 1;
        c1.weighty = 1;
        //c1.gridwidth = GridBagConstraints.REMAINDER;
        //c1.gridwidth = 6;
        c1.anchor = GridBagConstraints.NORTH;
        //c1.fill = GridBagConstraints.VERTICAL;
        c1.insets = inset;
        bottomPanel.add(endListLabel,c1);

        c1 = new GridBagConstraints();
        c1.gridx = 2;
        c1.gridy = 9;
        c1.weightx = 1;
        c1.weighty = 1;
        c1.gridwidth = GridBagConstraints.REMAINDER;
        c1.fill = GridBagConstraints.BOTH;
        c1.insets = inset;
        bottomPanel.add(sep9,c1);
                
        
        //bottomPanel.setBorder(BorderFactory.createEtchedBorder());
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setViewportView(bottomPanel);
        
        Dimension d0 = new Dimension (900,800);
        Dimension d1 = new Dimension (200,600);
        Dimension d2 = new Dimension (900,200);
        panel2.setPreferredSize(d1);
        topPanel.setPreferredSize(d2);
        getContentPane().add(topPanel,BorderLayout.NORTH);
        getContentPane().add(scrollPanel,BorderLayout.CENTER);
        getContentPane().add(panel2, BorderLayout.EAST);
        setTitle("TEST CLASS");
        setPreferredSize(d0);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setVisible(true);
        pack();
        
    }
    
    /* 
    jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("New");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Save");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Save As");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
    */
    
    
    
    /*
    private LayoutManager GridBagLayout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    */    
    private JPanel bottomPanel;
    private JPanel panel2;
    private JScrollPane scrollPanel;
    
    private JButton addLineButton;
    private JButton removeLineButton;
    private JButton addComboBoxFolderOneButton;
    private JButton addComboBoxFolderTwoButton;
    private JButton addComboBoxDocButton;
    private JButton addFieldButton;
    private JButton removeFieldButton;
    private JButton folderOneDeleteButton;
    private JButton folderTwoDeleteButton;
    private JButton docDeleteButton;
    
    private JComboBox<String> documentComboBox;
    private JComboBox<String> finalComboBox;
    private JComboBox<String> folderOneComboBox;
    private JComboBox<String> folderTwoComboBox;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    
    private JLabel folderOneLabel;
    private JLabel folderTwoLabel;
    private JLabel startFieldsLabel;
    private JLabel endFieldsLabel;
    private JLabel startListLabel;
    private JLabel endListLabel;
    private JLabel documentLabel;
    private JLabel templateNameTitle;

    private JSeparator sep1;
    private JSeparator sep2;
    private JSeparator sep3;
    private JSeparator sep4;
    private JSeparator sep5;
    private JSeparator sep6;
    private JSeparator sep7;
    private JSeparator sep8;
    private JSeparator sep9;

    private int comboBoxCount;
    private int comboBoxPos;
    private int fieldCount;
    private int lineCount;
    private int folderCount;
    private int folderPos;
    private String[] s1;
    private GridBagConstraints gbcCopy;
    private GridBagConstraints gbcLabel;
    private GridBagConstraints gbc0;
    private GridBagConstraints gbc1;
    private GridBagConstraints gbc2;
    private GridBagConstraints gbcAdd0;
    private GridBagConstraints gbcAdd1;
    private GridBagConstraints gbcAdd2;
    private GridBagConstraints gbcDel0;
    private GridBagConstraints gbcDel1;
    private GridBagConstraints gbcDel2;
    
    //private ArrayList<MutableComboBoxModel<String>> modelArrayList; 
    //private ArrayList<MutableComboBoxModel<String>> folderOneModelArrayList;
    //private ArrayList<MutableComboBoxModel<String>> folderTwoModelArrayList;
    //private MutableComboBoxModel<String> cbm0;
    //private MutableComboBoxModel<String> cbm1;
    //private MutableComboBoxModel<String> cbm2;
    //private MutableComboBoxModel<String> cbm3;
    //private MutableComboBoxModel<String> cbm4;
    
    
    
    private ArrayList<DefaultComboBoxModel> modelArrayList; 
    private ArrayList<DefaultComboBoxModel> folderOneModelArrayList;
    private ArrayList<DefaultComboBoxModel> folderTwoModelArrayList;
    private ArrayList<DefaultComboBoxModel> docModelArrayList;
    private ArrayList<ArrayList<DefaultComboBoxModel>> folderModelArrayList;
    
    private DefaultComboBoxModel cbm0;
    private DefaultComboBoxModel cbm1;
    private DefaultComboBoxModel cbm2;
    private DefaultComboBoxModel cbm3;
    private DefaultComboBoxModel cbm4;
    
    
    private JPanel topPanel;
    private JLabel templateNameLabel;
    private JLabel docTypeLabel;
    private JLabel fieldCountLabel;
    private JLabel lineCountLabel;
    private JLabel folderCountLabel;
    private JTextField templateNameTextField;
    private JTextField fieldLengthTextField;
    private JTextField lineCountTextField;
    private JTextField folderCountTextField;
    private JComboBox<String> docTypeComboBox; // new JComboBox<>(docTypes
    private JButton resetButton;
    private JButton previewButton;
    private JButton saveButton;
    private JLabel saveLocationLabel;
    
    private final Template temp;
    private Path tempPath;
    private File tempFile;
    private final String[] docTypes = {".TIF", ".tif", ".JPG", ".jpg", ".JPEG", ".jpeg",".PDF", ".pdf"};
    private JFileChooser fc0;
    private Dimension dButton;
    
    
    
}