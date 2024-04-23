public class Node {


    //the Node we are coming from
    public Node parent;

    //cost from start to this node
    public int hCost;

    //cost from this node to end
    public int gCost;

    public int xPos;
    public int yPos;


    public int getFCoSt(){
        return hCost + gCost;
    }

    public Node(int xPos,int yPos, int hCost, int gCost){
        this.xPos = xPos;
        this.yPos = yPos;
        this.hCost = hCost;
        this.gCost = gCost;
    }




}
