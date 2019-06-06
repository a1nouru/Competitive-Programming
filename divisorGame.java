class Solution {
    public boolean divisorGame(int N) {
        int A = 0, B = 0;
        boolean boolA = false; //Making sure alice starts the game 
        while(0 < 1 && 1 < N){ 
                N -= 1; 
                if (!boolA){ //is it alice's turn? 
                    A++;
                    boolA = !boolA; //Alice just played, now next turn is for bob
                }
                else {
                    B++;
                    boolA = !boolA; //Bob just played, now next turn is for Alice 
                }   
        }
        return A > B; //If Alice has played more than bob 
    }
}
