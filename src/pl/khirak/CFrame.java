package pl.khirak;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CFrame extends JPanel implements ActionListener {

    Car car = new Car();
    ArrayList<Car> cars = new ArrayList<>();
    int amount = 2;

    public static void main(String[] arg){

        CFrame c = new CFrame();
    }

    public void paint(Graphics g){

        super.paintComponent(g);
        for(Car p: cars){
            p.paint(g);
        }
        g.drawString((((int)car.color_r)+" "+((int)car.color_g)+" "+((int)car.color_b)), 630, 30);
        for(int i = 0; i < amount; i++){
            g.drawString(i+".  "+String.valueOf(cars.get(i).x)+" "+String.valueOf(cars.get(i).y),630,60+15*i);
        }
    }

    public CFrame(){

        JFrame frame = new JFrame("Symulacja");
        frame.setSize(900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
//        frame.setBackground(new Color(178, 255, 255));

        for(int i = 0; i < amount; i++){
            cars.add(new Car());
        }

        Timer t = new Timer(17, this);

        t.restart();

//        Timer t2 = new Timer(1000, this);
//        cars.add(new Car());
//        t2.restart();

        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
