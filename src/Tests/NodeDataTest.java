package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructure.NodeData;
import utils.Point3D;

class NodeDataTest {

	@Test
	void testNodeData() {
		Point3D p=new Point3D(12, 2, 3);
		NodeData x=new NodeData(p);
//		System.out.println(x.getKey()+"a");
		assertEquals(11,x.getKey());
		assertEquals(new Point3D(12,2,3), x.getLocation());
		assertEquals(Double.MAX_VALUE, x.getWeight());
		assertEquals(0, x.getTag());
	}

	@Test
	void testGetKey() {

		NodeData x1=new NodeData(null);
		NodeData x2=new NodeData(null);
//		System.out.println(x1.getKey()+"b");
//		System.out.println(x2.getKey()+"c");
		assertEquals(5, x1.getKey());
		assertEquals(6, x2.getKey());
	}

	@Test
	void testGetLocation() {
		Point3D p=new Point3D(1, 2, 3);
		NodeData x3=new NodeData(p);
		//System.out.println(x3.getKey()+"d");
		assertEquals(p, x3.getLocation());

	}

	@Test
	void testSetLocation() {
		Point3D p=new Point3D(1, 2, 3);
		NodeData x4=new NodeData(p);
		x4.setLocation(new Point3D(2,3,4));
		assertEquals(new Point3D(2,3,4), x4.getLocation());
	}

	@Test
	void testGetWeight() {
		Point3D p=new Point3D(1, 2, 3);
		NodeData x5=new NodeData(p);	
		assertEquals(Double.MAX_VALUE, x5.getWeight());
	}

	@Test
	void testSetWeight() {
		Point3D p=new Point3D(1, 2, 3);
		NodeData x6=new NodeData(p);
		x6.setWeight(235);
		assertEquals(235, x6.getWeight());
	}

	@Test
	void testGetInfo() {
		Point3D p=new Point3D(1, 2, 3);
		NodeData x7=new NodeData(p);
		assertEquals("", x7.getInfo());
	}

	@Test
	void testSetInfo() {
		Point3D p=new Point3D(1, 2, 3);
		NodeData x8=new NodeData(p);
		x8.setInfo("hello");
		assertEquals("hello", x8.getInfo());

	}

	@Test
	void testGetTag() {
		Point3D p=new Point3D(1, 2, 3);
		NodeData x9=new NodeData(p);
		assertEquals(0, x9.getTag());	
	}

	@Test
	void testSetTag() {
		Point3D p=new Point3D(1, 2, 3);
		NodeData x10=new NodeData(p);
		x10.setTag(1);
		assertEquals(1, x10.getTag());
	}

}
