package pl.khirak;

import java.awt.*;
import java.util.ArrayList;

public class Car_Fov {

    Car car = new Car();
    ArrayList<Car> cars = new ArrayList<>();

    double x, y;
//    double vx, vy;
    int size;
    int vision = 30;

    public Car_Fov(){

        x = car.x - vision + Math.random()-1;
        y = car.y - vision;
        size = 2*vision + car.size;
//        vx = car.vx;
//        vy = car.vy;

    }

    public void paint(Graphics g) {

        g.setColor(new Color(160,160,160));
        g.drawRect((int)x, (int)y, size, size);
    }
}
