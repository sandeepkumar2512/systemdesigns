package com.example.systemdesigns.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/design/island")
public class IslandProblemController {
	/**
	 * Given a 2D grod of 0s(water) and 1s(land), find the number of islands. An island is surrounded by water formed by connecting adjecent lands
	 * horizontal and vertical. Outside boundary of grid is all water.
	 */
	@PostMapping("/findnumberofislands")
	public void findNumberOfIslands() {
//		int[][] landscape =  {{1,0,0,0,0},{0,1,0,0,1}}; //no. of Islands 3
//		10000
//		01001
		int[][] landscape =  {{1,0,0,0,0},{0,1,0,0,1},{1,0,1,0,1}}; //no. of Islands 5
//		10000
//		01001
//		10101
		
		int noOfIslands = 0;
		boolean[][] visited = new boolean[landscape.length][landscape[0].length];
		for(int i=0; i < landscape.length ; i++) {
			for(int j=0; j < landscape[i].length ; j++) {
				boolean isVisited = processNodes(i,j, landscape,visited);
				if(isVisited) {
					noOfIslands++;
				}
			}
		}
		System.out.println("No. of isLands = " + noOfIslands);
	}

	private boolean processNodes(int i, int j, int[][] landscape, boolean[][] visited) {
		if(i < 0 || i > landscape.length-1 || j < 0 || j > landscape[i].length-1 || landscape[i][j] == 0 || visited[i][j]==true) {
			return false;
		}
		boolean isVisited = true;
		visited[i][j]=true;
		processNodes(i, j-1, landscape,visited);//right - mark visited if 1
		processNodes(i, j+1, landscape,visited);//left - mark visited if 1
		processNodes(i+1, j, landscape,visited);//up - mark visited if 1
		processNodes(i-1, j, landscape,visited);//down - mark visited if 1
		return isVisited;
	}
	
}
