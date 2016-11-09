import java.awt.*;
import java.util.Random;

/**
 * Created by Radosław Naruszewicz on 2016-11-09.
 */
public class StrategiaA extends AbstractStrategia {

   Double dlugosc;
Random rand;
    StrategiaA(){

        color = Color.RED;
rand = new Random();
    }

    @Override
    public void move(Mucha mucha) {
        if(dlugosc == null)
            dlugosc = Math.sqrt(mucha.vx*mucha.vx+mucha.vy*mucha.vy);

        if(dlugosc != Math.sqrt(mucha.vx*mucha.vx+mucha.vy*mucha.vy))
            System.out.println(dlugosc + "!=" + Math.sqrt(mucha.vx*mucha.vx+mucha.vy*mucha.vy));


        if(mucha.x<0) { mucha.x = -mucha.x; mucha.vx = -mucha.vx; }
        if(mucha.x>1) { mucha.x = 2-mucha.x;mucha.vx = -mucha.vx; }
        if(mucha.y<0) { mucha.y = -mucha.y; mucha.vy = -mucha.vy; }
        if(mucha.y>1) { mucha.y = 2-mucha.y;mucha.vy = -mucha.vy; }

        mucha.x += mucha.vx * Math.cos(Math.PI*Math.random()) * (rand.nextDouble() > 0.25 ? 1 : -1);
        mucha.y += mucha.vy * Math.sin(Math.PI*Math.random()) * (rand.nextDouble() > 0.25 ? 1 : -1);
    }
}
