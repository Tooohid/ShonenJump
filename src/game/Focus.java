package game;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Focus extends MouseAdapter {
    private Component target;
    

    public Focus(Component target) {
        this.target = target;
    }
    

    @Override
    public void mouseEntered(MouseEvent e) {
        target.requestFocus();
    }
}
