
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends MouseAdapter {

    private WorldView view;
    private Shape ballShape;
    private BodyImage ballImage;

    public MouseHandler(WorldView view) {
        this.view = view;
        float radius = 0.8f;
        ballShape = new CircleShape(radius);
        ballImage = new BodyImage("data/Kamehameha.png", 2*radius);
    }


    public void mousePressed(MouseEvent e) {
        DynamicBody ball = new DynamicBody(view.getWorld(), ballShape);
        ball.setPosition(view.viewToWorld(e.getPoint()));
        ball.addImage(ballImage);

//        for(int i=0; i<2 ; i++){
//            ball.setBullet(true);
//            ball.setPosition(i,Mo
//
//        }
    }
}
