import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;

public class RegisterPage extends JFrame{
    public RegisterPage(){
        JFrame registerFrame = new JFrame();

        JLabel reg = new JLabel("Register");
        reg.setFont(new Font("Calibri", Font.BOLD, 30));
        reg.setBounds(130, 20, 200, 100);
        registerFrame.add(reg);

        ImageIcon icon = new ImageIcon("C:/Users/pc/Desktop/OOP Finals Files/Logo.png");
        registerFrame.setIconImage(icon.getImage());

        JLabel lblName = new JLabel("Username");
        lblName.setBounds(40, 100, 100, 30);
        registerFrame.add(lblName);

        JTextField fldName = new JTextField(15);
        fldName.setBounds(120, 100, 200, 30);
        registerFrame.add(fldName);

        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(40, 150, 100, 30);
        registerFrame.add(lblPass);

        JTextField fldPass = new JTextField(15);
        fldPass.setBounds(120, 150, 200, 30);
        registerFrame.add(fldPass);

        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(40, 200, 100, 30);
        registerFrame.add(lblEmail);

        JTextField fldEmail = new JTextField(15);
        fldEmail.setBounds(120, 200, 200, 30);
        registerFrame.add(fldEmail);

        JButton btnBack = new JButton("Go back");
        btnBack.setBounds(75, 275 , 100, 40);
        registerFrame.add(btnBack);

        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(200, 275 , 100, 40);
        registerFrame.add(btnRegister);

        registerFrame.setLayout(null);
        registerFrame.setSize(375,400);
        registerFrame.setTitle("National Bureau of Investigation");
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setVisible(true);
        registerFrame.setResizable(false);

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username = fldName.getText();
                String password = fldPass.getText();
                String email = fldEmail.getText();
                
            if(!username.isEmpty() && !password.isEmpty() && !email.isEmpty()){
                try{
                    File file = new File("C:/Users/pc/Desktop/OOP Finals Files/account.txt");
                    FileWriter fileWriter = new FileWriter(file,true);
                    fileWriter.write(username + " , " + password + " , " + email+ "\n");
                    JOptionPane.showMessageDialog(null, "Registration Successful");
                    fileWriter.close();
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                        fldName.setText("");
                        fldPass.setText("");
                        fldEmail.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Please fill in all the fields");
            }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
                registerFrame.dispose();
                new LoginPage();
            }
        });
    }
    public static main(String [] args){
        new RegisterPage();
    }
}
