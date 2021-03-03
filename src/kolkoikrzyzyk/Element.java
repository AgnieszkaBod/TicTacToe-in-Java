package kolkoikrzyzyk;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;


public class Element extends JButton{

    int stan=0;
    public Element() {
    } //konstruktor

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(stan == 1)
        {
            g.setColor(Color.BLUE);
            g.drawLine(0, 0, 160, 150);//rysowanie krzyżyka
            g.drawLine(130, 0, 0, 120);
        }
        else if(stan==2)
        {
              g.setColor(Color.RED);
              g.drawOval(10, 10, 110, 110); //rysowanie kołka
        }
    }
    
    
}
