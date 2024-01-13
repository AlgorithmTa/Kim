class EmoticonSaleFestival{
    
    private int[][] users;
    private int[] emoticons;
    private int[] selection;
    private int sale = 0;
    private int plus = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        selection = new int[emoticons.length];
        
        makeSelection(0, emoticons.length);
        int[] answer = new int[2];
        answer[0] = plus;
        answer[1] = sale;
        return answer;
    }
    
    public void makeSelection(int n, int max){
        if(n==max){
            calculate();
            return;
        }
        
        for(int i = 10 ; i <= 40 ; i+= 10){
            selection[n] = i; 
            makeSelection(n+1, max);
        }
    }
    
    public void calculate(){
        int nowPlus = 0;
        int nowSale = 0;
        for(int i = 0 ; i < users.length; i++){
            int money = 0;

            for(int j = 0 ; j < emoticons.length ; j++){
                if(users[i][0] > selection[j]) continue;
                money += (emoticons[j] /100  * (100 - selection[j]));
            }
            
            if(money >= users[i][1])    nowPlus++;
            else nowSale += money;
            
        }
        
        if(nowPlus > plus){
            plus = nowPlus;
            sale = nowSale;
        }
        else if(nowPlus == plus && nowSale > sale)
            sale = nowSale;
    }
}