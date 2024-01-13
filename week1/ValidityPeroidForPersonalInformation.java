import java.util.*;

class ValidityPeroidForPersonalInformation{
    private Map<Character, Integer> termMap = new HashMap<>();
    private int year, month, day;
    private List<Integer> result = new ArrayList<Integer>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        setDate(today);
        setTerms(terms);
        
        setList(privacies);
            
        int[] answer = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
    
    private void setTerms(String[] terms){
        for(String term : terms){
            String[] unit = term.split(" ");
            Character c = term.charAt(0);
            Integer i = Integer.parseInt(unit[1]);
            termMap.put(c, i);
        }
    }
    
    private void setDate(String today){
        String[] date = today.split("\\.");
        year = Integer.parseInt(date[0]);
        month = Integer.parseInt(date[1]);
        day = Integer.parseInt(date[2]);
    }

    private void setList(String[] privacies){
        int j = 0;
        for(int i = 0 ; i < privacies.length ; i++){
            String[] privacy = privacies[i].split(" ");
            String[] date =  privacy[0].split("\\.");
            Character c = privacy[1].charAt(0);
            
            int limit = termMap.get(c);
            int peroid = (year - Integer.parseInt(date[0]))*12;
            peroid += (month - Integer.parseInt(date[1]));
            if(peroid > limit || ( peroid == limit && (day - Integer.parseInt(date[2])) >= 0) ){
                result.add(i+1);
            }
    }
}
}