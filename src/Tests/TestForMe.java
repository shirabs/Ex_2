package Tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

		
		NodeData x=new NodeData(new Point3D(11, 1, 0));
		NodeData x1=new NodeData(new Point3D(22, 10, 0));
		NodeData x2=new NodeData(new Point3D(33, 24, 0));
		NodeData x3=new NodeData(new Point3D(44, 20, 0));
		NodeData x4=new NodeData(new Point3D(55, 80, 0));
		NodeData x5=new NodeData(new Point3D(66, 40, 0));
		NodeData x6=new NodeData(new Point3D(77, 7, 0));
		NodeData x7=new NodeData(new Point3D(88, 59, 0));
		//NodeData x8=new NodeData(new Point3D(10,9, 5));

		DGraph y=new DGraph();
		y.addNode(x);
		y.addNode(x1);
		y.addNode(x2);
		y.addNode(x3);
		y.addNode(x4);
		y.addNode(x5);
		y.addNode(x6);
		y.addNode(x7);
		//y.addNode(x8);

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
		y.connect(5, 6, 1);
		y.connect(6, 3, 2);
		y.connect(6, 5, 4);
		y.connect(7, 6, 8);
		y.connect(7, 8, 10);




		Graph_Algo a=new Graph_Algo();
		a.init(y);
		ArrayList<Integer> targets=new ArrayList<Integer>();
		targets.add(1);
		targets.add(6);
		targets.add(7);
		targets.add(2);
		targets.add(5);



		//System.out.println(a);
//		System.out.println(a.shortestPath(1, 8));
//		System.out.println(a.shortestPathDist(1, 8));

//		System.out.println(a);
//		System.out.println(a.shortestPath(1, 8));
//		System.out.println(a.shortestPathDist(1, 8));


//		System.out.println(a.TSP(targets));
		//System.out.println(a);
				//	System.out.println(a.shortestPath(6,7 ));
			//	System.out.println(a.shortestPathDist(6,7 ));


		//		graph z=  a.copy();
		//		System.out.println(z);
		//		z.removeNode(1);
		//		System.out.println(y);
		//		System.out.println(z);
		//		//System.out.println(z);


//		System.out.println(a.isConnected());

		//System.out.println(a.isConnected());

		//
//				a.save("graph y");
//				Graph_Algo b=new Graph_Algo();
//				b.init("graph y");
//				System.out.println(b);


		//System.out.println(a);
		//		graph z=  a.copy();
		//		System.out.println(z);
		//		z.removeNode(1);
		//		System.out.println(y);
		//		System.out.println(z);
		//		//System.out.println(z);



		//		a.save("graph y");
		//		Graph_Algo b=new Graph_Algo();
		//		b.init("graph y");
		//		System.out.println(b);



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
	}
	/*
	 * 
		}

		it1=tar1.iterator();
		ArrayList<NodeData> temp=new ArrayList<NodeData>();
		while(it1.hasNext()) {
			if(tar2.contains(it1.next())) {
				tar2.remove(0);
				it2=tar2.iterator();
			}
			double y=Double.POSITIVE_INFINITY;
			int counter=0;

			while(it2.hasNext()) {
				//System.out.println(it2.next());
				System.out.println(y);
	//-------->			
				if(shortestPathDist(it1.next().intValue(), it2.next().intValue())<y) {
					y=shortestPathDist(it1.next(), it2.next());
					counter=it2.next();	

				}
			}
			List<node_data> mylist=shortestPath(it1.next(), counter);
			Iterator<node_data> it=mylist.iterator();
			while(it.hasNext()) {
				temp.add((NodeData) it.next());
				if(tar1.contains(it.next().getKey())) {
					tar1.remove(it.next().getKey());
					tar2.remove(it.next().getKey());
					it1=tar1.iterator();
					it2=tar2.iterator();
				}
			}
			it1=tar1.iterator();
			it2=tar2.iterator();

		}

	 */


}
