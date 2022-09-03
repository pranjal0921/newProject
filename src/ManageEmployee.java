import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;

public class ManageEmployee extends WindowAdapter {

    JFrame f=new JFrame();
    ManageEmployee()
    {
        f=new JFrame();

        JLabel l=new JLabel("EMPLOYEE ID");
        JLabel l2=new JLabel("NAME");
        JLabel l3=new JLabel("SHIFT");
        JButton b=new JButton("EDIT");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                EditStaff es=new EditStaff();
            }
        });
        JButton b2=new JButton("ADD NEW");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                NewEmployee m=new NewEmployee();
            }
        });

        JButton b3=new JButton("BACK");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Restaurant r=new Restaurant();
            }
        });
        TextArea t=new TextArea();

        l.setBounds(100, 100, 100, 30);
        l2.setBounds(300,100,150,30);
        l3.setBounds(600, 100, 100, 30);
        b.setBounds(100, 500, 100, 30);
        b2.setBounds(300, 500, 100, 30);
        b3.setBounds(500, 500, 100, 30);
        t.setBounds(90, 130, 700, 350 );

        f.add(l);
        f.add(l2);
        f.add(l3);
        f.add(b);
        f.add(b2);
        f.add(b3);
        f.add(t);

        f.addWindowListener(this);
        f.setSize(3000,3000);
        f.setTitle("MANAGE EMPLOYEE");
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
            System.out.println("Database Connected successfully");
        } else {
            System.out.println("Database Connection failed");
        }
        ManageEmployee m=new ManageEmployee();
    }
}
