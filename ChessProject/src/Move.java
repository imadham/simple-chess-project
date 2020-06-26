
public class Move {
	//static String[][] chessBoard=AlphaBeta.chessBoard;
//static int kingPosition1=AlphaBeta.kingPosition1;
//static int kingPosition2=AlphaBeta.kingPosition2;
static int forKing[]={-9,-8,-7,-1,0,1,7,8,9};
static boolean lbr=true,rbr=true,lwr=true,rwr=true,bk=true,wk=true;
	public static String blackPosibleMoves() {
		
		/* for(int i=0;i<8;i++){
    		for(int j=0;j<8;j++)System.out.print(AlphaBeta.chessBoard[i][j]+" ");System.out.println();}   **/
		
		 String list="";
		 for (int i=0;i<64;i++){
			 switch (AlphaBeta.chessBoard[i/8][i%8]){
			 case"Q": list+=blackQueen(i);
			 break;
			 case"R": {list+=blackRock(i);}
			 break;
			 case"B": list+=blackBishop(i);
			 break;
			 case"K": list+=blackKnight(i);
			 break;
			 case"P": list+=blackPawn(i);
			 break;
			 case"A": list+=blackKing(i);
			 break;
			 }
			// if(i==4&&bk)list+=blackcast();
		 }
		//System.out.println("list="+list);
	        return list;//x1,y1,x2,y2,ÇáÞØÚÉ ÇáãÇÎæÐÉ
	    }
	
	private static String blackcast() {String list="";
		if(lbr)list+="0040H";
		if(rbr)list+="7040H";
		return list;
	}

	public static String whitePosibleMoves() {
		 String list="";
		 for (int i=0;i<64;i++){
			 switch (AlphaBeta.chessBoard[i/8][i%8]){
			 case"q": list+=whiteQueen(i);
			 break;
			 case"r": list+=whiteRock(i);
			 break;
			 case"b": list+=whiteBishop(i);
			 break;
			 case"k": list+=whiteKnight(i);
			 break;
			 case"p": list+=whitePawn(i);
			 break;
			 case"a": list+=whiteKing(i);
			 break;
			 
			 }
			// if(i==60&&wk)list+=whitecast();
		 }
	        return list;//x1,y1,x2,y2,ÇáÞØÚÉ ÇáãÇÎæÐÉ
	    }
	
	
	private static String whitecast() {String list="";
	if(lwr)list+="0747H";
	if(rwr)list+="7747H";
	return list;
	}

	public static String blackRock(int i){
		 String list="",oldPiece;
		 int temp = 1;
		 int r=i/8,c=i%8;
		 for(int j=-1;j<=1;j+=2){
			try{
		//		for(int e=0;e<8;e++){
		//			for(int f=0;f<8;f++)System.out.print(AlphaBeta.chessBoard[e][f]+":");System.out.println();}
			//	System.out.println(r);
			//	System.out.println(c);
				
		//		System.out.println(c+temp*j);
				
				while(AlphaBeta.chessBoard[r][(c+temp*j)].equals(" ")){
					oldPiece=AlphaBeta.chessBoard[r][c+temp*j];
					AlphaBeta.chessBoard[r][c]=" ";
					AlphaBeta.chessBoard[r][c+temp*j]="R";
					if(kingSafe()){
						 list=list+r+c+(r)+(c+temp*j)+oldPiece;
					 }
					AlphaBeta.chessBoard[r][c]="R";
					AlphaBeta.chessBoard[r][c+temp*j]=oldPiece;
					temp++;
				}
				 if(Character.isLowerCase(AlphaBeta.chessBoard[r][c+temp*j].charAt(0))){
					 oldPiece=AlphaBeta.chessBoard[r][c+temp*j];
					 AlphaBeta.chessBoard[r][c]=" ";
					 AlphaBeta.chessBoard[r][c+temp*j]="R";
						if(kingSafe()){
							 list=list+r+c+(r)+(c+temp*j)+oldPiece;
						 }
						AlphaBeta.chessBoard[r][c]="R";
						AlphaBeta.chessBoard[r][c+temp*j]=oldPiece;
						
				 }
			}catch (Exception e){} 
			 
			temp=1;
			 try{
					while(AlphaBeta.chessBoard[r+temp*j][c].equals(" ")){
						oldPiece=AlphaBeta.chessBoard[r+temp*j][c];
						AlphaBeta.chessBoard[r][c]=" ";
						AlphaBeta.chessBoard[r+temp*j][c]="R";
						if(kingSafe()){
							 list=list+r+c+(r+temp*j)+(c)+oldPiece;
						 }
						AlphaBeta.chessBoard[r][c]="R";
						AlphaBeta.chessBoard[r+temp*j][c]=oldPiece;
						temp++;
					}
					 if(Character.isLowerCase(AlphaBeta.chessBoard[r+temp*j][c].charAt(0))){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c];
							AlphaBeta.chessBoard[r][c]=" ";
							AlphaBeta.chessBoard[r+temp*j][c]="R";
							if(kingSafe()){
								 list=list+r+c+(r+temp*j)+(c)+oldPiece;
							 }
							AlphaBeta.chessBoard[r][c]="R";
							AlphaBeta.chessBoard[r+temp*j][c]=oldPiece;
							
					 }
				}catch (Exception e){} 
			 temp=1; 
		 }
		
		 
		 return list;
		 
	 }
	
	public static String whiteRock(int i){
		 String list="",oldPiece;
		 int temp = 1;
		 int r=i/8,c=i%8;
		 for(int j=-1;j<=1;j+=2){
			try{
				while(AlphaBeta.chessBoard[r][c+temp*j].equals(" ")){
					oldPiece=AlphaBeta.chessBoard[r][c+temp*j];
					AlphaBeta.chessBoard[r][c]=" ";
					AlphaBeta.chessBoard[r][c+temp*j]="r";
					if(wkingSafe()){
						 list=list+r+c+(r)+(c+temp*j)+oldPiece;
					 }
					AlphaBeta.chessBoard[r][c]="r";
					AlphaBeta.chessBoard[r][c+temp*j]=oldPiece;
					temp++;
				}
				 if(Character.isUpperCase(AlphaBeta.chessBoard[r][c+temp*j].charAt(0))){
					 oldPiece=AlphaBeta.chessBoard[r][c+temp*j];
						AlphaBeta.chessBoard[r][c]=" ";
						AlphaBeta.chessBoard[r][c+temp*j]="r";
						if(wkingSafe()){
							 list=list+r+c+(r)+(c+temp*j)+oldPiece;
						 }
						AlphaBeta.chessBoard[r][c]="r";
						AlphaBeta.chessBoard[r][c+temp*j]=oldPiece;
						
				 }
			}catch (Exception e){} 
			 
			temp=1;
			 try{
					while(AlphaBeta.chessBoard[r+temp*j][c].equals(" ")){
						oldPiece=AlphaBeta.chessBoard[r+temp*j][c];
						AlphaBeta.chessBoard[r][c]=" ";
						AlphaBeta.chessBoard[r+temp*j][c]="r";
						if(wkingSafe()){
							 list=list+r+c+(r+temp*j)+(c)+oldPiece;
						 }
						AlphaBeta.chessBoard[r][c]="r";
						AlphaBeta.chessBoard[r+temp*j][c]=oldPiece;
						temp++;
					}
					 if(Character.isUpperCase(AlphaBeta.chessBoard[r+temp*j][c].charAt(0))){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c];
							AlphaBeta.chessBoard[r][c]=" ";
							AlphaBeta.chessBoard[r+temp*j][c]="r";
							if(wkingSafe()){
								 list=list+r+c+(r+temp*j)+(c)+oldPiece;
							 }
							AlphaBeta.chessBoard[r][c]="r";
							AlphaBeta.chessBoard[r+temp*j][c]=oldPiece;
							
					 }
				}catch (Exception e){} 
			 temp=1; 
		 }
		 return list;
		 
	 }
	
	
	
	
	public static String blackBishop(int i){
		 String list="",oldPiece;
		 int r=i/8,c=i%8;
		 int temp=1;
		 for(int j=-1;j<=1;j+=2){
			 
			 for(int k=-1;k<=1;k+=2){
				 try {
					 while(AlphaBeta.chessBoard[r+temp*j][c+temp*k].equals(" ")){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c+temp*k];
						 AlphaBeta.chessBoard[r][c]=" ";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]="B";
						 if(kingSafe()){
							 list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
						 }
						 AlphaBeta.chessBoard[r][c]="B";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]=oldPiece;
						 
					temp++;	 
					 }
					 if(Character.isLowerCase(AlphaBeta.chessBoard[r+temp*j][c+temp*k].charAt(0))){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c+temp*k];
						 AlphaBeta.chessBoard[r][c]=" ";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]="B";
						 if(kingSafe()){
							 list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
						 }
						 AlphaBeta.chessBoard[r][c]="B";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]=oldPiece;
						 
					 
						 
						 
						 
					 }
					 
					 
					 
					 
				 }catch(Exception e){}
				 temp=1;	
			 }
		 }
		 return list;
		 
	 
	 }
	
	
	public static String whiteBishop(int i){
		 String list="",oldPiece;
		 int r=i/8,c=i%8;
		 int temp=1;
		 for(int j=-1;j<=1;j+=2){
			 
			 for(int k=-1;k<=1;k+=2){
				 try {
					 while(AlphaBeta.chessBoard[r+temp*j][c+temp*k].equals(" ")){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c+temp*k];
						 AlphaBeta.chessBoard[r][c]=" ";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]="b";
						 if(wkingSafe()){
							 list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
						 }
						 AlphaBeta.chessBoard[r][c]="b";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]=oldPiece;
						 
					temp++;	 
					 }
					 if(Character.isUpperCase(AlphaBeta.chessBoard[r+temp*j][c+temp*k].charAt(0))){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c+temp*k];
						 AlphaBeta.chessBoard[r][c]=" ";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]="b";
						 if(wkingSafe()){
							 list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
						 }
						 AlphaBeta.chessBoard[r][c]="b";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]=oldPiece;
						 
					 
						 
						 
						 
					 }
					 
					 
					 
					 
				 }catch(Exception e){}
				 temp=1;	
			 }
		 }
		 return list;
		 
	 
	 }
	
	public static String blackQueen(int i){
		 String list="",oldPiece;
		 int r=i/8,c=i%8;
		 int temp=1;
		 for(int j=-1;j<=1;j++){
			 
			 for(int k=-1;k<=1;k++){
				 try {
					 while(AlphaBeta.chessBoard[r+temp*j][c+temp*k].equals(" ")){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c+temp*k];
						 AlphaBeta.chessBoard[r][c]=" ";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]="Q";
						 if(kingSafe()){
							 list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
						 }
						 AlphaBeta.chessBoard[r][c]="Q";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]=oldPiece;
						 
					temp++;	 
					 }
					 if(Character.isLowerCase(AlphaBeta.chessBoard[r+temp*j][c+temp*k].charAt(0))){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c+temp*k];
						 AlphaBeta.chessBoard[r][c]=" ";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]="Q";
						 if(kingSafe()){
							 list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
						 }
						 AlphaBeta.chessBoard[r][c]="Q";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]=oldPiece;
						 
					 
						 
						 
						 
					 }
					 
					 
					 
					 
				 }catch(Exception e){}
				 temp=1;	
			 }
		 }
		 return list;}
	
	public static String whiteQueen(int i){
		 String list="",oldPiece;
		 int r=i/8,c=i%8;
		 int temp=1;
		 for(int j=-1;j<=1;j++){
			 
			 for(int k=-1;k<=1;k++){
				 try {
					 while(AlphaBeta.chessBoard[r+temp*j][c+temp*k].equals(" ")){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c+temp*k];
						 AlphaBeta.chessBoard[r][c]=" ";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]="q";
						 if(wkingSafe()){
							 list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
						 }
						 AlphaBeta.chessBoard[r][c]="q";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]=oldPiece;
						 
					temp++;	 
					 }
					 if(Character.isUpperCase(AlphaBeta.chessBoard[r+temp*j][c+temp*k].charAt(0))){
						 oldPiece=AlphaBeta.chessBoard[r+temp*j][c+temp*k];
						 AlphaBeta.chessBoard[r][c]=" ";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]="q";
						 if(wkingSafe()){
							 list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
						 }
						 AlphaBeta.chessBoard[r][c]="q";
						 AlphaBeta.chessBoard[r+temp*j][c+temp*k]=oldPiece;
						 
					 
						 
						 
						 
					 }
					 
					 
					 
					 
				 }catch(Exception e){}
				 temp=1;	
			 }
		 }
		 return list;}
	
	
	public static String blackKnight(int i){
		 String list="",oldPiece;
		// int temp = 1;
		 int r=i/8,c=i%8;
		 for(int j=-1;j<=1;j+=2){
			 for(int k=-1;k<=1;k+=2){
				 try {
					 if(Character.isLowerCase(AlphaBeta.chessBoard[r+j][c+2*k].charAt(0))||" ".equals(AlphaBeta.chessBoard[r+j][c+2*k])){
						oldPiece=AlphaBeta.chessBoard[r+j][c+2*k];
						AlphaBeta.chessBoard[r][c]=" ";
						AlphaBeta.chessBoard[r+j][c+2*k]="K";
						if(kingSafe()){
							 list=list+r+c+(r+j)+(c+2*k)+oldPiece;
						 }
						AlphaBeta.chessBoard[r][c]="K";
						AlphaBeta.chessBoard[r+j][c+2*k]=oldPiece;
					 }
					 }catch (Exception e){}
				 
				 
				 try {
					 if(Character.isLowerCase(AlphaBeta.chessBoard[r+j*2][c+k].charAt(0))||" ".equals(AlphaBeta.chessBoard[r+j*2][c+k])){
						oldPiece=AlphaBeta.chessBoard[r+j*2][c+k];
						AlphaBeta.chessBoard[r][c]=" ";
						AlphaBeta.chessBoard[r+j*2][c+k]="K";
						if(kingSafe()){
							 list=list+r+c+(r+j*2)+(c+k)+oldPiece;
						 }
						AlphaBeta.chessBoard[r][c]="K";
						AlphaBeta.chessBoard[r+j*2][c+k]=oldPiece;
					 }
					 }catch (Exception e){}
			 
		 } }
		 return list;
		 }
	
	
	
	
	public static String whiteKnight(int i){
		 String list="",oldPiece;
		// int temp = 1;
		 int r=i/8,c=i%8;
		 for(int j=-1;j<=1;j+=2){
			 for(int k=-1;k<=1;k+=2){
				 try {
					 if(Character.isUpperCase(AlphaBeta.chessBoard[r+j][c+2*k].charAt(0))||" ".equals(AlphaBeta.chessBoard[r+j][c+2*k])){
						oldPiece=AlphaBeta.chessBoard[r+j][c+2*k];
						AlphaBeta.chessBoard[r][c]=" ";
						AlphaBeta.chessBoard[r+j][c+2*k]="k";
						if(wkingSafe()){
							 list=list+r+c+(r+j)+(c+2*k)+oldPiece;
						 }
						AlphaBeta.chessBoard[r][c]="k";
						AlphaBeta.chessBoard[r+j][c+2*k]=oldPiece;
					 }
					 }catch (Exception e){}
				 
				 
				 try {
					 if(Character.isUpperCase(AlphaBeta.chessBoard[r+j*2][c+k].charAt(0))||" ".equals(AlphaBeta.chessBoard[r+j*2][c+k])){
						oldPiece=AlphaBeta.chessBoard[r+j*2][c+k];
						AlphaBeta.chessBoard[r][c]=" ";
						AlphaBeta.chessBoard[r+j*2][c+k]="k";
						if(wkingSafe()){
							 list=list+r+c+(r+j*2)+(c+k)+oldPiece;
						 }
						AlphaBeta.chessBoard[r][c]="k";
						AlphaBeta.chessBoard[r+j*2][c+k]=oldPiece;
					 }
					 }catch (Exception e){}
			 
		 } }
		 return list;
		 }
	
	
	
	
	
	public static String whitePawn(int i){String list="",oldPiece;
	
	 int r=i/8,c=i%8;
	 for(int j=-1;j<=1;j+=2){
		try{//capture
			if(Character.isUpperCase(AlphaBeta.chessBoard[r-1][c+j].charAt(0))&&i>=16){
				oldPiece=AlphaBeta.chessBoard[r-1][c+j];
				AlphaBeta.chessBoard[r][c]=" ";
				AlphaBeta.chessBoard[r-1][c+j]="p";
				if(wkingSafe()){
					 list=list+r+c+(r-1)+(c+j)+oldPiece;
				 }
				AlphaBeta.chessBoard[r][c]="p";
				AlphaBeta.chessBoard[r-1][c+j]=oldPiece;
			}
		}catch (Exception e){} 
		
		try{//capture && pro
			if(Character.isUpperCase(AlphaBeta.chessBoard[r-1][c+j].charAt(0))&&i<16){
				String [] temp ={"q","r","b","k"};
				for(int k=0;k<4;k++){
					
					oldPiece=AlphaBeta.chessBoard[r-1][c+j];
					AlphaBeta.chessBoard[r][c]=" ";
					AlphaBeta.chessBoard[r-1][c+j]=temp[k];
					if(wkingSafe()){//column1,column2,capturedp,newp,P
						 list=list+c+(c+j)+oldPiece+temp[k]+"z";
					 }
					AlphaBeta.chessBoard[r][c]="p";
					AlphaBeta.chessBoard[r-1][c+j]=oldPiece;
				}
				
			}
		}catch (Exception e){} 
		
		
		
		}
	 try{//move 1
			if(" ".equals(AlphaBeta.chessBoard[r-1][c])&&i>=16){
				oldPiece=AlphaBeta.chessBoard[r-1][c];
				AlphaBeta.chessBoard[r][c]=" ";
				AlphaBeta.chessBoard[r-1][c]="p";
				if(wkingSafe()){
					 list=list+r+c+(r-1)+(c)+oldPiece;
				 }
				AlphaBeta.chessBoard[r][c]="p";
				AlphaBeta.chessBoard[r-1][c]=oldPiece;
			}
		}catch (Exception e){} 
	 try{//move 1 && prom
			if(" ".equals(AlphaBeta.chessBoard[r-1][c])&&i<16){
				String [] temp ={"q","r","b","k"};
				for(int k=0;k<4;k++){
					
					oldPiece=AlphaBeta.chessBoard[r-1][c];
					AlphaBeta.chessBoard[r][c]=" ";
					AlphaBeta.chessBoard[r-1][c]=temp[k];
					if(wkingSafe()){//column1,column2,capturedp,newp
						 list=list+c+(c)+oldPiece+temp[k]+"z";
					 }
					AlphaBeta.chessBoard[r][c]="p";
					AlphaBeta.chessBoard[r-1][c]=oldPiece;
				}
				
			}
		}catch (Exception e){} 
	 try{//move 2
			if(" ".equals(AlphaBeta.chessBoard[r-1][c])&&" ".equals(AlphaBeta.chessBoard[r-2][c])&&i>=48){
				oldPiece=AlphaBeta.chessBoard[r-2][c];
				AlphaBeta.chessBoard[r][c]=" ";
				AlphaBeta.chessBoard[r-2][c]="p";
				if(wkingSafe()){
					 list=list+r+c+(r-2)+(c)+oldPiece;
				 }
				AlphaBeta.chessBoard[r][c]="p";
				AlphaBeta.chessBoard[r-2][c]=oldPiece;
			}
		}catch (Exception e){} 
	 return list;}
	
	public static String blackPawn(int i){String list="",oldPiece;
	
	 int r=i/8,c=i%8;
	 for(int j=-1;j<=1;j+=2){
		try{//capture
			if(Character.isLowerCase(AlphaBeta.chessBoard[r+1][c+j].charAt(0))&&i>=16){
				oldPiece=AlphaBeta.chessBoard[r+1][c+j];
				AlphaBeta.chessBoard[r][c]=" ";
				AlphaBeta.chessBoard[r+1][c+j]="P";
				if(kingSafe()){
					 list=list+r+c+(r+1)+(c+j)+oldPiece;
				 }
				AlphaBeta.chessBoard[r][c]="P";
				AlphaBeta.chessBoard[r+1][c+j]=oldPiece;
			}
		}catch (Exception e){} 
		
		try{//capture && pro
			if(Character.isLowerCase(AlphaBeta.chessBoard[r+1][c+j].charAt(0))&&i>47){
				String [] temp ={"Q","R","B","K"};
				for(int k=0;k<4;k++){
					
					oldPiece=AlphaBeta.chessBoard[r+1][c+j];
					AlphaBeta.chessBoard[r][c]=" ";
					AlphaBeta.chessBoard[r+1][c+j]=temp[k];
					if(kingSafe()){//column1,column2,capturedp,newp,P
						 list=list+c+(c+j)+oldPiece+temp[k]+"Z";
					 }
					AlphaBeta.chessBoard[r][c]="P";
					AlphaBeta.chessBoard[r+1][c+j]=oldPiece;
				}
				
			}
		}catch (Exception e){} 
		
		
		
		}
	 try{//move 1
			if(" ".equals(AlphaBeta.chessBoard[r+1][c])&&i<=47){
				oldPiece=AlphaBeta.chessBoard[r+1][c];
				AlphaBeta.chessBoard[r][c]=" ";
				AlphaBeta.chessBoard[r+1][c]="P";
				if(kingSafe()){
					 list=list+r+c+(r+1)+(c)+oldPiece;
				 }
				AlphaBeta.chessBoard[r][c]="P";
				AlphaBeta.chessBoard[r+1][c]=oldPiece;
			}
		}catch (Exception e){} 
	 try{//move 1 && prom
			if(" ".equals(AlphaBeta.chessBoard[r+1][c])&&i>=48){
				String [] temp ={"Q","R","B","K"};
				for(int k=0;k<4;k++){
					
					oldPiece=AlphaBeta.chessBoard[r+1][c];
					AlphaBeta.chessBoard[r][c]=" ";
					AlphaBeta.chessBoard[r+1][c]=temp[k];
					if(kingSafe()){//column1,column2,capturedp,newp
						 list=list+c+(c)+oldPiece+temp[k]+"Z";
					 }
					AlphaBeta.chessBoard[r][c]="P";
					AlphaBeta.chessBoard[r+1][c]=oldPiece;
				}
				
			}
		}catch (Exception e){} 
	 try{//move 2
			if(" ".equals(AlphaBeta.chessBoard[r+1][c])&&" ".equals(AlphaBeta.chessBoard[r+2][c])&&i<16){
				oldPiece=AlphaBeta.chessBoard[r+2][c];
				AlphaBeta.chessBoard[r][c]=" ";
				AlphaBeta.chessBoard[r+2][c]="P";
				if(kingSafe()){
					 list=list+r+c+(r+2)+(c)+oldPiece;
				 }
				AlphaBeta.chessBoard[r][c]="P";
				AlphaBeta.chessBoard[r+2][c]=oldPiece;
			}
		}catch (Exception e){} 
	 return list;}
	
	public static String blackKing(int i){
		 String list="",oldPiece;
		 int r=i/8,c=i%8;
		 for(int j=0;j<9;j++){
			 
				 try{
				 if(Character.isLowerCase(AlphaBeta.chessBoard[r-1+j/3][c-1+j%3].charAt(0))||(AlphaBeta.chessBoard[r-1+j/3][c-1+j%3]).equals(" ")){
				 oldPiece=AlphaBeta.chessBoard[r-1+j/3][c-1+j%3];
				 AlphaBeta.chessBoard[r][c]=" ";
				 AlphaBeta.chessBoard[r-1+j/3][c-1+j%3]="A";
				 int kingt=AlphaBeta.kingPosition1;
				 AlphaBeta.kingPosition1=i+forKing[j];
				 if(kingSafe()){
					 list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
				 }
				 AlphaBeta.chessBoard[r][c]="A";
				 AlphaBeta.chessBoard[r-1+j/3][c-1+j%3]=oldPiece;
				 AlphaBeta.kingPosition1=kingt;}
			 }catch(Exception e){}
			 
		 }
		 return list;
		 
	 }
	
	public static String whiteKing(int i){
		 String list="",oldPiece;
		 int r=i/8,c=i%8;
		 for(int j=0;j<9;j++){
			 
				 try{
				 if(Character.isUpperCase(AlphaBeta.chessBoard[r-1+j/3][c-1+j%3].charAt(0))||(AlphaBeta.chessBoard[r-1+j/3][c-1+j%3]).equals(" ")){
				 oldPiece=AlphaBeta.chessBoard[r-1+j/3][c-1+j%3];
				 AlphaBeta.chessBoard[r][c]=" ";
				 AlphaBeta.chessBoard[r-1+j/3][c-1+j%3]="a";
				 int kingt=AlphaBeta.kingPosition2;
				 AlphaBeta.kingPosition2=i+forKing[j];
				 if(wkingSafe()){
					 list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
				 }
				 AlphaBeta.chessBoard[r][c]="a";
				 AlphaBeta.chessBoard[r-1+j/3][c-1+j%3]=oldPiece;
				 AlphaBeta.kingPosition2=kingt;}
			 }catch(Exception e){}
			 
		 }
		 return list;
		 
	 }
	
	
	
	public static boolean kingSafe(){
		 //bishop,q
		 int temp=1;
		for(int i=-1;i<=1;i+=2){
			 
			 for(int j=-1;j<=1;j+=2){
					 try {
						 while(" ".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+temp*i][AlphaBeta.kingPosition1%8+temp*j])){temp++;}
						 if("b".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+temp*i][AlphaBeta.kingPosition1%8+temp*j])||
								 "q".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+temp*i][AlphaBeta.kingPosition1%8+temp*j])){
							 return false;
						 }
						
					
						
						 }catch(Exception e){}
						 temp=1;
					 }
			 }
		 //rook,q
		
		for(int i=-1;i<=1;i+=2){
			 
			try {
				 while(" ".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8][AlphaBeta.kingPosition1%8+temp*i])){temp++;}
				 if("r".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8][AlphaBeta.kingPosition1%8+temp*i])||
						 "q".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8][AlphaBeta.kingPosition1%8+temp*i])){
					 return false;
				 }
				
				
				 }catch(Exception e){}
				 temp=1;
			try {
				 while(" ".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+temp*i][AlphaBeta.kingPosition1%8])){temp++;}
				 if("r".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+temp*i][AlphaBeta.kingPosition1%8])||
					 "q".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+temp*i][AlphaBeta.kingPosition1%8])){
					 return false;
				 }
					 
				
					
				 }catch(Exception e){}	 
				temp=1;																						
					 
			 }
		 //knight
		for(int i=-1;i<=1;i+=2){
			 
			 for(int j=-1;j<=1;j+=2){
					 try {
						 if("k".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+i][AlphaBeta.kingPosition1%8+2*j])){
							 return false;
						 }
						
						 }catch(Exception e){}
					 try {
						 if("k".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+i*2][AlphaBeta.kingPosition1%8+j])){
							 return false;
						 }
						
						 }catch(Exception e){}

					 }
			 }
		//pawn
		if(AlphaBeta.kingPosition1<48){
			try {
				 if("p".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+1][AlphaBeta.kingPosition1%8-1])){
					 return false;
				 }
				
				 }catch(Exception e){}
			try {
				 if("p".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+1][AlphaBeta.kingPosition1%8+1])){
					 return false;
				 }
				
				 }catch(Exception e){}
		}
		//king
		for(int i=-1;i<=1;i++){
			 
			 for(int j=-1;j<=1;j++){
					if(i!=0||j!=0){
					 try {
						 if("a".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+i][AlphaBeta.kingPosition1%8+j])){
							 return false;
						 }
						
						 }catch(Exception e){}

					 }
			 }
			 }
		 return true;
	 }
	
	
	public static boolean wkingSafe(){
		 //bishop,q
		 int temp=1;
		for(int i=-1;i<=1;i+=2){
			 
			 for(int j=-1;j<=1;j+=2){
					 try {
						 while(" ".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8+temp*i][AlphaBeta.kingPosition2%8+temp*j])){temp++;}
						 if("B".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8+temp*i][AlphaBeta.kingPosition2%8+temp*j])||
								 "Q".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8+temp*i][AlphaBeta.kingPosition2%8+temp*j])){
							 return false;
						 }
						
					
						
						 }catch(Exception e){}
						 temp=1;
					 }
			 }
		 //rook,q
		
		for(int i=-1;i<=1;i+=2){
			 
			try {
				 while(" ".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8][AlphaBeta.kingPosition2%8+temp*i])){temp++;}
				 if("R".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8][AlphaBeta.kingPosition2%8+temp*i])||
						 "Q".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8][AlphaBeta.kingPosition2%8+temp*i])){
					 return false;
				 }
				
				
				 }catch(Exception e){}
				 temp=1;
			try {
				 while(" ".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8+temp*i][AlphaBeta.kingPosition2%8])){temp++;}
				 if("R".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8+temp*i][AlphaBeta.kingPosition2%8])||
					 "Q".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8+temp*i][AlphaBeta.kingPosition2%8])){
					 return false;
				 }
					 
				
					
				 }catch(Exception e){}	 
				temp=1;																						
					 
			 }
		 //knight
		for(int i=-1;i<=1;i+=2){
			 
			 for(int j=-1;j<=1;j+=2){
					 try {
						 if("K".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8+i][AlphaBeta.kingPosition2%8+2*j])){
							 return false;
						 }
						
						 }catch(Exception e){}
					 try {
						 if("K".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8+i*2][AlphaBeta.kingPosition2%8+j])){
							 return false;
						 }
						
						 }catch(Exception e){}

					 }
			 }
		//pawn
		if(AlphaBeta.kingPosition2>=16){
			try {
				 if("P".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8-1][AlphaBeta.kingPosition2%8-1])){
					 return false;
				 }
				
				 }catch(Exception e){}
			try {
				 if("P".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition2/8-1][AlphaBeta.kingPosition2%8+1])){
					 return false;
				 }
				
				 }catch(Exception e){}
		}
		//king
		for(int i=-1;i<=1;i++){
			 
			 for(int j=-1;j<=1;j++){
					if(i!=0||j!=0){
					 try {
						 if("A".equals(AlphaBeta.chessBoard[AlphaBeta.kingPosition1/8+i][AlphaBeta.kingPosition1%8+j])){
							 return false;
						 }
						
						 }catch(Exception e){}

					 }
			 }
			 }
		 return true;
	 }
	
}



	


