package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import utils.Point3D;

class DGraphTest {

	@Test
	void testDGraph() {
		DGraph x=new DGraph();
	}

	@Test
	void testGetNode() {
		NodeData y1=new NodeData(new Point3D(1, 23, 3));
		NodeData y2=new NodeData(new Point3D(22, 23, 33));
		NodeData y3=new NodeData(new Point3D(1, 23, 3));
		DGraph x=new DGraph();
		x.addNode(y1);
		x.addNode(y2);
		x.addNode(y3);
	}

	@Test
	void testGetEdge() {
		NodeData y4=new NodeData(new Point3D(1, 23, 3));
		NodeData y5=new NodeData(new Point3D(22, 23, 33));
		NodeData y6=new NodeData(new Point3D(1, 23, 3));
		DGraph x=new DGraph();
		x.addNode(y4);
		x.addNode(y5);
		x.addNode(y6);

		x.connect(2, 3, 2);
		x.connect(1, 3, 5);
		assertEquals(1, x.getEdge(1,3).getSrc());
		assertEquals(3, x.getEdge(1,3).getDest());
		assertEquals(5, x.getEdge(1,3).getWeight());









	}

	@Test
	void testAddNode() {
		fail("Not yet implemented");
	}

	@Test
	void testConnect() {
		fail("Not yet implemented");
	}

	@Test
	void testGetV() {
		fail("Not yet implemented");
	}

	@Test
	void testGetE() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveNode() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveEdge() {
		fail("Not yet implemented");
	}

	@Test
	void testNodeSize() {
		fail("Not yet implemented");
	}

	@Test
	void testEdgeSize() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMC() {
		fail("Not yet implemented");
	}

}
