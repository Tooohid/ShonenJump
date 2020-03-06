package game;

import city.cs.engine.*;


public class Goku extends Walker {


    private static final Shape shape = new PolygonShape(
            0.149f, 0.975f, 0.775f, 0.193f, 0.772f, -0.099f, 0.401f, -0.928f, -0.36f, -0.922f, -0.719f, -0.025f, -0.725f, 0.163f, -0.14f, 0.972f);

    private static final BodyImage image =
        new BodyImage("data/goku4.gif", 2.25f);

    public StaticBody body;

    private int beanCount;

    public Goku(World world) {
        super(world, shape);
        addImage(image);
        beanCount = 0;
    }

    public void incrementSenzuCount() {
        beanCount++;
        System.out.println("Goku: 'I feel better now, thanks!'      COLLECTED:   " + beanCount);
    }
    public void friezeDeath(){
        System.out.println("Frieza: DAMN YOU KAKAROT!");
        System.out.println("*Frieza has left the chat...*");
    }
    public void DecrementLives(){
        System.out.println("Damn that hurt!       ONE LIFE LOST");

    }
    public int getBeanCount() {
        return beanCount;
    }

}
