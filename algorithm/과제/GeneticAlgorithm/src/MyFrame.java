import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame {

 MyFrame(String title, LinearFuct bestFit) {

 super(title);

 setSize(700,700);

 setDefaultCloseOperation(EXIT_ON_CLOSE);

 makeUI(bestFit);

 setVisible(true);

 }

 private void makeUI(LinearFuct bestFit) {

 MyPanel p = new MyPanel(bestFit);

 add(p, BorderLayout.CENTER);

 }

}


class MyPanel extends JPanel {
	LinearFuct bestFit;
	
	public MyPanel(LinearFuct bestFit) {
		this.bestFit=bestFit;
	}
	
 protected void paintComponent(Graphics g) {


    Graphics2D g2=(Graphics2D)g;
 
    float dash0[] = {1,0f}; 
    float dash3[] = {3,3f}; 

    g2.translate(0, 0); 
 

   g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash3,0));


    for (int i=-600; i<=600; i = i+20) {

    g2.draw(new Line2D.Float(-600, i, 600, i));     // x축과 평행선을 그린다.

    }
    for (int j=-600; j<=600; j = j+20) {

    g2.draw(new Line2D.Float(j, -600, j, 600));     // y축과 평행선을 그린다.


    }
 
 
 g2.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,1,dash0,0));


   g2.draw(new Line2D.Float(-600, 0, 600, 0));     // x축을 그린다.
 
    g2.draw(new Line2D.Float(0, -600, 0, 600));     // y축을 그린다.
 

   g2.setColor(Color.RED);


   for ( int i=0, radius=2; i<Data.OECDname.length; i++ ) {  
	   
	   g2.fillOval((int)(Data.OECDhyperInternet[i]-10)*10, 600-(int)(Data.OECDinternet[i]-60)*10, radius*2, radius*2);

	   }
   
   int a=bestFit.useA();
   int b=bestFit.useB();
   
   int dx, dy;
   int sy=a*10+b;
   
   sy=600-(sy-60)*10;
   
   dx=((120-b)/a-10)*10;
   dy=(1200-(a*70+b)*10);
   
   g2.setColor(Color.BLUE);
   
   if(dx>600)
	   g2.draw(new Line2D.Float(0, sy, 600, dy));
	else
		g2.draw(new Line2D.Float(0, sy, dx, 0));
	
 

 }
}
