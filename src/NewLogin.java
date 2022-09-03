import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class NewLogin extends WindowAdapter {
    JFrame f = new JFrame();
    private JTextField t;
    private JPasswordField p1, p2;
    private JButton b, b2;
    private JLabel l, l2, l3, l4;
    private Choice c;
    protected NewLogin(){

        f = new JFrame();
        l = new JLabel("UserID:");
        l2 = new JLabel("Password:");
        l3 = new JLabel("Confirm Password:");
        l4 = new JLabel("Sign Up as:");
        t = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        b = new JButton("SIGNUP");
        //insert through button click
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String userID = String.valueOf(t.getText());
                String pass = String.valueOf(p1.getPassword());
                String confirm_pass = String.valueOf(p2.getPassword());

                if (userID.equals("")) {
                    JOptionPane.showMessageDialog(null, "Add Username");
                } else if (pass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Add Password");
                } else if (!pass.equals(confirm_pass)) {
                    JOptionPane.showMessageDialog(null, "Password doesn't match");
                } else{

                    try {
                    PreparedStatement ps;
                    String query = "INSERT INTO `new_login`(`userID`, `password`, `confirm_pass`, `post`) VALUES (?,?,?,?)";
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "12345");
                    ps = con.prepareStatement(query);
                    ps.setString(1, t.getText());
                    ps.setString(2, p1.getText());
                    ps.setString(3, p2.getText());
                    ps.setString(4, c.getSelectedItem());
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "SUCCESSFULLY SIGNED IN!");
                    f.dispose();
                    new Welcome();
                    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        });

        b2 = new JButton("BACK");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new Welcome();
            }
        });
        c = new Choice();

        l.setBounds(190, 200, 80, 30);
        l2.setBounds(190, 250, 80, 30);
        l3.setBounds(190, 300, 110, 30);
        l4.setBounds(190, 370, 80, 30);
        t.setBounds(310, 200, 300, 30);
        p1.setBounds(310, 250, 300, 30);
        p2.setBounds(310, 300, 300, 30);
        b.setBounds(310, 420, 80, 30);
        b2.setBounds(410, 420, 80, 30);
        c.setBounds(310, 370, 150, 40);

        c.add("Manager");
        c.add("Staff");
        
        f.add(l);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(t);
        f.add(p1);
        f.add(p2);
        f.add(b);
        f.add(b2);
        f.add(c);

        f.addWindowListener(this);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 650);
        f.setLayout(null);
        f.setVisible(true);
        f.setTitle("SIGN UP");
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

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
        NewLogin n = new NewLogin(); //displays form
    }
}