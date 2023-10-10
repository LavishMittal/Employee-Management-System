package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfeducation, tffname, salary, address, phone, email, designation;
    JLabel EmpId;
    JButton add, back;
    String empId;

    UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont((new Font("San_SERIF", Font.BOLD, 25)));
        add(heading);

        JLabel Labelname = new JLabel("Name");
        Labelname.setBounds(50, 150, 150, 30);
        Labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(Labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(150, 150, 150, 30);
        add(lblname);

        JLabel Labelfname = new JLabel("Father's Name");
        Labelfname.setBounds(400, 150, 150, 30);
        Labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(Labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel labeldob = new JLabel("DOB");
        labeldob.setBounds(50, 250, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(150, 250, 150, 30);
        add(lbldob);

        JLabel Labelsalary = new JLabel("Salary");
        Labelsalary.setBounds(400, 250, 150, 30);
        Labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(Labelsalary);

        salary = new JTextField();
        salary.setBounds(600, 250, 150, 30);
        add(salary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 350, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        address = new JTextField();
        address.setBounds(150, 350, 150, 30);
        add(address);

        JLabel Labelphone = new JLabel("Phone");
        Labelphone.setBounds(400, 350, 150, 30);
        Labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(Labelphone);

        phone = new JTextField();
        phone.setBounds(600, 350, 150, 30);
        add(phone);

        JLabel Labelemail = new JLabel("Email");
        Labelemail.setBounds(50, 450, 150, 30);
        Labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(Labelemail);

        email = new JTextField();
        email.setBounds(150, 450, 150, 30);
        add(email);

        JLabel Labeleducation = new JLabel("Highest Education");
        Labeleducation.setBounds(400, 450, 150, 30);
        Labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(Labeleducation);

        tfeducation = new JTextField();
//        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600, 450, 150, 30);
        add(tfeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 550, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        designation = new JTextField();
        designation.setBounds(150, 550, 150, 30);
        add(designation);

        JLabel LabelempId = new JLabel("Employee Id");
        LabelempId.setBounds(400, 550, 150, 30);
        LabelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(LabelempId);

        EmpId = new JLabel();
        EmpId.setBounds(600, 550, 150, 30);
        EmpId.setFont(new Font("serif", Font.PLAIN, 20));
        add(EmpId);

        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                salary.setText(rs.getString("Salary"));
                address.setText(rs.getString("Address"));
                phone.setText(rs.getString("Phone"));
                email.setText(rs.getString("Email"));
                tfeducation.setText(rs.getString("education"));
                designation.setText(rs.getString("Designation"));
                EmpId.setText(rs.getString("empId"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update Details");
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
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            
            String fname = tffname.getText();
            String Salary = salary.getText();
            String Address = address.getText();
            String Phone = phone.getText();
            String Email = email.getText();
            String education = tfeducation.getText();
            String Designation = designation.getText();

            try {
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+Salary+"',Address = '"+Address+"', Phone = '"+Phone+"', Email = '"+Email+"', education = '"+education+"', Designation = '"+Designation+"' where empId = '"+EmpId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");

    }
}
