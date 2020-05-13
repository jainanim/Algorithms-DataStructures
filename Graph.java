// Java program to print BFS traversal from a given source vertex. 
// BFS(int s) traverses vertices reachable from s. 
import java.io.*;
import java.util.*;

// This class represents a directed graph using adjacency list 
// representation 
class Graph
{
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor 
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph 
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s 
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default 
        // set as false)
        boolean []visited = new boolean[V];
        //make a queue to keep all values
        LinkedList<Integer> queue = new LinkedList();
        //mark first node as visited
        visited[s]=true;
        queue.add(s);
        //check for queue size

        while(queue.size()!=0)
        {
            s=queue.poll();
            System.out.println(s);

            Iterator<Integer> itr = adj[s].listIterator();
            while (itr.hasNext())
            {
                int n = itr.next();
                if(!visited[n])
                {
                    visited[n]=true;
                    queue.add(n);
                }

            }


        }


    }

    public void DFSUtil(int s, boolean[] visited)
    {
        visited[s]= true;
        System.out.println(s);

        Iterator<Integer> itr = adj[s].listIterator();
        while(itr.hasNext())
        {
            int n = itr.next();
            if(!visited[n])
            {
                DFSUtil(n,visited);
            }
        }
    }
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
    // Driver method to 
    public static void main(String args[])
    {
        

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);


    }
}
// This code is contributed by Aakash Hasija 