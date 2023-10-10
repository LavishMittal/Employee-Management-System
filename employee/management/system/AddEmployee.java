package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    Random ran =new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname, salaryname, address, phone, email, designation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel EmpId;
    JButton add, back;
            
    AddEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont((new Font("San_SERIF", Font.BOLD,25)));
        add(heading);
        
        JLabel Labelname = new JLabel("Name");
        Labelname.setBounds(50,150,150,30);
        Labelname.setFont(new Font("serif", Font.PLAIN,20));
        add(Labelname);
        
        tfname = new JTextField();
        tfname.setBounds(150,150,150,30);
        add(tfname);
        
        JLabel Labelfname = new JLabel("Father's Name");
        Labelfname.setBounds(400,150,150,30);
        Labelfname.setFont(new Font("serif", Font.PLAIN,20));
        add(Labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob = new JLabel("DOB");
        labeldob.setBounds(50,250,150,30);
        labeldob.setFont(new Font("serif", Font.PLAIN,20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(150, 250, 150, 30);
        add(dcdob);
       
        JLabel Labelsalary = new JLabel("Salary");
        Labelsalary.setBounds(400,250,150,30);
        Labelsalary.setFont(new Font("serif", Font.PLAIN,20));
        add(Labelsalary);
        
        salaryname = new JTextField();
        salaryname.setBounds(600,250,150,30);
        add(salaryname);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,350,150,30);
        labeladdress.setFont(new Font("serif", Font.PLAIN,20));
        add(labeladdress);
        
        address = new JTextField();
        address.setBounds(150,350,150,30);
        add(address);
        
        JLabel Labelphone = new JLabel("Phone");
        Labelphone.setBounds(400,350,150,30);
        Labelphone.setFont(new Font("serif", Font.PLAIN,20));
        add(Labelphone);
        
        phone = new JTextField();
        phone.setBounds(600,350,150,30);
        add(phone);
        
        JLabel Labelemail = new JLabel("Email");
        Labelemail.setBounds(50,450,150,30);
        Labelemail.setFont(new Font("serif", Font.PLAIN,20));
        add(Labelemail);
        
        email = new JTextField();
        email.setBounds(150,450,150,30);
        add(email);
        
        JLabel Labeleducation = new JLabel("Highest Education");
        Labeleducation.setBounds(400,450,150,30);
        Labeleducation.setFont(new Font("serif", Font.PLAIN,20));
        add(Labeleducation);
        
        String courses[] = { "--Choose Your Field--", "BTech", "BCA", "MTech", "BBA", "BA", "MBA"}; 
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,450,150,30);
        add(cbeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,550,150,30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN,20));
        add(labeldesignation);
        
        designation = new JTextField();
        designation.setBounds(150,550,150,30);
        add(designation);
        
        JLabel LabelempId = new JLabel("Employee Id");
        LabelempId.setBounds(400,550,150,30);
        LabelempId.setFont(new Font("serif", Font.PLAIN,20));
        add(LabelempId);
        
        EmpId = new JLabel("" + number);
        EmpId.setBounds(600,550,150,30);
        EmpId.setFont(new Font("serif", Font.PLAIN, 20));
        add(EmpId);
        
        add = new JButton("Add Details");
        add.setBounds(250, 650, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 650, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 800);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = dcdob.getDateEditor().getUiComponent().getToolTipText();
            String salary = salaryname.getText();
            String Address = address.getText();
            String Phone = phone.getText();
            String Email = email.getText();
            String education = (String) cbeducation.getSelectedItem();
            String Designation = designation.getText();
            String empId = EmpId.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+Address+"', '"+Phone+"', '"+Email+"', '"+education+"', '"+Designation+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added Successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();

    }
}

