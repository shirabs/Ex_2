package dataStructure;

import java.awt.Color;

public class EdgeData implements edge_data{

	private NodeData src;
	private NodeData dest;
	private String info;
	private int weight;
	private Color tag;
	
	public static Color[]color= {Color.WHITE,Color.GRAY,Color.BLACK};

	public EdgeData(NodeData start,NodeData end,int w) {

		src=start;
		dest=end;
		weight=w;
		info="";
	}

	public EdgeData(NodeData start,NodeData end,int w,String s) {

		src=start;
		dest=end;
		weight=w;
		info=s;
	}


	@Override
	public int getSrc() {

		return src.getKey();
	}

	@Override
	public int getDest() {

		return dest.getKey();
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

}
