import javax.swing.*;
class gui
{
    public static void main(String args[])
    {
        JFrame frame = new JFrame("MY First GUI");
        frame.setDefaultCLoseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setsize(300,300);
        JButton button = new JButton("Press");
        frame.add(button);
        frame.setvisible(true);
    }
}
