// C343 Summer 2020
// Bryant Hunsberger | bjhunsbe
// 7/28/20 - 11:30pm
// Homework-07
// a simple implementation for graphs with adjacency lists

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AdjGraph implements Graph {

    // is it a directed graph (true or false) :
    private boolean digraph;

    private Vector<LinkedList<Integer>> adjWeight; //utilized from a previous lab

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
        adjWeight = new Vector<LinkedList<Integer>>(); // Added from lab15
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
            totalEdges ++;   // tmp2 and the adjWeight are added from lab15
            LinkedList<Integer> tmp2 = adjWeight.elementAt(v1);
            tmp2.add(weight);
            adjWeight.set(v1,  tmp2);
        }
    }

    public int getWeight(int v, int u) // This method is recycled from lab15
    {
        LinkedList<Integer> tmp = this.adjList.get(v);
        LinkedList<Integer> weight = adjWeight.get(v);
        if (tmp.contains(u)) {
            return weight.get(tmp.indexOf(u));
        } else {
            return Integer.MAX_VALUE;
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

    public static void topologicalSortWithQueue(AdjGraph myGraph)
    {
        ArrayList<Integer> mySortedNodes = new ArrayList<Integer>();
        int[] myInDegrees = new int[myGraph.nodeList.size()];

        for(int a = 0; a < myInDegrees.length; a++)
        {
            myInDegrees[a] = 0;
        }

        Queue<Integer> nextVertice = new LinkedList<Integer>();
        ArrayList<Integer> trackTheVals = new ArrayList<Integer>();

        for(int j = 0; j < myInDegrees.length; j++)
        {
            for (int y = 0; y < myGraph.adjList.get(j).size(); y++)
            {
                myInDegrees[myGraph.adjList.get(j).get(y)] += 1;
                trackTheVals.add(myGraph.adjList.get(j).get(y));
            }

        }
        ArrayList<Integer> unUsed = new ArrayList<Integer>();

        for(int f = 0; f < myInDegrees.length; f++)
        {
            boolean valIn = false;
            for(int b = 0; b < trackTheVals.size(); b++)
            {
                if (trackTheVals.get(b) == f)
                {
                    valIn = true;
                }
            }
            if(!valIn) {
                unUsed.add(f);
            }
        }
        for(int x = 0; x < unUsed.size(); x++)
        {
            nextVertice.add(unUsed.get(x));
        }

        while(!nextVertice.isEmpty())
        {
            int myVertex = nextVertice.remove();
            mySortedNodes.add(myVertex);

            for(int i = 0; i < myGraph.adjList.get(myVertex).size(); i++)
            {

                myInDegrees[myGraph.adjList.get(myVertex).get(i)] -= 1;

                if (myInDegrees[myGraph.adjList.get(myVertex).get(i)] == 0)
                {
                    nextVertice.add(myGraph.adjList.get(myVertex).get(i));
                }

            }


        }
        /*if (mySortedNodes.size() == myGraph.nodeList.size())
        {
            //System.out.print("My Topological Order is: \n");
            for(int k = 0; k < mySortedNodes.size(); k++)
            {
                System.out.print(myGraph.nodeList.get(mySortedNodes.get(k)) + ", ");
            }
        }
        else
        {
            System.out.println("Your solution is inapplicable");
        }
        */
        longestPath(mySortedNodes, myGraph);

    }

    public static void longestPath(ArrayList<Integer> myTopList, AdjGraph myGraph)
    {
        int longestLength = 0;
        ArrayList<String> index = new ArrayList<String>();

        for(int i = 0; i < myTopList.size(); i++)
        {
            int currentMaxIndex = -1;
            String sizeOne = "";
            for(int j = 0; j < myGraph.adjList.get(myTopList.get(i)).size(); j++)
            {
                if (currentMaxIndex < (myGraph.getWeight(myTopList.get(i), myGraph.adjList.get(myTopList.get(i)).get(j))))
                {
                    currentMaxIndex = myGraph.getWeight(myTopList.get(i), myGraph.adjList.get(myTopList.get(i)).get(j));
                    sizeOne += myGraph.nodeList.get(myTopList.get(i));
                    index.add(sizeOne);
                }
            }
            if (myGraph.adjList.get(myTopList.get(i)).size() == 0)
            {
                currentMaxIndex = 0;
                //sizeOne += myGraph.nodeList.get(myTopList.get(i));
            }

            longestLength += currentMaxIndex;

        }

        index.add(myGraph.nodeList.get(myTopList.get(myTopList.size() - 1)));
        System.out.println("The longest path size is: " + longestLength);
        System.out.println("My Sequence: ");
        for(int k = 0; k < index.size(); k++)
        {
            System.out.print(index.get(k) + ", ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        AdjGraph bryantsGraph = new AdjGraph();
        bryantsGraph.digraph = true;
        File myLocations = new File("C:\\Users\\bryant\\IdeaProjects\\Homework02\\homework07\\src\\locations.txt");

        Scanner myFileScan = new Scanner(myLocations);

        String numberLocations = "";
        String numberRoads = "";
        int i = 0;
        while(myFileScan.hasNext())
        {
            while(myFileScan.hasNextLine())
            {
                if (i == 0)
                {
                    numberLocations += myFileScan.next();
                    numberRoads += myFileScan.next();
                    i += 1;
                }
                else
                {
                    String vertexOne = myFileScan.next();

                    String vertexTwo = myFileScan.next();

                    if (bryantsGraph.getNode(vertexOne) == -1)
                    {
                        bryantsGraph.addVertex(vertexOne);
                    }
                    if (bryantsGraph.getNode(vertexTwo) == -1)
                    {
                        bryantsGraph.addVertex(vertexTwo);
                    }
                    bryantsGraph.setEdge(vertexOne, vertexTwo, Integer.valueOf(myFileScan.next()));
                    myFileScan.next();
                    i += 1;
                }
            }
        }


        topologicalSortWithQueue(bryantsGraph);

    }

}