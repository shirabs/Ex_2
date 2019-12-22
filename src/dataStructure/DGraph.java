package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph{

	private HashMap<Integer,node_data> DataMap;
	private HashMap<Integer, HashMap<Integer, EdgeData>> EdgeMap;
	private int countEdge=0;
	private int mc;
	public DGraph() {
		this.DataMap=new HashMap<Integer, node_data>();
		this.EdgeMap=new HashMap<Integer, HashMap<Integer, EdgeData>>();
		this.countEdge=0;
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
		if(this.EdgeMap.get(src).get(dest)!=null) {
			return this.EdgeMap.get(src).get(dest);
		}
		return null;


	}


	@Override
	public void addNode(node_data n) {
		int key=n.getKey();
		DataMap.put(key, (NodeData) n);
	}


	@Override
	public void connect(int src, int dest, double w) {
		if(this.DataMap.get(src)==null||this.DataMap.get(dest)==null) {
			System.out.println("connect faild");
		}
		else {
			EdgeData x=new EdgeData(src, dest, w);
			if(this.EdgeMap.get(src)==null) {
				this.EdgeMap.put(src,new HashMap<Integer,EdgeData>());
				this.EdgeMap.get(src).put(dest, x);
				countEdge++;
			}
			else {
				this.EdgeMap.get(src).put(dest, x);
				countEdge++;
			}
		}
	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return this.DataMap.size();
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return this.countEdge;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String toString() {
		return  "the countedge= "+countEdge+"\n"+"   "+this.EdgeMap;

	}

}
