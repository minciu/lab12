package lab12;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.Random;

import javax.swing.JPanel;

public class DesignPanel extends JPanel{
	
	private Graphics2D canvas;
	private int forms;
	
	
	private void drawShapeAt(int x, int y) {
        Random rand = new Random();
        canvas.setColor(new Color(rand.nextInt(0xFFFFFF)));
        canvas.fill((Shape) new RegularPolygon(x, y, rand.nextInt((30 - 5) +1) +5, forms));
        float dash1[] = {10.0f};
        BasicStroke dashed =
                new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
        canvas.setStroke(dashed);

    }

	
	public class RegularPolygon extends Polygon {
	    public RegularPolygon(int x0, int y0, int radius, int sides) {
	        double alpha = 2 * Math.PI / sides;
	        for (int i = 0; i < sides; i++) {
	            double x = x0 + radius * Math.cos(alpha * i);
	            double y = y0 + radius * Math.sin(alpha * i);
	            this.addPoint((int) x, (int) y);
	        }
	    }
}}
