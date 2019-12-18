package dataStructure;

import java.awt.Color;

import utils.Point3D;

public class NodeData implements node_data {

	private Point3D p;
	private double weight;
	private Color c;
	private NodeData prev;
	public static int id=1;
	
	public NodeData() {


	}

	@Override
	public int getKey() {


		return 0;
	}

	@Override
	public Point3D getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLocation(Point3D p) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWeight(double w) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub

	}

}
