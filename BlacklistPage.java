import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.Font;


public class BlacklistPage extends JFrame {
    public BlacklistPage(){
        JFrame blacklistFrame = new JFrame("National Bureau of Investigation");

        blacklistFrame.setLayout(null);
        blacklistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blacklistFrame.setSize(950, 500);
        blacklistFrame.setLocationRelativeTo(null);
        Font font = new Font("Calibri", Font.BOLD, 20);

        ImageIcon icon = new ImageIcon("C:/Users/pc/Desktop/OOP Finals Files/Logo.png");
        blacklistFrame.setIconImage(icon.getImage());

        JLabel lblName = new JLabel("Full Name");
        lblName.setBounds(20, 50, 80, 25);
        blacklistFrame.add(lblName);

        JTextField fldName = new JTextField(20);
        fldName.setBounds(100, 50, 165, 25);
        blacklistFrame.add(fldName);

     
        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(20, 80, 80, 25);
        blacklistFrame.add(lblAge);

        JTextField fldAge = new JTextField(20);
        fldAge.setBounds(100, 80, 165, 25);
        blacklistFrame.add(fldAge);

       
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(20, 110, 80, 25);
        blacklistFrame.add(lblGender);

       
        String gender[] = {"Male","Female"};
        JComboBox comboGender = new JComboBox(gender);
        comboGender.setBounds(100, 110, 165, 25);
        blacklistFrame.add(comboGender);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(20, 140, 80, 25);
        blacklistFrame.add(lblAddress);

        JTextField fldAddress = new JTextField(20);
        fldAddress.setBounds(100, 140, 165, 25);
        blacklistFrame.add(fldAddress);

        JLabel lblContactNum = new JLabel("Contact No.");
        lblContactNum.setBounds(20, 170, 90, 25);
        blacklistFrame.add(lblContactNum);

        JTextField fldContactNum = new JTextField(20);
        fldContactNum.setBounds(100, 170, 165, 25);
        blacklistFrame.add(fldContactNum);
         
        JLabel lblTable = new JLabel("Blacklisted");
        lblTable.setBounds(300, 15, 150, 30);
        blacklistFrame.add(lblTable);
        lblTable.setFont(font);


        int length = 0;
        try{
            Scanner sc = new Scanner(new File("C:/Users/pc/Desktop/OOP Finals Files/blacklist.txt"));
            while(sc.hasNextLine()){
                length++;
                sc.nextLine();
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Error");
        }

        String data[][] = new String[length][5];

        String column[] = {"Full Name", "Age", "Gender", "Address", "Contact Number"};

        int i = 0;
        try{
            Scanner sc = new Scanner(new File("C:/Users/pc/Desktop/OOP Finals Files/blacklist.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data1 = line.split(",");
                data[i][0] = data1[0];
                data[i][1] = data1[1];
                data[i][2] = data1[2];
                data[i][3] = data1[3];
                data[i][4] = data1[4];
                i++;
            }
            sc.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);
        table.setBounds(300, 50, 600, 350);
        blacklistFrame.add(table);

        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 50, 600, 350);
        blacklistFrame.add(scrollPane);

        table.setRowSelectionAllowed(true);

        JButton buttonAdd = new JButton("Add");
        buttonAdd.setBounds(50, 220, 80, 25);
        blacklistFrame.add(buttonAdd);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(150, 220, 80, 25);
        blacklistFrame.add(buttonUpdate);

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(50, 260, 80, 25);
        blacklistFrame.add(buttonDelete);

        JButton buttonClear = new JButton("Clear");
        buttonClear.setBounds(150, 260, 80, 25);
        blacklistFrame.add(buttonClear);

        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(100, 300, 80, 25);
        blacklistFrame.add(buttonBack);

        blacklistFrame.setVisible(true);
        
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                int x = table.getSelectedRow();
                String name = fldName.getText();
                String age = fldAge.getText();
                String sex = comboGender.getSelectedItem().toString();
                String address = fldAddress.getText();
                String contactNumber = fldContactNum.getText();
                
                if(!name.equals("") && !age.equals("") && !address.equals("") && !contactNumber.equals("")){
                                                        try{
                                                            File file = new File("C:/Users/pc/Desktop/OOP Finals Files/blacklist.txt");
                                                            FileWriter fileWriter = new FileWriter(file,true);
                                                            fileWriter.write(name + " , " + age + " , " + sex + " , " + address + " , " + contactNumber + "\n");
                                                            JOptionPane.showMessageDialog(null, "Added Successful");
                                                            fileWriter.close();
                                                        }catch(Exception ex){ex.printStackTrace();}
                                                            blacklistFrame.dispose();
                                                            new BlacklistPage();
            
                }else{JOptionPane.showMessageDialog(null, "Please fill up all the fields");}
    
            }
        });
    
       
        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                int x = table.getSelectedRow();
                String name = fldName.getText();
                String age = fldAge.getText();
                String sex = comboGender.getSelectedItem().toString();
                String address = fldAddress.getText();
                String contactNumber = fldContactNum.getText();
                if(x==-1){
                    JOptionPane.showMessageDialog(null, "Please select a row to update");
                }
                else{
                    if(!name.equals("") && !age.equals("")&& !address.equals("") && !contactNumber.equals("")){
                                                        if(x >= 0) {
                                                            model.setValueAt(name, x, 0);
                                                            model.setValueAt(age, x, 1);
                                                            model.setValueAt(sex, x, 2);
                                                            model.setValueAt(address, x, 3);
                                                            model.setValueAt(contactNumber, x, 4);
                                                            try {
                                                                FileWriter fileWriter = new FileWriter("C:/Users/pc/Desktop/OOP Finals Files/blacklist.txt");
                                                                for(int j = 0; j < table.getRowCount(); j++) {
                                                                    fileWriter.write(model.getValueAt(j, 0).toString() + " , " + model.getValueAt(j, 1).toString() + " , " + model.getValueAt(j, 2).toString() + " , " + model.getValueAt(j, 3).toString() + " , " + model.getValueAt(j, 4).toString() + "\n");
                                                                }
                                                                fileWriter.close();
                                                                JOptionPane.showMessageDialog(null, "Update Successful");
                                                               
                                                            } catch (IOException e1) {e1.printStackTrace();}
                                                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Please fill up all the fields");
                    }
    
                }
    
            }
        });
    
        
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int row = table.getSelectedRow();
                    if(row == -1) {
                        JOptionPane.showMessageDialog(null, "Please select a row to delete");
                    }else {
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Delete", JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION) {
                            model.removeRow(row);
                            try {
                                FileWriter fileWriter = new FileWriter("C:/Users/pc/Desktop/OOP Finals Files/blacklist.txt");
                                for(int j = 0; j < table.getRowCount(); j++) {
                                    fileWriter.write(model.getValueAt(j, 0).toString() + " , " + model.getValueAt(j, 1).toString() + " , " + model.getValueAt(j, 2).toString() + " , " + model.getValueAt(j, 3).toString() + " , " + model.getValueAt(j, 4).toString() + "\n");
                                }
                                fileWriter.close();
                                JOptionPane.showMessageDialog(null, "Delete Successful");
                            } catch (IOException e1) {e1.printStackTrace();
                        }
                    }
                }
            }
        });
    
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                fldName.setText("");
                fldAge.setText("");
                fldAddress.setText("");
                fldContactNum.setText("");
            }
        });
    
        
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                blacklistFrame.dispose();
                new MainPage();
            }
        });
    }
    public static void main(String[]args){
        new BlacklistPage();
    }
}
