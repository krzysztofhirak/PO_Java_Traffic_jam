package pl.khirak;

import java.awt.*;

public class Light {

    int color = (int)(Math.random()*3);
    int x = (int)(Math.random()*(600+1)+0);
    int y = (int)(Math.random()*(600+1)+0);

    public void paint(Graphics g) {

        switch(color){
            case 0:
                g.setColor(new Color(0,255,0));
                break;
            case 1:
                g.setColor(new Color(255,255,0));
                break;
            case 2:
                g.setColor(new Color(255,0,0));
                break;
        }


        g.fillOval(x, y, 15, 15);
//        g.setColor(Color.black);
    }
}
