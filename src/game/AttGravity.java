
package game;

import city.cs.engine.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A MouseListener that drops a bowling ball on each mouse press.
 */
public class AttGravity extends MouseAdapter {

    private WorldView view;

    public AttGravity(WorldView view) {
        this.view = view;
    }

    public void mousePressed(MouseEvent e) {
        DynamicBody ball = new Kamehame(view.getWorld());
        ball.setPosition(view.viewToWorld(e.getPoint()));
    }

    
           
 
}
