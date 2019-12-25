package tester;



import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.graph;
import utils.Point3D;

public class TestForMe {

	public static void main(String[] args) {



		NodeData x=new NodeData(new Point3D(1, 23, 3));
		NodeData x1=new NodeData(new Point3D(22, 23, 33));
		NodeData x2=new NodeData(new Point3D(33, 24, 344));
		NodeData x3=new NodeData(new Point3D(44, 25, 33));
		NodeData x4=new NodeData(new Point3D(55, 27, 32));
		NodeData x5=new NodeData(new Point3D(66, 28, 335));
		NodeData x6=new NodeData(new Point3D(77, 29, 31));



		DGraph y=new DGraph();
		y.addNode(x);
		y.addNode(x1);
		y.addNode(x2);
		y.addNode(x3);
		y.addNode(x4);
		y.addNode(x5);
		y.addNode(x6);

		y.connect(1, 2, 2);
		y.connect(1, 3, 3);
		y.connect(2, 3, 10);
		y.connect(2, 1, 4);
		y.connect(2, 5, 9);
		y.connect(3, 4, 7);		
		y.connect(3, 7, 3);
		y.connect(3, 5, 3);
		y.connect(4, 7, 12);
		y.connect(4, 1, 6);
		y.connect(5, 6, 5);
		y.connect(6, 3, 2);
		y.connect(6, 5, 4);
		y.connect(7, 6, 8);

		Graph_Algo a=new Graph_Algo();
		a.init(y);
		graph z=  a.copy();
		System.out.println(z);

		z.removeNode(1);
		System.out.println(y);
		System.out.println(z);
		//System.out.println(z);
		
//		a.save("graph y");
		










		//		System.out.println(y);
		//		System.out.println(y.getEdge(1,3));
		//System.out.println(x.getTag());
		//System.out.println(y.nodeSize());

		//		EdgeData y=new EdgeData(x, x1, 2);
		//		EdgeData y1=new EdgeData(x, x2, 3);
		//		EdgeData y2=new EdgeData(x, x3, 4);
		//		EdgeData y3=new EdgeData(x1, x2, 3);
		//		EdgeData y4=new EdgeData(x3, x2, 2);
		//		EdgeData y5=new EdgeData(x1, x4, 5);
		//		EdgeData y6=new EdgeData(x2, x5, 6);
		//		EdgeData y7=new EdgeData(x3, x6, 9);
		//		EdgeData y8=new EdgeData(x4, x5, 2);
		//		EdgeData y9=new EdgeData(x6, x5, 7);
		//		EdgeData y10=new EdgeData(x4, x7, 1);
		//		EdgeData y11=new EdgeData(x5, x7, 3);






	}

}