package game;

import city.cs.engine.*;

public class Door extends StaticBody {
    public Door(World world){
        super(world, new BoxShape(0.5f,0.8f));
        addImage( new BodyImage("data/Door.png", 4f));
    }
}
