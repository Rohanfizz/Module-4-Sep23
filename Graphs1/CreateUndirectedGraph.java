import java.util.*;

class CreateUndirectedGraph {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int V = scn.nextInt();
    int E = scn.nextInt();

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < V; i++) graph.add(new ArrayList<>());


    for(int i = 0;i<E;i++){
        int u = scn.nextInt();
        int v = scn.nextInt();
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    for(int i = 0;i<V;i++){
        System.out.println(i+": "+graph.get(i));
    }
    scn.close();
  }
}
