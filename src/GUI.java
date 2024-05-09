import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashSet;

public class GUI implements ActionListener {

        JFrame frame;

        JMenuItem start;
        JMenuItem end;
        JMenuItem obstacle;

        Square[] squares;

        JMenuBar menuBar;
        JMenu run;
        JMenu select;
        public static final int SELECT_STARTSQUARE = 0;
        public static final int SELECT_ENDSQUARE = 1;
        public static final int SELECT_OBSTACLE = 2;

        public static final int UNSELECT = 3;

        int state = SELECT_STARTSQUARE;
        StartState startState = new StartState();
        Square startSquare;
        Square endSquare;
        HashSet<Square> obstacles;


    public GUI(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menuBar = new JMenuBar();
        run = new JMenu("run");
        select = new JMenu("select");
        start = new JMenuItem("startNode");
        start.addActionListener(this);
        select.add(start);
        end = new JMenuItem("endNode");
        end.addActionListener(this);
        select.add(end);
        obstacle = new JMenuItem("obstacle");
        obstacle.addActionListener(this);
        select.add(obstacle);
        menuBar.add(select);
        menuBar.add(run);
        frame.setJMenuBar(menuBar);
        initializeSquares();
        frame.setVisible(true);
    }

    public void initializeSquares(){

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dim.getHeight()/Square.length;
        int width = (int)dim.getWidth()/Square.length;
        squares = new Square[height*width];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                squares[i *width + j] = new Square(i,j,this, width);
                frame.add(squares[i*width + j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start) { state = SELECT_STARTSQUARE;}
        else if(e.getSource() == end) state = SELECT_ENDSQUARE;
        else if(e.getSource() == obstacle) state = SELECT_OBSTACLE;
    }

    public void squareGotKlicked(Square square){
        square.setColor(state);
        if(state == SELECT_OBSTACLE){
            startState.obstacles.add(square.square);
        } else if (state == SELECT_STARTSQUARE && startState.start != square.square){
            if(startState.start != -1){
                squares[startState.start].setColor(UNSELECT);
            }
            startState.start = square.square;
        } else if(state == SELECT_ENDSQUARE && startState.end != square.square){
            if(startState.end != -1){
                squares[startState.end].setColor(UNSELECT);
            }
            startState.end = square.square;
        }
    }

    public void squareGotRightClicked(Square square){
        square.setColor(UNSELECT);
        if(state == SELECT_OBSTACLE) startState.obstacles.remove(square.square);
        else if(state == SELECT_ENDSQUARE && startState.end == square.square) startState.end = -1;
        else if(state == SELECT_STARTSQUARE && startState.start == square.square) startState.start = -1;
    }


}
