package Graphs.Lec4_ShortestPathAlgos;

public class GridPair {
    GridNode node; int cost;
    GridPair(GridNode n, int p){
        node = n;
        cost = p;
    }

    GridPair(int h, int o, int p){
        node = new GridNode(h, o);
        cost = p;
    }
}
