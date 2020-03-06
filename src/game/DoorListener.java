package game;

import city.cs.engine.*;

public class DoorListener implements CollisionListener {
    private Game game;

    public DoorListener(Game game){
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Goku player1 = game.getPlayer();
        if (e.getOtherBody() == player1 && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next Level....");
            game.goNextLevel();
        }

    }
}
