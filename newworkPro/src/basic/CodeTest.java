package basic;

import java.util.Arrays;

public class CodeTest {

	public static void main(String[] args) {
		String[] participant = new String[] {"mislav", "stanko", "mislav","han", "ana", "ana", "zzz"};
		String[] completion = new String[] {"ana", "stanko", "ana", "mislav", "han", "mislav"};
		Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = "";
        for(int i=0; i<participant.length-1; i++){
            if(participant[i].charAt(0) != completion[i].charAt(0)){
                answer = participant[i];
                System.out.println(answer);
            }
        }
        if(answer.equals("")){
            answer = participant[participant.length-1];
            System.out.println(answer);
        }
	}

}
