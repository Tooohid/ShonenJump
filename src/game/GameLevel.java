package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public abstract class GameLevel extends World {
    Goku player1;

    public Goku getPlayer() {
        return player1;
    }

    public void populate(Game game) {
        this.player1 = new Goku(this);
        this.player1.setPosition(new Vec2(8, -6));
    }

    public abstract Vec2 startPosition();
    public abstract Vec2 doorPosition();
    public abstract boolean isCompleted();

}

