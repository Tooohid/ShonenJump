package game;

import city.cs.engine.*;

import javax.swing.*;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;
import java.awt.*;

import java.util.ArrayList;
import java.util.Random;

/** The computer game. */
public class Game {

  private GameLevel world;
  private int level;
  private UserView view;
  private CharMove controller;
  private Background background;
  private int BeanCount;

  public Game() {

    // BeanCount = 0;
    // make the world
    level = 1;

    world = new Level1();
    world.populate(this);

    view = new UserView(world, 600, 500);

    // make a view
    // uncomment this to draw a 1-metre grid over the view
    view.setGridResolution(1);

    // display the view in a frame
    final JFrame frame = new JFrame("ShonenJump");
    view.setBackground(new Color(27, 45, 59));

    ////        view.setZoom(40);
    //        UserView view = new PointDisplay(world, this, 600, 600);
    ////        frame.add(view);
    //        UserView View = new UserView(world, 500, 100);
    //        view.setZoom(6);
    //        frame.add(view, BorderLayout.SOUTH);

    // quit the application when the game window is closed
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationByPlatform(true);
    // display the world in the window
    frame.add(view);
    // don't let the game window be resized
    frame.setResizable(false);
    // size the game window to fit the world view
    frame.pack();
    // make the window visible
    frame.setVisible(true);
    // get keyboard focus
    frame.requestFocus();
    // give keyboard focus to the frame whenever the mouse enters the view
    view.addMouseListener(new Focus(frame));

    view.addMouseListener(new MouseHandler(view));

    frame.addKeyListener(new CharMove(world.getPlayer()));

    // uncomment to make the view track the bird
    world.addStepListener(new Tracking(view, world.getPlayer()));

    // uncomment this to make a debugging view
    JFrame debugView = new DebugViewer(world, 600, 500);

    // start!
    world.start();
  }

  public Goku getPlayer() {
    return world.getPlayer();
  }

  public boolean isCurrentLevelCompleted() {
    return world.isCompleted();
  }

  public void goNextLevel() {
    world.stop();
    if (level == 2) {
      System.exit(0);

    } else {
      level++;
      world = new Level2();
      // fill it with bodies
      world.populate(this);
      // switch the keyboard control to the new player
      controller.setBody(world.getPlayer());
      // show the new world in the view
      view.setWorld(world);
      world.start();
    }
  }

  public int getBeanCount() {
    return BeanCount;
  }

  /** Run the game. */
  public static void main(String[] args) {
    new Game();
  }
}
