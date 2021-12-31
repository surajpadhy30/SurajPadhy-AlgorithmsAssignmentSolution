package com.GL.Utils;

public class BinarySearch {

	public boolean Search(double[] stockPrice, double searchValue) {
		// TODO Auto-generated method stub
		return binarySearch(stockPrice,0,stockPrice.length-1,searchValue);
	}

	private boolean binarySearch(double[] stockPrice, int start, int end, double searchValue) {
		int mid= start+ (end-start)/2;
		if(start<=end) {
			if(stockPrice[mid]==searchValue) {
				return true;
			}else if(stockPrice[mid]>searchValue) {
				return binarySearch(stockPrice, start, mid-1, searchValue);
			}else {
				return binarySearch(stockPrice, mid+1, end, searchValue);
			}
		}
		return false;
	}

}
