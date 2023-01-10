//GUI imports
import javax.swing.*;
import java.awt.*;

public class BinClock extends JPanel {
// holds value of the frames height and width
    int width;
    int height;

    //holds the x and y position of each circle as they change in loops
    int ovalX;
    int ovalY;

    //holds the binary string value of the hour, minute, and second
    String binHour;
    String binMinute;
    String binSecond;

    //constructor
    public BinClock()
    {
        //new background color
        setBackground(new Color(206, 189, 125));
        //gets first height + width of frame
        width = getWidth();
        height = getHeight();
        //sets values to default
        ovalX = 0;
        ovalY = 0;
        binSecond = "";
        binMinute = "";
        binHour = "";
    }

    //gets and stores the current height and width of the frame
    private void updateSize()
    {
        width = getWidth();
        height = getHeight();
    }

    //a loop that is used three times to create each row of circles
    private void drawCircles(String time, Graphics g)
    {
        //sets the first circle position
        ovalX = width/8-width/15;
        //runs 6 times for each circle
        for(int i = 0; i < 6; i++)
        {
            //draws or fills in the oval based on weather the binary
            //has a 1 or 0 value at a specific index
            if (time.charAt(i) == '0')
            {
                g.drawOval(ovalX, ovalY, width / 40,width / 40);
            }
            else
            {
                g.fillOval(ovalX, ovalY, width / 40,width / 40);
            }
            //updates the x value to separate the circles
            ovalX += width/8;
        }
    }
//draws the clock
    public void paint(Graphics g)
    {
        super.paintComponent(g);
        //runs update methods
        updateSize();
        Time.updateTime();
        //gets and stores new time values
        binSecond = Time.getBinSecond();
        binMinute = Time.getBinMinute();
        binHour = Time.getBinHour();
        //sets default y value for every new iteration
        ovalY = height/3 + height/30 - height/12;
        //creates font color and different font sizes
        g.setColor(new Color(44, 59, 94));
        Font font = new Font("Spot Mono", 1, width/15);
        Font font2 = new Font("Spot Mono", 1, width/30);
        Font font3 = new Font("Spot Mono", 1, width/25);
        // writes the wording(title, numbers, and time on the clock)
        g.setFont(font);
        g.drawString("Davis's Binary Clock" ,width/10, height/7);
        g.setFont(font2);
        g.drawString("32", width/8-width/15, height/20*19);
        g.drawString("16", width/4-width/15, height/20*19);
        g.drawString("8", (width/8)*3-width/15, height/20*19);
        g.drawString("4", width/2-width/15, height/20*19);
        g.drawString("2", (width/8)*5-width/15, height/20*19);
        g.drawString("1", (width/4)*3-width/15, height/20*19);
        g.setFont(font3);
        g.drawString("Hour", (width/6)*5, (height/3) + height/30 - height/20);
        g.drawString("Minute", (width/6)*5, (height/2) + height/30);
        g.drawString("Second", (width/6)*5, ((height/3)*2) + height/30 + height/20);
        //draws the AM and PM for 12-hour clock
        if (Time.getAM()) {
            g.drawString("AM", (width / 20) * 17, (height / 20) * 19);
        } else {
            g.drawString("PM", (width / 20) * 17, (height / 20) * 19);
        }
        //draws the circles based on the updated time
        drawCircles(binHour, g);
        ovalY = height/2 - height/100;
        drawCircles(binMinute, g);
        ovalY = (height/3)*2 + height/25;
        drawCircles(binSecond, g);
        //repaints everything once complete
        repaint();
    }

}

