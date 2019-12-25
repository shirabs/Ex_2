package dataStructure;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import utils.Point3D;


public class MyGui extends JFrame implements ActionListener {

	public MyGui() {
		initGUI();
	}

	private void initGUI() {

		this.setSize(700, 700);
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		menuBar.add(menu);
		this.setMenuBar(menuBar);

		MenuItem item1 = new MenuItem("load");
		item1.addActionListener(this);
		
		MenuItem item2 = new MenuItem("save");
		item2.addActionListener(this);
		
		menu.add(item1);
		menu.add(item2);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		DGraph prev = null;
		
//		for (DGraph p : ) 
//		{
//			g.setColor(Color.BLUE);
//			g.fillOval((int)p.x(), (int)p.y(), 10, 10);
//			
//			if(prev != null)
//			{
//				g.setColor(Color.RED);
//				g.drawLine((int)p.x(), (int)p.y(), 
//						(int)prev.x(), (int)prev.y());
//				
//				g.drawString("5", (int)((p.x()+prev.x())/2),(int)((p.y()+prev.y())/2));
//			}
//			
//			prev = p;
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
