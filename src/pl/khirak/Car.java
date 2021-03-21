package pl.khirak;

import java.awt.*;

public class Car {

    double x, y;
    double ax, ay;
    double vx, vy;
//    int kolor = 0;
    int size;
    double speed;
    double color_r, color_g, color_b;

//    CFrame cframe = new CFrame();

    public Car() {

        size = 15;

//        ax = vx / cframe.time;
//        ay = vy / cframe.time;
//        ax = vx / 0.017;
//        ay = vy / 0.017;

        double speed_max = 3;
        double speed_min = 1.5;
        speed = ((Math.random()*(speed_max-speed_min))+speed_min);

        x = (int)(Math.random()*(600-size));
        y = (int)(Math.random()*(565-size));

        if(Math.random()<.25){
            vx = -speed;
            vy = 0;
        }
        else if(Math.random()<.5){
            vx = 0;
            vy = speed;
        }
        else if(Math.random()<.75){
            vx = speed;
            vy = 0;
        }
        else{
            vx = 0;
            vy = -speed;
        }

//        color_r = Math.sqrt(Math.pow(px, 2) + Math.pow(py, 2)) * 255 / 10 * size / 20;
//        color_g = 0;
//        color_b = (255 - color_r) * size / 20;
        color_b = (255.0/(speed_max-speed_min))*(speed_max-speed);
        color_g = 0;
        color_r = (255 - (int)color_b);
    }

    public void collision(Car c){
        Rectangle c1 = new Rectangle((int)c.x, (int)c.y, size, size);
        Rectangle c2 = new Rectangle((int)c.x, (int)c.y, size, size);
        if(c1.intersects(c2)){
            c1.x = 0;
            c1.y = 0;
            c2.x = 0;
            c2.y = 0;
        }
    }

    public void paint(Graphics g) {

        g.setColor(new Color((int)color_r,(int)color_g,(int) color_b));

        x = x + vx;
        y = y + vy;

        if (x < 0 || x >= 600 - size - vx) {
            vx = vx * (-1);
        }
        if (y < 0 || y >= 565 - size - vy) {
            vy = vy * (-1);
        }

        g.fillRect((int)x, (int)y, size, size);

        g.setColor(Color.black);
        g.drawLine(600, 0, 600, 600);
    }
}
