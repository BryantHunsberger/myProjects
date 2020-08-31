// C343 Summer 2020
//
// a simple implementation for graphs with adjacency lists

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class AdjGraph implements Graph {

    // is it a directed graph (true or false) :
    private boolean digraph;

    private int totalNodes;
    // all the nodes in the graph:
    private Vector<String> nodeList;

    private int totalEdges;
    // all the adjacency lists, one for each node in the graph:
    private Vector<LinkedList<Integer>>  adjList;

    // every visited node:
    private Vector<Boolean> visited;

    // list of nodes pre-visit:
    private Vector<Integer> nodeEnum;

    public AdjGraph() {
        init();
    }

    public AdjGraph(boolean ifdigraph) {
        init();
        digraph = ifdigraph;
    }

    public void init() {
        nodeList = new Vector<String>();
        adjList = new Vector<LinkedList<Integer>>();
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        totalNodes = totalEdges = 0;
        digraph = false;
    }

    // set vertices:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        totalNodes ++;
    }

    public int getNode(String node) {
        for (int i = 0; i < nodeList.size(); i ++) {
            if (nodeList.elementAt(i).equals(node)) return i;
        }
        return -1;
    }

    // return the number of vertices:
    public int length() {
        return nodeList.size();
    }

    // add edge from v1 to v2:
    public void setEdge(int v1, int v2, int weight) {
        LinkedList<Integer> tmp = adjList.elementAt(v1);
        if (adjList.elementAt(v1).contains(v2) == false) {
            tmp.add(v2);
            adjList.set(v1,  tmp);
            totalEdges ++;
        }
    }

    public void setEdge(String v1, String v2, int weight) {
        if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
            // add edge from v1 to v2:
            setEdge(getNode(v1), getNode(v2), weight);
            // for undirected graphs, add edge from v2 to v1 as well:
            if (digraph == false) {
                setEdge(getNode(v2), getNode(v1), weight);
            }
        }
    }

    // keep track whether a vertex has been visited or not,
    //    for graph traversal purposes:
    public void setVisited(int v) {
        visited.set(v, true);
        nodeEnum.add(v);
    }

    public boolean ifVisited(int v) {
        return visited.get(v);
    }


    // clean up before traversing the graph:
    public void clearWalk() {
        nodeEnum.clear();
        for (int i = 0; i < nodeList.size(); i ++)
            visited.set(i, false);
    }

    public void walk(String method) {
        clearWalk();
        // traverse the graph:
        for (int i = 0; i < nodeList.size(); i ++) {
            if (ifVisited(i) == false) {
                if (method.equals("BFS")) {
                    BFS(i);      // i is the start node
                } else if (method.equals("DFS")) {
                    DFS(i); // i is the start node
                } else {
                    System.out.println("unrecognized traversal order: " + method);
                    System.exit(0);
                }
            }
        }
        System.out.println(method + ":");
        displayEnum();
    }

    // Lab 13 TODO:
    //
    // write your componentsAndSizes() method here.
    //



    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i ++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) DFS(v1);
        }
    }

    public void BFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(s);
        while (toVisit.size() > 0) {
            int v = toVisit.remove(0);   // first-in, first-visit
            setVisited(v);
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for (int i = 0; i < neighbors.size(); i ++) {
                int v1 = neighbors.get(i);
                if ( (ifVisited(v1) == false) && (toVisit.contains(v1) == false) ) {
                    toVisit.add(v1);
                }
            }
        }
    }
    public void display() {
        System.out.println("total nodes: " + totalNodes);
        System.out.println("total edges: " + totalEdges);
    }
    public void displayEnum() {
        for (int i = 0; i < nodeEnum.size(); i ++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }

    public static void floydNoWeights(AdjGraph myGraph)
    {
        int numberOfPairs = myGraph.totalNodes;

        int[][] nOfE = new int[numberOfPairs + 1][numberOfPairs + 1];

        for(int i = 0; i < nOfE.length; i++)
        {
            nOfE[i][i] = 0;
            nOfE[i][0] = -1;
            nOfE[0][i] = -1;
        }

        for(int j = 0; j < myGraph.adjList.size(); j++)
        {
            for(int z = 0; z < myGraph.adjList.get(j).size(); z++)
            {
                nOfE[j+1][myGraph.adjList.get(j).get(z) + 1] = 1;

            }
        }

        for(int x = 0; x < nOfE.length; x++) {
            for (int m = 0; m < nOfE.length; m++) {
                if((nOfE[x][m] == 0) && (x!= m))
                {
                    nOfE[x][m] = 1000;
                }
            }

        }

        for(int k = 1; k < nOfE.length; k++)
        {
            for(int s = 1; s < nOfE.length; s++)
            {
                for(int f = 1; f < nOfE.length; f++)
                {
                    if (nOfE[s][f] > (nOfE[s][k] + nOfE[k][f]))
                    {
                        nOfE[s][f] = (nOfE[s][k] + nOfE[k][f]);
                    }
                }
            }
        }

        System.out.print("Shortest path from (Vertice A) to (Vertice B): \n\n");
        for(int k = 1; k < nOfE.length; k++)
        {
            for (int s = 1; s < nOfE.length; s++)
            {
                if (!(nOfE[k][s] == 1000))
                {
                    System.out.print(myGraph.nodeList.get(k-1) + " to " +
                            myGraph.nodeList.get(s-1) + " is: " + nOfE[k][s] + "\n");
                }
            }

        }
    }

    public static void main(String[] args)
    {
        System.out.println("Graph One\n");
        String[] setOne = {"B", "R", "Y", "A", "N", "T"};
        AdjGraph graphOne = new AdjGraph();
        graphOne.digraph = true;
        graphOne.setVertices(setOne);
        graphOne.setEdge("B", "R", 0);
        graphOne.setEdge("R", "T", 0);
        graphOne.setEdge("T", "A", 0);
        graphOne.setEdge("R", "A", 0);
        graphOne.setEdge("T", "N", 0);
        graphOne.setEdge("T", "Y", 0);
        graphOne.setEdge("A", "Y", 0);
        floydNoWeights(graphOne);

        System.out.println("\n\n");
        System.out.println("Graph Two\n");
        String[] setTwo = {"Indy", "Bloom", "China", "Atlanta", "Vegas"};
        AdjGraph graphTwo = new AdjGraph();
        graphTwo.digraph = true;
        graphTwo.setVertices(setTwo);
        graphTwo.setEdge("Indy", "China", 0);
        graphTwo.setEdge("China", "Atlanta", 0);
        graphTwo.setEdge("Atlanta", "Vegas", 0);
        graphTwo.setEdge("Vegas", "Bloom", 0);
        graphTwo.setEdge("China", "Bloom", 0);
        graphTwo.setEdge("Indy", "Bloom", 0);
        graphTwo.setEdge("China", "Vegas", 0);
        floydNoWeights(graphTwo);

        System.out.println("\n\n");
        System.out.println("Graph Three\n");
        String[] setThree = {"C", "O", "M", "P", "U", "T", "E", "R"};
        AdjGraph graphThree = new AdjGraph();
        graphThree.digraph = true;
        graphThree.setVertices(setThree);
        graphThree.setEdge("C", "O", 0);
        graphThree.setEdge("C", "M", 0);
        graphThree.setEdge("C", "P", 0);
        graphThree.setEdge("P", "U", 0);
        graphThree.setEdge("P", "T", 0);
        graphThree.setEdge("T", "E", 0);
        graphThree.setEdge("E", "R", 0);
        floydNoWeights(graphThree);
    }


    // Lab 13 TODO:

    // write a main() method here:

    // 1) instantiate a new graph,
    // 2) assign2 vertices and edges to the graph,
    // 3) then display2 the graph's content (use display() )
    // 4) finally call your componentsAndSizes() method to provide
    //    output results as from Lab 13 instructions

    // provide 3 different examples,
    //   with at least 10 nodes for each different graph

} // end of class AdjGraph