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


public class AccountPage extends JFrame {
    public AccountPage(){
        JFrame accountFrame = new JFrame("National Bureau of Investigation");

        accountFrame.setLayout(null);
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountFrame.setSize(700, 475);
        accountFrame.setLocationRelativeTo(null);
        Font font = new Font("Calibri", Font.BOLD, 20);

        ImageIcon icon = new ImageIcon("C:/Users/pc/Desktop/OOP Finals Files/Logo.png");
        accountFrame.setIconImage(icon.getImage());
         
        JLabel lblTable = new JLabel("Accounts");
        lblTable.setBounds(100, 10, 150, 30);
        accountFrame.add(lblTable);
        lblTable.setFont(font);


        int length = 0;
        try{
            Scanner sc = new Scanner(new File("C:/Users/pc/Desktop/OOP Finals Files/account.txt"));
            while(sc.hasNextLine()){
                length++;
                sc.nextLine();
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Error");
        }

        String data[][] = new String[length][3];

        String column[] = {"Username", "Password", "Email Address"};

        int i = 0;
        try{
            Scanner sc = new Scanner(new File("C:/Users/pc/Desktop/OOP Finals Files/account.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] data1 = line.split(",");
                data[i][0] = data1[0];
                data[i][1] = data1[1];
                data[i][2] = data1[2];
                i++;
            }
            sc.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        DefaultTableModel model = new DefaultTableModel(data, column);
        JTable table = new JTable(model);
        table.setBounds(100, 50, 500, 300);
        accountFrame.add(table);

        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 50, 500, 300);
        accountFrame.add(scrollPane);

        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(300, 375, 80, 25);
        accountFrame.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                accountFrame.dispose();
                new MainPage();
            }
        });

        table.setRowSelectionAllowed(true);

        accountFrame.setVisible(true);
        
       
    }
    public static void main(String[]args){
        new AccountPage();
    }
}