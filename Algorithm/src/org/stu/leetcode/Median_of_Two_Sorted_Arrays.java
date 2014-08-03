package org.stu.leetcode;


/**
 * 
 * 题目：There are two sorted arrays A and B of size m and n respectively.
 *      Find the median of the two sorted arrays. 
 * 		The overall run time complexity should be O(log (m+n)).
 * 所以如果长度为偶数，需要找出中间的两个数，相加除以2。
 * @author ym
 * 
 * 解法：题目等同于求两个有序数组合并后的第K小的元素。
 */
public class Median_of_Two_Sorted_Arrays {
	
	public class Solution {
		
		public double findK(int[] a, int[] b, int k){
			int a1 = 0;
			int a2 = a.length -1;
			int b1 = 0;
			int b2 = b.length -1;
			int mida = 0;
			int midb = 0;
			
			while (a1 <= a2 && b1 <= b2){
				mida = (a1 + a2) / 2;
				midb = (b1 + b2) / 2;
				if (a[mida] <= b[midb]){
					if (k <= mida - a1 + midb - b1 + 1)
						b2 = midb - 1; //去掉数组b的后midb个元素，因为题目等同求第k小元素，去掉的是大的数，所以不修改k值
					else {
						k = k - (mida - a1 + 1); // 去掉数组a的前mida个元素，同时修改k值，因为去掉的是小的数
						a1 = mida + 1; 
					}
				} else {
					if (k <= mida - a1 + midb - b1 + 1)
						a2 = mida - 1;
					else {
						k = k - (midb - b1 + 1);
						b1 = midb + 1;
					}
				}
			}
			
			if (a1 <= a2)
				return a[a1 + k - 1];
			else 
				return b[b1 + k - 1];
			
		}
		
		public double findMedianSortedArrays(int A[], int B[]) {
			int k = A.length + B.length;
			if (k % 2 == 0){
				double v1 = findK(A, B, k / 2);
				double v2 = findK(A, B, k / 2 + 1);
				return (v1 + v2) / 2;
			}
			return findK(A, B , k / 2 + 1);
		}
	}
	
	public static void main(String[] args) {
		Median_of_Two_Sorted_Arrays m = new Median_of_Two_Sorted_Arrays();
		Solution s = m.new Solution();
		int [] a = new int []{1, 2};
		int [] b = new int []{1, 2};
		double result = s.findMedianSortedArrays(a, b);
		System.out.println(result);
	}
}
