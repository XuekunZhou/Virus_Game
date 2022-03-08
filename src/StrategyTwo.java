import java.util.ArrayList;
import java.util.Random;

public class StrategyTwo implements VirusStrategy {

    @Override
    public VirusMove doMove(Player currentPlayer, Player[][] playingField, ArrayList<VirusMove> moveList, int FieldSize) {

        for (VirusMove move : moveList) {
            switch ((int) move.to.getX()) {
                case 1, 3, 5:
                    int x = (int) (move.to.getX() - move.from.getX());
                    int y = (int) (move.to.getY() - move.from.getY());

                    if (Math.abs(x) < 2 && Math.abs(y) < 2)
                        return move;
            }
        }

        Random rand = new Random();
        return moveList.get(rand.nextInt(moveList.size()));
    }

    @Override
    public String getName() {
        return "Two";
    }
}

