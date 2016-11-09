import java.awt.*;

/**
 * Created by Radosław Naruszewicz on 2016-11-09.
 */
public abstract class AbstractStrategia  implements IStrategia{
    Color color;

    @Override
     public abstract void move(Mucha mucha);

    @Override
    public Color getColor() {
        return this.color;
    }
}
