package gui;

import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;

import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.StdDraw;

public class gui_graph {
	
	public static void drowgraph(graph g) {
		//update the range
		StdDraw.setCanvasSize();
		StdDraw.setXscale(0,100);
		StdDraw.setYscale(0,100);

		//drow point of node_location
		Collection<node_data> v =g.getV();
		Iterator<node_data> it=v.iterator();
		StdDraw.setPenRadius(0.015);
		StdDraw.setPenColor(Color.BLACK);
		while (it.hasNext()) {
			node_data node=it.next();
			double x=node.getLocation().x();
			double y=node.getLocation().y();
			StdDraw.point(x,y);
			StdDraw.textLeft(x+0.5, y+0.5, node.getKey()+"");
		}

		//drow line of edge , weight of edge and the direction of the edge 
		it=v.iterator();
		while (it.hasNext()) {
			Collection<edge_data> e =g.getE(it.next().getKey());
			if(e!=null) {
				Iterator<edge_data> it2=e.iterator();
				while (it2.hasNext()) {
					edge_data edge=it2.next();
					StdDraw.setPenRadius(0.0005);
					StdDraw.setPenColor(Color.GREEN);
					double x1=g.getNode(edge.getSrc()).getLocation().x();
					double x2=g.getNode(edge.getDest()).getLocation().x();
					double y1=g.getNode(edge.getSrc()).getLocation().y();
					double y2=g.getNode(edge.getDest()).getLocation().y();
					StdDraw.line(x1, y1, x2, y2);
					StdDraw.text((x1+x2)/2, (y1+y2)/2, edge.getWeight()+"");
					StdDraw.setPenRadius(0.01);
					StdDraw.setPenColor(Color.PINK);
					StdDraw.point((9.4*x1+0.6*x2)/10, (9.4*y1+0.6*y2)/10);
				}
			}
		}

	
	}
}
