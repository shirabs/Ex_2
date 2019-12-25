package algorithms;


import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import dataStructure.NodeData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import dataStructure.DGraph;
import dataStructure.EdgeData;
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
	public void save(String file_name) {
		// TODO Auto-generated method stub
		Gson gson =new Gson();
		String json= gson.toJson(g);
		try 
		{
			PrintWriter pw = new PrintWriter(new File(file_name));
			pw.write(json);
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}

	}

	@Override
	public void init(String file_name) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		try 
		{
			FileReader reader = new FileReader(file_name);


			final TypeToken<ArrayList<graph>> requestListTypeToken = new TypeToken<ArrayList<graph>>() {};

			//			
			final RuntimeTypeAdapterFactory<graph> typeFactory = RuntimeTypeAdapterFactory
					.of(graph.class, "type") 
					.registerSubtype(DGraph.class) ;

			final Gson gson2 = new GsonBuilder().registerTypeAdapterFactory(typeFactory).create();

			final ArrayList<graph> result = gson2.fromJson(reader, requestListTypeToken.getType() );
			this.g=(graph) result;
			//			System.out.println(g);

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean isConnected() {



















		return false;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
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
			Iterator<edge_data> it2=edge.iterator();
			while(it2.hasNext()) {
				edge_data t=it2.next();
				c.connect(t.getSrc(), t.getDest(), t.getWeight());
				
			}
		}
		return c;
	}

}
