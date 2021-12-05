public class Edge {
    public Vertex startPt;
    public int timeCost, distCost;

    public Edge(Vertex startPt, int timeCost, int distCost) {
        this.startPt = startPt;
        this.timeCost = timeCost;
        this.distCost = distCost;
    }


    @Override
    public String toString() {
        String ret = " ";

        ret += getStartPt() ;
        ret += ", " + getTimeCost();
        ret += "," + getDistCost();
        return ret;
    }

    public Vertex getStartPt() {
        return startPt;
    }

    public int getTimeCost() {
        return timeCost;
    }

    public int getDistCost() {
        return distCost;
    }


}
