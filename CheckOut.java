import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class CheckOut extends JFrame implements ActionListener{

    Choice ccustomerId;
    JLabel lblroomnumber , lblcheckintime , lblcheckouttime;
    JButton checkout , back;

    CheckOut(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel text = new JLabel("CheckOut");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma" , Font.PLAIN , 20));
        add(text);


        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);


        ccustomerId = new Choice();
        ccustomerId.setBounds(150,80,150,25);
        add(ccustomerId);

        


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);


        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);


        JLabel checkintime = new JLabel("Check In Time ");
        checkintime.setBounds(30,180,100,30);
        add(checkintime);


        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,180,100,30);
        add(lblcheckintime);


        JLabel checkouttime = new JLabel("Check Out Time ");
        checkouttime.setBounds(30,230,100,30);
        add(checkouttime);


        Date date = new Date();
        lblcheckouttime = new JLabel("" + date);
        lblcheckouttime.setBounds(150,230,150,30);
        add(lblcheckouttime);


        checkout = new JButton("CheckOut");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomerId.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkin"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(350,50,400,250);
        add(image);


        setBounds(300,200,800,400);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){

            String query1 = "delete from customer where number = ' "+ccustomerId.getSelectedItem()+" ' ";
            String query2 = "update room set availability = 'Available' where roomnumber = ' "+lblroomnumber.getText()+" '";

            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);


                JOptionPane.showMessageDialog(null , "Checkout Done Successfully");
                setVisible(false);
                new Reception();
            }catch (Exception e){

            }

        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new CheckOut();
    }
}
