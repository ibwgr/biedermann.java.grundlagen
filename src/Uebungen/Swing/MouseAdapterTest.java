package Uebungen.Swing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by dieterbiedermann on 22.11.16.
 */
public class MouseAdapterTest extends MouseAdapter {
    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
//        e.getComponent().("x=" + e.getX() + ", y=" + e.getY());
    }
}
