import java.util.Comparator;

class sortByPoints implements Comparator<Formula1Driver> {

    @Override
    public int compare(Formula1Driver a,Formula1Driver b){
        if (b.point == a.point){
            return b.positionData.get(0)-a.positionData.get(0);
        }
        else {
            return b.point-a.point;
        }
    }
}
class sortByPosition implements Comparator<Formula1Driver>{

    @Override
    public int compare(Formula1Driver a,Formula1Driver b){
        return a.positionData.get(0) - b.positionData.get(0);
    }
}

class sortByDate implements Comparator<Formula1Driver> {

    @Override
    public int compare(Formula1Driver o1, Formula1Driver o2) {
        return o1.date.compareTo(o2.date);
    }
}