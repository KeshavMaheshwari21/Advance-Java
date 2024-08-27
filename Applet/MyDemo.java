import java.applet.Applet;
import java.awt.*;

/*
<applet code="MyDemo" width=300 height=300>
</applet>
*/

public class MyDemo extends Applet
{
    public void paint(Graphics g)
    {
        g.drawString("Hello",20,20);
    }
}
