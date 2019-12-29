package tester;



import java.util.Collection;
import java.util.Iterator;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
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
		NodeData x7=new NodeData(new Point3D(72, 59, 81));



		DGraph y=new DGraph();
		y.addNode(x);
		y.addNode(x1);
		y.addNode(x2);
		y.addNode(x3);
		y.addNode(x4);
		y.addNode(x5);
		y.addNode(x6);
		//y.addNode(x7);

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


		Graph_Algo a=new Graph_Algo();
		a.init(y);
		graph b=a.copy();

	//System.out.println(a);
//	System.out.println(b);
		System.out.println(a.isConnected());











		//		graph z=  a.copy();
		//		System.out.println(z);
		//		z.removeNode(1);
		//		System.out.println(y);
		//		System.out.println(z);
		//		//System.out.println(z);

		//a.save("graph y");


		//		System.out.println(y);
		//		System.out.println(y.getEdge(1,3));
		//System.out.println(x.getTag());
		//System.out.println(y.nodeSize());



		/**

		public graph copy() {
			graph c= new DGraph();
			Collection<node_data> node=	g.getV();
			Iterator<node_data> it=node.iterator();
			while(it.hasNext()){
				c.addNode(it.next());
			}

			it=node.iterator();
			while(it.hasNext()){
				Collection<edge_data> edge=g.getE(it.next().getKey());
				Iterator<edge_data> it2=edge.iterator();

				while(it2.hasNext()) {
					edge_data t=it2.next();
					c.connect(t.getSrc(), t.getDest(), t.getWeight());

				}

			}
			return c;
		}
		 */
	}

}
