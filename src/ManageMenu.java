import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ManageMenu {
    JFrame f = new JFrame();

    ManageMenu() {

        f = new JFrame();

        JLabel l1 = new JLabel("MENU ID:");
        JLabel l2 = new JLabel("ITEM NAME:");
        JLabel l3 = new JLabel("PRICE:");
        JLabel l4 = new JLabel("CATEGORY:");
        TextArea t = new TextArea();
        //add items
        JButton b = new JButton("ADD");
        b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                f.dispose();
                AddMenu a=new AddMenu();
                }
        });
        JButton b1 = new JButton("DELETE");
        JButton b2 = new JButton("EDIT");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                EditMenu em =new EditMenu();
            }
        });
        JButton b3 = new JButton("APPETIZERS");
        JButton b4 = new JButton("MAIN");
        JButton b5 = new JButton("DRINKS");
        JButton b6 = new JButton("DESSERT");
        //back to main menu
        JButton b7 = new JButton("BACK");
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Restaurant r=new Restaurant();
            }
        });

        l1.setBounds(100, 100, 90, 30);
        l2.setBounds(300, 100, 90, 30);
        l3.setBounds(580, 100, 90, 30);
        l4.setBounds(700, 100, 90, 30);
        t.setBounds(90, 150, 850, 350);
        b.setBounds(100, 500, 80, 30);
        b1.setBounds(200, 500, 80, 30);
        b2.setBounds(300, 500, 80, 30);
        b3.setBounds(400, 500, 110, 30);
        b4.setBounds(530, 500, 80, 30);
        b5.setBounds(630, 500, 80, 30);
        b6.setBounds(730, 500, 90, 30);
        b7.setBounds(840, 500, 80, 30);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(t);
        f.add(b);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);

        f.setSize(1000, 600);
        f.setTitle("MANAGE MENU");
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/javaproject";
        String username = "root";
        String password = "12345";

        Connection con = DriverManager.getConnection(url, username, password);
        if (con != null) {
            System.out.println("Database successfully connected!");
        } else {
            System.out.println("Connection failed!");
        }
        ManageMenu m = new ManageMenu();
    }
}