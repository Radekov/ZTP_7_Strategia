import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Radosław Naruszewicz on 2016-11-09.
 */
public class Muchy extends JPanel implements Runnable {
    private Mucha[] ar;
    public Muchy()	{
        this.setPreferredSize(new Dimension(640, 480));
        ar = new Mucha[30];

        Random random  = new Random();

        for(int i = 0; i < ar.length; ++i) {
            switch(random.nextInt(3)){
                case 0:
                    ar[i] = new Mucha(new StrategiaA());
                    break;
                case 1:
                    ar[i] = new Mucha(new StrategiaB());
                    break;
                case 2:
                    ar[i] = new Mucha(new StrategiaC());
                    break;
            }
            //ar[i] = new Mucha();
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i = 0; i < ar.length; ++i)
            ar[i].draw(g);
    }

    public void run() {
        while (true) {
            for(int i = 0; i < ar.length; ++i)
                ar[i].move();
            repaint();
            try {
                Thread.currentThread().sleep(20);
            } catch(InterruptedException e){ e.printStackTrace();}
        }
    }

    public static void main(String[] args)	{
        JFrame frame = new JFrame("Muchy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Muchy m = new Muchy();
        frame.getContentPane().add(m);
        frame.pack();
        frame.setVisible(true);
        new Thread(m).start();
    }
}