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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class AddCustomer extends JFrame implements ActionListener{

    JComboBox comboid;
    JTextField tfnumber , tfname , tfcountry , tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add , back;
    
    AddCustomer(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(text);


        JLabel lblid = new JLabel("Id");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(lblid);

        String options[] = {"Aadhar id" , "Passport" , "Driving Lisence" , "Voter Id Card " , "Ration Card"};
        comboid = new JComboBox<>(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);


        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35,130,100,20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(lblnumber);

        tfnumber =  new JTextField();
        tfnumber.setBounds(200,130,150,25);
        add(tfnumber);


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,180,100,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(lblname);

        tfname =  new JTextField();
        tfname.setBounds(200,180,150,25);
        add(tfname);


        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,230,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(lblgender);


        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,230,60,25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(280,230,100,25);
        add(rfemale);


        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,280,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,280,150,25);
        add(tfcountry);



        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35,330,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(lblroom);


        croom = new Choice();

        try {
            
            Conn conn = new Conn();
            String query = "select * from room where availability = ' Available ' ";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(200,330,150,25);
        add(croom);

        

        JLabel lbltime = new JLabel("Checkin Time");
        lbltime.setBounds(35,380,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(lbltime);


        Date date = new Date();
        checkintime = new JLabel(" " + date);
        checkintime.setBounds(200,380,250,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(checkintime);


        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35,430,100,20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN , 20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,430,150,25);
        add(tfdeposit);


        add = new JButton("ADD");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFocusable(false);
        add.addActionListener(this);
        add.setBounds(35,480,120,30);
        add(add);


        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setBounds(200,480,120,30);
        add(back);   


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,500,500);
        add(image);



        setBounds(350,200,900,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            
            String id =(String)comboid.getSelectedItem(); 
            String number = tfnumber.getText();
            String name =  tfname.getText();
            String gender = null;

            if(rmale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }

            String country  = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();

            try {
                    
                String query = "insert into customer values(' "+id+ "' ,' "+number+ "' , ' "+name+ "' , ' "+gender+ "' ,' "+country+ "' , ' "+room+ "' , ' "+time+ "' , ' "+deposit+ "')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = ' "+room+" '   ";
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);


                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}
