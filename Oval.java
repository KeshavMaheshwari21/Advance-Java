import java.applet.Applet;
import java.awt.*;

/*
<applet code="MyDemo" width=500 height=500>
</applet>
*/

public class Oval extends Applet
{
    public void paint(Graphics g)
    {
	      g.drawOval(50,50,150,100);
    }
}
