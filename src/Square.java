import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

class Square extends JPanel implements MouseListener {
    public static final int length = 200;
    public static boolean mouseISpressed;

    int line;
    int column;
    int square;

    JLabel gCost;

    JLabel hCost;
    JLabel fCost;


    GUI gui;
    public Square(int line, int column, GUI gui) {
        this.gui = gui;
        this.line = line;
        this.column = column;
        setBounds(column * length, line * length, length, length);
        this.square = line * 8 + column;
        addMouseListener(this);
        setBorder(new LineBorder(Color.BLUE));
        setLayout(null);
        initializehCost();
        initializefCost();
        initializegCost();
    }

    private void initializefCost(){
        fCost = new JLabel();
        fCost.setText("0");
        fCost.setBounds(length/2-5, length/2-10,20,20);
        fCost.setSize(20,20);
        add(fCost);
    }

    private void initializehCost(){
        hCost = new JLabel();
        hCost.setText("0");
        hCost.setBounds(5,0,20,20);
        add(hCost);
    }

    private void initializegCost(){
        gCost = new JLabel();
        gCost.setText("0");
        gCost.setBounds(length-20,0,20,20);
        add(gCost);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(Color.RED);
        mouseISpressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseISpressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(mouseISpressed)setBackground(Color.RED);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}