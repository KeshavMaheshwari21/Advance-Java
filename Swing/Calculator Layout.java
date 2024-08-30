import javax.swing.*;
import java.awt.*;// awt -> advance java toolkit
public class CalculatorExample
{
    CalculatorExample()
    {
        JFrame jframe = new JFrame();
        JTextField txt = new JTextField(30);
        txt.setColumns(45);
        JButton bt1 = new JButton("1");
        JButton bt2 = new JButton("2");
        JButton bt3 = new JButton("3");
        JButton bt4 = new JButton("4");
        JButton bt5 = new JButton("5");
        JButton bt6 = new JButton("6");
        JButton bt7 = new JButton("7");
        JButton bt8 = new JButton("8");
        JButton bt9 = new JButton("9");
        JButton bta = new JButton("+");
        JButton bts = new JButton("-");
        JButton btm = new JButton("*");
        JButton btd = new JButton("/");
        JButton bte = new JButton("=");
        JButton btdot = new JButton(".");
        JButton btz = new JButton("0");

        jframe.setLayout(new GridLayout(4,4,10,15));

        jframe.add(txt);
        jframe.add(bt1);
        jframe.add(bt2);
        jframe.add(bt3);
        jframe.add(bta);
        jframe.add(bt4);
        jframe.add(bt5);
        jframe.add(bt6);
        jframe.add(bts);
        jframe.add(bt7);
        jframe.add(bt8);
        jframe.add(bt9);
        jframe.add(btm);
        jframe.add(btdot);
        jframe.add(btz);
        jframe.add(bte);
        jframe.add(btd);


        jframe.setSize(300,300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
    
    public static void main(String args[])
    {
        new CalculatorExample();
    }
}
