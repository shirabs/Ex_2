package dataStructure;

import java.awt.Color;

import utils.Point3D;

public class NodeData implements node_data {
	public static Color[]color= {Color.WHITE,Color.GRAY,Color.BLACK};
	private Point3D location;
	public int key;
	private double weight;
	private Color tag;
	private NodeData prev;
	private String info;
	public static int id=1;

	public NodeData(Point3D locat) {
		this.location=locat;
		this.key=id;
		this.id++;
		this.weight= Double.POSITIVE_INFINITY;
		this.tag=color[0];
		this.prev=null;

	}

	@Override
	public int getKey() {
		return this.key;
	}

	@Override
	public Point3D getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(Point3D p) {
		this.location=new Point3D(p.x(), p.y(), p.z());
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(double w) {
		this.weight=w;
	}

	@Override
	public String getInfo() {
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		this.info=s;
	}

	@Override
	public int getTag() {
		if(this.tag==color[0])
			return 0;
		if(this.tag==color[1])
			return 1;
		return 2;
	}

	@Override
	public void setTag(int t) {
		if(t<3&&t>=0)
			tag=color[t];

	}

	public String toString() {
		return "key ="+ this.key+ "color ="+this.tag+ "location ="+this.location+ "wegith ="+this.weight+ "prev ="+this.prev;
	}
}
