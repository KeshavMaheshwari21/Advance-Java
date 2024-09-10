import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class myframe extends JFrame implements ActionListener
{
    static JFrame f;
    static JTextField l;
    public static void main(String args[])
    {
        f = new JFrame("my frame");
        l = new JTextField(16);
        myframe f=new myframe();
        JButton b1,b2;
        b1 = new JButton("1");
        b2 = new JButton("2");
        JPanel p = new JPanel();
        b2.addActionListener(f);
        b1.addActionListener(f);
        p.add(b1);
        p.add(b2);
        p.add(l);
        f.add(p);
        f.setSize(200,220);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.charAt(0)=='1'){
            l.setText("Good Morning");}
        else {
            l.setText("Good Evening");}
    }
}
