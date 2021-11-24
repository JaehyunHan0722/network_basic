package basic;

import java.util.Arrays;
import java.util.Vector;

public class CodeTest {

	public static void main(String[] args) {
//		Vector<Integer> number = new Vector<Integer>();
//		Vector<Integer> test = new Vector<Integer>();
//		for(int i=1; i<=100; i++) {
//			number.add(i);
//		}
//		number.set(1, 99);
//		System.out.println(number.get(0));
//		System.out.println(number.get(1));
//		System.out.println(number.size());
//		System.out.println(number);
//		test.add(number.get(0));
//		test.add(number.get(1));
//		test.add(number.get(98));
//		test.add(number.get(99));
//		System.out.println();
//		System.out.println(test);
//		test.remove(3);
//		System.out.println(test);
		
//		Vector<Vector<Integer>> number = new Vector<Vector<Integer>>();
//		Vector<Integer> temp = new Vector();
//		for(int i=0; i<5; i++) {
//			for(int j=51; j<=55; j++) {
//				temp.add(j);
//				System.out.println(temp);
//			}
//			temp.clear();
//		}
//		
//		Vector<Integer> number = new Vector<Integer>();
//		number.add(1);
//		number.add(2);
//		number.add(3);
//		number.add(3);
//		number.add(2);
//		int length = number.size()/2;
//		System.out.println(number);
//		for(int j=1; j<=length; j++) {
//			for(int i=0; i<number.size()-1; i++) {
//				System.out.println(i+", "+number.get(i)+", "+number.get(i+1));
//				if(number.get(i) == number.get(i+1)) {
//					number.remove(i+1);
//					number.remove(i);
//					
//				}
//			}
//		}
//		
//		System.out.println(number);

//	    int answer = 0;
//	    
//	    vector<int> basket = new vector();
//	    for(int i=0; j<moves.size(); i++){
//	        int move = moves.get(i);
//	        for(int j=0; j<board.size(); j++){
//	            if(board.get(j).get(move) != 0){
//	                basket.add(board.get(0).get(move));
//	            }
//	        }
//	    }
//	    int number = basket.size()/2;
//	    for(int i=1; i<=number; i++){
//	        for(int j=0; j<basket.size()-1; j++){
//	            if(basket.get(j)==basket.get(j+1)){
//	                basket.remove(j+1);
//	                basket.remove(j);
//	                answer = answer + 2;
//	            }
//	        }
//	    }
//	    return answer;
		
		int[] number = {1,2,3};
		
		
		
		for(int i=0; i<number.length; i++) {
			
			for(int j=0; j<number.length; j++) {
				if(i ==1 ) {
					i = 3;
				}
				System.out.println(i+" "+j);
				
			}
		}
		
		
	}
	    
}
