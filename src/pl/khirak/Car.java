package pl.khirak;

import java.awt.*;

public class Car {

    double x, y;
//    double ax, ay;
    double vx, vy;
//    int kolor = 0;
    int size;
    double speed;
    double speed_cpy;
    double color_r, color_g, color_b;
    int collisions;
    double rand_v;

    double speed_max = 3;
    double speed_min = 1.5;

    public Car() {

        size = 15; // 15 is best

//        ax = vx / cframe.time;
//        ay = vy / cframe.time;
//        ax = vx / 0.017;
//        ay = vy / 0.017;

        speed = ((Math.random()*(speed_max-speed_min))+speed_min);
        speed_cpy = speed;

        color_b = (255.0/(speed_max-speed_min))*(speed_max-speed);
        color_g = 0;
        color_r = (255 - (int)color_b);

        x = (int)(Math.random()*(600-size));
        y = (int)(Math.random()*(565-size));

        rand_v = Math.random();

        //tu było wyznaczanie prędkości, teraz jest w paint

//        color_r = Math.sqrt(Math.pow(px, 2) + Math.pow(py, 2)) * 255 / 10 * size / 20;
//        color_g = 0;
//        color_b = (255 - color_r) * size / 20;

        //tu były kolory, teraz są w paint
    }

    public void collision(Car car1, Car car2){
        Rectangle c1 = new Rectangle((int)car1.x, (int)car1.y, size, size);
//        Rectangle c2 = new Rectangle((int)this.x, (int)this.y, size, size);
        Rectangle c2 = new Rectangle((int)car2.x, (int)car2.y, size, size);
        if(c1.intersects(c2)){
            car1.color_r = 0;
            car1.color_g = 0;
            car1.color_b = 0;
            car2.color_r = 0;
            car2.color_g = 0;
            car2.color_b = 0;
            car1.speed = 0;
//            car1.vy = 0;
            car2.speed = 0;
//            car2.vy = 0;
            collisions++;
        }
    }

    public void paint(Graphics g) {

        g.setColor(new Color((int)color_r,(int)color_g,(int) color_b));
//        color_b = (255.0/(speed_max-speed_min))*(speed_max-Math.abs(speed));
//        color_b = ((-255/(speed_min-speed_max))*(Math.abs(speed)) + (0-(-255/(speed_min-speed_max))*speed_min));
        if(Math.abs(speed) > speed_max){
            color_r = ((-255/(0-speed_max))*(speed_max) + (0-(-255/(0-speed_max))*0));
            color_g = 0;
            color_b = (255 - (int)color_r);
        }
        else{
            color_r = ((-255/(0-speed_max))*(Math.abs(speed)) + (0-(-255/(0-speed_max))*0));
            color_g = 0;
            color_b = (255 - (int)color_r);
        }


        if(rand_v<.25){
            vx = -speed;
            vy = 0;
        }
        else if(rand_v<.5){
            vx = 0;
            vy = speed;
        }
        else if(rand_v<.75){
            vx = speed;
            vy = 0;
        }
        else{
            vx = 0;
            vy = -speed;
        }

        x = x + vx;
        y = y + vy;

        if (x < 0 || x >= 600 - size - vx) {
//            vx = vx * (-1);
            speed = speed * (-1);
//            vx *= (-1);
//            vy *= (-1);
        }
        if (y < 0 || y >= 565 - size - vy) {
//            vy = vy * (-1);
            speed = speed * (-1);
//            vx *= (-1);
//            vy *= (-1);
        }

        g.fillRect((int)x, (int)y, size, size);
    }
}
