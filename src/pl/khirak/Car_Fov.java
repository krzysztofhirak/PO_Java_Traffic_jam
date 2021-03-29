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

    public void collision(Car_Fov car1, Car_Fov car2, Car car3, Car car4) {

        Rectangle c1 = new Rectangle((int)car1.x, (int)car1.y, size, size);
        Rectangle c2 = new Rectangle((int)car2.x, (int)car2.y, size, size);

//        if(car.vx == 0){
//            car1.x -= vision;
//        }
//        if(car.vy == 0){
//            car1.y -= vision;
//        }
        if(c1.intersects(c2)){
//                car3.vx = -car3.vx;
//                car3.vy = -car3.vy;
//                car4.vx = -car4.vx;
//                car4.vy = -car4.vy;
            car3.speed = car3.speed/1.1;
            car4.speed = car4.speed/1.1;

            if(Math.abs(car3.speed) < 0.1){
                car3.speed = 0;
            }
            if(Math.abs(car4.speed) < 0.1){
                car4.speed = 0;
            }
        }
        else{
            if(Math.abs(car3.speed) < car3.speed_cpy){
                car3.speed = car3.speed*1.001;
            }
            if(Math.abs(car4.speed) < car4.speed_cpy){
                car4.speed = car4.speed*1.001;
            }
        }
    }

    public void paint(Graphics g) {

//        x = x - vision + car.vx;
//        y = y - vision + car.vy;

        g.setColor(new Color(160,160,160));
        g.drawRect((int)x-vision, (int)y-vision, size, size);

//        if(car.vy == 0){
//            y = y - vision;
//            g.setColor(new Color(160,160,160));
//            g.drawRect((int)x, (int)y, car.size, size-vision);
//        }
//        if(car.vx == 0){
//            x = x - vision;
//            g.setColor(new Color(160,160,160));
//            g.drawRect((int)x, (int)y, size-vision, car.size);
//        }
    }
}
