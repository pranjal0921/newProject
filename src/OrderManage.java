import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OrderManage extends WindowAdapter{
    JFrame f=new JFrame();
    OrderManage(){
        f=new JFrame();
        TextArea t=new TextArea();
        JLabel l=new JLabel("Total Order:");
        JLabel l2=new JLabel("Total Amount:");
        JLabel l3=new JLabel("Cancel Order:");
        JLabel l4=new JLabel("Cancel Amount:");
        JTextField t1=new JTextField();
        JTextField t2=new JTextField();
        JTextField t3=new JTextField();
        JTextField t4=new JTextField();
        JButton b=new JButton("NEW");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                TakeOrder obj = new TakeOrder();
            }
        });
        JButton b2=new JButton("EDIT");
        JButton b3=new JButton("CANCEL");
        JButton b4=new JButton("RECEIPT");
        JButton b5=new JButton("BACK");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Restaurant r=new Restaurant();
            }
        });

        t.setBounds(100, 100, 500, 300);
        l.setBounds(100, 400, 80, 50);
        l2.setBounds(300, 400, 80, 50);
        l3.setBounds(100, 450, 80, 50);
        l4.setBounds(300, 450, 90 ,50);
        t1.setBounds(180, 412, 50, 30);
        t2.setBounds(390, 412, 50, 30);
        t3.setBounds(190, 462, 50, 30);
        t4.setBounds(400, 462, 50, 30);
        b.setBounds(100,500, 80, 30);
        b2.setBounds(200,500, 80, 30);
        b3.setBounds(300,500, 80, 30);
        b4.setBounds(400,500, 90, 30);
        b5.setBounds(510,500, 80, 30);

        f.add(t);
        f.add(l);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(b);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);

        f.addWindowListener(this);
        f.setSize(3000,3000);
        f.setTitle("ORDER");
        f.setLayout(null);
        f.setVisible(true);
    }
    public void windowClosing (WindowEvent e) {
        f.dispose(); }

    public static void main(String[] args){

        OrderManage o=new OrderManage();
    }
}
