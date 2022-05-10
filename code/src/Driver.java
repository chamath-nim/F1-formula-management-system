import java.util.ArrayList;

abstract class Driver {
    private static ArrayList<ArrayList<String>> dataList = new ArrayList<>();
    private static ArrayList<Integer> pointList = new ArrayList<>();
    private static ArrayList<String> dates = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> positions = new ArrayList<>();
    private static ArrayList<ArrayList<String>> race = new ArrayList<>();

    public static ArrayList<ArrayList<String>> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<ArrayList<String>> dataList) {
        Driver.dataList = dataList;
    }

    public static ArrayList<Integer> getPointList() {
        return pointList;
    }

    public void setPointList(ArrayList<Integer> pointList) {
        Driver.pointList = pointList;
    }

    public static ArrayList<String> getDates() {
        return dates;
    }

    public void setDates(ArrayList<String> dates) {
        Driver.dates = dates;
    }

    public static ArrayList<ArrayList<Integer>> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<ArrayList<Integer>> positions) {
        Driver.positions = positions;
    }

    public static ArrayList<ArrayList<String>> getRace() {
        return race;
    }

    public static void setRace(ArrayList<ArrayList<String>> race) {
        Driver.race = race;
    }
}