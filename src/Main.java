import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        VirusGame game = new VirusGame(7);
        // game.virusSingleGame(new StrategyThree(), new RandomVirusStrategy());

        ArrayList<VirusStrategy> strategies = new ArrayList<>();

        strategies.add(new RandomVirusStrategy());

        strategies.add(new StrategyOne());
        strategies.add(new StrategyTwo());
        strategies.add(new StrategyThree());

        strategies.add(new StrategyFour());
        strategies.add(new StrategyFive());
        strategies.add(new StrategySix());

        strategies.add(new StrategySeven());
        strategies.add(new StrategyEight());
        strategies.add(new StrategyNine());

        game.virusTournament(strategies);
    }
}
