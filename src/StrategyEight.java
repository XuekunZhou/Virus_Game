import java.util.ArrayList;

public class StrategyEight implements VirusStrategy{

    private class Result {
        public int youGain;
        public VirusMove Move;

        public Result(int gain, VirusMove move) {
            youGain = gain;
            Move = move;
        }
    }

    @Override
    public VirusMove doMove(Player currentPlayer, Player[][] playingField, ArrayList<VirusMove> moveList, int FieldSize) {

        ArrayList<Result> list = new ArrayList<>();

        for (VirusMove move : moveList) {

            int gain = 1;

            int fromX = (int) move.from.getX();
            int fromY = (int) move.from.getY();
            int toX = (int) move.to.getX();
            int toY = (int) move.to.getY();
            if (Math.abs(fromX-toX) > 1 || Math.abs(fromY - toY) > 1){
                gain -= 1;
            }
            //take enemy viruses
            for (int x = toX - 1; x <= toX + 1; x++){
                for (int y = toY - 1; y <= toY + 1; y++){
                    if (y >= 0 && x >= 0 && y < FieldSize && x < FieldSize && playingField[x][y] != Player.EMPTY && playingField[x][y] != currentPlayer){
                        gain++;
                    }
                }
            }

            list.add(new Result(gain, move));
        }

        Result bestMove = list.get(0);
        for (Result res : list) {
            if (res.youGain >= bestMove.youGain) {
                bestMove = res;
            }
        }

        return bestMove.Move;
    }


    @Override
    public String getName() {
        return "Eight";
    }
}
