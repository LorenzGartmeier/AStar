import java.util.ArrayList;

public class Grid {

    public int height;

    public int width;


    public Node[][] grid;

    public Node end;

    public Grid(int height, int width){
        this.height = height;
        this.width = width;
        grid = new Node[width][height];
    }

    public ArrayList<Node> getNeighbours(Node node){
        ArrayList<Node> result = new ArrayList<>();
        int xPos;
        int yPos;
        for(int i = 0; i < 8; i++){
            xPos = node.xPos + directions[i][0];
            yPos = node.yPos + directions[i][1];

            if(isInBounds(xPos,yPos)){
                if(grid[xPos][yPos] == null) grid[xPos][yPos] = new Node(xPos,yPos,node.hCost + costs[i],getGCost(xPos,yPos));
                result.add(grid[xPos][yPos]);
            }
        }
        return result;
    }

    public boolean isInBounds(int xPos, int yPos){
        return xPos >= 0 && xPos < width && yPos >= 0 && yPos < height;
    }


    public int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};

    public int[] costs = new int[]{10,10,10,10,14,14,14,14};

    public int getGCost(int xPos, int yPos){
        int xDist = Math.abs(xPos - end.xPos);
        int yDist = Math.abs(yPos - end.yPos);

        if(xDist < yDist) return 14*xDist + 10*(yDist - xDist);
        else return 14*yDist + 10*(xDist - yDist);
    }
}
