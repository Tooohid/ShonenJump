package game;

import city.cs.engine.*;

public class CollectListener implements CollisionListener {
    private Goku Avatar1;

    public CollectListener(Goku Avatar1) {
        this.Avatar1 = Avatar1;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == Avatar1) {
            if (e.getReportingBody() instanceof SenzuBean) {
                Avatar1.incrementSenzuCount();
                e.getReportingBody().destroy();
            }

            if (e.getReportingBody() instanceof Enemy) {
                Avatar1.DecrementLives();
                e.getReportingBody().destroy();
            }
        }
    }
}
