package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.Random;

public class Level2 extends GameLevel{
    private static final int NUM_SENZU = 5;
    private static final int NUM_LEVELS = 10;
    private static final int HALF_WIDTH = 30;
    private static final int SEPARATION = 10;
    private static final int MAX_PLATFORMS = 3;
    private Random random;
    private Goku avatar1;
    private Enemy Fr;
    private Background background;
    public void populate(Game game){
        super.populate(game);
        Shape groundShape = new BoxShape(HALF_WIDTH, 0.2f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -8));

        this.random = new Random();


        for (int i = 0; i < NUM_LEVELS; i++) {
            for (int n = 0; n < random.nextInt(MAX_PLATFORMS) + 1; n++) {
                Body platform = new Platforms(this);
                platform.setPosition(new Vec2(random.nextInt( HALF_WIDTH) , i * SEPARATION));
                platform.addCollisionListener(new CollectListener(avatar1));
            }
        }

        // make a character
        avatar1 = new Goku(this);
        avatar1.setPosition(new Vec2(8, -6));

        for (int i=0; i<5; i++){
            Fr = new Enemy(this);
            Fr.setPosition(new Vec2(i*5,50));
            Fr.addCollisionListener(new CollectListener(avatar1));
            SensorBody sb = new SensorBody(this);

            sb.setPosition(new Vec2(i*5,50));
        }
        for (int i = 0; i < 8; i++) {
            Body Senzu = new SenzuBean(this);
            Senzu.setPosition(new Vec2(i*5-i, 50));
            Senzu.addCollisionListener(new CollectListener(avatar1));
        }

    }
    public Enemy Fr(){
        return Fr;
    }

    public Goku getPlayer() {
        return avatar1;
    }

    public Vec2 startPosition(){
        return new Vec2(2, -10);

    }
    public Vec2 doorPosition(){
        return new Vec2(-10.4f, -9.6f);

    }
    public boolean isCompleted() {
        return getPlayer().getBeanCount() == NUM_SENZU;
    }
}
