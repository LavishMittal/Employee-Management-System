package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;


public class LogIn extends JFrame implements ActionListener {
    
    JTextField tfusername, tfpassword;
    
    LogIn(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50, 70, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 70, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(50, 120, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 120, 150, 30);
        add(tfpassword);
        
        JButton login = new JButton("LogIn");
        login.setBounds(150, 200, 150, 30);
        login.addActionListener(this);
        add(login);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = il.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 50, 200,200);
        add(image);
        
        setSize(600, 380);
        setLocation(450, 200);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
            
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Welcome admin");
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
            }
        }catch(Exception e){
            
        }
    }
    
    public static void main(String[] args) {
        new LogIn();
    }
}
