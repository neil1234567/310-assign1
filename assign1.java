package assignment1;

import java.util.LinkedList;
import java.util.Queue;

public class assign1 {
	 //initial the 18*18 matrix
	final static int row = 18;
	final static int col = 18;
	public static void main(String[] args) {
		Point[][] matrix  = new Point[row][col];
		for(int i=0; i < row ; i++ ){
			for(int j=0; j < col ; j++){
				matrix[i][j] = new Point(i,j);
				if((i == 7 && (j>=5 && j <=9)) || 
						(((i>=10) && (i<=15)) &&(j==13)) || 
						((i==15)&&(j==12))){
					matrix[i][j].setObstacle();
				}
			}
		}
		
		findShortPath(matrix, 0,0,3,17);
		findShortPath_landmarks(matrix,0,0,17,17);
			
	}
	
	 //clear the record of visited of each point
	private static void clearmatrix(Point[][] matrix)
	{
		for(int i=0; i < row ; i++ ){
			for(int j=0; j < col ; j++){
					matrix[i][j].clearVisited();
				}
			}
	}
	
	 //clear the record of parent of each point
	private static void clearparent(Point[][] matrix)
	{
		for(int i=0; i < row ; i++ ){
			for(int j=0; j < col ; j++){
					matrix[i][j].clearParent();
				}
			}
	}
	
	// find the shortest path without landmarks
	private static void findShortPath(Point[][] matrix, int i, int j,int k, int l) {
		 clearmatrix(matrix);
		 clearparent(matrix);
		
		 Queue<Point> q = new LinkedList<Point>();
		 q.add(matrix[i][j]);
		 while (q.size() != 0)
       {
			 Point curr = q.poll();
			 int y = curr.getY();
			 int x = curr.getX();
			
			 matrix[x][y].setVisitied();
			 //if reach the end point, then output
			 if (x == k && y == l)
           {
				 int length = 0;
				 int fri = 0;
				 System.out.println("Path from start point to end point:");
				 System.out.println("path: " + matrix[k][l].toString());
				 while(curr.getParent() != null){
					 length++;
					 if(curr.getParent().getFringe()){
						 fri++;
					 }
					 System.out.println("path: " + curr.getParent().toString());
					 curr = curr.getParent();
					 
				 }
				 System.out.println("length: " + length);
				 System.out.println("num of fringe node: " + fri);
				 break;
           }
			 // if not reach the end point, then continue search
			 if (y + 1 < col && matrix[x][y + 1].getObstacle() != true && matrix[x][y + 1].getVisitied() == false)
	         {
	             q.add(matrix[x][y + 1]);
	             matrix[x][y + 1].setParent(matrix[x][y]);
	         }
	         if (y - 1 >= 0 && matrix[x][y - 1].getObstacle() != true && matrix[x][y - 1].getVisitied() == false)
	         {
	             q.add(matrix[x][y - 1]);
	             matrix[x][y - 1].setParent(matrix[x][y]);
	         }
	         if (x - 1 >= 0 && matrix[x - 1][y].getObstacle() != true && matrix[x-1][y].getVisitied() == false)
	         {
	             q.add(matrix[x - 1][y]);
	             matrix[x - 1][y].setParent(matrix[x][y]);
	         }
	         if (x + 1 < row && matrix[x + 1][y].getObstacle() != true && matrix[x+1][y].getVisitied() == false)
	         {
	             q.add(matrix[x+1][y]);
	             matrix[x+1][y].setParent(matrix[x][y]);
	         }
       }
	}
	
	
	// find the shortest path with landmarks
	private static void findShortPath_landmarks(Point[][] matrix, int i, int j,int k, int l) {
		 //find the shortest path from start point to the nearest landmark
		 clearmatrix(matrix);
		 clearparent(matrix);
		 Queue<Point> q = new LinkedList<Point>();
		 q.add(matrix[i][j]);
		 int landmark_start_x=0;
		 int landmark_start_y=0;
		 int landmark_end_x=0;
		 int landmark_end_y=0;
		 int length = 0;
		 int fri = 0;
		 while (q.size() != 0)
        {
			 Point curr = q.poll();
			 int y = curr.getY();
			 int x = curr.getX();
			
			 matrix[x][y].setVisitied();
			//if reach landmark, then output
			 if ((x == 5 && y == 5) || (x == 5 && y == 12) || (x == 12 && y ==5) || (x == 12 && y ==12))
            {
				 landmark_start_x = x;
				 landmark_start_y = y;
				 System.out.println("Path from start point to the nearest landmark:");
				 System.out.println("path: " + matrix[x][y].toString());
				 while(curr.getParent() != null){
					 length++;
					 if(curr.getParent().getFringe()){
						 fri++;
					 }
					 System.out.println("path: " + curr.getParent().toString());
					 curr = curr.getParent(); 
				 }
				 break;
            }
			  //if not reach landmark, then continue to search
			 if (y + 1 < col && matrix[x][y + 1].getObstacle() != true && matrix[x][y + 1].getVisitied() == false)
	         {
	             q.add(matrix[x][y + 1]);
	             matrix[x][y + 1].setParent(matrix[x][y]);
	         }
	         if (y - 1 >= 0 && matrix[x][y - 1].getObstacle() != true && matrix[x][y - 1].getVisitied() == false)
	         {
	             q.add(matrix[x][y - 1]);
	             matrix[x][y - 1].setParent(matrix[x][y]);
	         }
	         if (x - 1 >= 0 && matrix[x - 1][y].getObstacle() != true && matrix[x-1][y].getVisitied() == false)
	         {
	             q.add(matrix[x - 1][y]);
	             matrix[x - 1][y].setParent(matrix[x][y]);
	         }
	         if (x + 1 < row && matrix[x + 1][y].getObstacle() != true && matrix[x+1][y].getVisitied() == false)
	         {
	             q.add(matrix[x+1][y]);
	             matrix[x+1][y].setParent(matrix[x][y]);
	         }
        }
		 
		// find the shortest path from end point to the nearest landmark
		 clearmatrix(matrix);
		 clearparent(matrix);
		 Queue<Point> q2 = new LinkedList<Point>();
		 q2.add(matrix[k][l]);
		 while (q2.size() != 0)
        {
			 Point curr = q2.poll();
			 int y = curr.getY();
			 int x = curr.getX();
			
			 matrix[x][y].setVisitied();
			 //if reach landmark, then output
			 if ((x == 5 && y == 5) || (x == 5 && y == 12) || (x == 12 && y ==5) || (x == 12 && y ==12))
            {
				 
				 System.out.println("Path from end point to the nearest landmark:");
				 System.out.println("path: " + matrix[x][y].toString());
				 landmark_end_x = x;
				 landmark_end_y = y;
				 while(curr.getParent() != null){
					 length++;
					 if(curr.getParent().getFringe()){
						 fri++;
					 }
					 System.out.println("path: " + curr.getParent().toString());
					 curr = curr.getParent();
					 
				 }
				
				 break;
            }
			 // if not reach landmark, then continue to search
			 if (y + 1 < col && matrix[x][y + 1].getObstacle() != true && matrix[x][y + 1].getVisitied() == false)
	         {
	             q2.add(matrix[x][y + 1]);
	             matrix[x][y + 1].setParent(matrix[x][y]);
	         }
	         if (y - 1 >= 0 && matrix[x][y - 1].getObstacle() != true && matrix[x][y - 1].getVisitied() == false)
	         {
	             q2.add(matrix[x][y - 1]);
	             matrix[x][y - 1].setParent(matrix[x][y]);
	         }
	         if (x - 1 >= 0 && matrix[x - 1][y].getObstacle() != true && matrix[x-1][y].getVisitied() == false)
	         {
	             q2.add(matrix[x - 1][y]);
	             matrix[x - 1][y].setParent(matrix[x][y]);
	         }
	         if (x + 1 < row && matrix[x + 1][y].getObstacle() != true && matrix[x+1][y].getVisitied() == false)
	         {
	             q2.add(matrix[x+1][y]);
	             matrix[x+1][y].setParent(matrix[x][y]);
	         }
        }
		
		 //add the shortest length between the two landmarks up to the total shortest length
		 if(landmark_start_x == 5 && landmark_start_y ==5 && landmark_end_x==5&&landmark_end_y==12)
		 {
		    length=length+7;
		 }
		 if(landmark_start_x == 5 && landmark_start_y ==5 && landmark_end_x==12&&landmark_end_y==5)
		 {
		    length=length+7;
		 }
		 if(landmark_start_x == 5 && landmark_start_y ==5 && landmark_end_x==12 &&landmark_end_y==12)
		 {
		    length=length+14;
		 }
		 if(landmark_start_x == 5 && landmark_start_y ==12 && landmark_end_x==5&&landmark_end_y==5)
		 {
		    length=length+7;
		 }
		 if(landmark_start_x == 5 && landmark_start_y ==12 && landmark_end_x==12&&landmark_end_y==5)
		 {
		    length=length+14;
		 }
		 if(landmark_start_x == 5 && landmark_start_y ==12 && landmark_end_x==12&&landmark_end_y==12)
		 {
		    length=length+7;
		 }
		 if(landmark_start_x == 12 && landmark_start_y ==5 && landmark_end_x==5&&landmark_end_y==5)
		 {
		    length=length+7;
		 }
		 if(landmark_start_x == 12 && landmark_start_y ==5 && landmark_end_x==5&&landmark_end_y==12)
		 {
		    length=length+14;
		 }
		 if(landmark_start_x == 12 && landmark_start_y ==5 && landmark_end_x==12&&landmark_end_y==12)
		 {
		    length=length+7;
		 }
		 if(landmark_start_x == 12 && landmark_start_y ==12 && landmark_end_x==5&&landmark_end_y==5)
		 {
		    length=length+14;
		 }
		 if(landmark_start_x == 12 && landmark_start_y ==12 && landmark_end_x==5&&landmark_end_y==12)
		 {
		    length=length+7;
		 }
		 if(landmark_start_x == 12 && landmark_start_y ==12 && landmark_end_x==12&&landmark_end_y==5)
		 {
		    length=length+7;
		 }
		 
		 System.out.println("length: " + length);
		 System.out.println("num of fringe node: " + fri);
		 
	}
	
	
}



