package assignment1;

//define the point class
public class Point {
	private int x;
	private int y;
	private boolean visitied;
	private Point parent;
	private boolean obstacle;
	private boolean fringe;
	public Point(){
		
	}
	public Point(int x,int y){
		this.x = x;
		this.y = y;
		this.visitied = false;
		this.parent = null;
		this.obstacle = false;
		this.checkFringe();
	}
    //check if the point is placed on the fringe
	private void checkFringe(){
		if(this.x == 0 || this.x == 17 || this.y ==0 || this.y == 17){
			this.fringe = true;
		}else{
			this.fringe = false;
		}
	}
	public boolean getFringe(){
		return this.fringe;
	}
	public void setVisitied(){
		this.visitied = true;
	}
	public void clearVisited(){
		this.visitied =false;
	}
	
	public boolean getVisitied(){
		return this.visitied;
	}
	public void setParent(Point p){
		this.parent = p;
	}
	public void clearParent(){
		this.parent = null;
	}
	public Point getParent(){
		return this.parent;
	}
	public void setObstacle(){
		this.obstacle = true;
	}
	public boolean getObstacle(){
		return this.obstacle;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public String toString(){
		return "x: " + this.x + " Y: "+ this.y;
	}

	

}
