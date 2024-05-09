import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

class Square extends JPanel implements MouseListener {
    public static final int length = 20;
    public static boolean mouseISpressed;
    public static boolean rightPressed;

    public static final Color obstacleColor = Color.BLACK;
    public static final Color startColor = Color.GREEN;
    public static final Color endColor = Color.RED;
    public static final Color normalColor = Color.WHITE;

    int line;
    int column;
    int square;

    JLabel gCost;

    JLabel hCost;
    JLabel fCost;


    GUI gui;
    public Square(int line, int column, GUI gui, int totalColumn) {
        this.gui = gui;
        this.line = line;
        this.column = column;
        setBounds(column * length, line * length, length, length);
        this.square = line * totalColumn + column;
        addMouseListener(this);
        setBorder(new LineBorder(Color.BLUE));
        setBackground(Color.WHITE);
        setLayout(null);
        initializehCost();
        initializefCost();
        initializegCost();
    }

    private void initializefCost(){
        fCost = new JLabel();
        fCost.setBounds(length/2-5, length/2-10,20,20);
        fCost.setFont(new Font("Serif", Font.PLAIN, 14));
        add(fCost);
    }

    private void initializehCost(){
        hCost = new JLabel();
        hCost.setBounds(5,0,20,20);
        hCost.setFont(new Font("Serif", Font.PLAIN, 14));
        add(hCost);
    }

    private void initializegCost(){
        gCost = new JLabel();
        gCost.setBounds(length-20,0,20,20);
        gCost.setFont(new Font("Serif", Font.PLAIN, Math.min(30,length/5)));
        add(gCost);
    }


    public void setColor(int state){
        switch (state) {
            case GUI.SELECT_STARTSQUARE -> setBackground(startColor);
            case GUI.SELECT_ENDSQUARE -> setBackground(endColor);
            case GUI.SELECT_OBSTACLE -> setBackground(obstacleColor);
            case GUI.UNSELECT -> setBackground(normalColor);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1){
            mouseISpressed = true;
            gui.squareGotKlicked(this);
        }
        else{
            rightPressed = true;
            gui.squareGotRightClicked(this);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 1){
            mouseISpressed = false;
        }
        else rightPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(mouseISpressed)gui.squareGotKlicked(this);
        else if(rightPressed) gui.squareGotRightClicked(this);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}