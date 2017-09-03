package com.test;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

import com.test.Graph.GraphNode;
import com.test.MinHeapGraph.MinHeapNode;

public class Graph {

	static class GraphNode {
		public GraphNode(int dest, int weight) {
			this.to = dest;
			this.weight = weight;
		}

		int to;
		int weight;
	}

	public static final int INFINITY = Integer.MAX_VALUE;

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

		Graph graph = new Graph(9);
		graph.addEdgeTwoSidedorUndirectedGraph(0, 1, 0);
		graph.addEdgeTwoSidedorUndirectedGraph(0, 7, 1);
		graph.addEdgeTwoSidedorUndirectedGraph(1, 7, 1);
		graph.addEdgeTwoSidedorUndirectedGraph(1, 2, 1);
		graph.addEdgeTwoSidedorUndirectedGraph(2, 3, 0);
		graph.addEdgeTwoSidedorUndirectedGraph(2, 5, 0);
		graph.addEdgeTwoSidedorUndirectedGraph(2, 8, 1);
		graph.addEdgeTwoSidedorUndirectedGraph(3, 4, 1);
		graph.addEdgeTwoSidedorUndirectedGraph(3, 5, 1);
		graph.addEdgeTwoSidedorUndirectedGraph(4, 5, 1);
		graph.addEdgeTwoSidedorUndirectedGraph(5, 6, 1);
		graph.addEdgeTwoSidedorUndirectedGraph(6, 7, 1);
		graph.addEdgeTwoSidedorUndirectedGraph(7, 8, 1);
		int src = 0;// source node
		graph.zeroOneBFS(src);

		// Graph graph = new Graph(9);
		// graph.addEdgeTwoSidedorUndirectedGraph(0, 1, 4);
		// graph.addEdgeTwoSidedorUndirectedGraph(0, 7, 8);
		// graph.addEdgeTwoSidedorUndirectedGraph(1, 2, 8);
		// graph.addEdgeTwoSidedorUndirectedGraph(1, 7, 11);
		// graph.addEdgeTwoSidedorUndirectedGraph(2, 3, 7);
		// graph.addEdgeTwoSidedorUndirectedGraph(2, 8, 2);
		// graph.addEdgeTwoSidedorUndirectedGraph(2, 5, 4);
		// graph.addEdgeTwoSidedorUndirectedGraph(3, 4, 9);
		// graph.addEdgeTwoSidedorUndirectedGraph(3, 5, 14);
		// graph.addEdgeTwoSidedorUndirectedGraph(4, 5, 10);
		// graph.addEdgeTwoSidedorUndirectedGraph(5, 6, 2);
		// graph.addEdgeTwoSidedorUndirectedGraph(6, 7, 1);
		// graph.addEdgeTwoSidedorUndirectedGraph(6, 8, 6);
		// graph.addEdgeTwoSidedorUndirectedGraph(7, 8, 7);
		// graph.dijkstraShortestPath(0);
		// graph.primsAlgorithmForMST();

		// Graph g = new Graph(6);
		// g.addEdgeOneSidedorDirectedGraph(0, 1, 5);
		// g.addEdgeOneSidedorDirectedGraph(0, 2, 3);
		// g.addEdgeOneSidedorDirectedGraph(1, 3, 6);
		// g.addEdgeOneSidedorDirectedGraph(1, 2, 2);
		// g.addEdgeOneSidedorDirectedGraph(2, 4, 4);
		// g.addEdgeOneSidedorDirectedGraph(2, 5, 2);
		// g.addEdgeOneSidedorDirectedGraph(2, 3, 7);
		// g.addEdgeOneSidedorDirectedGraph(3, 4, -1);
		// g.addEdgeOneSidedorDirectedGraph(4, 5, -2);
		//
		// g.shortestPathFromSourceToAllVerticesInDAG(1);

		// Graph g = new Graph(6);
		// g.addEdgeOneSidedorDirectedGraph(1, 2);
		// g.addEdgeOneSidedorDirectedGraph(1, 0);
		// g.addEdgeOneSidedorDirectedGraph(4, 0);
		// g.addEdgeOneSidedorDirectedGraph(4, 5);
		// g.addEdgeOneSidedorDirectedGraph(2, 3);
		// g.addEdgeOneSidedorDirectedGraph(3, 5);
		// g.topologicalSorting();

		// g.addEdgeOneSidedorDirectedGraph(0, 4);
		// g.addEdgeOneSidedorDirectedGraph(1, 4);
		// g.addEdgeOneSidedorDirectedGraph(1, 2);
		// g.addEdgeOneSidedorDirectedGraph(3, 2);
		// g.addEdgeOneSidedorDirectedGraph(5, 3);
		// g.addEdgeOneSidedorDirectedGraph(0, 5);
		//
		// g.topologicalSorting();

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
				if (!visited[n.to]) {
					visited[n.to] = true;
					queue.add(n.to);
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
			if (!visited[node.to]) {
				DFSUtil(node.to, visited);
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
			if (!visited[node.to]) {
				return isCycleInUndirectedGraphUsingDFS(visited, node.to, vertex);
			}

			if (parent != node.to) {
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
			if (!visited[node.to] && isCycleInDirectedGraphUsinDFS(node.to, visited, recStack)) {
				return true;
			}

			if (recStack[node.to]) {
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
			if (!visited[node.to]) {
				topologicalSortingUtil(node.to, visited, nodeStack);
			}
		}

		nodeStack.push(i);

	}

	/**
	 * will do this later from bookmarks tab
	 */
	public void allTopologicalSort() {
		// TODO
	}

	public void shortestPathFromSourceToAllVerticesInDAG(int src) {
		Stack<Integer> stack = topologicalSortingPractise();
		int[] distance = new int[vertexCount];

		for (int i = 0; i < distance.length; i++) {
			distance[i] = INFINITY;
		}
		distance[src] = 0;

		while (!stack.isEmpty()) {
			Integer pop = stack.pop();
			// I think it means firstly this condition search for src vertex
			// because we initialize every distance to infinity except src
			// vertex and also since topological sorted vertices in stack so
			// upto src vertex always infinity and after that only those
			// vertices are thee which are coming after src vertex
			if (distance[pop] != INFINITY) {
				Iterator<GraphNode> iterator = listArray[pop].iterator();
				while (iterator.hasNext()) {
					GraphNode node = iterator.next();
					// here checking if to vertex distance greater than from
					// vertex +weight then we need to update
					// from vertex means pop and from vertex distance is
					// distance from source to pop vertex so we are checking via
					// distance array
					if (distance[node.to] > distance[pop] + node.weight) {
						distance[node.to] = distance[pop] + node.weight;
					}
				}
			}

		}

		System.out.println("Graph.shortestPathFromSourceToAllVerticesInDAG()");

		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == INFINITY) {
				System.out.print(" INF");
			} else {
				System.out.print(" " + distance[i]);
			}
		}

	}

	public Stack<Integer> topologicalSortingPractise() {
		boolean[] visited = new boolean[vertexCount];

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < vertexCount; i++) {
			if (!visited[i]) {
				topologicalSortingUtilPractise(i, visited, stack);
			}
		}
		return stack;
	}

	private void topologicalSortingUtilPractise(int i, boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;

		ListIterator<GraphNode> listIterator = listArray[i].listIterator();
		while (listIterator.hasNext()) {
			GraphNode node = listIterator.next();
			if (!visited[node.to]) {
				topologicalSortingUtilPractise(node.to, visited, stack);
			}
		}
		stack.push(i);

	}

	private void primsAlgorithmForMST() {
		int[] parent = new int[vertexCount];
		int key[] = new int[vertexCount];

		MinHeapGraph minHeap = createMinHeap();

		for (int vertex = 1; vertex < vertexCount; vertex++) {
			parent[vertex] = -1;
			key[vertex] = INFINITY;
			// this is optimization as only all having value infinity except
			// first that is initialized after this loop so no need to run
			// minheap code for insert item
			minHeap.array[vertex] = new MinHeapNode(vertex, key[vertex]);
			minHeap.pos[vertex] = vertex;
		}

		key[0] = 0;
		parent[0] = 0;
		minHeap.array[0] = new MinHeapNode(0, key[0]);

		while (!minHeap.isEmptyHeap()) {
			MinHeapNode minHeapNode = minHeap.extractMin();
			int u = minHeapNode.vertex;

			Iterator<GraphNode> iterator = listArray[u].iterator();
			while (iterator.hasNext()) {
				GraphNode v = iterator.next();
				System.out.println(" from : " + u + " to : " + v.to);
				if (isInMinHeap(minHeap, v.to) && v.weight < key[v.to]) {
					key[v.to] = v.weight;
					parent[v.to] = u;

					// decrease key method
					minHeap.array[minHeap.pos[v.to]].key = v.weight;
					int current = minHeap.pos[v.to];
					while (current != 0 && minHeap.array[(current - 1) / 2].key > minHeap.array[current].key) {
						minHeap.pos[current] = (current - 1) / 2;
						minHeap.pos[(current - 1) / 2] = current;
						swapMinHeapNode(minHeap, (current - 1) / 2, current);
						current = (current - 1) / 2;
					}
				}
			}
		}

		System.out.println("MST is : ");
		for (int i = 1; i < key.length; i++) {
			System.out.println(" Edge : " + parent[i] + " - " + i + "  having edge weight : " + key[i]);
		}
	}

	private void printMinHepa(MinHeapGraph minHeap) {
		for (int i = 0; i < minHeap.size; i++) {
			System.out.print(" " + minHeap.array[i] + " pos : " + minHeap.pos[i]);
		}
		System.out.println();
	}

	private void printArray(int[] key) {
		for (int i = 0; i < key.length; i++) {
			System.out.print(" " + key[i]);
		}
	}

	private static void swapMinHeapNode(MinHeapGraph minHeap, int i, int current) {
		MinHeapNode temp = minHeap.array[i];
		minHeap.array[i] = minHeap.array[current];
		minHeap.array[current] = temp;
	}

	private boolean isInMinHeap(MinHeapGraph minHeap, int vertex) {
		return minHeap.pos[vertex] < minHeap.size;
	}

	private MinHeapGraph createMinHeap() {
		return new MinHeapGraph(vertexCount);
	}

	/**
	 * shortest path from source to all other vertices like prim's algo
	 */
	public void dijkstraShortestPath(int src) {
		int distance[] = new int[vertexCount];
		int parent[] = new int[vertexCount];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = INFINITY;
			parent[i] = -1;
		}

		distance[src] = 0;

		MinHeapGraph minHeapGraph = createMinHeap();

		for (int i = 0; i < vertexCount; i++) {
			minHeapGraph.array[i] = new MinHeapNode(i, INFINITY);
			minHeapGraph.pos[i] = i;
		}
		decreaseKey(minHeapGraph, src, 0);

		while (!minHeapGraph.isEmptyHeap()) {
			MinHeapNode minNode = minHeapGraph.extractMin();
			Iterator<GraphNode> iterator = listArray[minNode.vertex].iterator();
			while (iterator.hasNext()) {
				GraphNode next = iterator.next();
				if (isInMinHeap(minHeapGraph, next.to) && distance[minNode.vertex] != INFINITY
						&& distance[minNode.vertex] + next.weight < distance[next.to]) {
					distance[next.to] = distance[minNode.vertex] + next.weight;
					parent[next.to] = minNode.vertex;
					decreaseKey(minHeapGraph, minHeapGraph.pos[next.to], distance[next.to]);
				}
			}

		}

		System.out.println();
		System.out.println("Distance from source : " + src);
		for (int i = 0; i < distance.length; i++) {
			System.out.println("vertex :  " + i + " distance : " + distance[i] + " path is : " + getPath(parent, i));
		}

	}

	private String getPath(int[] parent, int i) {
		if (i == -1) {
			return " ";
		}

		return getPath(parent, parent[i]) + " " + i;
	}

	private void decreaseKey(MinHeapGraph minHeapGraph, int src, int value) {
		minHeapGraph.array[src].key = value;

		while (minHeapGraph.array[src].key < minHeapGraph.array[(src - 1) / 2].key) {
			minHeapGraph.pos[minHeapGraph.array[src].vertex] = (src - 1) / 2;
			minHeapGraph.pos[minHeapGraph.array[(src - 1) / 2].vertex] = src;
			swapMinHeapNode(minHeapGraph, src, (src - 1) / 2);
			src = (src - 1) / 2;
		}

	}

	private void zeroOneBFS(int src) {
		int[] dist = new int[vertexCount];
		int[] parent = new int[vertexCount];
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < dist.length; i++) {
			dist[i] = INFINITY;
			parent[i] = -1;
		}

		dist[src] = 0;

		deque.addFirst(src);

		while (!deque.isEmpty()) {
			Integer vertex = deque.removeFirst();
			Iterator<GraphNode> iterator = listArray[vertex].iterator();

			while (iterator.hasNext()) {
				GraphNode next = iterator.next();
				if (dist[next.to] == INFINITY) {
					if (next.weight == 0) {
						deque.addFirst(next.to);
					} else {
						deque.addLast(next.to);
					}
					dist[next.to] = dist[vertex] + next.weight;
					parent[next.to] = vertex;
				} else if (dist[next.to] > dist[vertex] + next.weight) {
					dist[next.to] = dist[vertex] + next.weight;
					parent[next.to] = vertex;
					if (next.weight == 0) {
						deque.addFirst(next.to);
					} else {
						deque.addLast(next.to);
					}
				}
			}
		}

		for (int i = 1; i < dist.length; i++) {

			System.out
					.println("vertex : : " + i + "  distance : " + dist[i] + " path  from src : " + getPath(parent, i));
		}
	}
}
