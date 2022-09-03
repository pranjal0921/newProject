import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PayReceipt extends WindowAdapter {
    JFrame f=new JFrame();
    PayReceipt(){

        f=new JFrame();
        JLabel l=new JLabel("NAME:");
        JLabel l1=new JLabel("PHONE NO:");
        JLabel l2=new JLabel("ORDER PRICE:");
        JLabel l3=new JLabel("TAX:");
        JLabel l4=new JLabel("DISCOUNT:");
        JLabel l5=new JLabel("TOTAL AMOUNT:");
        JTextField t=new JTextField();
        JTextField t1=new JTextField();
        JTextField t2=new JTextField();
        JTextField t3=new JTextField();
        JTextField t4=new JTextField();
        JTextField t5=new JTextField();
        JButton b =new JButton("BACK");

        l.setBounds(100, 100, 80, 30);
        l1.setBounds(100, 150, 80, 30);
        l2.setBounds(100, 200, 80, 30);
        l3.setBounds(100, 250, 80, 30);
        l4.setBounds(100, 300, 80, 30);
        l5.setBounds(100, 350, 120, 30);
        t.setBounds(300, 100, 150, 30);
        t1.setBounds(300, 150, 150, 30);
        t2.setBounds(300, 200, 150, 30);
        t3.setBounds(300, 250, 150, 30);
        t4.setBounds(300, 300, 150, 30);
        t5.setBounds(300, 350, 150, 30);
        b.setBounds(250, 400, 100, 30);

        f.add(l);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(t);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(b);

        f.addWindowListener (this);

        f.setSize(3000,3000);
        f.setTitle("PAYMENT RECEIPT");
        f.setLayout(null);
        f.setVisible(true);
    }
    public void windowClosing (WindowEvent e) {
        f.dispose(); }

    public static void main(String[] args){
        PayReceipt p=new PayReceipt();
    }
}
