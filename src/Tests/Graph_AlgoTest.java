package Tests;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.graph;
import dataStructure.node_data;

class Graph_AlgoTest {

	private static graph_algorithms ga;

	@BeforeAll
	static void testInitGraph() {
		ga=new Graph_Algo(DGraphTest.buildgraph());
	}
	@Test	
	void testSave() {
		ga.save("graph");
	}
	
	@Test
	void testInitString(){
		graph_algorithms gt=new Graph_Algo();
		gt.init("graph y");
		gt.equals(ga);
	}

	@Test
	void testIsConnect() {
		assertEquals(true, ga.isConnected());
	}
	
	@Test
	void testShortestPathDist() {
		assertEquals(ga.shortestPathDist(6, 3), 2);
	}
	
	@Test
	void testShortestPath() {
		assertEquals(ga.shortestPath(5, 2).size(), 4);
	}
	
	@Test
	void testTSP() {
		List< Integer> t=new LinkedList<Integer>(); 
		t.add(1);
		t.add(5);
		t.add(7);
		List<node_data> a=ga.TSP(t);
		assertEquals(true,a.size()>=3);
	}

	@Test
	void testCopy() {
		graph y=ga.copy();
		graph t=DGraphTest.buildgraph();
		assertEquals(false,t.equals(y));

	}
	



}
