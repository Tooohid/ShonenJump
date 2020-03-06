package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.security.Key;

/**
 * Key handler to control an Walker.
 */
public class CharMove extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 12;
    private static final BodyImage image1 =  //flipped
            new BodyImage("data/GokuFlippedx.png", 2.25f);
    private static final BodyImage image =
            new BodyImage("data/goku4.gif", 2.25f);
    private Walker body;
    private WorldView view;
    private Shape ballShape;
    private BodyImage ballImage;
    private World world;

    public CharMove(Walker body) {
        this.body = body;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // J = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
             //   body.rotate(45);



            }
//            if (code == MouseEvent.BUTTON1){
//                body.isBullet();
//
//            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-WALKING_SPEED);
            // 1 = walk left
            body.removeAllImages();
            body.addImage(image1);
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
            body.removeAllImages();
            body.addImage(image);

        }

        if(code == KeyEvent.VK_P){
            world.stop();
        } else
        if(code == KeyEvent.VK_O){
            world.start();
        }

    }
public void pause(){
        world.stop();
}
public void resume(){
        world.start();
}


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code== KeyEvent.VK_W){
//            body.rotate(-45);
        }
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
//            body.rotate(90);
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();

        }
    }

    public void setBody(Goku player) {
        this.body = body;
    }
}
