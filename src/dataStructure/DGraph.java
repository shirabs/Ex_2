package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class DGraph implements graph{

	private HashMap<Integer,node_data> DataMap;
	private HashMap<Integer, HashMap<Integer, edge_data>> EdgeMap;
	private int countEdge=0;
	private int mc=0;

	public DGraph() {
		this.DataMap=new HashMap<Integer, node_data>();
		this.EdgeMap=new HashMap<Integer, HashMap<Integer, edge_data>>();
		this.countEdge=0;
		this.mc=0;
	}

	@Override
	public node_data getNode(int key) {
		if(this.DataMap.get(key)==null) {
			return null;
		}
		return this.DataMap.get(key);
	}


	@Override
	public edge_data getEdge(int src, int dest) {
		if(EdgeMap.get(src)!=null) {
			if(EdgeMap.containsValue(dest)) {
				return this.getEdge(src, dest);
			}
		}
		return null;
	}


	@Override
	public void addNode(node_data n) {
		int key=n.getKey();
		DataMap.put(key, (NodeData) n);
		mc++;
	}


	@Override
	public void connect(int src, int dest, double w) {

		if(this.DataMap.get(src)==null||this.DataMap.get(dest)==null) {
			System.out.println("connect faild");
		}
		else {
			EdgeData x=new EdgeData(src, dest, w);
			if(this.EdgeMap.get(src)==null) {
				this.EdgeMap.put(src,new HashMap<Integer,edge_data>());
				this.EdgeMap.get(src).put(src, x);
				countEdge++;
			}
			else {
				this.EdgeMap.get(src).put(src, x);
				countEdge++;
			}
			mc++;
		}
	}

	@Override
	public Collection<node_data> getV() {

		return this.DataMap.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		HashMap<Integer, edge_data> t= this.EdgeMap.remove(node_id);
		this.EdgeMap.put(node_id, t);
		return t.values();
	}

	@Override
	public node_data removeNode(int key) {
		node_data t= this.DataMap.remove(key);
		Collection<edge_data> rem=this.EdgeMap.remove(key).values();
		countEdge-=rem.size();
		for(int i=0;i<EdgeMap.size();i++) {
			removeEdge(i, key);
			countEdge--;
		}
		mc++;
		return t;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		mc++;
		countEdge--;
		return this.EdgeMap.get(src).remove(dest);
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return DataMap.size() ;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return this.countEdge;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return mc;
	}
	public String toString() {
		return  "the countedge ="+countEdge;
	}

}
