package game;

import java.awt.Graphics2D;
import city.cs.engine.*;

public class PointDisplay extends UserView{

    private Game game;

    public PointDisplay(World world, Game game, int width, int height) {
        super(world, width, height);
        this.game = game;
    }

    @Override
    protected void paintForeground(Graphics2D g) {

        g.drawString("W,A,D to move ", 10, 20);
        g.drawString("Score : " + game.getBeanCount(), 20,40);

    }
}