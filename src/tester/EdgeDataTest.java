package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructure.EdgeData;

class EdgeDataTest {

	@Test
	void testEdgeDataIntIntDouble() {
		EdgeData x=new EdgeData(22, 33,100);
		assertEquals(22,x.getSrc() );
		assertEquals(33,x.getDest() );
		assertEquals("",x.getInfo() );
		assertEquals(100,x.getWeight() );
	}

	@Test
	void testEdgeDataIntIntDoubleString() {
		EdgeData x=new EdgeData(22, 33,100,"hello");
		assertEquals(22,x.getSrc() );
		assertEquals(33,x.getDest() );
		assertEquals("hello",x.getInfo() );
		assertEquals(100,x.getWeight() );	}

	@Test
	void testGetSrc() {
		EdgeData x=new EdgeData(22, 33,100);
		assertEquals(22,x.getSrc() );

	}

	@Test
	void testGetDest() {
		EdgeData x=new EdgeData(22, 33,100);
		assertEquals(33,x.getDest() );

	}

	@Test
	void testGetWeight() {
		EdgeData x=new EdgeData(22, 33,100);
		assertEquals(100,x.getWeight() );
	}

	@Test
	void testGetInfo() {
		EdgeData x=new EdgeData(22, 33,100);
		assertEquals("",x.getInfo() );
	}

	@Test
	void testSetInfo() {
		EdgeData x=new EdgeData(22, 33,100);
		x.setInfo("hello");
		assertEquals("hello",x.getInfo() );

	}

	@Test
	void testGetTag() {
		EdgeData x=new EdgeData(22, 33,100);
		assertEquals(0,x.getTag());

	}

	@Test
	void testSetTag() {
		EdgeData x=new EdgeData(22, 33,100);
		x.setTag(2);
		assertEquals(2, x.getTag());
	}

}
