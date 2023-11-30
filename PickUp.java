import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    Choice typeofcar;
    JCheckBox available;

    PickUp() {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("PickUp Service ");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Type Of Car");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {
                typeofcar.add(rs.getString("model"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(330, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(460, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Brand");
        l5.setBounds(630, 160, 100, 20);
        add(l5);

        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740, 160, 100, 20);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(890, 160, 100, 20);
        add(l7);

        table = new JTable();
        table.setBounds(0, 200, 1000, 350);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500, 620, 120, 30);
        back.setFocusable(false);
        add(back);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300, 620, 120, 30);
        submit.setFocusable(false);
        add(submit);

        setBounds(300, 200, 1000, 900);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){

            setVisible(false);
            new Reception();

        }else if (ae.getSource() == submit){
            try {
                String query = "select * from driver where brand = ' "+typeofcar.getSelectedItem()+" ' ";

                Conn conn =  new Conn();
                ResultSet rs = conn.s.executeQuery(query);

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
    }

    public static void main(String[] args) {
        new PickUp();

    }
}
