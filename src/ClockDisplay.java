//GUI imports
import javax.swing.*;
import java.awt.*;
public class ClockDisplay {

    public ClockDisplay() {
        //new frame with size and title
        JFrame clock = new JFrame();
        clock.setTitle("Binary Clock");
        clock.setSize(800,500);
        //sets minimums size of frame
        Dimension mSize = new Dimension(800, 500);
        clock.setMinimumSize(mSize);
        //stops code on exit
        clock.setDefaultCloseOperation(3);
        //creates the graphics panel
        BinClock binPanel = new BinClock();
        Container pane = clock.getContentPane();
        pane.add(binPanel);
        clock.setVisible(true);
    }
}
