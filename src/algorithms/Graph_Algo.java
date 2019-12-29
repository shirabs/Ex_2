package algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import dataStructure.DGraph;
import dataStructure.NodeData;
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
	}

	@Override
	public boolean isConnected() {
		graph temp=this.copy();
		int counterPoint=1;
		int counterPoint2=temp.getV().size();
		boolean flag=true;
		if(counterPoint2==1) {
			return true;
		}
		Stack<Integer> point=new Stack<Integer>();
		Collection<node_data> node=	temp.getV();
		Iterator<node_data> it=node.iterator();
		int run=it.next().getKey();
		while(flag){
			Collection<edge_data> edge=temp.getE(run);
			Iterator<edge_data> it2=edge.iterator();
			while(it2.hasNext()) {
				edge_data t=it2.next();
				if(!point.contains(t.getDest())) {
					point.push(t.getDest());
					counterPoint++;
				}
			}
			temp.removeNode(run);

			if(!point.isEmpty()) {
				run=point.pop();
			}
			else {
				flag=false;			
			}
		}
		if((counterPoint-counterPoint2)==0) {
			return true;
		}
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
		graph c= new DGraph();
		Collection<node_data> node=	g.getV();
		Iterator<node_data> it=node.iterator();
		while(it.hasNext()){
			c.addNode(it.next());

		}
		it=node.iterator();
		while(it.hasNext()){
			Collection<edge_data> edge=g.getE(it.next().getKey());
			if(edge==null) {
				break;
			}
			Iterator<edge_data> it2=edge.iterator();

			while(it2.hasNext()) {
				edge_data t=it2.next();
				c.connect(t.getSrc(), t.getDest(), t.getWeight());

			}

		}
		return c;
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

	public String toString() {
		return "mygraph"+ this.g;
	}
}
