import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StrategyOne implements VirusStrategy{
    private int greenCount;
    private int redCount;

    @Override
    public VirusMove doMove(Player currentPlayer, Player[][] playingField, ArrayList<VirusMove> moveList, int FieldSize) {

        ArrayList<Result> list = new ArrayList<Result>();
        Count(playingField, FieldSize);

        for (VirusMove move :
             moveList) {

            // copy playing field
            Player[][] copy = Arrays.stream(playingField).map(Player[]::clone).toArray(Player[][]::new);

            int fromX = (int) move.from.getX();
            int fromY = (int) move.from.getY();
            int toX = (int) move.to.getX();
            int toY = (int) move.to.getY();
            if (Math.abs(fromX-toX) > 1 || Math.abs(fromY - toY) > 1){
                playingField[fromX][fromY] = Player.EMPTY;
            }
            playingField[toX][toY] = currentPlayer;
            //take enemy viruses
            for (int x = toX - 1; x <= toX + 1; x++){
                for (int y = toY - 1; y <= toY + 1; y++){
                    if (y >= 0 && x >= 0 && y < FieldSize && x < FieldSize && playingField[x][y] != Player.EMPTY){
                        copy[x][y] = currentPlayer;
                    }
                }
            }

            int red = 0;
            int green = 0;

            for (int i = 0; i < FieldSize; i++) {
                for (int j = 0; j < FieldSize; j++) {
                    if (playingField[i][j] == Player.RED) {
                        red++;
                    }
                    if (playingField[i][j] == Player.GREEN) {
                        green++;
                    }
                }
            }

            int gains = 0;
            int redChange = red - redCount;
            int greenChange = green - greenCount;

            if (currentPlayer == Player.RED) {
                gains = greenChange - redChange;
            }
            if (currentPlayer == Player.GREEN) {
                gains = redChange - greenChange;
            }

            list.add(new Result(gains, move));
        }

        Result bestMove = list.get(0);
        for (Result res : list) {
            if (res.youGain > bestMove.youGain) {
                bestMove = res;
            }
        }

        return bestMove.Move;
    }

    private void Count(Player[][] playingField, int FieldSize)
    {
        for (int i = 0; i < FieldSize; i++) {
            for (int j = 0; j < FieldSize; j++) {
                if (playingField[i][j] == Player.RED) {
                    redCount ++;
                }
                if (playingField[i][j] == Player.GREEN) {
                    greenCount++;
                }
            }
        }
    }


    @Override
    public String getName() {
        return "One";
    }
}
