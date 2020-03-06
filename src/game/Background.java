package game;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;

public class Background extends UserView {

private Image background;

    public Background(World world,int width, int height) {
        super(world,width, height);
   this.background = new ImageIcon("data/Background_1.png").getImage();


    }
    public void paintBackground(Graphics2D g){
        g.drawImage(background, 0 ,0,this);
        this.setVisible(true);
    }

}
