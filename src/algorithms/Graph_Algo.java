package algorithms;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collection;
import java.util.List;

import com.sun.corba.se.impl.orbutil.graph.NodeData;
import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{

	graph g;

	public Graph_Algo() {
		g=new DGraph();
	}


	@Override
	public void init(graph g) {
		this.g=g;

	}

	@Override
	public void init(String file_name) {


	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		List<node_data> sp = new LinkedList();
		sp.add(g.getNode(src));
		g.getNode(src).setWeight(0);
		while(!visitall()) {
			int s=smallest_node();
			node_data t = g.getNode(s);
			t.setTag(1);
			Collection<edge_data> ed= g.getE(s);
			Iterator<edge_data> it = ed.iterator();
			while(it.hasNext()) {
				edge_data eg = it.next();
				if(t.getWeight()+eg.getWeight()<g.getNode(eg.getDest()).getWeight()) {
					g.getNode(eg.getDest()).setWeight(t.getWeight()+eg.getWeight());
					g.getNode(eg.getDest()).setInfo(eg.getSrc()+"");
					
				}
			}
		}
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {


		return null;
	}
	
	
	
	
	private void upnode_inf() { 
		Collection<node_data> col = g.getV();
		Iterator<node_data> it = col.iterator();
		while(it.hasNext()) {
			it.next().setWeight(Double.POSITIVE_INFINITY);
		}

	}
	private int smallest_node() { 

		Collection<node_data> col = g.getV();
		Iterator<node_data> it = col.iterator();
		int ans = it.next().getKey();
		while(it.hasNext()) {
			if(g.getNode(ans).getWeight()>it.next().getWeight()) {
				ans=it.next().getKey();
			}
		}
		return ans;
	}
	private boolean visitall() { 
		Collection<node_data> col = g.getV();
		Iterator<node_data> it = col.iterator();
		while(it.hasNext()) {
			if(it.next().getTag()==0) {
				return false;
			}
		}
		return true;

	}


}
