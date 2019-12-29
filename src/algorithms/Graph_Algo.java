package algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import dataStructure.*;

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
	private graph g;

	public Graph_Algo() {
		g=new DGraph();
	}

	@Override
	public void init(graph g) {
		this.g=g;
	}

	@Override
	public void init(String file_name) {
		try 
		{
			FileReader reader = new FileReader(file_name);
			final TypeToken<graph> requestListTypeToken = new TypeToken<graph>() {};
			final RuntimeTypeAdapterFactory<graph> graphTypeFactory = RuntimeTypeAdapterFactory
					.of(graph.class, "type") 
					.registerSubtype(DGraph.class);

			final RuntimeTypeAdapterFactory<node_data> nodeTypeFactory = RuntimeTypeAdapterFactory
					.of(node_data.class, "type")
					.registerSubtype(NodeData.class);

			final RuntimeTypeAdapterFactory<edge_data> edgeTypeFactory = RuntimeTypeAdapterFactory
					.of(edge_data.class, "type")
					.registerSubtype(EdgeData.class);


			final GsonBuilder gson2 = new GsonBuilder();			
			final graph result2 = gson2
					.registerTypeAdapterFactory(graphTypeFactory)
					.registerTypeAdapterFactory(nodeTypeFactory)
					.registerTypeAdapterFactory(edgeTypeFactory)
					.create()
					.fromJson(reader,requestListTypeToken.getType());
			this.g= result2;
			System.out.println(result2);

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void save(String file_name) {
		GsonBuilder gson= new GsonBuilder();
		String wj= gson.create().toJson(g);
		System.out.println(wj);
		try {
			PrintWriter pw= new PrintWriter(new File(file_name));
			pw.write(wj);
			pw.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
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
		List<node_data> sp=shortestPath(src, dest);
		Iterator< node_data> it=sp.iterator();
		double ans=0;
		while(it.hasNext()) {
			ans=it.next().getWeight();
		}
		return ans;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		upnode_max_and_notvisit_and_info();
		g.getNode(src).setWeight(0);
		while(!visitall()) {
			int s=smallest_node();
			node_data ts = g.getNode(s);
			ts.setTag(1);
			Collection<edge_data> edges= g.getE(s);
			if(edges!=null) {
				Iterator<edge_data> it = edges.iterator();
				while(it.hasNext()) {
					edge_data tedge = it.next();
					if(ts.getWeight()+tedge.getWeight()<=g.getNode(tedge.getDest()).getWeight()) {
						g.getNode(tedge.getDest()).setWeight(ts.getWeight()+tedge.getWeight());
						g.getNode(tedge.getDest()).setInfo(tedge.getSrc()+"");
					}
				}
			}
		}
		List<node_data> sp = new LinkedList();
		sp.add(g.getNode(dest));
		node_data t = g.getNode(dest);
		while(t.getKey()!=src) {
			int b=Integer.parseInt(t.getInfo());
			List<node_data> tsp = new LinkedList();
			tsp.add(g.getNode(b));
			tsp.addAll(sp);
			sp=tsp;
			t=g.getNode(b);
		}
	
		return sp;
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
			if(edge==null)
				break;

			Iterator<edge_data> it2=edge.iterator();
			while(it2.hasNext()) {
				edge_data t=it2.next();
				c.connect(t.getSrc(), t.getDest(), t.getWeight());
			}
		}
		return c;
	}

	private void upnode_max_and_notvisit_and_info() { 
		Collection<node_data> col = g.getV();
		Iterator<node_data> it = col.iterator();
		while(it.hasNext()) {
			node_data t=it.next();
			t.setTag(0);
			t.setInfo("");
			t.setWeight(Double.MAX_VALUE);

		}

	}
	private int smallest_node() { 
		Collection<node_data> col = g.getV();
		Iterator<node_data> it = col.iterator();
		node_data ans=it.next();
		it=col.iterator();
		
		while (it.hasNext()) {
			node_data temp= it.next();
			if(temp.getTag()==0) {
				ans=temp;
				break;
			}
		}
		while(it.hasNext()) {
			node_data t = it.next();
			if(t.getWeight()<ans.getWeight()&&t.getTag()==1) {
				ans=t;
			}
		}
		return ans.getKey();
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
