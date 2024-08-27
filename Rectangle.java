import java.applet.Applet;
import java.awt.*;

/*
<applet code="MyDemo" width=500 height=500>
</applet>
*/

public class Rectangle extends Applet
{
    public void paint(Graphics g)
    {

        g.drawRect(50,50,150,100);
	      g.setColor(Color.red);
	      g.fillRect(50,50,150,100);
    }
}
