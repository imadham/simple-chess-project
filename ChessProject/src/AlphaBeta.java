import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AlphaBeta {
	
	static String chessBoard[][]={
		{"R","K","B","Q","A","B","K","R"},//r=rock ﬁ·⁄…,k=knight Õ’«‰,q=queen Ê“Ì—,b=bishop ›Ì·,a=king „·ﬂ,p=pawn Ã‰œÌ
        {"P","P","P","P","P","P","P","P"},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"p","p","p","p","p","p","p","p"},
        {"r","k","b","q","a","b","k","r"}};
	static String temp[][]={
		{"R","K","B","Q","A","B","K","R"},//r=rock ﬁ·⁄…,k=knight Õ’«‰,q=queen Ê“Ì—,b=bishop ›Ì·,a=king „·ﬂ,p=pawn Ã‰œÌ
        {"P","P","P","P","P","P","P","P"},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "},
        {"p","p","p","p","p","p","p","p"},
        {"r","k","b","q","a","b","k","r"}};
	static int kingPosition1=0,kingPosition2=0;
	static int Depth,humanAsWhite;
	static boolean black=true,tt=true;
	static int globalDepth=2;
	static JFrame frm = new JFrame("Chess");
	public static void main(String[] args) {
		while(chessBoard[kingPosition1/8][kingPosition1%8]!="A"){kingPosition1++;}
		while(chessBoard[kingPosition2/8][kingPosition2%8]!="a"){kingPosition2++;}
		
		Timer timer = new Timer();
		System.out.println(timer);
	
	
	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Interface ui = new Interface();
	frm.add(ui);
	frm.setSize(640,640);
	frm.setResizable(false);
	frm.setVisible(true);
	
	
	
	
	Object[] option ={"Black","White"};
	humanAsWhite=JOptionPane.showOptionDialog(null, "which color ?", "Option", JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	if(humanAsWhite==1)black=false;
	
	
	 if(black){tt=true;
	long startti =System.currentTimeMillis();
		String s=(AlphaBeta.alphaBeta(-1000000,1000000,globalDepth,"",0));
		long endti =System.currentTimeMillis();
		
	//System.out.println(s);
	
	System.out.println("dgddfgg"+(endti-startti)+"ms");
	
	 AlphaBeta.makeMove(s);
	
	
	
	}
	
	
	
	//System.out.println(Rating.whiteRating(50, 2));
	
	//System.out.println(humanAsWhite);
	//System.out.println(Move.whitePawn(12));
	//String s=alphaBeta(-1000000,1000000,4,"",0);
	//System.out.println(s);
	//s=s.substring(0,0+5);
	//System.out.println(s);
	//makeMove("22 qz");
	//frm.repaint();
	//for(int i=0;i<8;i++){
	//	for(int j=0;j<8;j++)System.out.print(chessBoard[i][j]);System.out.println();}
	//makeMove(s);
	//long startti =System.currentTimeMillis();
	//makeMove(alphaBeta(-1000000,1000000,4,"",0));//makemove take first 4 char
	//long endti =System.currentTimeMillis();
	//System.out.println("dgddfgg"+(endti-startti)+"ms");
      
      
        frm.repaint();
	
	
	
	//System.out.println(rating());
    /*String g=posibleMoves();
    for(int i=1;i<g.length()/5;i++){
    	int n=5*i,a=5;
    	
    	while(a>0){System.out.print(g.charAt(n-a--));}
    	System.out.println();
    }*/
	
	}
	
	
	public static void reset(){
		
		
		for(int i=0;i<8;i++){
				for(int j=0;j<8;j++)chessBoard[i][j]=temp[i][j];
						}
		
		
		//System.out.println(chessBoard);
		frm = new JFrame("Chess");
		while(chessBoard[kingPosition1/8][kingPosition1%8]!="A"){kingPosition1++;}
		while(chessBoard[kingPosition2/8][kingPosition2%8]!="a"){kingPosition2++;}
	
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Interface ui = new Interface();
		frm.add(ui);
		frm.setSize(640,640);
		frm.setResizable(false);
		frm.setVisible(true);
		
		
		Object[] option ={"Black","White"};
		humanAsWhite=JOptionPane.showOptionDialog(null, "which color ?", "Option", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		if(humanAsWhite==1)black=false;
		
		
		 if(black){tt=true;
		long startti =System.currentTimeMillis();
			String s=(AlphaBeta.alphaBeta(-1000000,1000000,globalDepth,"",0));
			long endti =System.currentTimeMillis();
			
		//System.out.println(s);
		
		System.out.println("dgddfgg"+(endti-startti)+"ms");
		
		 AlphaBeta.makeMove(s);
		
		  frm.repaint();
		
		
		}
		
		
	}
	
	public static String alphaBeta(int alpha,int beta,int depth,String move,int player){
		
		// for(int i=0;i<8;i++){
			//	for(int j=0;j<8;j++)System.out.print(AlphaBeta.chessBoard[i][j]+"|");System.out.println();}
		
		String list;
		//3627r###########(score)
		if(tt){list=Move.whitePosibleMoves();;}
		else {list=Move.blackPosibleMoves();}
		int white= Move.whitePosibleMoves().length();
		int bla=Move.blackPosibleMoves().length();
		
		if(depth==0||list.length()==0){
			if(tt){
			return move+((-1*Rating.blackRating(bla,depth)+Rating.whiteRating(white,depth)*+1));}
		else return move+((+1*Rating.blackRating(bla,depth)+Rating.whiteRating(white,depth)*-1));}
		
	//	else if(depth==0||list.length()==0&&depth%2!=0){return move+(blackRating());}
		player=1-player;
		tt=!tt;
		for(int i=0;i<list.length();i+=5){//System.out.println("ikafjlkasfsadafafsfas"+list);
			makeMove(list.substring(i,i+5));
			
			String returnString=alphaBeta(alpha,beta,depth-1,list.substring(i,i+5),player);
			int value = Integer.valueOf(returnString.substring(5));
			
			undoMove(list.substring(i,i+5));
			
			if(player==0){
				if(value<=beta){ beta=value; if(depth==globalDepth){move = returnString.substring(0,5);}}
			}else{
				if(value>alpha){ alpha=value; if(depth==globalDepth){move = returnString.substring(0,5);}}
			}
			if(alpha>=beta){
				if(player==0){return move+beta;}else{return move+alpha;}
			}
		}
		if(player==0){ return move+beta;}else{return move+alpha;}	
	}
	
	public static void makeMove(String move){
		if(move.charAt(4)!='z'){//x1,y1,x2,y2,old
			chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))]=
					chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))];
			chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))]=" ";
			if("A".equals(chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))])){
				kingPosition1=8*Character.getNumericValue(move.charAt(2))+Character.getNumericValue(move.charAt(3));
			}
			
			if("a".equals(chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))])){
				kingPosition2=8*Character.getNumericValue(move.charAt(2))+Character.getNumericValue(move.charAt(3));
			}
			
		}else{//pro
			//column1,column2,capturedp,newp,P
			chessBoard[1][Character.getNumericValue(move.charAt(0))]=" ";
			chessBoard[0][Character.getNumericValue(move.charAt(1))]=String.valueOf(move.charAt(3));
			
		}
	}
public static void undoMove(String move){
	
		if(move.charAt(4)!='z'){//x1,y1,x2,y2,old
			chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))]=
					chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))];
			chessBoard[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))]=String.valueOf(move.charAt(4));
			if("A".equals(chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))])){
				kingPosition1=8*Character.getNumericValue(move.charAt(0))+Character.getNumericValue(move.charAt(1));
			}
			
			if("a".equals(chessBoard[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))])){
				kingPosition2=8*Character.getNumericValue(move.charAt(0))+Character.getNumericValue(move.charAt(1));
			}
			
		}else{//pro
			//column1,column2,capturedp,newp,P
			chessBoard[1][Character.getNumericValue(move.charAt(0))]="P";
			chessBoard[0][Character.getNumericValue(move.charAt(1))]=String.valueOf(move.charAt(2));
			
	}}


}