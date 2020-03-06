package game;

import city.cs.engine.*;


public class Enemy extends DynamicBody {
    private Goku Avatar1;
    private static final Shape Fr = new PolygonShape(
            0.149f, 0.975f, 0.775f, 0.193f, 0.772f, -0.099f, 0.401f, -0.928f, -0.36f, -0.922f, -0.719f, -0.025f, -0.725f, 0.163f, -0.14f, 0.972f);

    public static final BodyImage image =
            new BodyImage("data/Frieza.png", 2.25f);

    public Enemy(World world) {
        super(world, Fr);
        this.addImage(image);
    }
// public void collisionResponse(Body b){
//    if(b == Avatar1){
//        Avatar1.incrementSenzuCount();
//        destroy();
//
//    }
 }



