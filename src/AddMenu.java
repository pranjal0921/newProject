import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
public class AddMenu extends WindowAdapter{

    JFrame f=new JFrame();
    AddMenu() {

        f = new JFrame();

        JLabel l1 = new JLabel("MENU ID:");
        JLabel l2 = new JLabel("ITEM NAME:");
        JLabel l3 = new JLabel("PRICE:");
        JLabel l4 = new JLabel("TYPE:");
        JTextField t=new JTextField();
        JTextField t1=new JTextField();
        JTextField t2=new JTextField();
        Choice c=new Choice();
        JButton b = new JButton("ADD");

        //insert items through button click
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String menuID = String.valueOf(t.getText());
                String item_name = String.valueOf(t1.getText());
                String item_price = String.valueOf(t2.getText());

                if (menuID.equals("")) {
                    JOptionPane.showMessageDialog(null, "Add MENU ID");
                } else if (item_name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Add ITEM NAME");
                } else if (item_price.equals("")) {
                    JOptionPane.showMessageDialog(null, "Add ITEM PRICE");
                } else{

                    try {
                        PreparedStatement ps;
                        String query = "INSERT INTO `menu`(`menuID`, `item_name`, `item_price`, `type`) VALUES (?,?,?,?)";
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "12345");
                        ps = con.prepareStatement(query);
                        ps.setString(1, t.getText());
                        ps.setString(2, t1.getText());
                        ps.setString(3, t2.getText());
                        ps.setString(4, c.getSelectedItem());
                        ps.execute();
                        JOptionPane.showMessageDialog(null, "ITEM ADDED SUCCESSFULLY!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        });
        //back to manage menu window
        JButton b1=new JButton("BACK");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                ManageMenu m = new ManageMenu();
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
        f.setTitle("ADD ITEM IN MENU");
        f.setLayout(null);
        f.setVisible(true);
    }
    public void windowClosing (WindowEvent e) {
        f.dispose(); }

    //Connection to database
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
        AddMenu a=new AddMenu();
    }
}
