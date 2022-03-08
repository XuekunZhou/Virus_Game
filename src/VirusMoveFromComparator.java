import java.util.Comparator;

public class VirusMoveFromComparator implements Comparator<VirusMove> {
    @Override
    public int compare(VirusMove o1, VirusMove o2) {

        if (o1.from.getX() == o2.from.getX())
            if (o1.from.getY() == o2.from.getY())
                return 0;
            else if (o1.from.getY() > o2.from.getY())
                return 1;
            else return -1;
        else if (o1.from.getX() > o2.from.getX())
            return 1;
        else
            return -1;
    }
}
