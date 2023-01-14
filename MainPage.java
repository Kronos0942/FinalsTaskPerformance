import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MainPage extends JFrame{
    public MainPage(){
        JFrame mainFrame = new JFrame();

        ImageIcon icon = new ImageIcon("C:/Users/pc/Desktop/OOP Finals Files/Logo.png");
        mainFrame.setIconImage(icon.getImage());

        JButton btnAccount = new JButton("Account List");
        btnAccount.setBounds(145, 75, 200, 50);
        mainFrame.add(btnAccount);
    
        JButton btnBlacklist = new JButton("Blacklisted");
        btnBlacklist.setBounds(145, 175, 200, 50);
        mainFrame.add(btnBlacklist);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(145, 275, 200, 50);
        mainFrame.add(btnLogout);
        
        mainFrame.setLayout(null);
        mainFrame.setSize(500,500);
        mainFrame.setTitle("National Bureau of Investigation");
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

       btnAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                mainFrame.dispose();
                new AccountPage();
            }
        });
        btnBlacklist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                mainFrame.dispose();
                new BlacklistPage();
            }
        });
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                mainFrame.dispose();
                new LoginPage();
            }
        });
    }
    public static void main(String[]args){
        new MainPage();
    }
}