class Solution {
    //METHOD 1:- DFS (TLE)
    /*
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        TreeMap<Integer,Integer> map= new TreeMap<>();
        for (int i=0; i<n; i++){
            boolean[] visited= new boolean[n];
            HashSet<Integer> list= new HashSet<>();
            recursion(list,visited, edges,i,n,distanceThreshold);
            System.out.println(list);
            map.put(i,list.size());
        }

        int min= Integer.MAX_VALUE, city= 0;
        for (Integer key: map.keySet()){ //keys will be iterated in sorted order
            if (map.get(key)<=min){
                min= map.get(key);
                city= key;
            }
        }
        return city;
    }

    private void recursion(HashSet<Integer> store, boolean[] visited, int[][] edges, int node, int n, int threshold){
        visited[node]= true;
        for(int[] edge: edges){
            if (edge[0]==node && edge[2]<=threshold && !visited[edge[1]]){
                store.add(edge[1]);
                recursion(store, visited, edges, edge[1], n, threshold-edge[2]);
            }
            if (edge[1]==node && edge[2]<=threshold && !visited[edge[0]]){
                store.add(edge[0]);
                recursion(store, visited, edges, edge[0], n, threshold-edge[2]);
            }
        }
        visited[node]= false;
    }
    //DFS IS GOOD BUT TLE  
     */
    
    //METHOD 2:- DIJKSTRA'S ALGORITHM
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // first convert graph to adjacency list representation
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1], distance = edge[2];
            graph.get(node1).add(new int[]{node2, distance});
            graph.get(node2).add(new int[]{node1, distance});
        }

        int minimum_number = n;
        int res = -1;

        for (int source = 0; source < n; source++) {
            int neighbors = get_number_of_neighbors_in_distance(graph, source, n, distanceThreshold);
            // we iterate source from smaller to bigger this ensures that we choose node with greater value if they have equal number of neighbors
            if (neighbors <= minimum_number) {
                minimum_number = neighbors;
                res = source;
            }
        }

        return res;
    }

    private int get_number_of_neighbors_in_distance(List<List<int[]>> graph, int source, int n, int distanceThreshold) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.add(new int[]{0, source}); // distance to node itself is 0
        Set<Integer> visited = new HashSet<>();

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int distance_to_this_node = top[0], cur_node = top[1];
            if (!visited.contains(cur_node)) {
                visited.add(cur_node);
                for (int[] neighbor : graph.get(cur_node)) {
                    int distance_from_source = distance_to_this_node + neighbor[1];
                    if (distance_from_source <= distanceThreshold) { // ensure that we're allowed to go to this node
                        minHeap.add(new int[]{distance_from_source, neighbor[0]});
                    }
                }
            }
        }
        // actually you can return visited.size() and with math there will be nothing wrong but actually we have visited.size() - 1 neighbors since we're not neighbor of ourselves
        return visited.size() - 1;
    }
}