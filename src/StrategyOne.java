import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StrategyOne implements VirusStrategy{

    @Override
    public VirusMove doMove(Player currentPlayer, Player[][] playingField, ArrayList<VirusMove> moveList, int FieldSize) {

        moveList.sort(new VirusMoveComparator());

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
            if (res.youGain > bestMove.youGain) {
                bestMove = res;
            }
//            System.out.println(res.Move.from + " to " + res.Move.to + " gains: " +  res.youGain);
        }
//
//        System.out.println();
//        System.out.println("Best move:");
//        System.out.println(bestMove.Move.from + " to " + bestMove.Move.to + " gains: " +  bestMove.youGain);
//        System.out.println();
//
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();

        return bestMove.Move;
    }


    @Override
    public String getName() {
        return "One";
    }
}
