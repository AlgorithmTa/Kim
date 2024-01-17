class CodingTestStudy {
    private int maxAlP = 0, maxCP = 0;
    private int[][] d;
    public int solution(int alp, int cop, int[][] problems) {
        setNeeds(problems);
        d = new int[maxAlP+1][maxCP+1];
        dInit();
        alp = Math.min(alp, maxAlP);
        cop = Math.min(cop, maxCP);
        
        
        d[alp][cop] = 0;
        
        for(int i = alp ; i <= maxAlP ; i ++){
            for(int j = cop ; j <= maxCP ; j++){
                if(i < maxAlP) d[i+1][j] = Math.min(d[i+1][j], d[i][j] + 1);
                if(j < maxCP) d[i][j+1] = Math.min(d[i][j+1], d[i][j] + 1);
                for(int[] problem : problems){
                    if(problem[0] <= i && problem[1] <= j){

                        int newAlP = Math.min(i + problem[2], maxAlP);
                        int newCP = Math.min(j + problem[3], maxCP);

                        d[newAlP][newCP] = Math.min(d[newAlP][newCP], d[i][j] + problem[4]);
                    }
                }
            }
        }
        
        return d[maxAlP][maxCP];
    }
    
    public void setNeeds(int[][] problems){
        for(int[] problem : problems){
            maxAlP = Math.max(problem[0] , maxAlP);
            maxCP = Math.max(problem[1] , maxCP);
        }
    }
    
    public void dInit(){
        for(int i = 0 ; i < d.length ; i++){
            for(int j = 0 ; j < d[0].length ; j++)
                d[i][j] = Integer.MAX_VALUE;
        }
    }
}
