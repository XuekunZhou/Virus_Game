import java.util.ArrayList;

public class HackerStrategy implements VirusStrategy{
    @Override
    public VirusMove doMove(Player currentPlayer, Player[][] playingField, ArrayList<VirusMove> moveList, int FieldSize) {

        for (int i = 0; i < FieldSize; i++) {
            for (int j = 0; j < FieldSize; j++) {
                if (playingField[i][j] != Player.EMPTY && playingField[i][j] != currentPlayer) {
                    playingField[i][j] = currentPlayer;
                }
            }
        }
        return moveList.get(0);
    }

    @Override
    public String getName() {
        return "Hacker";
    }
}
