import java.applet.Applet;
import java.awt.*;

/*
<applet code="MyDemo" width=500 height=500>
</applet>
*/

public class Line extends Applet
{
    public void paint(Graphics g)
    {
	      g.drawLine(50,50,150,100);
    }
}
