package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class CodeTest {

	public static void main(String[] args) {
		
		int[][]board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,2,4};
		
		int answer = 0;
		
		Vector<Integer> basket = new Vector();
		for(int i=0; i<moves.length; i++){
            int move = moves[i]-1;
            for(int j=0; j<board.length; j++){
                if(board[j][move] != 0){
                    basket.add(board[j][move]);
                    board[j][move] = 0;
                    
                    break;
                }
                
            }
            
        }
		
		boolean delete = false;
		int count = 0;
		for(int i=0; i<basket.size(); i++) {
			count +=  i;
		}
		System.out.println(count);
		System.out.println("바스켓: "+basket);
		int i = 0;
		while(i<count) {			
			System.out.println("테스트전: "+basket);
			if(basket.size() == 0) {
				break;
			}
			if(delete) {
				i = 0;
			}
			System.out.println("i값 "+i);
			System.out.println("바스켓 길이: "+basket.size());
			if(basket.size() == 0) {
				break;
			}
            int next = i+1;
            System.out.println("테스트 하는 숫자: "+basket.get(i)+", "+basket.get(next));
        	if(basket.get(i) == basket.get(next)) {
        		basket.remove(next);
        		basket.remove(i);
        		answer += 2;
        		delete = true;
        		System.out.println("지웠다!!");
        	}else {
        		System.out.println("안지웠다!!");
        		delete = false;
        	}
        	i++;
        	System.out.println("테스트후: "+basket);
        	System.out.println("==============================================");	      
		}
//		for(int i=0; i<count; i++){
//			System.out.println("테스트전: "+basket);
//			if(delete) {
//				i = start;
//			}
//			System.out.println("i값 "+i);
//			System.out.println("바스켓 길이: "+basket.size());
//			if(basket.size() == 0) {
//				break;
//			}
//            int next = i+1;
//            System.out.println("테스트 하는 숫자: "+basket.get(i)+", "+basket.get(next));
//        	if(basket.get(i) == basket.get(next)) {
//        		basket.remove(next);
//        		basket.remove(i);
//        		answer += 2;
//        		delete = true;
//        		System.out.println("지웠다!!");
//        	}else {
//        		System.out.println("안지웠다!!");
//        		delete = false;
//        	}
//        	System.out.println("테스트후: "+basket);
//        	System.out.println("==============================================");
//        }
		
		System.out.println(answer);
	
	}
	    
}
