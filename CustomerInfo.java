import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class CustomerInfo extends JFrame implements ActionListener{

    JTable table;
    JButton back;
    
    CustomerInfo(){

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);


        JLabel l2 = new JLabel("Number");
        l2.setBounds(160,10,100,20);
        add(l2);


        JLabel l3 = new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);



        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410,10,100,20);
        add(l4);



        JLabel l5 = new JLabel("Country");
        l5.setBounds(540,10,100,20);
        add(l5);


        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(660,10,100,20);
        add(l6);


        JLabel l7 = new JLabel("CheckIn Time ");
        l7.setBounds(800,10,100,20);
        add(l7);


        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(970,10,100,20);
        add(l8);




        table = new JTable();
        table.setBounds(0,40,1070,400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }


        back = new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,120,30);
        back.setFocusable(false);
        add(back);




        setBounds(350,250,1070,600);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
