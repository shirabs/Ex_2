package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

class DGraphTest {
	private static graph y;

	@BeforeAll
	static void setDgraph() {
		y=buildgraph();
		graph_algorithms a=new Graph_Algo(y);
		System.out.println(a.isConnected());
	}
	public static graph buildgraph() {
		NodeData x0=new NodeData(new Point3D(11, 1, 0));
		NodeData x1=new NodeData(new Point3D(22, 10, 0));
		NodeData x2=new NodeData(new Point3D(33, 24, 0));
		NodeData x3=new NodeData(new Point3D(44, 20, 0));
		NodeData x4=new NodeData(new Point3D(55, 80, 0));
		NodeData x5=new NodeData(new Point3D(66, 40, 0));
		NodeData x6=new NodeData(new Point3D(77, 7, 0));
		NodeData x7=new NodeData(new Point3D(88, 59, 0));
//		NodeData x8=new NodeData(new Point3D(10,9, 5));

		graph y=new DGraph();
		y.addNode(x0);
		y.addNode(x1);
		y.addNode(x2);
		y.addNode(x3);
		y.addNode(x4);
		y.addNode(x5);
		y.addNode(x6);
		y.addNode(x7);
//		y.addNode(x8);

		y.connect(1, 2, 2);
		y.connect(1, 3, 5);
		y.connect(2, 3, 10);
		y.connect(2, 5, 9);
		y.connect(3, 2, 4);
		y.connect(3, 4, 7);		
		y.connect(3, 7, 3);
		y.connect(3, 5, 3);
		y.connect(4, 7, 12);
		y.connect(4, 1, 6);
		y.connect(5, 6, 5);
		y.connect(6, 3, 2);
		y.connect(6, 5, 4);
		y.connect(7, 6, 8);
		y.connect(7, 8, 10);
		return y;
	}

	@Test
	void testDGraph() {
		DGraph x=new DGraph();
	}


	@Test
	void testGetNode() {
		assertEquals(new Point3D(11, 1, 0), y.getNode(1).getLocation());

	}

	@Test
	void testGetEdge() {
		assertEquals(1, y.getEdge(1,3).getSrc());
		assertEquals(3, y.getEdge(1,3).getDest());
		assertEquals(5, y.getEdge(1,3).getWeight());
	}

	@Test
	void testAddNode() {
		NodeData node= new NodeData(new Point3D(5, 4, 0));
		y.addNode(node);
		assertEquals(y.getV().size(), y.nodeSize());
	}

	@Test
	void testConnect() {
		NodeData node= new NodeData(new Point3D(5, 4, 0));
		NodeData node2= new NodeData(new Point3D(6, 10, 0));
		y.addNode(node);
		y.addNode(node2);
		int sume=y.edgeSize();
		//can to add connect
		y.connect(node2.getKey(), node.getKey(), 5);
		assertEquals(sume+1, y.edgeSize());
		//dont can add connect
		y.connect(0, 7, 5);
		assertEquals(sume+1, y.edgeSize());
	}

	@Test
	void testGetV() {
		Collection <node_data> t= y.getV();
		for(int i=1;i<y.nodeSize();i++)
			assertEquals(true, t.contains(y.getNode(i)));
		assertEquals(t.size(), y.nodeSize());
	}

	@Test
	void testGetE() {
		int sume=0;
		for(int i=1;i<y.nodeSize();i++) {
			Collection<edge_data> e=y.getE(i);
			if(e!=null)
				sume+=e.size();
		}
		assertEquals(sume, y.edgeSize());
		Collection<edge_data> e=y.getE(9);
		assertEquals(null, e);

	}

	@Test
	void testRemoveNode() {
		Collection<node_data> allnode=y.getV();
		int t=allnode.size();
		while(t!=0) {
			y.removeNode(t);
			t--;
		}
		assertEquals(0,y.nodeSize());
	}

	@Test
	void testRemoveEdge() {
		int t=y.edgeSize();
		int m=y.getMC();
		y.removeEdge(1, 3);
		assertEquals(m+1, y.getMC());
		assertEquals(t-1, y.edgeSize());
	}

	@Test
	void testNodeSize() {
		int t=y.nodeSize();
		y.addNode(new NodeData());
		assertEquals(t+1, y.nodeSize());;
	}

	@Test
	void testEdgeSize() {
		assertEquals(15, y.edgeSize());;
	}

	@Test
	void testGetMC(){
		int mc=y.getMC();
		y.addNode(new NodeData());
		assertEquals(mc+1, y.getMC());;
	}

}
