package dataStructure;

import java.awt.Color;

public class EdgeData implements edge_data{

	private int src;
	private int dest;
	private String info;
	private double weight;
	private Color tag;
	
	public static Color[]color= {Color.WHITE,Color.GRAY,Color.BLACK};

	public EdgeData(int start,int end,double w) {

		src=start;
		dest=end;
		weight=w;
		info="";
	}

	public EdgeData(int start,int end,double w,String s) {

		src=start;
		dest=end;
		weight=w;
		info=s;
	}


	@Override
	public int getSrc() {

		return this.src;
	}

	@Override
	public int getDest() {

		return this.dest;
	}

	@Override
	public double getWeight() {

		return weight;
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
		if(t>=0&&t<3)
		tag=color[t];

	}
	public String toString() {
		return "src ="+this.src+ "dest ="+this.dest;
	}
}
