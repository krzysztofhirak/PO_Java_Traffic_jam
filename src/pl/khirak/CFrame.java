package pl.khirak;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
//import java.util.Timer;
//import java.util.TimerTask;

public class CFrame extends JPanel implements ActionListener {

    Car car = new Car();
    ArrayList<Car> cars = new ArrayList<>();

    Light light = new Light();
    ArrayList<Light> lights = new ArrayList<>();

    int amount = 50;

    public static void main(String[] arg){

        CFrame cframe = new CFrame();
        cframe.setBackground(new Color(213, 255, 248));
    }

//    public boolean isClose(){
//
//        return false;
//    }

    public void paint(Graphics g){

        super.paintComponent(g);
        for(Car p: cars){
            p.paint(g);
        }

        for(Light q: lights){
            q.paint(g);
        }

        /*for(int i = 0; i < cars.size()-1; i++){
            for(int j = i+1; i < cars.size(); j++){
                cars.get(i).collision(cars.get(j));
            }
        }*/
        /*for(int i = cars.size()-2; i >= 0; i++){
            for(int j = cars.size()-1; i > 0; j++){
                cars.get(i).collision(cars.get(j));
            }
        }*/

        g.setColor(Color.black);
        g.drawString("Cars: "+ cars.size(), 630, 30);
        g.drawString((((int)car.color_r)+" "+((int)car.color_g)+" "+((int)car.color_b)), 630, 50);
//        g.drawString(String.valueOf((cars.size())), 630, 300);
        for(int i = 0; i < amount; i++){
            g.setColor(Color.black);
            g.drawString(i+".  "+ (int) cars.get(i).x +" "+ (int) cars.get(i).y,630,80+15*i);
        }

    }

    public CFrame(){

        JFrame frame = new JFrame("Symulacja");
        frame.setSize(900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.cyan);
        frame.setResizable(false);
//        frame.setBackground(new Color(178, 255, 255));

        for(int i = 0; i < amount; i++){
            cars.add(new Car());
        }

        for(int i = 0; i < 4; i++){
            lights.add(new Light());
        }

        Timer t = new Timer(17, this);
        t.restart();
//        Timer t = new Timer();
//        t.schedule(new addCar(), 1000);

//        Timer t2 = new Timer(1000, this);
//        cars.add(new Car());
//        t2.restart();

        frame.add(this);
        frame.setVisible(true);
    }

//    class addCar extends TimerTask{
//        public void run(){
//            cars.add(new Car());
//        }
//    }



    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
//        cars.add(new Car());
    }
}
