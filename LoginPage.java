import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LoginPage extends JFrame{
    public LoginPage(){
        JFrame loginFrame = new JFrame();

        JLabel welcome = new JLabel("National Bureau of Investigation");
        welcome.setFont(new Font("Calibri", Font.BOLD, 30));
        welcome.setBounds(150, 175, 500, 100);
        loginFrame.add(welcome);

        ImageIcon icon = new ImageIcon("C:/Users/pc/Desktop/OOP Finals Files/Logo.png");
        loginFrame.setIconImage(icon.getImage());

        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon("C:/Users/pc/Desktop/OOP Finals Files/nbi.png"));
        lblLogo.setBounds(250, 10, 200, 200 );
        loginFrame.add(lblLogo);

        JLabel lblName = new JLabel("Username");
        lblName.setBounds(200, 250, 100, 30);
        loginFrame.add(lblName);

        JTextField fldName = new JTextField(15);
        fldName.setBounds(300, 250, 200, 30);
        loginFrame.add(fldName);

        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(200, 300, 200, 30);
        loginFrame.add(lblPass);

        JTextField fldPass = new JTextField(15);
        fldPass.setBounds(300, 300, 200, 30);
        loginFrame.add(fldPass);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(200, 350 , 100, 40);
        loginFrame.add(btnLogin);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(400, 350 , 100, 40);
        loginFrame.add(btnRegister);
    
        loginFrame.setLayout(null);
        loginFrame.setSize(700,500);
        loginFrame.setTitle("National Bureau of Investigation");
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        loginFrame.setResizable(true);
        
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                new RegisterPage();
                loginFrame.setVisible(false);
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                String username = fldName.getText();
                String password = fldPass.getText();
                String line = "";
                
                File file = new File("C:/Users/pc/Desktop/OOP Finals Files/account.txt");
                    if(username.isEmpty() || password.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please fill up the form");
                    }
                    try (Scanner scan = new Scanner(file)) {
                        while(scan.hasNextLine()){
                            line = scan.nextLine();
                            String[] datasplit = line.split(" , ");
                            if(username.equals(datasplit[0]) && password.equals(datasplit[1])){
                                loginFrame.dispose();
                                JOptionPane.showMessageDialog(null, "Login Successful");
                                new MainPage();
        
                            }
                        }
                    }catch (FileNotFoundException e){ e.printStackTrace();}
                    
                    fldName.setText("");
                    fldPass.setText("");
            }
        });
    }
    public static void main(String[]args){
        new LoginPage();
    }
}