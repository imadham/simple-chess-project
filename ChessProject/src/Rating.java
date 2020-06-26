
public class Rating {
	
	public static int whiteRating(int list,int depth) {int counter=0;
	counter+=whiteboard();
	counter+=ratewhiteMaterial();
	counter+=rateWhiteAttack();
	counter+=rateWhiteMovability(list,depth);
	return counter;
	}
	
	public static int blackRating(int list,int depth) {int counter=0;
	counter+=blackboard();
	counter+=rateblackMaterial();
	counter+=rateBlackAttack();
	counter+=rateBlackMovability(list,depth);
	return counter;
	}
	
	
	
	
	
	
	public static int whiteboard(){
	     int counter=0;
	     for(int i=0;i<64;i++){
	         switch (AlphaBeta.chessBoard[i/8][i%8]) {
	             case "p": counter+=pawnBoard[i/8][i%8];
	                 break;
	             case "r": counter+=rookBoard[i/8][i%8];
	                 break;
	             case "k": counter+=knightBoard[i/8][i%8];
	                 break;
	             case "b": counter+=bishopBoard[i/8][i%8];
	                 break;
	             case "q": counter+=queenBoard[i/8][i%8];
	                 break;
	             case "a": counter+=kingMidBoard[i/8][i%8];
	                 break;}
	         }
	     
	     return counter;
	 }
	
	
	
	
	
	public static int blackboard(){
	     int counter=0;
	     for(int i=0;i<64;i++){
	         switch (AlphaBeta.chessBoard[i/8][i%8]) {
	             case "P": counter+=blackPawnBoard[i/8][i%8];
	                 break;
	             case "R": counter+=blackRookBoard[i/8][i%8];
	                 break;
	             case "K": counter+=blackKnightBoard[i/8][i%8];
	                 break;
	             case "B": counter+=blackBishopBoard[i/8][i%8];
	                 break;
	             case "Q": counter+=blackQueenBoard[i/8][i%8];
	                 break;
	             case "A": counter+=blackKingMidBoard[i/8][i%8];
	                 break;}
	         }
	     
	     return counter;
	 }

	
	public static int rateblackMaterial(){
		 int counter=0,bishopCounter=0;
		 for(int i=0;i<64;i++){
			 switch (AlphaBeta.chessBoard[i/8][i%8]) {
	         case "P": counter+=100;
	             break;
	         case "R": counter+=500;
	             break;
	         case "K": counter+=300;
	             break;
	         case "B": bishopCounter+=1;
	             break;
	         case "Q": counter+=900;
	             break;
	     }
		 }
		 if (bishopCounter>=2) {
	         counter+=300*bishopCounter;
	     } else {
	         if (bishopCounter==1) {counter+=250;}//one bishop is weaker
	     }
		 return counter;
	 }
	
	
	public static int ratewhiteMaterial(){
		 int counter=0,bishopCounter=0;
		 for(int i=0;i<64;i++){
			 switch (AlphaBeta.chessBoard[i/8][i%8]) {
	         case "p": counter+=100;
	             break;
	         case "r": counter+=500;
	             break;
	         case "k": counter+=300;
	             break;
	         case "b": bishopCounter+=1;
	             break;
	         case "q": counter+=900;
	             break;
	     }
		 }
		 if (bishopCounter>=2) {
	         counter+=300*bishopCounter;
	     } else {
	         if (bishopCounter==1) {counter+=250;}//one bishop is weaker
	     }
		 return counter;
	 }
	
	public static int rateBlackAttack(){
		 int counter=0;
		 int tempK=AlphaBeta.kingPosition1;
		 
		 for(int i=0;i<64;i++){
			 switch (AlphaBeta.chessBoard[i/8][i%8]) {
	         case "P": {AlphaBeta.kingPosition1=i;if(!Move.kingSafe()){counter-=55;}}
	             break;
	         case "R": {AlphaBeta.kingPosition1=i;if(!Move.kingSafe()){counter-=500;}}
	             break;
	         case "K": {AlphaBeta.kingPosition1=i;if(!Move.kingSafe()){counter-=300;}}
	             break;
	         case "B": {AlphaBeta.kingPosition1=i;if(!Move.kingSafe()){counter-=300;}}
	             break;
	         case "Q": {AlphaBeta.kingPosition1=i;if(!Move.kingSafe()){counter-=900;}}
	             break;
	     }
		 }AlphaBeta.kingPosition1=tempK;
		 if(!Move.kingSafe()){counter-=200;}
		 return counter/2;
	 }
	
	
	
	public static int rateWhiteAttack(){
		 int counter=0;
		 int tempK=AlphaBeta.kingPosition2;
		 
		 for(int i=0;i<64;i++){
			 switch (AlphaBeta.chessBoard[i/8][i%8]) {
	         case "p": {AlphaBeta.kingPosition2=i;if(!Move.wkingSafe()){counter-=55;}}
	             break;
	         case "r": {AlphaBeta.kingPosition2=i;if(!Move.wkingSafe()){counter-=500;}}
	             break;
	         case "k": {AlphaBeta.kingPosition2=i;if(!Move.wkingSafe()){counter-=300;}}
	             break;
	         case "b": {AlphaBeta.kingPosition2=i;if(!Move.wkingSafe()){counter-=300;}}
	             break;
	         case "q": {AlphaBeta.kingPosition2=i;if(!Move.wkingSafe()){counter-=900;}}
	             break;
	     }
		 }AlphaBeta.kingPosition2=tempK;
		 if(!Move.wkingSafe()){counter-=200;}
		 return counter/2;
	 }
	
	
	
	public static int rateBlackMovability(int list,int depth){
		 int counter=0;
		 counter+=list*10;//5 for each move
		 if(list==0){//check mate||  cannot move
			 if(!Move.kingSafe()){//check mate
				 counter-=200000*depth;
			 }else {//cant move
				 counter-=150000*depth;

			 }
		 
		 }
		 return counter/4;
	
	}
	
	
	public static int rateWhiteMovability(int list,int depth){
		 int counter=0;
		 counter+=list*10;//5 for each move
		 if(list==0){//check mate||  cannot move
			 if(!Move.wkingSafe()){//check mate
				 counter-=200000*depth;
			 }else {//cant move
				 counter-=150000*depth;

			 }
			 
		 }//System.out.println("cccc"+counter);	
		 return counter/4;
	
	}
	
	static int pawnBoard[][]={//http://chessprogramming.wikispaces.com/Simplified+evaluation+function
       { 0,  0,  0,  0,  0,  0,  0,  0},
       {50, 50, 50, 50, 50, 50, 50, 50},
       {10, 10, 20, 30, 30, 20, 10, 10},
       { 5,  5, 10, 25, 25, 10,  5,  5},
       { 0,  0,  0, 20, 20,  0,  0,  0},
       { 5, -5,-10,  0,  0,-10, -5,  5},
       { 5, 10, 10,-20,-20, 10, 10,  5},
       { 0,  0,  0,  0,  0,  0,  0,  0}};
	
	static int blackPawnBoard[][]={
       { 0,  0,  0,  0,  0,  0,  0,  0},
       { 5, 10, 10,-20,-20, 10, 10,  5},
       { 5, -5,-10,  0,  0,-10, -5,  5},
       { 0,  0,  0, 20, 20,  0,  0,  0},
       { 5,  5, 10, 25, 25, 10,  5,  5},
       {10, 10, 20, 30, 30, 20, 10, 10},
       {50, 50, 50, 50, 50, 50, 50, 50},
       { 0,  0,  0,  0,  0,  0,  0,  0}};
	
	static int rookBoard[][]={
	   { 0,  0,  0,  5,  5,  0,  0,  0},
	   { 5, 10, 10, 10, 10, 10, 10,  5},
	   {-5,  0,  0,  0,  0,  0,  0, -5},
	   {-5,  0,  0,  0,  0,  0,  0, -5},
	   {-5,  0,  0,  0,  0,  0,  0, -5},
	   {-5,  0,  0,  0,  0,  0,  0, -5},
	   {-5,  0,  0,  0,  0,  0,  0, -5},
	   { 0,  0,  0,  0,  0,  0,  0,  0}};

	
	
	static int blackRookBoard[][]={
       { 0,  0,  0,  5,  5,  0,  0,  0},
       {-5,  0,  0,  0,  0,  0,  0, -5},
       {-5,  0,  0,  0,  0,  0,  0, -5},
       {-5,  0,  0,  0,  0,  0,  0, -5},
       {-5,  0,  0,  0,  0,  0,  0, -5},
       {-5,  0,  0,  0,  0,  0,  0, -5},
       { 5, 10, 10, 10, 10, 10, 10,  5},
       { 0,  0,  0,  0,  0,  0,  0,  0}};
	
		
   static int knightBoard[][]={
       {-50,-40,-30,-30,-30,-30,-40,-50},
       {-40,-20,  0,  0,  0,  0,-20,-40},
       {-30,  0, 10, 15, 15, 10,  0,-30},
       {-30,  5, 15, 20, 20, 15,  5,-30},
       {-30,  0, 15, 20, 20, 15,  0,-30},
       {-30,  5, 10, 15, 15, 10,  5,-30},
       {-40,-20,  0,  5,  5,  0,-20,-40},
       {-50,-40,-30,-30,-30,-30,-40,-50}};
   
   static int blackKnightBoard[][]={
       {-50,-40,-30,-30,-30,-30,-40,-50},
       {-40,-20,  0,  5,  5,  0,-20,-40},
       {-30,  5, 10, 15, 15, 10,  5,-30},
       {-30,  0, 15, 20, 20, 15,  0,-30},
       {-30,  5, 15, 20, 20, 15,  5,-30},
       {-30,  0, 10, 15, 15, 10,  0,-30},
       {-40,-20,  0,  0,  0,  0,-20,-40},
       {-50,-40,-30,-30,-30,-30,-40,-50}};
   
   static int bishopBoard[][]={
       {-20,-10,-10,-10,-10,-10,-10,-20},
       {-10,  0,  0,  0,  0,  0,  0,-10},
       {-10,  0,  5, 10, 10,  5,  0,-10},
       {-10,  5,  5, 10, 10,  5,  5,-10},
       {-10,  0, 10, 10, 10, 10,  0,-10},
       {-10, 10, 10, 10, 10, 10, 10,-10},
       {-10,  5,  0,  0,  0,  0,  5,-10},
       {-20,-10,-10,-10,-10,-10,-10,-20}};
   
   static int blackBishopBoard[][]={
       {-20,-10,-10,-10,-10,-10,-10,-20},
       {-10,  5,  0,  0,  0,  0,  5,-10},
       {-10, 10, 10, 10, 10, 10, 10,-10},
       {-10,  0, 10, 10, 10, 10,  0,-10},
       {-10,  5,  5, 10, 10,  5,  5,-10},
       {-10,  0,  5, 10, 10,  5,  0,-10},
       {-10,  0,  0,  0,  0,  0,  0,-10},
       {-20,-10,-10,-10,-10,-10,-10,-20}};
   
   static int queenBoard[][]={
       {-20,-10,-10, -5, -5,-10,-10,-20},
       {-10,  0,  0,  0,  0,  0,  0,-10},
       {-10,  0,  5,  5,  5,  5,  0,-10},
       { -5,  0,  5,  5,  5,  5,  0, -5},
       {  0,  0,  5,  5,  5,  5,  0, -5},
       {-10,  5,  5,  5,  5,  5,  0,-10},
       {-10,  0,  5,  0,  0,  0,  0,-10},
       {-20,-10,-10, -5, -5,-10,-10,-20}};
   
   static int blackQueenBoard[][]={
       {-20,-10,-10, -5, -5,-10,-10,-20},
       {-10,  0,  5,  0,  0,  0,  0,-10},
       {-10,  5,  5,  5,  5,  5,  0,-10},
       { -5,  0,  5,  5,  5,  5,  0, -5},
       {  0,  0,  5,  5,  5,  5,  0, -5},
       {-10,  0,  5,  5,  5,  5,  0,-10},
       {-10,  0,  0,  0,  0,  0,  0,-10},
       {-20,-10,-10, -5, -5,-10,-10,-20}};
   
   
   static int kingMidBoard[][]={
       {-30,-40,-40,-50,-50,-40,-40,-30},
       {-30,-40,-40,-50,-50,-40,-40,-30},
       {-30,-40,-40,-50,-50,-40,-40,-30},
       {-30,-40,-40,-50,-50,-40,-40,-30},
       {-20,-30,-30,-40,-40,-30,-30,-20},
       {-10,-20,-20,-20,-20,-20,-20,-10},
       { 20, 20,  0,  0,  0,  0, 20, 20},
       { 20, 30, 10,  0,  0, 10, 30, 20}};
   
   
   static int blackKingMidBoard[][]={
       { 20, 30, 10,  0,  0, 10, 30, 20},
       { 20, 20,  0,  0,  0,  0, 20, 20},
       {-10,-20,-20,-20,-20,-20,-20,-10},
       {-20,-30,-30,-40,-40,-30,-30,-20},
       {-30,-40,-40,-50,-50,-40,-40,-30},
       {-30,-40,-40,-50,-50,-40,-40,-30},
       {-30,-40,-40,-50,-50,-40,-40,-30},
       {-30,-40,-40,-50,-50,-40,-40,-30}};
   
   
   static int blackKingEndBoard[][]={
       {-50,-40,-30,-20,-20,-30,-40,-50},
       {-30,-20,-10,  0,  0,-10,-20,-30},
       {-30,-10, 20, 30, 30, 20,-10,-30},
       {-30,-10, 30, 40, 40, 30,-10,-30},
       {-30,-10, 30, 40, 40, 30,-10,-30},
       {-30,-10, 20, 30, 30, 20,-10,-30},
       {-30,-30,  0,  0,  0,  0,-30,-30},
       {-50,-30,-30,-30,-30,-30,-30,-50}};

}
