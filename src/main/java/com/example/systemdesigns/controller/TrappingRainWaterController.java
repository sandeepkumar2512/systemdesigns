package com.example.systemdesigns.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/design/trappingrainwater")
public class TrappingRainWaterController {
	/**
	 * {6,2,3,0,4,1,2,5} each no. denotes wall height. Width of each wall is 1sq. unit. Find the total amount of water trapped
	 *   _
	 *  | |            _
	 *  | |      _    | |
	 *  | |  _  | |   | | 
	 *  | |_| | | |  _| | 
	 *  | | | | | |_| | |
	 *  | | | |_| | | | |
	 *   6 2 3 0 4 1 2 5 (wall height)
	 *   1 2 3 4 5 6 7 8 (wall no.)
	 *  
	 *  water trapped by wall 1 = 0
	 *  water trapped by wall 2 = min(max left wall height, max right wall height) - wall height = min(6,5) - 2 = 5-2 = 3
	 *  water trapped by wall 3 = min(max left wall height, max right wall height) - wall height = min(6,5) - 3 = 5-2 = 2
	 *  water trapped by wall 4 = min(max left wall height, max right wall height) - wall height = min(6,5) - 0 = 5-0 = 5
	 *  water trapped by wall 5 = min(max left wall height, max right wall height) - wall height = min(6,5) - 4 = 5-4 = 1
	 *  water trapped by wall 6 = min(max left wall height, max right wall height) - wall height = min(6,5) - 4 = 5-1 = 4
	 *  water trapped by wall 7 = min(max left wall height, max right wall height) - wall height = min(6,5) - 4 = 5-2 = 3
	 *  water trapped by wall 8 = 0
	 *  
	 *  Total water trapped = 18
	 *   
	 */
	@GetMapping("/find-trapped-water")
	public void findTrappedWater() {
		int[] arr = {6,2,3,0,4,1,2,5};
		int[] maxLeftArr = new int[arr.length];
		int[] maxRightArr = new int[arr.length];
		
		int maxLeft = -1;
		int maxRight = -1;
		for(int i=0,j=arr.length-1; i < arr.length && j > -1; i++,j--) {
			if(maxLeft < arr[i]) {
				maxLeft = arr[i];
			}
			if(maxRight < arr[j]) {
				maxRight = arr[j];
			}
			
			if(i==0) 
				maxLeftArr[i]=0;
			else 
				maxLeftArr[i] = maxLeft;
			
			if(j==arr.length-1) 
				maxRightArr[j]=0;
			else
				maxRightArr[j]=maxRight;
		}
		System.out.println("max left arr" + maxLeftArr);
		System.out.println("max right arr" + maxRightArr);
		
		int totalTrappedWater = 0;
		for(int i = 1; i < arr.length - 1 ; i++) {
			if(maxLeftArr[i] > maxRightArr[i]) {
				totalTrappedWater = totalTrappedWater + (maxRightArr[i] - arr[i]);	
			}else {
				totalTrappedWater = totalTrappedWater + (maxLeftArr[i] - arr[i]);
			}
		}
		System.out.println("Total trapped water : " + totalTrappedWater);
	}

}
