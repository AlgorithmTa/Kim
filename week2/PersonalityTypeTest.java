import java.util.*;


class PersonalityTypeTest {
    private int[] scores;
    private char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
    private Map<Character, Integer> typeNumber = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
    
        scores = new int[4];
        
        typeNumber.put('R', 1);
        typeNumber.put('T', -1);
        typeNumber.put('C', 2);
        typeNumber.put('F', -2);
        typeNumber.put('J', 3);
        typeNumber.put('M', -3);
        typeNumber.put('A', 4);
        typeNumber.put('N', -4);
        
        String answer = "";
        for(int i = 0 ; i < survey.length; i++){
            String type = survey[i];
            char disAgree = type.charAt(0);
            char agree = type.charAt(1);
            int typeNum = Math.abs(typeNumber.get(agree)) - 1;
            int score = choices[i] - 4;
            if(typeNumber.get(agree) > 0) scores[typeNum] +=-1 * score;
            else  scores[typeNum] += score;
        }
        
        for(int i = 0 ; i < 4 ; i++){
            if(scores[i] > 0)
                answer += types[i][1];
            else answer += types[i][0];
        }
        
        return answer;
    }
    
    
}