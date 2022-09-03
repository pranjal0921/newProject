import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;

public class EditMenu extends WindowAdapter{
    JFrame f=new JFrame();
    EditMenu() {

        f = new JFrame();

        JLabel l1 = new JLabel("MENU ID:");
        JLabel l2 = new JLabel("ITEM NAME:");
        JLabel l3 = new JLabel("PRICE:");
        JLabel l4 = new JLabel("TYPE:");
        JTextField t=new JTextField();
        JTextField t1=new JTextField();
        JTextField t2=new JTextField();
        Choice c=new Choice();
        JButton b = new JButton("EDIT");
        JButton b1=new JButton("BACK");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                ManageMenu m=new ManageMenu();
            }
        });

        l1.setBounds(100, 100, 50, 30);
        l2.setBounds(100, 150, 80, 30);
        l3.setBounds(100, 200, 80, 30);
        l4.setBounds(100, 250, 50, 30);
        t.setBounds(200, 100, 150, 30);
        t1.setBounds(200, 150, 150, 30);
        t2.setBounds(200, 200, 150, 30);
        c.setBounds(200, 250, 150, 30);
        b.setBounds(150, 300, 80, 30);
        b1.setBounds(250, 300, 80, 30);

        c.add("MAIN");
        c.add("APPETIZERS");
        c.add("DRINKS");
        c.add("DESSERT");


        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(t);
        f.add(t1);
        f.add(t2);
        f.add(b);
        f.add(b1);
        f.add(c);

        f.addWindowListener(this);
        f.setSize(600,500);
        f.setTitle("UPDATE ITEM IN MENU");
        f.setLayout(null);
        f.setVisible(true);
    }
    public void windowClosing (WindowEvent e) {
        f.dispose(); }

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
        EditMenu em=new EditMenu();
    }
}

