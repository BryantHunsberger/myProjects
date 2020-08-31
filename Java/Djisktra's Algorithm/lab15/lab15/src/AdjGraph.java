// C343 Summer 2020
//
// a simple implementation for graphs with adjacency lists

// lab 15 starter file


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

    // all the weights of the edges, one for each node in the graph:
    private Vector<LinkedList<Integer>> adjWeight;

    // every visited node:
    private Vector<Boolean> visited;

    // list of nodes pre-visit:
    private Vector<Integer> nodeEnum;

    private int[] distances;

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
        adjWeight = new Vector<LinkedList<Integer>>();
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
            adjWeight.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }

    // add a vertex:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        adjWeight.add(new LinkedList<Integer>());
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
            LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
            tmp2.add(weight);
            adjWeight.set(v1,  tmp2);
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


    // new for Lab 15:
    public LinkedList<Integer> getNeighbors(int v) {
        return adjList.get(v);
    }

    public int getWeight(int v, int u) {
        LinkedList<Integer> tmp = getNeighbors(v);
        LinkedList<Integer> weight = adjWeight.get(v);
        if (tmp.contains(u)) {
            return weight.get(tmp.indexOf(u));
        } else {
            return Integer.MAX_VALUE;
        }
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

    // Lab 15 TODO:
    //
    // write your methods here.
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

    public void relax(int v, int u, int e, int currentElement, int previous)
    {
        if (v + e < u)
        {
            distances[currentElement] = v + e;
            if (previous >= 0)
            {
                distances[previous] = v;
            }
        }
    }

    public void dijkstra1(AdjGraph myGraph, int s)
    {
        int myNodes = myGraph.totalNodes;
        distances = new int[myNodes]; // 0 1 2 3 4 5 - nodes by number. S --> each node
        boolean distanceKnown = false;
        boolean[] visitedVals = new boolean[myNodes];

        distances[0] = 0;
        //visitedVals[0] = true;

        for(int i = 1; i < distances.length; i++)
        {
            distances[i] = 10000;
            visitedVals[i] = false;
        }

        int numTruths = 0;
        for(int i = 0; i < visitedVals.length; i++)
        {
            if (visitedVals[i] == true)
            {
                numTruths += 1;
            }
        }

        if(numTruths == visitedVals.length)
        {
            distanceKnown = true;
        }

        int currentSmallestElement = s;
        int newSmallest = 0;
        int previous = -1;

        while(!distanceKnown)
        {
            LinkedList<Integer> theNeighbors = myGraph.getNeighbors(currentSmallestElement);
            for (int i = 0; i < theNeighbors.size(); i++) {
                if (i == 0) {
                    newSmallest = theNeighbors.get(i);
                } else if (myGraph.getWeight(theNeighbors.get(i), currentSmallestElement) <
                        (myGraph.getWeight(newSmallest, currentSmallestElement))) {
                    newSmallest = theNeighbors.get(i);

                }
            }
            for (int i = 0; i < theNeighbors.size(); i++)
            {
                if (visitedVals[theNeighbors.get(i)] == false)
                {
                    int currentCost = myGraph.getWeight(currentSmallestElement, theNeighbors.get(i));
                    if (i > 0)
                    {
                        relax(distances[currentSmallestElement], distances[theNeighbors.get(i)], currentCost,
                                theNeighbors.get(i), previous);
                    }
                    relax(distances[currentSmallestElement], distances[theNeighbors.get(i)], currentCost,
                            theNeighbors.get(i), previous);
                }
            }

            visitedVals[currentSmallestElement] = true;
            previous = currentSmallestElement;
            currentSmallestElement = newSmallest;
            numTruths = 0;
            for(int i = 0; i < visitedVals.length; i++)
            {
                if (visitedVals[i] == true)
                {
                    numTruths += 1;
                }
            }

            if(numTruths == visitedVals.length - 1)
            {
                distanceKnown = true;
            }

        }
        distances[0] = 0;

        for(int i = 0; i < distances.length; i++)
        {
            System.out.println("Node " + myGraph.nodeList.get(0) + " to node " + myGraph.nodeList.get(i) +
                    " is a distance of " + distances[i]);
        }
    }

    public static void main(String argv[]) {
        AdjGraph g1 = new AdjGraph(true);
        String[] nodes1 = {"A", "B", "C", "D", "E"};
        int weight = 1;
        g1.setVertices(nodes1);
        g1.setEdge("A", "B", weight);
        g1.setEdge("B", "C", weight);
        g1.setEdge("C", "D", weight);
        g1.setEdge("A", "C", weight);
        System.out.println("Graph One: \n\n");
        g1.dijkstra1(g1, 0);

        //second example: g2
        AdjGraph g2 = new AdjGraph(true);
        String[] nodes2 = {"a", "b", "c", "d", "e", "f"};
        g2.setVertices(nodes2);
        g2.setEdge("a", "b", 9);
        g2.setEdge("a", "f", 5);
        g2.setEdge("a", "e", 3);
        g2.setEdge("b", "c", 5);
        g2.setEdge("b", "f", 4);
        g2.setEdge("c", "d", 2);
        g2.setEdge("c", "f", 8);
        g2.setEdge("d", "f", 7);
        g2.setEdge("d", "e", 1);
        g2.setEdge("e", "f", 5);
        System.out.println("\nGraph Two: \n\n");
        g2.dijkstra1(g2, 0);

        AdjGraph g3 = new AdjGraph(true);
        String[] setTwo = {"Indy", "Bloom", "China", "Atlanta", "Vegas"};
        g3.setVertices(setTwo);
        g3.setEdge("Indy", "China", 4);
        g3.setEdge("China", "Atlanta", 3);
        g3.setEdge("Atlanta", "Vegas", 7);
        g3.setEdge("Vegas", "Bloom", 10);
        g3.setEdge("China", "Bloom", 3);
        g3.setEdge("Indy", "Bloom", 2);
        g3.setEdge("China", "Vegas", 5);
        System.out.println("\nGraph Three: \n\n");
        g3.dijkstra1(g3, 0);

    }


    // Lab 15 TODO:

    // write your new main() method here:

    // provide 3 different examples, using the two different versions of Dijkstra's algorithm
    //   with at least 10 nodes for each different graph




}