    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.sql.*;

    public class ShowMenu implements ActionListener {
        JFrame f;
        TextArea t;
        JButton b, b1, b2, b3, b4;
        public ShowMenu(){

            f=new JFrame();

            JLabel l1=new JLabel("CATEGORY:");
            JLabel l2=new JLabel("ITEM ID:");
            JLabel l3=new JLabel("ITEM NAME:");
            JLabel l4=new JLabel("PRICE:");
            t=new TextArea();

            b=new JButton("ALL");
            b.addActionListener(this);

            b1=new JButton("APPETIZERS");
            b1.addActionListener(this);

             b2=new JButton("MAIN");
            b2.addActionListener(this);

             b3=new JButton("DRINKS");
            b3.addActionListener(this);

             b4=new JButton("DESSERT");
            b4.addActionListener(this);

            JButton b5=new JButton("BACK");
            b5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    Restaurant r=new Restaurant();
                }
            });

            l1.setBounds(100, 100, 90, 30);
            l2.setBounds(200, 100, 90, 30);
            l3.setBounds(300, 100, 90, 30);
            l4.setBounds(630, 100, 90, 30);
            t.setBounds(90, 150, 750, 350);
            b.setBounds(100, 500, 100, 30);
            b1.setBounds(210, 500, 120, 30);
            b2.setBounds(340, 500, 100, 30);
            b3.setBounds(450, 500, 110, 30);
            b4.setBounds(570, 500, 100, 30);
            b5.setBounds(680, 500, 80, 30);

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

            f.setSize(3000,3000);
            f.setTitle("MENU");
            f.setLayout(null);
            f.setVisible(true);

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
            ShowMenu m=new ShowMenu();
        }

        public void actionPerformed(ActionEvent e1) {
            if (e1.getSource() == b) {
                t.setText("");
                getOperation();
            }
            else if(e1.getSource() == b1)
            {
                t.setText("");
                getOperation1();
            }
            else if(e1.getSource() == b2)
            {
                t.setText("");
                getOperation2();
            }
            else if(e1.getSource() == b3)
            {
                t.setText("");
                getOperation3();
            }
            else if(e1.getSource() == b4)
            {
                t.setText("");
                getOperation4();
            }
        }
        public void getOperation(){
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "12345");
                String sql = "select * from menu";
                PreparedStatement ps1 = con.prepareStatement(sql);
                ResultSet rs1 = ps1.executeQuery();
                while(rs1.next()){
                    t.append(rs1.getString("type") + "\t"+"\t" + rs1.getString("menuID") + "\t"+"\t"
                            + rs1.getString("item_name") + "\t"+"\t" + rs1.getString("item_price") + "\t"+"\n");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
       public void getOperation1()
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "12345");
                String sql = "select * from menu  where type='APPETIZERS'";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    t.append(rs.getString(1) + "\t"+"\t" + rs.getString(2) + "\t"+"\t" + rs.getString(3) + "\t"+"\t" + rs.getString(4) + "\n");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        public void getOperation2()
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "12345");
                String sql = "select * from menu  where type='MAIN'";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    t.append(rs.getString(1) + "\t"+"\t" + rs.getString(2) + "\t"+"\t" + rs.getString(3) + "\t"+"\t" + rs.getString(4) + "\n");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        public void getOperation3()
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "12345");
                String sql = "select * from menu  where type='DRINKS'";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    t.append(rs.getString(1) + "\t"+"\t" + rs.getString(2) + "\t"+"\t" + rs.getString(3) + "\t"+"\t" + rs.getString(4) + "\n");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        public void getOperation4()
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "12345");
                String sql = "select * from menu  where type='DESSERT'";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    t.append(rs.getString(1) + "\t"+"\t" + rs.getString(2) + "\t"+"\t" + rs.getString(3) + "\t"+"\t" + rs.getString(4) + "\t"+"\n");
                }
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }