// C343 Summer 2020
//
// a simple interface for graphs

// C343 Summer 2020
// Bryant Hunsberger | bjhunsbe
// 7/28/20 - 11:30pm
// Homework-07

public interface Graph {
    public void init();
    public int length();
    public void setVertices(String[] nodes);
    public void addVertex(String node);
    public void setEdge(int v1, int v2, int weight);
    public void setEdge(String v1, String v2, int weight);
    public void setVisited(int v);
    public boolean ifVisited(int v);
    public void clearWalk();
    public void walk(String order);
    public void DFS(int s);    // depth first
    public void BFS(int s);    // breath first
    public void display();     // display information
    public void displayEnum(); // display vertex enumeration
    public int getWeight(int v, int u);
}