import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TakeOrder extends WindowAdapter {
    JFrame f = new JFrame();

    TakeOrder() {
        f = new JFrame();

        TextArea t = new TextArea();
        TextArea t1=new TextArea();
        JButton b = new JButton("ADD");
        JButton b1 = new JButton("DELETE");
        JButton b2 = new JButton("RESET");
        JButton b3 = new JButton("CONFIRM");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                OrderManage o=new OrderManage();
            }
        });
        JButton b4 = new JButton("BACK");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Restaurant r=new Restaurant();
            }
        });
        JLabel l = new JLabel("Item:");
        JLabel l1 = new JLabel("Quantity:");
        JLabel l2 = new JLabel("Price:");
        JLabel l3 = new JLabel("Total:");
        JLabel l4 = new JLabel("Staff Name:");
        JLabel l5 = new JLabel("Type:");
        JLabel l6 = new JLabel("MENU");
        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        Choice c=new Choice();

        l.setBounds(100, 100, 80, 30);
        l1.setBounds(300, 100, 80, 30);
        l2.setBounds(400, 100, 80, 30);
        l3.setBounds(400, 400, 80, 30);
        l4.setBounds(100, 450, 80, 30);
        l5.setBounds(500, 100, 80, 30);
        l6.setBounds(650, 100, 80, 30);
        t.setBounds(90, 150, 550, 300);
        t1.setBounds(650, 150, 480, 300);
        tf1.setBounds(470, 400, 140, 30);
        tf2.setBounds(200, 450, 150, 30);
        b.setBounds(400, 450, 80, 30);
        b1.setBounds(500, 450, 80, 30);
        b2.setBounds(100, 500, 120, 30);
        b3.setBounds(300, 500, 120, 30);
        b4.setBounds(500, 500, 120, 30);
        c.setBounds(650, 470, 150, 40);

        c.add("APPETIZERS");
        c.add("DRINKS");
        c.add("MAIN");
        c.add("DESSERT");

        f.add(l);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.add(tf1);
        f.add(tf2);
        f.add(t);
        f.add(t1);
        f.add(b);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(c);

        f.addWindowListener(this);
        f.setSize(3000, 3000);
        f.setTitle("ORDER");
        f.setLayout(null);
        f.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public static void main(String[] args) {

        TakeOrder obj = new TakeOrder();
    }
}
