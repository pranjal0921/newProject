import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Welcome{

    private JFrame f;
    private JButton b, b2;
    private JLabel l, l2;
    private JTextField t;
    private JPasswordField p;
    protected Welcome() {
        f=new JFrame();
        l=new JLabel("UserID:");
        l2= new JLabel("Password:");

        //LOGIN button
        b=new JButton("LOGIN");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PreparedStatement ps;
                ResultSet rs;
                String userID = t.getText();
                String password = String.valueOf(p.getPassword());
                try {
                    String query = "SELECT * FROM `new_login` WHERE `userID` =? AND `password` =?";
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "12345");
                    ps = con.prepareStatement(query);
                    ps.setString(1, userID);
                    ps.setString(2, password);
                    rs = ps.executeQuery();
                    if(rs.next())
                    {
                        f.setVisible(true);
                        f.pack();
                        f.setLocationRelativeTo(null);
                        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        this.dispose();
                        f.dispose();
                        new Restaurant();
                    } else{
                        JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            private void dispose() {}
        });
        //signup
        b2=new JButton("SIGN UP");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new NewLogin();
            }
        });

        t=new JTextField("");
        p=new JPasswordField();
        JCheckBox c=new JCheckBox("Login as Manager");

        //set location and size
        l.setBounds(210, 200, 80, 30);
        l2.setBounds(210, 250, 80, 30);
        t.setBounds(310, 200, 300, 30);
        p.setBounds(310, 250, 300, 30);
        b.setBounds(490, 350, 80, 30);
        b2.setBounds(340, 350, 80, 30);
        c.setBounds(380, 300, 150, 30);

        //add component to container
        f.add(b);
        f.add(b2);
        f.add(l);
        f.add(l2);
        f.add(t);
        f.add(p);
        f.add(c);
        f.getContentPane().add(b2);

        f.setSize(900,650);
        f.setTitle("LOGIN");
        f.setLayout(null);
        f.setVisible(true);

        JPanel p=new JPanel();
        p.setBounds(200, 120, 490, 300);
        f.add(p);
        p.setBackground(Color.lightGray);
    }

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
        Welcome w=new Welcome();
    }
}
