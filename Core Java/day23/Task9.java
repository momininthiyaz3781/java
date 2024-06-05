package day23;
import java.util.Arrays;

public class Task9 {
	public static <T> void swap(T[] array, int index1, int index2) {
		T temp =array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	public static void main(String[] args) {
		Integer[] intArray= {1,2,3,4,5};
		System.out.println("ORG array:- "+Arrays.toString(intArray));
		swap(intArray,1,3);
		System.out.println("Swapped integer array:- "+Arrays.toString(intArray));
		
		String[] strArray= {"A","B","C","D","E"};
		System.out.println("ORG string array:- "+Arrays.toString(strArray));
		swap(strArray,0,4);
		System.out.println("Swapped string array:- "+Arrays.toString(strArray));
		
	}
	}