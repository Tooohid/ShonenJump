package game;

import city.cs.engine.*;
public class Platforms extends StaticBody {
    private static final Shape Floor = new BoxShape(2.55f,0.2f);
            //0.149f, 0.975f, 0.775f, 0.193f, 0.772f, -0.099f, 0.401f, -0.928f, -0.36f, -0.922f, -0.719f, -0.025f, -0.725f, 0.163f, -0.14f, 0.972f);

    private static final BodyImage image =
            new BodyImage("data/platform.png", 1.25f);
    public Platforms(World world) {
        super(world, Floor);
        this.addImage(image);
       // setGravityScale(0);

    }
}
