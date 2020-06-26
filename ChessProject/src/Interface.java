import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Interface extends JPanel implements MouseListener ,MouseMotionListener,ComponentListener,ActionListener {
	static int squareSize=64;
	static boolean im=true;
	static int mouseX,mouseY,newMouseX,newMouseY;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.RED);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addComponentListener(this);
		//this.removeMouseMotionListener(this);
		JButton b1 = new JButton("restart");
		
		b1.setVerticalTextPosition(AbstractButton.CENTER);
	    b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
		
		 b1.addActionListener(this);
		 this.add(b1);
		 
		 JLabel label1;
		 
		 ImageIcon gg = new ImageIcon("gif1.gif");
		 
		 
		 Image img = gg.getImage();
		 Image newimg = img.getScaledInstance(64, 64,  java.awt.Image.SCALE_SMOOTH);
		 gg = new ImageIcon(newimg);
		 
		 
		 label1 = new JLabel("playing",
		                     gg,
		                     JLabel.RIGHT);
		 
	        add(label1);


		 
		 
		 
		 
		 
		boolean z;
		for(int i=1;i<9;i++){if(i%2==0)z=false;
		else z=true;
			for(int j=1;j<9;j++){
				if(z){g.setColor(new Color(200,200,200));z=false;}
				else{g.setColor(new Color(50,50,50));z=true;}
				g.fillRect(j*squareSize, i*squareSize,squareSize , squareSize);}}
			
				Image wk,wq,wr,wb,wp,wkk;
				Image bk,bq,br,bb,bp,bkk;
				wk = new ImageIcon("wk.png").getImage();
				wq = new ImageIcon("wq.png").getImage();
				wr = new ImageIcon("wr.png").getImage();
				wb = new ImageIcon("wb.png").getImage();
				wp = new ImageIcon("wp.png").getImage();
				wkk = new ImageIcon("wkk.png").getImage();
				bk = new ImageIcon("bk.png").getImage();
				bq = new ImageIcon("bq.png").getImage();
				br = new ImageIcon("br.png").getImage();
				bb = new ImageIcon("bb.png").getImage();
				bp = new ImageIcon("bp.png").getImage();
				bkk = new ImageIcon("bkk.png").getImage();
				
				for(int i=0;i<64;i++){
					
					 switch (AlphaBeta.chessBoard[i/8][i%8]){
					 case"P": g.drawImage(bp, (i%8+1)*(squareSize), (i/8+1)*(squareSize), null);
					 break;
					 case"p": g.drawImage(wp, (i%8+1)*(squareSize), (i/8+1)*(squareSize), null);
					 break;
					 case"R": g.drawImage(br, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 case"r": g.drawImage(wr, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 case"K": g.drawImage(bkk, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 case"k": g.drawImage(wkk, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 case"B": g.drawImage(bb, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 case"b": g.drawImage(wb, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 case"Q": g.drawImage(bq, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 case"q": g.drawImage(wq, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 case"A": g.drawImage(bk, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 case"a": g.drawImage(wk, (i%8+1)*squareSize, (i/8+1)*squareSize, null);
					 break;
					 }
				
					 
					//	 g.drawImage(img, (i%8)*squareSize, (i/8)*squareSize, (i%8+1)*squareSize,(i/8+1)*squareSize,j*64,k*64,(j+1)*64,(k+1)*64,this);
			}
}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {if(e.getX()<10*squareSize&&e.getY()<10*squareSize&&e.getX()>1*squareSize&&e.getY()>1*squareSize){
		mouseX=e.getX();
		mouseY=e.getY();
		repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {//try{
		
		
		
		if(e.getX()<10*squareSize&&e.getY()<10*squareSize&&e.getX()>1*squareSize&&e.getY()>1*squareSize){
			newMouseX=e.getX();
			newMouseY=e.getY();
			
			String dragMove="";
			if(e.getButton()==MouseEvent.BUTTON1){
				if(newMouseY/squareSize==1&&mouseY/squareSize==2&&"P".equals(AlphaBeta.chessBoard[mouseY/squareSize][mouseX/squareSize])){
					//pawn pro
					 dragMove+=-1+mouseX/squareSize-1+newMouseX/squareSize+AlphaBeta.chessBoard[-1+newMouseY/squareSize][-1+newMouseX/squareSize]+"QZ";
	//System.out.print("imadddddd");
				}else{
					//move regular
					 dragMove=""+(-1+mouseY/squareSize)+""+(-1+mouseX/squareSize)+(-1+newMouseY/squareSize)+(-1+newMouseX/squareSize)+AlphaBeta.chessBoard[-1+newMouseY/squareSize][-1+newMouseX/squareSize];
				
				}
				
			//	System.out.println("drag;"+dragMove);
			}
			
				String userPosibilities;
				if(AlphaBeta.black){userPosibilities=Move.blackPosibleMoves();}
				else userPosibilities=Move.whitePosibleMoves();

				//for(int i=0;i<8;i++){
					//	for(int j=0;j<8;j++)System.out.print(AlphaBeta.chessBoard[i][j]+"|");System.out.println();}
				
				//System.out.println("black: "+Move.blackPosibleMoves());
				
			//	System.out.println("user: "+userPosibilities);
				if(userPosibilities.replaceAll(dragMove,"").length()<userPosibilities.length()){
					//valid move
				//	System.out.println("ijfskdlnvkldsjsv;");
					AlphaBeta.makeMove(dragMove);
				//	AlphaBetaChess.rep();
				
				//	  for(int i=0;i<8;i++){
					//		for(int j=0;j<8;j++)System.out.print(AlphaBeta.chessBoard[i][j]+"|");System.out.println();}
					
					
				//String temp [] []=AlphaBeta.chessBoard;
					String s = null;
	                if(AlphaBeta.black){AlphaBeta.tt=true;
	                s=(AlphaBeta.alphaBeta(-1000000,1000000,AlphaBeta.globalDepth,"",0));}
	                else {AlphaBeta.tt=false;
	                	s=(AlphaBeta.alphaBeta(-1000000,1000000,AlphaBeta.globalDepth,"",0));
	                }
	               //    s=s.substring(0,0+5);
	             //    System.out.println("ssss: "+s);
	                 
	             
	                 
	                 
	               //  System.out.println("aaa"+a);
	                   //AlphaBeta.chessBoard=temp;
	                   AlphaBeta.makeMove(s);
	         //         
	                   
					repaint();

				}
			
		}

	//}catch(Exception a){JOptionPane.showMessageDialog(getComponentPopupMenu(), "check mate");System.exit(0);}
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void componentHidden(ComponentEvent a) {}
    public void componentMoved(ComponentEvent a) {}
    public void componentShown(ComponentEvent a) {}
    
    public void componentResized(ComponentEvent a) {
        Dimension newSize = a.getComponent().getBounds().getSize(); 
        int hh=newSize.height;
        int ww=newSize.width;
        int xx=Math.min(hh,ww);
    xx=xx/10;
    squareSize=xx;
    

	
	//System.out.println(newSize);
    }

    
    public void actionPerformed(ActionEvent b) {AlphaBeta.frm.setVisible(false);
	//start=5;
	//end =9;
	//hi=squareSize;
	//we=hi;
	repaint();

AlphaBeta.reset();
	
}
    
    
    protected static ImageIcon createImageIcon(String path,
            String description) {
java.net.URL imgURL = Interface.class.getResource(path);
if (imgURL != null) {
return new ImageIcon(imgURL, description);
} else {
System.err.println("Couldn't find file: " + path);
return null;
}
}
    
    
    
    
    
	
}