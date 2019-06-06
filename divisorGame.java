/*
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.

Return True if and only if Alice wins the game, assuming both players play optimally.


*/ 
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
