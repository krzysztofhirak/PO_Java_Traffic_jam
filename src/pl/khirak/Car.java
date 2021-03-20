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

        int speed_max = 6;
        int speed_min = 4;
        speed = (int)((Math.random()*(speed_max-speed_min+1))+speed_min);

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

//        color_r = Math.sqrt(Math.pow(px, 2) + Math.pow(py, 2)) * 255 / 10 * size / 20;
//        color_g = 0;
//        color_b = (255 - color_r) * size / 20;
        color_b = (255/((double)speed_max-(double)speed_min))*(speed_max-speed);
        color_g = 0;
        color_r = (255 - color_b);
    }

    public void collision(Car c){
        Rectangle c1 = new Rectangle(c.x, c.y, size, size);
        Rectangle c2 = new Rectangle(c.x, c.y, size, size);
        if(c1.intersects(c2)){
            c1.x = 0;
            c1.y = 0;
            c2.x = 0;
            c2.y = 0;
        }
    }

    public void paint(Graphics g) {

        g.setColor(new Color((int) color_r, (int) color_g, (int) color_b));

        x = x + px;
        y = y + py;

        if (x < 0 || x >= 600 - size - px) {
            px = px * (-1);
        }
        if (y < 0 || y >= 565 - size - py) {
            py = py * (-1);
        }

        g.fillRect(x, y, size, size);

        g.setColor(Color.black);
        g.drawLine(600, 0, 600, 600);
    }
}
