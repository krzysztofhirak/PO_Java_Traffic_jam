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
    boolean pause = false;
    double carx = 50, cary = 70;

    public Car_Fov(){

//        x = x - vision;
//        y = y - vision;
//        size = 2*vision + car.size;
//        vx = car.vx;
//        vy = car.vy;
    }

    public void paint(Graphics g) {

        x = x - vision;
        y = y - vision;
        size = 2 * vision + car.size;

        g.setColor(new Color(160,160,160));
        g.drawRect((int)x, (int)y, size, size);
    }
}
