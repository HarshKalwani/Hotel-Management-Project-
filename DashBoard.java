import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DashBoard extends JFrame implements ActionListener{
    DashBoard(){
        
        //It is Imp to use setLayout(null) coz ye default h and apna diya hua dimentions will not work 
        setLayout(null);


        //Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1920,1080);
        add(image);

        //Label On Screen 
        JLabel text = new JLabel("THE DOLI'S GROUP WELCOMES YOU");
        text.setBounds(600,80,1000,50);
        text.setFont(new Font("Tahoma" , Font.PLAIN , 46));
        text.setForeground(Color.white);
        image.add(text);


        //MenuBar (On top of page)
        JMenuBar mb =  new JMenuBar();
        mb.setBounds(0,0,1920,40);
        image.add(mb);


        //menu 
        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.red);
        mb.add(hotel);

        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.BLUE);
        mb.add(admin);


        //Menu Item (means inside the selected menu)
        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);


        JMenuItem addEmployee = new JMenuItem("Add Employee");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        JMenuItem addRooms = new JMenuItem("Add Rooms");
        addRooms.addActionListener(this);
        admin.add(addRooms);

        JMenuItem addDrivers = new JMenuItem("Add Drivers");
        addDrivers.addActionListener(this);
        admin.add(addDrivers);
        

        //Frame Of Page
        setBounds(0,0,1550,1000);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
        }else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms();
        }else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
    }
    public static void main(String[] args) {
        new DashBoard();
    }
}
