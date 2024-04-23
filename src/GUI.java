import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class GUI implements ActionListener, MouseWheelListener {

        JFrame frame;

        JButton start;
        JButton end;
        JButton obstacle;

        Square[][] squares;


    public GUI(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initializeSquares();
        frame.setVisible(true);
    }

    public void initializeSquares(){

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dim.getHeight()/Square.length;
        int width = (int)dim.getWidth()/Square.length;
        squares = new Square[height][width];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                squares[i][j] = new Square(i,j,this);
                frame.add(squares[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

}
