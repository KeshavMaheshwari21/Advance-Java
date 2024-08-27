import java.applet.Applet;
import java.awt.*;

/*
<applet code="MyDemo" width=500 height=500>
</applet>
*/

public class MyDemo extends Applet
{
    public void paint(Graphics g)
    {
	g.drawLine(50,50,0,120);
	g.setColor(Color.yellow);
	g.fillRect(50,50,50,70);
	g.setColor(Color.black);
	g.drawLine(100,50,150,120);
	g.setColor(Color.blue);
	g.fillRect(0,120,160,50);
	g.setColor(Color.black);
	g.fillOval(10,165,40,40);
	g.fillOval(110,165,40,40);
    }
}
