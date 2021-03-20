package pl.khirak;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Light {

    int color = (int)(Math.random()*3);
    int size = 15;
    int x = (int)(Math.random()*(600 - size));
    int y = (int)(Math.random()*(565 - size));

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


        g.fillOval(x, y, size, size);
//        g.setColor(Color.black);
    }
}
