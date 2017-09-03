package com.test;

import java.util.Arrays;

public class GraphUnionFind {

	private static class Edge implements Comparable<Edge> {
		int src, dest, weight;

		@Override
		public String toString() {
			return " src : " + src + " dest : " + dest;
		}

		@Override
		public int compareTo(Edge compare) {

			return weight - compare.weight;
		}
	}

	private static class Subset {
		int rank, parent;
	}

	private int edgeCount;

	public GraphUnionFind(int v, int e) {
		this.vertexCount = v;
		this.edgeCount = e;
		edge = new Edge[edgeCount];

		for (int i = 0; i < edge.length; i++) {
			edge[i] = new Edge();
		}
	}

	public static void main(String[] args) {

		/* Let us create the graph given in above example */
		int V = 5; // Number of vertices in graph
		int E = 8; // Number of edges in graph
		GraphUnionFind graph = new GraphUnionFind(V, E);

		// add edge 0-1 (or A-B in above figure)
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		// add edge 0-2 (or A-C in above figure)
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		// add edge 1-2 (or B-C in above figure)
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		// add edge 1-3 (or B-D in above figure)
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		// add edge 1-4 (or A-E in above figure)
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		// add edge 3-2 (or D-C in above figure)
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		// add edge 3-1 (or D-B in above figure)
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		// add edge 4-3 (or E-D in above figure)
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		graph.bellmanFord(0);

		// int V = 4; // Number of vertices in graph
		// int E = 5; // Number of edges in graph
		// GraphUnionFind graph = new GraphUnionFind(V, E);
		//
		// // add edge 0-1
		// graph.edge[0].src = 0;
		// graph.edge[0].dest = 1;
		// graph.edge[0].weight = 10;
		//
		// // add edge 0-2
		// graph.edge[1].src = 0;
		// graph.edge[1].dest = 2;
		// graph.edge[1].weight = 6;
		//
		// // add edge 0-3
		// graph.edge[2].src = 0;
		// graph.edge[2].dest = 3;
		// graph.edge[2].weight = 5;
		//
		// // add edge 1-3
		// graph.edge[3].src = 1;
		// graph.edge[3].dest = 3;
		// graph.edge[3].weight = 15;
		//
		// // add edge 2-3
		// graph.edge[4].src = 2;
		// graph.edge[4].dest = 3;
		// graph.edge[4].weight = 4;
		//
		// graph.findMinimumSpanningTreeKruskal();

		// int V = 3, E = 3;
		// GraphUnionFind graph = new GraphUnionFind(V, E);
		//
		// // add edge 0-1
		// graph.edge[0].src = 0;
		// graph.edge[0].dest = 1;
		//
		// // add edge 1-2
		// graph.edge[1].src = 1;
		// graph.edge[1].dest = 2;
		//
		// // add edge 0-2
		// graph.edge[2].src = 0;
		// graph.edge[2].dest = 2;
		//
		// graph.detectCycleUsingFindPathCompressionAndRankUnion();
	}

	private int vertexCount;
	private Edge[] edge;

	/**
	 * this assumes that graph is not containing any self loops
	 */
	public void detectCycleUnionFind() {

		// using 1D array parent to detect cycle and initialize this firstly to
		// -1

		int[] parent = new int[vertexCount];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < edgeCount; i++) {
			int srcSubset = find(parent, edge[i].src);
			int desSubset = find(parent, edge[i].dest);

			if (srcSubset == desSubset) {
				System.out.println("Cycle is there ");
				return;
			} else {
				union(parent, edge[i].src, edge[i].dest);
			}

		}

		System.out.println("No cycle is there");

	}

	public void detectCycleUsingFindPathCompressionAndRankUnion() {

		// using 1D array parent to detect cycle and initialize this firstly to
		// -1

		Subset[] subset = new Subset[vertexCount];
		for (int i = 0; i < subset.length; i++) {
			subset[i] = new Subset();
			subset[i].parent = i;
			subset[i].rank = 0;
		}

		for (int i = 0; i < edgeCount; i++) {
			int srcSubset = findUsingRank(subset, edge[i].src);
			int desSubset = findUsingRank(subset, edge[i].dest);

			if (srcSubset == desSubset) {
				System.out.println("Cycle is there ");
				return;
			}

			unionUsingPathCompression(subset, edge[i].src, edge[i].dest);

		}

		System.out.println("No cycle is there");

	}

	public int find(int[] parent, int element) {
		if (parent[element] == -1) {
			return element;
		}

		return find(parent, parent[element]);
	}

	public int findUsingRank(Subset[] parent, int element) {
		if (parent[element].parent == element) {
			return element;
		}

		return findUsingRank(parent, parent[element].parent);
	}

	public void unionUsingPathCompression(Subset[] subset, int src, int des) {
		int srcSubset = findUsingRank(subset, src);
		int desSubset = findUsingRank(subset, des);
		if (subset[srcSubset].rank < subset[desSubset].rank) {
			subset[srcSubset].parent = desSubset;
		} else if (subset[srcSubset].rank > subset[desSubset].rank) {
			subset[desSubset].parent = srcSubset;
		} else {
			subset[desSubset].parent = srcSubset;
			subset[srcSubset].rank++;
		}
	}

	public void union(int[] parent, int src, int des) {
		int srcSubset = find(parent, src);
		int desSubset = find(parent, des);
		parent[srcSubset] = desSubset;

	}

	/**
	 * Kruskal's minimum Spanning Tree algorithm
	 */
	public void findMinimumSpanningTreeKruskal() {
		Arrays.sort(edge);
		Subset[] subset = new Subset[vertexCount];

		for (int i = 0; i < subset.length; i++) {
			subset[i] = new Subset();
			subset[i].parent = i;
			subset[i].rank = 0;
		}

		Edge[] minimumSpanningTree = new Edge[vertexCount - 1];
		int index = 0;
		for (int i = 0; i < edgeCount && index <= vertexCount - 1; i++) {
			int srcRoot = findUsingRank(subset, edge[i].src);
			int desRoot = findUsingRank(subset, edge[i].dest);
			// no cycle
			if (srcRoot != desRoot) {
				minimumSpanningTree[index++] = edge[i];
				unionUsingPathCompression(subset, edge[i].src, edge[i].dest);
			}

		}

		System.out.println("Minimum Spanning Tree : ");
		System.out.println();
		for (int i = 0; i < minimumSpanningTree.length; i++) {
			System.out.println(minimumSpanningTree[i]);
		}

	}

	public void bellmanFord(int src) {
		int dist[] = new int[vertexCount];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Graph.INFINITY;
		}

		dist[src] = 0;

		// keep in mind here v-1
		for (int i = 0; i < vertexCount - 1; i++) {
			for (int j = 0; j < edge.length; j++) {
				Edge edgeOne = edge[j];
				if (dist[edgeOne.src] != Graph.INFINITY && dist[edgeOne.dest] > dist[edgeOne.src] + edgeOne.weight) {
					dist[edgeOne.dest] = dist[edgeOne.src] + edgeOne.weight;
				}
			}
		}

		// here detection in V th time for negative weight cycle
		for (int j = 0; j < edge.length; j++) {
			Edge edgeOne = edge[j];
			if (dist[edgeOne.src] != Graph.INFINITY && dist[edgeOne.dest] > dist[edgeOne.src] + edgeOne.weight) {
				System.out.println("Negative weight cycle exist ");
			}
		}

		printArr(dist, dist.length);
	}

	// A utility function used to print the solution
	void printArr(int dist[], int n) {
		System.out.println("Vertex   Distance from Sourcen");
		for (int i = 0; i < n; ++i)
			System.out.println("vertex : " + i + " distance :  " + dist[i]);
	}
}
