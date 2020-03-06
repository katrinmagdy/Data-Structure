package eg.edu.alexu.csd.datastructure.iceHockey;
import java.awt.Point;
import java.lang.*;

public class hockey implements IPlayersFinder {
	
	public void swap(Point[] points,int a,int b) {
		int tempx = points[a].x;
		int tempy = points[a].y;
		
		points[a].x = points[b].x;
		points[a].y = points[b].y;
		
		
		points[b].x = tempx; 
		points[b].y = tempy; 
	}
	
	public void sort_x(Point[] points,int p) {
		for(int i=0;i<p;i++) {
			for(int j=0;j<p-1-i;j++) {
				if(points[j].x>points[j+1].x){
					 swap(points,j,j+1);
				}
			}
		}
	}
	
	public void sort_y(Point[] points,int p) {
		for(int i=0;i<p;i++) {
			for(int j=0;j<p-1;j++) {
				if(points[j].x ==points[j+1].x) {
					if(points[j].y>points[j+1].y) {
						 swap(points,j,j+1);
					}
				}
			}
		}
	}
	
	public int max_x(int[][] player,int length) {
		int max=player[0][0];
		for(int i=1;i<length;i++) {
			if(player[0][i]>max) {
				max=player[0][i];
			}
		}
		return max;
	}
	
	public int max_y(int[][] player,int length) {
		int max=player[1][0];
		for(int i=1;i<length;i++) {
			if(player[1][i]>max) {
				max=player[1][i];
			}
		}
		return max;
	}
	
	public int min_x(int[][] player,int length) {
		int min=player[0][0];
		for(int i=1;i<length;i++) {
			if(player[0][i]<min) {
				min=player[0][i];
			}
		}
		return min;
	}
	
	public int min_y(int[][] player,int length) {
		int min=player[1][0];
		for(int i=1;i<length;i++) {
			if(player[1][i]<min) {
				min=player[1][i];
			}
		}
		return min;
	}
	
	public void zeros(int[][] player,int length) {
		for(int i=0;i<2;i++) {
			for(int j=0;j<length;j++) {
				player[i][j]=0;
			}
		}
	}
	
	
	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
		if(photo.length ==0){
			return null;
		}
		else if(team<0||team>9) {
			return null;
		}
		else if(threshold<1||threshold>10000) {
			return null;
		}
		else {
			
		int[][] item =new int[3][2500];
		int k=-1;
		int q,l,m=0,p=0;
		Point[] points=new Point[2500];
		
		for (int i=0;i<photo.length;i++){
			for(int j=0;j<photo[i].length();j++){
				if(photo[i].charAt(j)>='0'&& photo[i].charAt(j)<='9') {
					String c = String.valueOf(photo[i].charAt(j));
					if(Integer.parseInt(c) == team) {
						k++;
						item[0][k]=j;
						item[1][k]=i;
				    	}
					}
			}
		}
		
		int[][] player =new int[2][2500];
		
		for(q=0;q<=k;q++) {
			int length=0,plus=0;
			if(item[2][q]!=-1) {
				player[0][plus]=item[0][q];
				player[1][plus]=item[1][q];
				item[2][q]=-1;
				length++;
				for(l=0;l<=k;l++) {
					if(item[2][l]!=-1) {
						while(m<length){
							if((Math.abs(item[0][l]-player[0][m]) +Math.abs(item[1][l] -player[1][m])) ==1){
								if(item[2][l]!=-1) {
								length++;
								plus++;
								player[0][plus]=item[0][l];
								player[1][plus]=item[1][l];
								item[2][l]=-1;
								}
								m++;
								l=0;
							
							}
							else {
								m++;
							}
					}
						m=0;
					}
					
				}
			}
			
			if(length*4>=threshold) {
				int x_min=min_x(player,length);
				int x_max=max_x(player,length);
				int y_min=min_y(player,length);
				int y_max=max_y(player,length);
				
				int no_x=x_max-x_min+1;
				int no_y=y_max-y_min+1;
				points[p] =new Point();
				points[p].x=(2*x_min)+no_x;
				points[p].y=(2*y_min)+no_y;
				p++;
				zeros(player, length);
			}
			else {
				zeros(player, length);
			}

		}
		sort_x(points, p);
		sort_y(points, p);
		Point[] points2= new Point[p];
		for(int i=0;i<p;i++) {
			points2[i] =new Point();
			points2[i].x = points[i].x;
			points2[i].y = points[i].y;
		}
		
		
		return points2;
		
	  }
	}

}

