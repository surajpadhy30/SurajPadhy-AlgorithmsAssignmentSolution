package com.GL.StockerDriverC;

import java.util.Scanner;

import com.GL.Utils.BinarySearch;
import com.GL.Utils.MergeSort;

public class StockersDriver {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [] stockPrice;
		System.out.println("Enter the no of companies:");
		stockPrice = new double[sc.nextInt()];
		int declinedStockPrice = 0;
		int roseStockPrice = 0;
		double SearchValue;
		int Iterator = -1;
		for (int i = 0; i < stockPrice.length; i++) {
			System.out.println("Enter current stock price of the company " + (i + 1));
			stockPrice[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			if (sc.next().trim().equalsIgnoreCase(Boolean.toString(true))) {
				roseStockPrice++;
			} else {
				declinedStockPrice++;
			}
		}
		MergeSort mSort = new MergeSort();
		mSort.sort(stockPrice, 0, stockPrice.length - 1);
		while (Iterator != 0) {
			System.out.println("\n-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform:");
			System.out.println("1. Display the companies stock prices in ascending order\n"
					+ "2. Display the companies stock prices in descending order\n"
					+ "3. Display the total no of companies for which stock prices rose today\n"
					+ "4. Display the total no of companies for which stock prices declined today\n"
					+ "5. Search a specific stock price\n" 
					+ "6. press 0 to exit");
			System.out.println("-----------------------------------------------");
			Iterator = sc.nextInt();
			switch (Iterator) {
			case 1:
				System.out.println("Stock prices in ascending order are :");
				for(int i=0;i<stockPrice.length;i++) {
					System.out.print(stockPrice[i]+" ");
				}
				System.out.println("\n");
				break;
			case 2:
				System.out.println("Stock prices in descending order are :");
				for(int i=stockPrice.length-1;i>-1;i--) {
					System.out.print(stockPrice[i]+" ");
				}
				System.out.println("\n");
				break;
			case 3:
				System.out.println("Total no of companies whose stock price rose today: "+roseStockPrice);
				break;
			case 4:
				System.out.println("Total no of companies whose stock price declined today: "+declinedStockPrice);
				break;
			case 5:
				System.out.println("Enter the key value:");
				SearchValue=sc.nextDouble();
				BinarySearch bs=new BinarySearch();
				if(bs.Search(stockPrice,SearchValue)) {
					System.out.println("Stock of value "+SearchValue+" is present");
				}else {
					System.out.println("Value not found");
				}
				break;
			default:
				if(Iterator!=0)
					System.out.println("Invalid Input try again");
				break;
			}

		}
		System.out.println("Exited successfully");

	}

}
