import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener{

    JButton newcustomer , rooms , department , allemployee , manager , customerinfo , searchrooms , updatestatus , roomstatus , pickup , checkout , logout;

    Reception(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newcustomer = new JButton("New Customer From");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.setFocusable(false);
        newcustomer.addActionListener(this);
        add(newcustomer);


        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.setFocusable(false);
        rooms.addActionListener(this);
        add(rooms);


        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.setFocusable(false);
        department.addActionListener(this);
        add(department);


        allemployee = new JButton("All Employee");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee.setForeground(Color.WHITE);
        allemployee.setFocusable(false);
        allemployee.addActionListener(this);
        add(allemployee);


        customerinfo = new JButton("Customer Info");
        customerinfo.setBounds(10,190,200,30);
        customerinfo.setBackground(Color.BLACK);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.setFocusable(false);
        customerinfo.addActionListener(this);
        add(customerinfo);


        manager = new JButton("Manager");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        manager.addActionListener(this);
        manager.setFocusable(false);
        add(manager);


        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFocusable(false);
        checkout.addActionListener(this);
        add(checkout);


        updatestatus = new JButton("Update Status");
        updatestatus.setBounds(10,310,200,30);
        updatestatus.setBackground(Color.BLACK);
        updatestatus.setForeground(Color.WHITE);
        updatestatus.setFocusable(false);
        updatestatus.addActionListener(this);
        add(updatestatus);


        roomstatus = new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.BLACK);
        roomstatus.setForeground(Color.WHITE);
        roomstatus.setFocusable(false);
        roomstatus.addActionListener(this);
        add(roomstatus);


        pickup = new JButton("PickUp Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.setFocusable(false);
        pickup.addActionListener(this);
        add(pickup);


        searchrooms = new JButton("Search Rooms");
        searchrooms.setBounds(10,430,200,30);
        searchrooms.setBackground(Color.BLACK);
        searchrooms.setForeground(Color.WHITE);
        searchrooms.addActionListener(this);
        searchrooms.setFocusable(false);
        add(searchrooms);


        logout = new JButton("Log Out");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFocusable(false);
        logout.addActionListener(this);
        add(logout);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        // Image i2 = i1.getImage().getScaledInstance(1200,675,Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);


        setBounds(450,200,900,750);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newcustomer){
            new AddCustomer();
            setVisible(false);
        }else if(ae.getSource() == rooms){
            new Room();
            setVisible(false);
        }else if(ae.getSource()==department){
            new Department();
            setVisible(false);
        }else if (ae.getSource()==allemployee){
            setVisible(false);
            new EmployeeInfo();
        }else if(ae.getSource()==manager){
            setVisible(false);
            new ManagerInfo();
        }else if (ae.getSource()==customerinfo){
            new CustomerInfo();
            setVisible(false);
        }else if (ae.getSource()==searchrooms){
            new SearchRoom();
            setVisible(false);
        }else if (ae.getSource()==updatestatus){
            new UpdateCheck();
            setVisible(false);
        }else if (ae.getSource()==roomstatus){
            new UpdateRoom();
            setVisible(false);
        }else if (ae.getSource()==pickup){
            new PickUp();
            setVisible(false);
        }else if (ae.getSource()==checkout) {
            setVisible(false);
            new CheckOut();
        }else if (ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }

        
    }

    public static void main(String[] args) {
        new Reception();
    }
}
