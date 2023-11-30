import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagementSystem extends JFrame implements ActionListener{

    HotelManagementSystem(){

        setSize(1366 , 565);  //width and height
        setLocation(100,100);
        

        //Front Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image =  new JLabel(i1);
        add(image);


        //Caption on Image
        JLabel text = new JLabel("THE DOLI'S HOTEL");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE); //font color
        text.setFont(new Font("serif" , Font.PLAIN , 50));
        image.add(text);


        //button on frontpage
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.white);
        next.setForeground(Color.DARK_GRAY);

        next.addActionListener(this);//for onClick event
        
        next.setFont(new Font("serif" , Font.PLAIN , 25));
        image.add((next));

        setVisible(true); //visibility should be true by (default value is false)

        while (true) {
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //function for onClick routing (inherits ActionLister class)
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }

}