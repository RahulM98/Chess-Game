/**
 * Created by Rahul on 10-Sep-2018
 * 
 */
/**
 * @author Payel
 *
 */
package Game_logical;

import java.lang.Math;

public class PAWN extends Piece
{
	//Piece_Type type;
	String turn;
	public PAWN(int x,int y,int piece_in_button_id, String turn)
	{
		super(x,y,piece_in_button_id);
		//type = piece_name;
		this.turn = turn;         //  Keeps track of currently whose turn is going on
	}
	boolean isValidPath(int dest_x,int dest_y)
	{
		int x_distance = Math.abs(dest_x - x_pos);  // row distance
		int y_distance = Math.abs(dest_y - y_pos);  // column distance
		
		System.out.println("x = "+x_pos+"y = "+y_pos);
		System.out.println("x dist = "+x_distance+"y dist = "+y_distance);
		System.out.println("x dest = "+dest_x+" y dest = "+dest_y);
		
		//moves two step
		if(x_distance == 2 && y_distance == 0 && dest_x < 8 && dest_x > -1 && Game_main_class.Board[dest_x][dest_y] == 0)
		{
			//if((y_pos == 1 && alliance == "white" && (Game_main_class.Board[x_pos][y_pos+1] == 0 || Game_main_class.Board[x_pos][y_pos+1] > 16)) || (y_pos == 6 && alliance == "black" && Game_main_class.Board[x_pos][y_pos-1] < 17))
			if(x_pos == 1 && turn == "white" && piece_id >= 9 && piece_id <= 16 && Game_main_class.Board[x_pos+1][y_pos] == 0)
			{
				return true;
			}
			else if(x_pos == 6 && turn == "black" && piece_id >= 25 && piece_id <= 32 && Game_main_class.Board[x_pos-1][y_pos] == 0)
			{
				return true;
			}
			else {
				System.out.println("A");
				return false;}
		}
		//moves one step
		else if(x_distance == 1 && dest_x < 8 && dest_x > -1)
		{
			//goes straight for one step
			if(y_distance == 0 && Game_main_class.Board[dest_x][dest_y] == 0)
			{
				if(turn == "white" && piece_id >= 9 && piece_id <= 16)
				{
					return true;
				}
				else if(turn == "black" && piece_id >= 25 && piece_id <= 32)
				{
					return true;
				}
				else{
					System.out.println("B");
					return false;}
			}
			
			//goes diagonally for one step to cut opponent
			else if(y_distance == 1 && Game_main_class.Board[dest_x][dest_y] != 0)
			{
				if(turn == "white" && piece_id >= 9 && piece_id <= 16 && Game_main_class.Board[dest_x][dest_y] > 16)
				{
					return true;
				}
				else if(turn == "black" && piece_id >= 25 && piece_id <= 32 && Game_main_class.Board[dest_x][dest_y] < 17)
				{
					return true;
				}
				else{
					System.out.println("C");
					return false;}
			}
			else{
				System.out.println("D");
				return false;}
		}
		else{
			System.out.println("E");
			return false;}
	}
	
	public boolean [][]drawPath()
	{
		boolean path[][] = new boolean[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				path[i][j] = false;//path[i][j] = isValidPath(i,j);
			}
		}
		
		
		//----------------------------------------------------------------------------------------------
		// For testing purpose only
		
		
		Game_main_class.Board[2][1] = 18;
		path[2][1] = isValidPath(2,1);
		path[2][0] = isValidPath(2,0);
		path[3][0] = isValidPath(3,0);
		for(int i = 0;i<8;i++)
		{
			for(int j = 0;j<8;j++)
			{
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		
		
		return path;
	}
}