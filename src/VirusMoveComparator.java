import java.util.Comparator;

public class VirusMoveComparator implements Comparator<VirusMove> {
    @Override
    public int compare(VirusMove o1, VirusMove o2) {

        if (o1.to.getX() == o2.to.getX())
            if (o1.to.getY() == o2.to.getY())
                return 0;
            else if (o1.to.getY() > o2.to.getY())
                return 1;
            else return -1;
        else if (o1.to.getX() > o2.to.getX())
            return 1;
        else
            return -1;
    }
}
