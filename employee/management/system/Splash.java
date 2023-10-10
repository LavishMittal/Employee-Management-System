package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener {
     
    Splash(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = il.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050,600);
        add(image);
        
        JButton clickhere = new JButton("Click Here To Continue");
        clickhere.setBounds(400, 500, 300, 70);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        setSize(1170,750);
        setLocation(200, 50);
        setVisible(true);
        
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
        }
        
    }
    
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new LogIn();
        
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}
