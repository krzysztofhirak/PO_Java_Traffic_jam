package pl.khirak;

import java.awt.*;
import java.util.ArrayList;

public class Car_Fov {

    Car car = new Car();
    ArrayList<Car> cars = new ArrayList<>();

    double x, y;
//    double vx, vy;
    int vision = 20;
    int size = 2 * vision + car.size;

    public Car_Fov(){

    }

    public void collision(Car_Fov car1, Car_Fov car2, Car car3, Car car4, int t) {
        Rectangle c1 = new Rectangle((int)car1.x, (int)car1.y, size, size);
        Rectangle c2 = new Rectangle((int)car2.x, (int)car2.y, size, size);
        if(c1.intersects(c2)){
            if(t <= 2){
//                car3.vx = -car3.vx;
//                car3.vy = -car3.vy;
//                car4.vx = -car4.vx;
//                car4.vy = -car4.vy;
                car3.vx = 0;
                car3.vy = 0;
                car4.vx = 0;
                car4.vy = 0;

//                car3.ax = -3;
//                car3.ay = -3;
//                car4.ax = -3;
//                car4.ay = -3;

//                t = 0;
            }
            else{
//                t++;
            }
        }
    }

    public void paint(Graphics g) {

//        x = x - vision + car.vx;
//        y = y - vision + car.vy;
        x = x - vision;
        y = y - vision;

        g.setColor(new Color(160,160,160));
        g.drawRect((int)x, (int)y, size, size);
    }
}
