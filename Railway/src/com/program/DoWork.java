package com.program;

import javax.swing.JFrame;

import com.program.ruler.MainMenu;
import com.program.ruler.MainToolBar;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.visualization3d.PluggableRenderContext;


public class DoWork {
	
	private static MainMenu menu;
	private static MainToolBar toolBar;
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		trySmth(frame);
		frame.setVisible(true);
;	}
	
	public static void trySmth(JFrame frame){
//		Graph g = new UndirectedSparseMultigraph<Nod, E>();
//		Layout l = new FRLayout( g );
//		Renderer r = new PluggableRenderContext<V, E>()
//		VisualizationViewer vv = new VisualizationViewer( l, r );
//		JFrame jf = new JFrame();
//		jf.getContentPane().add ( vv );
	}
}
