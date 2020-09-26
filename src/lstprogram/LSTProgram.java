/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lstprogram;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;


public class LSTProgram implements ActionListener {

    JButton openButton, saveButton, clearButton, createButton, templateSelectorButton, createTemplateButton;
    JFileChooser fc,fc1,fc2;
    JFrame frame;
    JPanel panel0;
    File inputFile, saveDir, templateFile;
    JTextField field1,field2,field3,field4;
    Path inputPath, saveLoc, templatePath;
    Template t = null;
    
    
    public static void main(String[] args) {
       LSTProgram lst = new LSTProgram();
       lst.buildGUI();
       
    }
    
    private void buildGUI() {
        frame = new JFrame();
        frame.setTitle("Laserfiche LST Creator");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //frame.pack();
        
        fc = new JFileChooser();
        fc1 = new JFileChooser();
        fc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc2 = new JFileChooser();
        
        panel0 = new JPanel(new GridBagLayout());
       
        Dimension d = new Dimension(150,50);
        Dimension d1 = new Dimension(2,2);
        Dimension dText = new Dimension(200,40);
        
        openButton = new JButton();
	openButton.setText("OPEN");
	openButton.setPreferredSize(d);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        c.insets = new Insets (2,2,2,2);
	panel0.add(openButton,c);
        openButton.addActionListener(new OpenFile());
        
        saveButton = new JButton();
        saveButton.setText("Save");
        saveButton.setPreferredSize(d);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        panel0.add(saveButton,c);
        saveButton.addActionListener(new saveLocation());
        
        templateSelectorButton = new JButton();
        templateSelectorButton.setText("Select Template");
        templateSelectorButton.setPreferredSize(d);
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        panel0.add(templateSelectorButton,c);
        templateSelectorButton.addActionListener(new selectTemplate());
                
        JLabel label3 = new JLabel("Delimitter:");
        label3.setPreferredSize(d);
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.5;
        panel0.add(label3,c);
                
        field1 = new JTextField(20);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridx = 1;
        c1.gridy = 0;
        c1.anchor = GridBagConstraints.CENTER;
        c1.fill = GridBagConstraints.BOTH;
        c1.weightx = 1;
        c1.insets = new Insets (2,2,2,2);
	panel0.add(field1,c1);
        
        field2 = new JTextField(20);
        c1.gridx = 1;
        c1.gridy = 1;
        c1.anchor = GridBagConstraints.CENTER;
        c1.fill = GridBagConstraints.BOTH;
        c1.weightx = 1;
	panel0.add(field2,c1);
        
        field3 = new JTextField(20);
        c1.gridx = 1;
        c1.gridy = 2;
        c1.anchor = GridBagConstraints.CENTER;
        c1.fill = GridBagConstraints.BOTH;
        c1.weightx = 1;
	panel0.add(field3,c1);
        
        field4 = new JTextField(20);
        c1.gridx = 1;
        c1.gridy = 3;
        c1.anchor = GridBagConstraints.CENTER;
        c1.fill = GridBagConstraints.BOTH;
        c1.weightx = 1;
	panel0.add(field4,c1);
        
        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(d);
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridx = 2;
        c2.gridy = 0;
        c2.anchor = GridBagConstraints.CENTER;
        c2.fill = GridBagConstraints.NONE;
        c2.weightx = 0.5;
        c2.insets = new Insets (2,2,2,2);
        panel0.add(clearButton,c2);
        clearButton.addActionListener(new clearFields());
        
        createButton = new JButton("Create LSTs");
        createButton.setPreferredSize(d);
        c2.gridx = 2;
        c2.gridy = 1;
        c2.anchor = GridBagConstraints.CENTER;
        c2.fill = GridBagConstraints.NONE;
        c2.weightx = 0.5;
        panel0.add(createButton,c2);
        createButton.addActionListener(new createLST());
        
        createTemplateButton = new JButton("Create Template");
        createTemplateButton.setPreferredSize(d);
        c2.gridx = 2;
        c2.gridy = 2;
        c2.anchor = GridBagConstraints.CENTER;
        c2.fill = GridBagConstraints.NONE;
        c2.weightx = 0.5;
        panel0.add(createTemplateButton,c2);
        createTemplateButton.addActionListener(new createTemplate());
        
        
        JSeparator sep = new JSeparator();
        sep.setPreferredSize(d1);
        c2.gridx = 0;
        c2.gridy = 4;
        c2.gridwidth = 3;
        c2.gridheight = 1;
        //c2.ipady = 10;
        c2.weightx = 1;
        c2.weighty = .1;
        c2.fill = GridBagConstraints.HORIZONTAL;
        panel0.add(sep,c2);
        
        
        
        JTextArea textArea = new JTextArea(2,2);
        //textArea.setPreferredSize(d);
        GridBagConstraints c3 = new GridBagConstraints();
        c3.gridx = 0;
        c3.gridy = 5;
        c3.anchor = GridBagConstraints.CENTER;
        c3.fill = GridBagConstraints.BOTH;
        c3.gridwidth = 3;
        //c3.gridheight = 1;
        c3.weighty = 1;
        //c3.weightx = 1;
        c3.insets = new Insets (2,2,2,2);
        panel0.add(textArea,c3);
        
        
        
        JButton testButton = new JButton("Test");
        testButton.setPreferredSize(d);
        testButton.setBackground(Color.red); 
        c2.gridx = 2;
        c2.gridy = 3;
        c2.anchor = GridBagConstraints.CENTER;
        c2.fill = GridBagConstraints.NONE;
        c2.weightx = 0.5;
        //panel0.add(testButton,c2);
        //testButton.addActionListener(new testFunction());
        
        
        frame.getContentPane().add(panel0);
        frame.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
    class OpenFile implements ActionListener {
        public OpenFile(){
        }
                
        public void actionPerformed(ActionEvent e) {
                //b1ActionPerformed(evt);
            if (e.getSource() == openButton) {
                int returnVal = fc.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
            inputFile = fc.getSelectedFile();
            field1.setText(inputFile.toString());
            inputPath = Paths.get(inputFile.toString());
            
            //This is where a real application would open the file.
//            log.append("Opening: " + file.getName() + "." + newline);
//        } else {
//            log.append("Open command cancelled by user." + newline);
//            }
//            try {
//         // What to do with the file, e.g. display it in a TextArea
//        textarea.read( new FileReader( file.getAbsolutePath() ), null );
//            } catch (IOException ex) {
//                System.out.println("problem accessing file"+file.getAbsolutePath());
//            }
//               } else {
//                System.out.println("File access cancelled by user.");
//             }

            }
            }
        }
    }
    
    class saveLocation implements ActionListener {
        public saveLocation(){            
        }
                
        public void actionPerformed(ActionEvent e) {
                //b1ActionPerformed(evt);
            if (e.getSource() == saveButton) {
                int returnVal = fc1.showSaveDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
            saveDir = fc1.getSelectedFile();
            field2.setText(saveDir.toString());
            saveLoc = Paths.get(saveDir.toString());
            
            //This is where a real application would open the file.
//            log.append("Opening: " + file.getName() + "." + newline);
//        } else {
//            log.append("Open command cancelled by user." + newline);
//            }
//            try {
//         // What to do with the file, e.g. display it in a TextArea
//        textarea.read( new FileReader( file.getAbsolutePath() ), null );
//            } catch (IOException ex) {
//                System.out.println("problem accessing file"+file.getAbsolutePath());
//            }
//               } else {
//                System.out.println("File access cancelled by user.");
//             }
            }
            }
        }
    }
    
    class selectTemplate implements ActionListener {
        public selectTemplate() {            
        }
        public void actionPerformed(ActionEvent e) {
                //b1ActionPerformed(evt);
            if (e.getSource() == templateSelectorButton) {
                int returnVal = fc2.showOpenDialog(frame);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
            templateFile = fc2.getSelectedFile();
            field3.setText(templateFile.toString());
            templatePath = Paths.get(templateFile.toString());
            }
            }
        }
        
    }
    
    
    class clearFields implements ActionListener {
        public clearFields(){           
        }
                
        public void actionPerformed(ActionEvent e) {
            field1.setText("");
            field2.setText("");
            field3.setText("");
            field4.setText("");
        }
    }
    
    class createTemplate implements ActionListener {
        public createTemplate() {            
        }
        public void actionPerformed(ActionEvent ev) {
            //Template newTemplate = new Template();
            //new TemplateCreator().setVisible(true);
            new TestClass().setVisible(true);
            
            /*
            Template test = new Template();
            test.setTemplateName("testTESTtestTEST");
            test.setFieldLength(21);
            test.setDocType(".TIF");
            test.setDocArray(new int[] {1,2,3});
            test.setFieldIndexes(new int[] {20,20,20,20,20,20,20,20,20,20,20,20,20,20});
            test.setFolder1Array(new int[] {1,2,3});
            test.setFolder2Array(new int[] {1,2,3});
            
            test.saveTemplate(test);
            */
        }
    }

    
    class createLST implements ActionListener {
        public createLST(){           
        }
                
        public void actionPerformed(ActionEvent e) {
            System.out.println();            
            openTemplate(templateFile);
            ArrayList<String[]> aList = getFields(getPath());
            
            
            String sTest;
            Path pTest;
            String name;
            int n = 0;
            
            System.out.println("arrayListStringArray size: " + aList.size());
            
            for (int i = 0;i < aList.size(); i++) {
                String[] array = aList.get(i);
                sTest = array[array.length-1];
                File fTest = new File(sTest);
                System.out.println(fTest.exists());
                
                Object[] options = {"Yes", "Yes to All", "No"};
                if (!fTest.exists() && (n != 1)) {                                        
                    try {
                        n = JOptionPane.showOptionDialog(frame, fTest.toString() + " path is not valid. \n Would you like to continue?", "Invalid Path", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                        //n = JOptionPane.showConfirmDialog(frame, fTest.toString() + " path is not valid. \n Would you like to continue?", "Invalid Path", JOptionPane.YES_NO_OPTION);
                        System.out.println(n);
                        if (n == 2) break;
                    } catch (HeadlessException ex) {
                        ex.printStackTrace();
                    }
                }
                pTest = fTest.toPath();
                System.out.println(pTest.getFileName());
                name = pTest.getFileName().toString().replace(t.getDocType(), "");
                System.out.println(name);
                
                System.out.println(pTest.getRoot());
                System.out.println(pTest.toString());
                
                
                ArrayList<String> stringArrayList = new ArrayList<>();
                for (int j = 0; j< array.length; j++) {
                    stringArrayList.add(array[j]);
                }
                System.out.println(stringArrayList);
                
                writeFiles(stringArrayList, name);
                
            }
            
            /*
            openTemplate(templateFile);
            ArrayList<String> alist = getFields(getPath());
 
            
            String str;
            int count = 0;
            int x = 0;
            for (int j=0; j<(alist.size()/t.getFieldLength());j++) {
		count++;
		str = "file " + count;
		ArrayList<String> idk = new ArrayList<String>(alist.subList(x, x+t.getFieldLength()));
		writeFiles(idk, str);
		x = x + t.getFieldLength();
	} 
	//System.out.println("there are " + str+ " arrays.");
            */
        }
    }
    
    class testFunction implements ActionListener {
        public testFunction() {            
        }
        public void actionPerformed (ActionEvent e) {
            System.out.println();            
            openTemplate(templateFile);
            ArrayList<String[]> aList = getFields(getPath());
            
            
            String sTest;
            Path pTest;
            String name;
            int n = 0;
            
            System.out.println("arrayListStringArray size: " + aList.size());
            
            for (int i = 0;i < aList.size(); i++) {
                String[] array = aList.get(i);
                sTest = array[array.length-1];
                File fTest = new File(sTest);
                System.out.println(fTest.exists());
                
                Object[] options = {"Yes", "Yes to All", "No"};
                if (!fTest.exists() && (n != 1)) {                                        
                    try {
                        n = JOptionPane.showOptionDialog(frame, fTest.toString() + " path is not valid. \n Would you like to continue?", "Invalid Path", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                        //n = JOptionPane.showConfirmDialog(frame, fTest.toString() + " path is not valid. \n Would you like to continue?", "Invalid Path", JOptionPane.YES_NO_OPTION);
                        System.out.println(n);
                        if (n == 2) break;
                    } catch (HeadlessException ex) {
                        ex.printStackTrace();
                    }
                }
                pTest = fTest.toPath();
                System.out.println(pTest.getFileName());
                name = pTest.getFileName().toString().replace(t.getDocType(), "");
                System.out.println(name);
                
                System.out.println(pTest.getRoot());
                System.out.println(pTest.toString());
                
                
                ArrayList<String> stringArrayList = new ArrayList<>();
                for (int j = 0; j< array.length; j++) {
                    stringArrayList.add(array[j]);
                }
                System.out.println(stringArrayList);
                
                writeFiles(stringArrayList, name);
                
            }
            
        }
        
    }
   
    private Path getPath() {
        inputPath = Paths.get(field1.getText());
        return inputPath;
    }
      
    private String verifyString(String s, int c) {
        String[] array = s.split(Pattern.quote(field4.getText()));
            if (array.length != t.getFieldLength()) {
                try {
                    int n = JOptionPane.showConfirmDialog(frame, "Field Length is not correct at LINE: " + c + "\n Fix Now?", "Invalid Field Length", JOptionPane.YES_NO_OPTION);
                    System.out.println(n);
                    if (n == 0) {
                        String s1 = JOptionPane.showInputDialog(frame, "Invalid field count" ,s);
                        verifyString(s1, c);
                    } else {
                        s = "close";
                    }
                    
                } catch (HeadlessException ex) {
                    ex.printStackTrace();
                }                
            }            
        return s;
    }
    
    
    
    private ArrayList<String[]> getFields(Path file) {
        ArrayList<String> fieldValues = new ArrayList<>();
        ArrayList<String[]> arrayListStringArray = new ArrayList<>();
        int count = 0;
        try {
            BufferedReader reader = Files.newBufferedReader(file);
            
            String line = null;
            while ((line = reader.readLine()) != null) {
                //line.trim();
                while (!line.endsWith(t.getDocType())) {
                    System.out.println("Before adding" + line);
                    line = line + reader.readLine();
                    System.out.println("After adding" + line);
                }
                
                System.out.println("line: " + line);
                if (line.endsWith(t.getDocType())) {
                    count++;
                    String line2 = verifyString(line, count);
                    if (line2.equals("close")) break;
                    String[] array = line2.split(Pattern.quote(field4.getText()));
                    //if (array.length != t.getFieldLength()) {
                    //    String s = JOptionPane.showInputDialog(frame, "Invalid field count" ,line);
                    //    //s.split(Pattern.quote(field4.getText()));
                    //}
                    arrayListStringArray.add(array);
                    for (int i=0; i<array.length; i++) {
                        //array[i].trim();
                        fieldValues.add(array[i]);
                    } 
                    /*
                    if (array.length != t.getFieldLength()) {
                        System.out.println("FieldCount and input Line don't match");
                    }
                    */
                    
                } else { 
                    System.out.println(" STILL NOT WORKING!!!!");
                }
                    
            }
            reader.close();
               
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arrayListStringArray;
    }
    
    
    public void openTemplate(File f) {
        
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream oos = new ObjectInputStream(fis);
            t = (Template) oos.readObject();
            fis.close();
            oos.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException cex) {
            cex.printStackTrace();
        }
        
    }
       
        
       
    private void writeFiles(ArrayList<String> a, String s) {
        try {
                //File output = new File(s + ".lst");
                //FileWriter fw = new FileWriter(output);
		//BufferedWriter writer = new BufferedWriter(fw);
                Path output = Paths.get(saveLoc.toString(), s + ".lst");
                BufferedWriter writer = Files.newBufferedWriter(output);
		
                int folderOneValue = 0;
                int folderTwoValue = 0;
                int docValue = 0;
                int[]fVArray = t.getFieldIndexes();
                
                System.out.println("fVarray: ");
                for (int i = 0; i<fVArray.length;i++) {
                    System.out.print(fVArray[i] + ", ");
                }
                System.out.println();
                for (int i=0; i<a.size();i++) {
			System.out.println("arrayValues: " + a.get(i));			
		}
                System.out.println();
                
		writer.write("LASERFICHE IMPORT LIST");
		writer.newLine();
		//writer.write("FOLDERS(" + a.get(folderOneValue) + ")");
                for (int i = 0; i<t.getFolder1Array().length; i++) {
                    System.out.println("folder1Array i = " + i);
                    System.out.println("t.getFolder1ArrayI(i): " + t.getFolder1ArrayI(i));
                    System.out.println(a.get(t.getFolder1ArrayI(i)-2).equals(""));
                    System.out.println(a.get(t.getFolder1ArrayI(i)-2).equals(null));
                    
                    if (t.getFolder1ArrayI(i)==-1) {
                        writer.write("FOLDERS()");
                        System.out.println("-1");
                        break;
                    } else if (t.getFolder1ArrayI(i)==0) {
                        writer.write("FOLDERS(UNKOWN)");
                        System.out.println("0");
                        break; 
                    } else if (t.getFolder1ArrayI(i)==1) {
                        writer.write("FOLDERS(CUSTOM)");
                        System.out.println("1");
                        break;
                    } else if (!a.get(t.getFolder1ArrayI(i)-2).equals("")) {
                        writer.write("FOLDERS(" + a.get(t.getFolder1ArrayI(i)-2) + ")");
                        System.out.println(t.getFolder1ArrayI(i)-2);
                        System.out.println(a.get(t.getFolder1ArrayI(i)-2));
                        break;
                    }
                    
                }                
		writer.newLine();
		//writer.write("FOLDERS("+ a.get(folderTwoValue) +")");
                for (int i = 0; i<t.getFolder2Array().length; i++) {
                    System.out.println("folder2Array i = " + i);
                    if (t.getFolder2ArrayI(i)==-1) {
                        writer.write("FOLDERS()");
                        break;
                    } else if (t.getFolder2ArrayI(i)==0) {
                        writer.write("FOLDERS(UNKOWN)");
                        break;
                    } else if (t.getFolder2ArrayI(i)==1) {
                        writer.write("FOLDERS(CUSTOM)");
                        break;
                    } else if (!a.get(t.getFolder2ArrayI(i)-2).equals("")) {
                        writer.write("FOLDERS(" + a.get(t.getFolder2ArrayI(i)-2) + ")");
                        break;
                    }
                    
                }             
		writer.newLine();
		writer.write("STARTFIELDS");
		writer.newLine();
		writer.write(t.getTemplateName());
		writer.newLine();
		
                //start at 1 because index 0 of this array is the final combobox
                for (int i =1;i<fVArray.length;i++) {
                    if(fVArray[i]==-1) {
                        writer.newLine();
                    } else if (fVArray[i]==0) {
                        writer.write("UNKNOWN");
                        writer.newLine();
                    } else if (fVArray[i]==1){
                        writer.write("CUSTOM");
                        writer.newLine();
                    } else {
                        writer.write(a.get(fVArray[i]-2));
                        writer.newLine();
                    }
                    
                }
                
		writer.write("ENDFIELDS");
		writer.newLine();
		//writer.write("VOLUMES()");
		//writer.newLine();
                for (int i = 0; i<t.getDocArray().length; i++) {
                    System.out.println("docArray i = " + i);
                    if (t.getDocArrayI(i)==-1) {
                        writer.write("DOCUMENT()");
                        break;
                    } else if (t.getDocArrayI(i)==0) {
                        writer.write("DOCUMENT(UNKOWN)");
                        break;
                    } else if (t.getDocArrayI(i)==1) {
                        writer.write("DOCUMENT(CUSTOM)");
                        break;
                    } else if (!a.get(t.getDocArrayI(i)-2).equals("")) {
                        writer.write("DOCUMENT(" + a.get(t.getDocArrayI(i)-2) + ")");
                        break;
                    }
                    
                }             
		writer.newLine();
		writer.write("STARTLIST");
		writer.newLine();
		writer.write(a.get(fVArray[0]-2));
		//writer.write(a.get(20));
		//writer.write(a.get(21));
		writer.newLine();
		writer.write("ENDLIST");
		//writer.newLine();
		//writer.newLine();
		//writer.newLine();
		//writer.write("size of array is: " + a.size());
		//writer.newLine();
                //writer.write("fVArray length: " + fVArray.length);
                writer.newLine();
				
		writer.close();

		} catch (IOException ex) { 
                    System.out.println("create error msg and dialog box here");
			ex.printStackTrace();
                }
    }
	
}





                
                /*
                System.out.println(" b: ");
                byte[] b = ("").getBytes();
                for (int j =0; j<b.length;j++) {
                        System.out.print(b[j]);
                    }
                System.out.println();
                for (int i =0; i<a.size();i++) {
                    byte[] byteArray = a.get(i).getBytes();
                    System.out.println();
                    System.out.println("i: " + i + " a.get(i): " + a.get(i));
                    for (int j =0; j<byteArray.length;j++) {
                        System.out.print(byteArray[j]);
                    }
                            
                }
                
                for(int i =0; i<t.getFolder1Array().length;i++) {
                    if (a.get(t.getFolder1ArrayI(i))!="") {
                        folderOneValue = t.getFolder1ArrayI(i);
                        break;
                    }
                }
                for(int i =0; i<t.getFolder2Array().length;i++) {
                    if (a.get(t.getFolder2ArrayI(i))!="") {
                        folderTwoValue = t.getFolder2ArrayI(i);
                        break;
                    }
                }
                for(int i=0; i<t.getDocArray().length;i++) {
                    if (a.get(t.getDocArrayI(i))!="") {
                        docValue = t.getDocArrayI(i);
                        break;
                    }
                }
		*/

/*
    private ArrayList<String> getFields(Path file) {
        ArrayList<String> tokens = new ArrayList<>();
        
        try {
            
            
//    Scanner s1 = new Scanner(file);
//    String regex = s1.nextLine();
//    String s2 = s1.replaceAll(regex, "LF");
//    System.out.println(s2); 
          
            Scanner sc = new Scanner(file);
            
//            while (sc.findWithinHorizon("\r\n\r\n", 0) != null) {
//                String str = sc.findWithinHorizon("\r\n\r\n", 0);
//                str = str.replace(str,"|");
//            }
            
//            while (sc.findWithinHorizon("\r\n", 0) != null) {
//                String str = sc.findWithinHorizon("\r\n", 0);
//                str = str.replace(str,"");
//            }
            
            sc.useDelimiter(Pattern.quote(field4.getText()));
            
            while (sc.hasNext()) {
                tokens.add(sc.next());
            }
        
           if (sc != null) sc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
 //       for (String s: tokens) {
 //           if (tokens.contains("\r\n\r\n")) {              
//            }
//          }
        System.out.println(tokens.size());
        return tokens;
    }
    
        
    
    private ArrayList<String> getFields(Path file) {
        ArrayList<String> fieldValues = new ArrayList<>();

		try {
			//File input = new File("samplecommas.txt");
			//FileReader fr = new FileReader(f);
			//BufferedReader reader = new BufferedReader(fr);
                        BufferedReader reader = Files.newBufferedReader(file);
//			ArrayList<String> al = new ArrayList<String>();
//			int count = 0;
                        
			String line = null;
			while ((line = reader.readLine()) != null) {	
                                //String removeCRLF = line.replace("\\r\\n", " ");
                                String removeCRLF = line.replaceAll("\\r\\n", " ");
                                //String removeCRLF = line.replace(System.lineSeparator(), " ");
				//String[] array = line.split("[" + field4.getText() + "]");
                                String[] array = removeCRLF.split(Pattern.quote(field4.getText()));

                                if (removeCRLF.trim().length() > 0) {
                                   
                                    for (int i=0; i<array.length; i++) {
                                            fieldValues.add(array[i]);
    //					System.out.println(wtf.get(count));
    //					System.out.println("field " + count + " : " + al.get(count));
    //					System.out.println("arraylist length is: " + al.size());
    //					count++;
                                    } 	
                                }
			}	
			reader.close();
		} catch (IOException ex) { 
			ex.printStackTrace();
		}  	
		return fieldValues;
    }
    
    private ArrayList<String> getFields(Path file) {
        ArrayList<String> fieldValues = new ArrayList<String>();

        try {
            RandomAccessFile raf = new
            RandomAccessFile(file.toFile(),"rw");
            long length = raf.length();
            byte[] byteArray0 = new byte[(int) length];

            raf.seek(0);
            raf.readFully(byteArray0);

            int pointer;
            byte[] b2 = {13, 10};
            byte[] byteArray1 = new byte[4];
            byte[] byteArray2 = new byte[2];
                    //raf.readFully(byteArray0);


                    for (int i = 0; i<length; i++) {
                        pointer = i;
                        raf.seek(pointer);
                        raf.readFully(byteArray1);
                        if (byteArray1.equals(b1)) raf.writeBytes("|");
                        System.out.print(byteArray1);
                    }

                    for (int i = 0; i<length; i++) {
                        pointer = i;
                        raf.seek(pointer);
                        raf.readFully(byteArray2);
                        if (byteArray2.equals(b2)) raf.writeBytes(" ");
                        System.out.print(byteArray2);
                    }
  

            System.out.println(b1);
            System.out.println(b2);
            System.out.println(raf.length());
            System.out.println(raf.getFilePointer());
            for (int i = 0; i<length;i++) {
                System.out.print(byteArray0[i]+ " ");
            }
            System.out.println();


           

            StringBuilder sb = new StringBuilder();
            for (byte z : byteArray0) {
                sb.append(z);
            }
            String s = sb.toString();
            System.out.println(s);

            raf.close();


                        BufferedReader reader = Files.newBufferedReader(file);

String line = null;
while ((line = reader.readLine()) != null) {
String[] array = line.split(Pattern.quote(field4.getText()));
for (int i=0; i<array.length; i++) {
fieldValues.add(array[i]);
}
}
reader.close();
                        

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return fieldValues;
        
    }

       
    
    
    private int getFieldLength() {
        return fieldLength;
    }
    
    private void setFieldLength(int i){
        fieldLength = i;
    }
    
    private String getTemplateName() {
        return templateName;
    }
    
    private void setTemplateName(String s){
        templateName = s;
    }
    */
