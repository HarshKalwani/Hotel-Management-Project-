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

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    JComboBox bedType;
    JCheckBox available;

    SearchRoom() {

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("Search For Rooms");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400, 30, 200, 30);
        add(text);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50, 100, 100, 20);
        add(lblbed);

        bedType = new JComboBox<>(new String[] { "Single Bed", "Double Bed" });
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        bedType.setForeground(Color.BLACK);
        add(bedType);

        available = new JCheckBox("Only Display Available");
        available.setBounds(650, 100, 150, 25);
        available.setBackground(Color.WHITE);
        available.setForeground(Color.BLACK);
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50, 160, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270, 160, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(450, 160, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(670, 160, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870, 160, 100, 20);
        add(l5);

        table = new JTable();
        table.setBounds(0, 200, 1000, 350);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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
                String query1 = "select * from room where bed_type = ' "+bedType.getSelectedItem()+" ' ";
                String query2 = "select * from room where availability  = 'Available' AND ' +bedType.getSelectedItem()+ ' ";

                Conn conn =  new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }else{
                    rs = conn.s.executeQuery(query1);
                }

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
    }

    public static void main(String[] args) {
        new SearchRoom();

    }
}
