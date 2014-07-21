package org.stu.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * 暴力枚举
 * 
 */
public class Max_Points_on_a_Line {
	
	
	class Point {
		int x;
	    int y;
	    Point() { x = 0; y = 0; }
	    Point(int a, int b) { x = a; y = b; }
	}
	/**
	 * Definition for a point.
	 * class Point {
	 *     int x;
	 *     int y;
	 *     Point() { x = 0; y = 0; }
	 *     Point(int a, int b) { x = a; y = b; }
	 * }
	 */
	public class Solution {
		public int maxPoints(Point[] points) {				
			if (points.length < 2)
				return points.length;
			
			Map<String, Integer> map = new HashMap<>();
			int globl_max = 0;
			
			Point a = null;
			Point b = null;
			for(int i = 0; i < points.length; i++){
				a = points[i];
				int one_point_max = 0;
				int same_point = 0;
				map.clear();
				for (int j = 0; j < points.length; j++){
					if (j == i)
						continue;
					
					b = points[j];
					if (a.x == b.x && a.y == b.y){ // the same point
						same_point++;
						continue;
					}					

					String result = incline(a, b);
					if (map.keySet().contains(result)){
						int count = map.get(result);
						count++;
						map.put(result, count);
					} else {
						map.put(result, 1);
					}
				}
				
				for(String key: map.keySet()){
					// System.out.println(key + ":" + map.get(key));
					if (one_point_max < map.get(key))
						one_point_max = map.get(key);
				}
				
				if (globl_max < one_point_max + same_point)
					globl_max = one_point_max + same_point;
			}
			
			
			return globl_max + 1;
		}
		
		public String incline(Point a, Point b){
			boolean flag = true;
			
			if (a.x == b.x)
				return "max" + a.x;
			
			if (a.y == b.y)
				return "0";
			
			int dx = b.x - a.x;
			int dy = b.y - a.y;
			
			if (dx * dy < 0){
				flag = false;			
			}
			
			if (dx < 0) dx = -dx;
			if (dy < 0) dy = -dy;
			
			int gcd = gcd(dx, dy);
			String result = (dy / gcd) + "/" + (dx / gcd);
			
			if(flag) 
				return result;
			
			return "-" + result;
		}
		
		public int gcd(int a, int b){
			int g = a % b;
			while (g > 0){
				a = b;
				b = g;
				g = a % b;
			}			
			return b;
		}		
	}
	
	public static void main(String[] args) {
		Max_Points_on_a_Line m = new Max_Points_on_a_Line();
		Solution s = m.new Solution();
		Point a = m.new Point(-4, -4);
		Point b = m.new Point(-8, -582);
		Point c = m.new Point(-3, 3);
		Point d = m.new Point(-9, -651);
		Point e = m.new Point(9, 591);
		System.out.println(s.maxPoints(new Point[]{a, b, c, d, e}));
	}
}



































