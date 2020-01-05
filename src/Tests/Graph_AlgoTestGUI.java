

package Tests;

import org.junit.jupiter.api.Test;
import algorithms.*;
import dataStructure.*;
import gui.gui_graph;
import utils.Point3D;


class Graph_AlgoTestGUI {
	public static void main(String[] args) {
		
	graph y=buildgraph();
	graph_algorithms a= new Graph_Algo(y);
	gui_graph.drowgraph(y);
	}
	private static graph buildgraph() {

		NodeData x=new NodeData(new Point3D(11, 1, 0));
		NodeData x1=new NodeData(new Point3D(22, 10, 0));
		NodeData x2=new NodeData(new Point3D(33, 24, 0));
		NodeData x3=new NodeData(new Point3D(44, 20, 0));
		NodeData x4=new NodeData(new Point3D(55, 80, 0));
		NodeData x5=new NodeData(new Point3D(66, 40, 0));
		NodeData x6=new NodeData(new Point3D(77, 7, 0));
		NodeData x7=new NodeData(new Point3D(88, 59, 0));
		NodeData x8=new NodeData(new Point3D(10,9, 5));

		DGraph y=new DGraph();
		y.addNode(x);
		y.addNode(x1);
		y.addNode(x2);
		y.addNode(x3);
		y.addNode(x4);
		y.addNode(x5);
		y.addNode(x6);
		y.addNode(x7);
		y.addNode(x8);

		y.connect(1, 2, 2);
		y.connect(1, 3, 3);
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
	void test() {
		//		fail("Not yet implemented");
	}




}
