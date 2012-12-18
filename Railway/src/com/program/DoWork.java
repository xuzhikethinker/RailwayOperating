package com.program;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.program.exceptions.LogicException;
import com.program.navigation.MainMenuBar;
import com.program.navigation.MainToolBar;
import com.program.navigation.StatusBar;


public class DoWork {
	
	private static MainMenuBar menu = new MainMenuBar();
	private static MainToolBar toolBar = new MainToolBar();
	
	public static void main(String[] args) throws LogicException{
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		trySmth(frame);
		frame.setJMenuBar(menu);
		frame.add(toolBar, BorderLayout.NORTH);
		frame.add(new StatusBar(), BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	public static void trySmth(JFrame frame){
//		Graph g = new UndirectedSparseMultigraph<Nod, E>();
//		Layout l = new FRLayout( g );
//		Renderer r = new PluggableRenderContext<V, E>()
//		VisualizationViewer vv = new VisualizationViewer( l, r );
//		JFrame jf = new JFrame();
//		jf.getContentPane().add ( vv );
	}
}
