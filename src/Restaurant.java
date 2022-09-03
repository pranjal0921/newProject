import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Restaurant extends WindowAdapter{
    private JFrame f;
    private JTextArea t;
    private JButton showMenu, takeOrder, orderManage, manageMenu, manageEmp, logout;

    public Restaurant(){
        f=new JFrame();
        t=new JTextArea();
        showMenu=new JButton("SHOW MENU");
        showMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new ShowMenu();
            }
        });
        takeOrder=new JButton("TAKE ORDER");
        takeOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                TakeOrder obj = new TakeOrder();
            }
        });
        orderManage=new JButton("ORDER MANAGEMENT");
        orderManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                OrderManage o=new OrderManage();
            }
        });

        manageMenu=new JButton("MANAGE MENU");
        manageMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                ManageMenu m=new ManageMenu();
            }
        });

        manageEmp=new JButton("MANAGE EMPLOYEE");
        manageEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                ManageEmployee m=new ManageEmployee();
            }
        });
        logout=new JButton("LOG OUT");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Welcome w=new Welcome();
            }
        });

        t.setBounds(230, 60, 600, 500);
        showMenu.setBounds(1, 60, 230, 100);
        takeOrder.setBounds(1, 160, 230, 100);
        orderManage.setBounds(1, 260, 230, 100);
        manageMenu.setBounds(1, 360, 230, 100);
        manageEmp.setBounds(1, 460, 230, 100);
        logout.setBounds(380, 570, 90, 30);

        f.add(t);
        f.add(showMenu);
        f.add(takeOrder);
        f.add(orderManage);
        f.add(manageMenu);
        f.add(manageEmp);
        f.add(logout);

        f.addWindowListener (this);

        f.setSize(900,650);
        f.setTitle("RESTAURANT");
        f.setLayout(null);
        f.setVisible(true);

        JPanel p=new JPanel();
        p.add(new JLabel(""+ "RESTAURANT MANAGEMENT SYSTEM" + ""));
        p.setBounds(1, 20, 830, 40);
        f.add(p);
        p.setBackground(Color.darkGray);

    }
    public void windowClosing (WindowEvent e) {
        f.dispose(); }

    public static void main(String[] args)
    {
        Restaurant r=new Restaurant();
    }


}
