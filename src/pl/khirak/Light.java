package pl.khirak;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Light {

    int color = (int)(Math.random()*3);
    int size = 15;
    int x = (int)(Math.random()*(600 - size));
    int y = (int)(Math.random()*(565 - size));

//    public void collision(Car_Fov car_fov, int j) {
//
//        Rectangle c1 = new Rectangle((int)car_fov.x, (int)car_fov.y, size, size);
//        Rectangle c2 = new Rectangle((int)light.x, (int)car2.y, size, size);
//    }

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
        g.setColor(Color.black);
        g.drawArc(x, y, size, size, 0, 360);

//        g.setColor(Color.black);
    }


}
