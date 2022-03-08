import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        VirusGame game = new VirusGame(7);
        //game.virusSingleGame(new StrategyThree(), new RandomVirusStrategy());

        ArrayList<VirusStrategy> list = new ArrayList<VirusStrategy>();
        list.add(new RandomVirusStrategy());
        // list.add(new StrategyOne());
        list.add(new StrategyTwo());
        list.add(new StrategyThree());
        game.virusTournament(list);
    }
}
