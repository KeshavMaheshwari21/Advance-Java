// B

import javax.swing.*;
import java.awt.*;// awt -> advance java toolkit
public class BorderLayoutExample
{
    BorderLayoutExample()
    {
        JFrame jframe = new JFrame();
        JButton btn1 = new JButton("North");
        JButton btn2 = new JButton("South");
        JButton btn3 = new JButton("East");
        JButton btn4 = new JButton("West");
        JButton btn5 = new JButton("Center");

        jframe.setLayout(new BorderLayout(20,15));

        jframe.add(btn1,BorderLayout.NORTH);
        jframe.add(btn2,BorderLayout.SOUTH);
        jframe.add(btn3,BorderLayout.EAST);
        jframe.add(btn4,BorderLayout.WEST);
        jframe.add(btn5,BorderLayout.CENTER);

        jframe.setSize(300,300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
    
    public static void main(String args[])
    {
        new BorderLayoutExample();
    }
}
