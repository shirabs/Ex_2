package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.util.Iterator;
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

	@Override
	public void init(graph g) {
		g=new DGraph();
	}

	@Override
	public void init(String file_name) {
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
	public void save(String file_name) {
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
			System.out.println(g);

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
	}

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
			Collection<edge_data> edge=g.getE(it.next().getKey());
			Iterator<edge_data> it2=edge.iterator();
			c.connect(it2.next().getSrc(), it2.next().getDest(), it2.next().getWeight());
		}
		return c;
	}

}
