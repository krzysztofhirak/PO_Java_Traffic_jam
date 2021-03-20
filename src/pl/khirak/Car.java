package pl.khirak;

import java.awt.*;

public class Car {

    int x, y;
//    int vx, vy;
//    int ax, ay;
    int px, py;
//    int kolor = 0;
    int size;
    int speed;
    double color_r, color_g, color_b;

    public Car() {

        size = 15;
        speed = (int)((Math.random()*(6-4+1))+4);

        x = (int) (Math.random() * (600-size));
        y = (int) (Math.random() * (565-size));

//        color_r = (int)(Math.random()*255+0);
//        color_g = (int)(Math.random()*255+0);
//        color_b = (int)(Math.random()*255+0);

//        if(Math.random()<.1){
//            kolor = 1;
//        }

//        vx = (int)(Math.random()*(10+1)+-5);
//        vy = (int)(Math.random()*(10+1)+-5);

        if(Math.random()<.25){
            px = -speed;
            py = 0;
        }
        else if(Math.random()<.5){
            px = 0;
            py = speed;
        }
        else if(Math.random()<.75){
            px = speed;
            py = 0;
        }
        else{
            px = 0;
            py = -speed;
        }

        color_r = Math.sqrt(Math.pow(px, 2) + Math.pow(py, 2)) * 255 / 10 * size / 20;
        color_g = 0;
        color_b = (255 - color_r) * size / 20;
    }

    public void paint(Graphics g) {

        g.setColor(new Color((int) color_r, (int) color_g, (int) color_b));

        x = x + px;
        y = y + py;

        if (x < 0 || x >= 600 - size) {
            px = px * (-1);
        }
        if (y < 0 || y >= 565 - size) {
            py = py * (-1);
        }

        g.fillRect(x, y, size, size);

        g.setColor(Color.black);
        g.drawLine(600, 0, 600, 600);
    }
}
