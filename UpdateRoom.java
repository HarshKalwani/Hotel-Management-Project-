import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener{

    Choice ccustomer;
    JTextField tfroom , tfavailable , tfstatus , tfpaid , tfpending;
    JButton check , update , back ;
    
    UpdateRoom(){

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma" , Font.PLAIN , 25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);



        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,20);
        add(lblid);


        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,120,100,20);
        add(lblroom);


        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);


        JLabel lblname = new JLabel("Availability");
        lblname.setBounds(30,160,100,20);
        add(lblname);


        tfavailable = new JTextField();
        tfavailable.setBounds(200,160,150,25);
        add(tfavailable);



        JLabel lblcheckin = new JLabel("Cleaning Status");
        lblcheckin.setBounds(30,200,100,20);
        add(lblcheckin);


        tfstatus = new JTextField();
        tfstatus.setBounds(200,200,150,25);
        add(tfstatus);




        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);


        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(160,300,100,30);
        update.addActionListener(this);
        add(update);



        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(290,300,100,30);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updateroom.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,500,300);
        add(image);



        setBounds(300,200,1100,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = ' "+id+" '";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = ' "+tfroom.getText()+" '");
                while (rs2.next()){
                    tfavailable.setText(rs.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(ae.getSource()==update){
            String number =  ccustomer.getSelectedItem();
            String room =  tfroom.getText();
            String available =  tfavailable.getText();
            String status = tfstatus.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = ' "+available+"' , cleaning_status=' "+status+" 'where roomnumber= '"+room+"' ");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");


            } catch (Exception e) {
                e.printStackTrace();
            }


        }else if (ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
