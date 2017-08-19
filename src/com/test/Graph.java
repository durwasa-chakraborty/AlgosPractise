package com.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

import com.test.Graph.GraphNode;

public class Graph {

	static class GraphNode {
		public GraphNode(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}

		int dest;
		int weight;
	}

	int vertexCount;
	LinkedList<GraphNode> listArray[];
	int[] inDegree;

	public Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		listArray = new LinkedList[vertexCount];
		inDegree = new int[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			listArray[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {

		Graph g = new Graph(6);
		// g.addEdgeOneSidedorDirectedGraph(5, 2);
		// g.addEdgeOneSidedorDirectedGraph(5, 0);
		// g.addEdgeOneSidedorDirectedGraph(4, 6);
		// g.addEdgeOneSidedorDirectedGraph(6, 0);
		// g.addEdgeOneSidedorDirectedGraph(4, 1);
		// g.addEdgeOneSidedorDirectedGraph(2, 3);
		// g.addEdgeOneSidedorDirectedGraph(3, 1);

		g.addEdgeOneSidedorDirectedGraph(0, 4);
		g.addEdgeOneSidedorDirectedGraph(1, 4);
		g.addEdgeOneSidedorDirectedGraph(1, 2);
		g.addEdgeOneSidedorDirectedGraph(3, 2);
		g.addEdgeOneSidedorDirectedGraph(5, 3);
		g.addEdgeOneSidedorDirectedGraph(0, 5);

		g.topologicalSorting();

		// Graph g1 = new Graph(5);
		// g1.addEdgeTwoSidedorUndirectedGraph(1, 0, 0);
		// g1.addEdgeTwoSidedorUndirectedGraph(0, 2, 0);
		// g1.addEdgeTwoSidedorUndirectedGraph(2, 0, 0);
		// g1.addEdgeTwoSidedorUndirectedGraph(0, 3, 0);
		// g1.addEdgeTwoSidedorUndirectedGraph(3, 4, 0);
		// if (g1.isCycleInUndirectedGraphUsingDFS())
		// System.out.println("Graph contains cycle");
		// else
		// System.out.println("Graph doesn't contains cycle");
		//
		// Graph g2 = new Graph(3);
		// g2.addEdgeTwoSidedorUndirectedGraph(0, 1, 0);
		// // g2.addEdge(1, 2, 0);
		// if (g2.isCycleInUndirectedGraphUsingDFS())
		// System.out.println("Graph contains cycle");
		// else
		// System.out.println("Graph doesn't contains cycle");
	}

	public void addEdgeTwoSidedorUndirectedGraph(int src, int dest, int weight) {
		listArray[src].add(new GraphNode(dest, weight));
		listArray[dest].add(new GraphNode(src, weight));
	}

	public void addEdgeOneSidedorDirectedGraph(int src, int dest, int weight) {
		listArray[src].add(new GraphNode(dest, weight));
		inDegree[dest]++;
	}

	public void addEdgeOneSidedorDirectedGraph(int src, int dest) {
		addEdgeOneSidedorDirectedGraph(src, dest, 0);
	}

	public static int findSubsetOfElement(int i, int[] parent) {
		if (parent[i] == -1) {
			return i;
		}

		return findSubsetOfElement(parent[i], parent);
	}

	public static void union(int[] parent, int src, int dest) {
		int srcFind = findSubsetOfElement(src, parent);
		int destFind = findSubsetOfElement(dest, parent);
		parent[srcFind] = destFind;
	}

	/**
	 * this traversal assumes this is connected graph
	 * 
	 * @param src
	 */
	public void BFS(int src) {
		boolean[] visited = new boolean[vertexCount];
		Queue<Integer> queue = new LinkedList<>();
		visited[src] = true;
		queue.add(src);

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			System.out.println("Queue Polling : " + poll);

			Iterator<GraphNode> i = listArray[poll].listIterator();
			while (i.hasNext()) {
				GraphNode n = i.next();
				if (!visited[n.dest]) {
					visited[n.dest] = true;
					queue.add(n.dest);
				}
			}

		}

	}

	public void DFS(int src) {
		boolean[] visited = new boolean[vertexCount];
		System.out.println("DFS is : ");
		DFSUtil(src, visited);
	}

	public void DFSDisconnectedGraph(int src) {
		boolean[] visited = new boolean[vertexCount];
		System.out.println("DFS is : ");
		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i]) {
				DFSUtil(i, visited);
			}
		}
	}

	public void DFSUtil(int src, boolean[] visited) {
		visited[src] = true;
		System.out.print(" " + src);

		ListIterator<GraphNode> listIterator = listArray[src].listIterator();

		while (listIterator.hasNext()) {
			GraphNode node = listIterator.next();
			if (!visited[node.dest]) {
				DFSUtil(node.dest, visited);
			}

		}

	}

	public void shortestPathInABinaryWeightedGraph() {

	}

	/**
	 * for cycle detections basic logic behind this is adjacent node visited and
	 * not parent of currentNode
	 */
	private boolean isCycleInUndirectedGraphUsingDFS(boolean[] visited, int vertex, int parent) {
		visited[vertex] = true;
		ListIterator<GraphNode> listIterator = listArray[vertex].listIterator();
		while (listIterator.hasNext()) {
			GraphNode node = listIterator.next();
			if (!visited[node.dest]) {
				return isCycleInUndirectedGraphUsingDFS(visited, node.dest, vertex);
			}

			if (parent != node.dest) {
				return true;
			}

		}
		return false;
	}

	public boolean isCycleInUndirectedGraphUsingDFS() {
		boolean[] visited = new boolean[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i]) {
				if (isCycleInUndirectedGraphUsingDFS(visited, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Logic behind this is to detect back edge if node is already visited
	 * 
	 * @return
	 */
	public boolean isCycleInDirectedGraphUsinDFS() {
		boolean[] visited = new boolean[vertexCount];
		boolean[] recStack = new boolean[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			if (isCycleInDirectedGraphUsinDFS(i, visited, recStack)) {
				return true;
			}
		}

		return false;
	}

	public boolean isCycleInDirectedGraphUsinDFS(int vertex, boolean visited[], boolean recStack[]) {
		visited[vertex] = true;
		recStack[vertex] = true;
		ListIterator<GraphNode> listIterator = listArray[vertex].listIterator();
		while (listIterator.hasNext()) {
			GraphNode node = listIterator.next();
			if (!visited[node.dest] && isCycleInDirectedGraphUsinDFS(node.dest, visited, recStack)) {
				return true;
			}

			if (recStack[node.dest]) {
				return true;
			}
		}

		recStack[vertex] = false;
		return false;
	}

	public void topologicalSorting() {
		boolean visited[] = new boolean[vertexCount];
		Stack<Integer> nodeStack = new Stack<>();
		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i]) {
				topologicalSortingUtil(i, visited, nodeStack);
			}
		}

		System.out.println("print topological sorting : ");
		while (!nodeStack.isEmpty()) {
			System.out.print(" " + nodeStack.pop());
		}

	}

	private void topologicalSortingUtil(int i, boolean[] visited, Stack<Integer> nodeStack) {
		visited[i] = true;

		ListIterator<GraphNode> listIterator = listArray[i].listIterator();
		while (listIterator.hasNext()) {
			GraphNode node = listIterator.next();
			if (!visited[node.dest]) {
				topologicalSortingUtil(node.dest, visited, nodeStack);
			}
		}

		nodeStack.push(i);

	}

	/**
	 * will do this later from bookmarks tab
	 */
	public void allTopologicalSort() {

	}

}
