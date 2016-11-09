import java.awt.*;

/**
 * Created by Radosław Naruszewicz on 2016-11-09.
 */
public class StrategiaB extends AbstractStrategia {

    Double srodekx, srodeky;
    double r = 0.0001;
    double tmp = 0.0;
    double dir = 0.02;

    public StrategiaB() {
        color = Color.GREEN;
        r = Math.random();
    }

    @Override
    public void move(Mucha mucha) {
        if (srodekx == null) {
            srodekx = new Double(mucha.x);
            srodeky = new Double(mucha.y);
        }
//        Zatem sinus (kąta)=a/c a cosinus(kąta) = b/c. Zatem z ogólnie znanych wzorów możemy wyliczyć:
//
//        x=a=c*sin(kąta)
//
//        y=b=c*cos(kąta)

        mucha.x = srodekx + r * Math.sin(tmp);
        mucha.y = srodeky + r * Math.cos(tmp);

        if(mucha.x<0) {dir-=dir; }
        if(mucha.x>1) { dir-=dir;}
       if(mucha.y<0) { dir-=dir; }
       if(mucha.y>1) { dir-=dir;}

        tmp += 0.02;
        if (tmp >= 360.)
            tmp = 0.0;

    }
}
