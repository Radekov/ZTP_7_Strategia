import java.awt.*;

/**
 * Created by Radosław Naruszewicz on 2016-11-09.
 */
class Mucha {
    private final double k = 0.01;
    double x, y; // pozycja muchy
    double vx, vy; // predkosc muchy

    private IStrategia strategia;

    public Mucha() {
        x = Math.random();
        y = Math.random();
        vx = k * (Math.random() - Math.random());
        vy = k * (Math.random() - Math.random());
    }

    public Mucha(IStrategia strategia) {
        this.strategia = strategia;
        x = Math.random();
        y = Math.random();
        vx = k * (Math.random() - Math.random());
        vy = k * (Math.random() - Math.random());

    }

    public void draw(Graphics g) {
        g.setColor(strategia.getColor());
        Rectangle rc = g.getClipBounds();
        int a = (int) (x * rc.getWidth()),
                b = (int) (y * rc.getHeight());
        g.fillOval(a, b, 5, 5);
    }

    public void move() {
        strategia.move(this);
//        x += vx;
//        y += vy;
//        if(x<0) { x = -x; vx = -vx; }
//        if(x>1) { x = 2-x;vx = -vx; }
//        if(y<0) { y = -y; vy = -vy; }
//        if(y>1) { y = 2-y;vy = -vy; }
    }
}