import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{

    JTextField username , password;
    JButton login , cancel;
    Login(){

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        //label in login page Username
        JLabel user =  new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

        //Text area username
        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);


        //label in login page PAssword
        JLabel pass =  new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        //textarea password
        password = new JTextField();
        password.setBounds(150,70,150,30);
        add(password);



        //Button Login
        login =  new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        //Button Cancel 
        cancel =  new JButton("cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        //Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =  new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);


        


        setBounds(500,200,600,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String user = username.getText();
            String pass =  password.getText();

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '"+user+ "' and password ="+ pass + "";
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new DashBoard();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password" );
                    setVisible(false);
                }
            } 
            
            catch (Exception e) {
                e.printStackTrace();
            }

        }else if(ae.getSource()==cancel){
            setVisible(false);
            new HotelManagementSystem();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
    
}
