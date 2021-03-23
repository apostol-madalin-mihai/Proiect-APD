
public class RoyFloydAlgorithm {

	final static int INF = 99999;
	final static int V = 4;
	 
	private int[][]graph = { {0,   5,  INF, 10},
			 		  		 {INF, 0,   3, INF},
			 		  		 {INF, INF, 0,   1},
			 		  		 {INF, INF, INF, 0}
                           };
	
	private int [][]rf_graph;
	
	/*
	public RoyFloydAlgorithm(int[][]t_args, int t_argv)throws Exception {
		boolean l_input_tester = testInput(t_args, t_argv);
		if(l_input_tester == false) {
		    throw new IllegalArgumentException("Matrix dimension is not legal due matrix given.");
		}
		else {
		    rf_graph = new int[t_argv][t_argv];
		    rf_graph = initDist(t_argv);
		}
	}
	*/
	
	public void computeSolution() {
		int[][]l_dist = new int[V][V];
		
		l_dist = initDist();
		l_dist = calculateSolution(l_dist);
		// FOR DEBUGGING
		printSolution(l_dist);
		
	}
	
	private int[][] initDist() {
		int[][]l_init_dist = new int[V][V];
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				l_init_dist[i][j] = graph[i][j];
			}
		}
		return l_init_dist;
	}
	
	private int[][]calculateSolution(int[][]t_init_dist){
		
		for(int k = 0; k < V; k++) {
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < V; j++) {
					if(t_init_dist[i][k] + t_init_dist[k][j] < t_init_dist[i][j]){
						t_init_dist[i][j] = t_init_dist[i][k] + t_init_dist[k][j];
					}
				}
			}
		}
		return t_init_dist;
	}
	
	private void printSolution(int[][] t_dist) {
		// FOR DEBUGGING PURPOSE
		 System.out.println("The following matrix shows the shortest "+
                 "distances between every pair of vertices");
		 for (int i=0; i<V; ++i)
		 {
			 for (int j=0; j<V; ++j)
			 {
				 if (t_dist[i][j]==INF)
					 System.out.print("INF ");
				 else
					 System.out.print(t_dist[i][j]+"   ");
			 }
			 System.out.println();
		 }
	}
	
	private boolean testInput(int[][] t_graph, int dim) {
	    int dim_row, dim_col;
	    dim_row = t_graph.length;
	    dim_col = t_graph[0].length;
	    return ((dim_row == dim)&&(dim_col == dim)) ? true : false;
	}
}
