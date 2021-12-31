package com.GL.Utils;

public class MergeSort {
	void merge(double[] stockPrice, int left, int mid, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		double leftArray[] = new double[n1];
		double rightArray[] = new double[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = stockPrice[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = stockPrice[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				stockPrice[k] = leftArray[i];
				i++;
			} else {
				stockPrice[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			stockPrice[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			stockPrice[k] = rightArray[j];
			j++;
			k++;
		}
	}

	// Main function that sorts array[left...right] using merge()
	public void sort(double[] stockPrice, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sort(stockPrice, left, mid);
			sort(stockPrice, mid + 1, right);

			// Merge the sorted halves
			merge(stockPrice, left, mid, right);
		}
	}
}
