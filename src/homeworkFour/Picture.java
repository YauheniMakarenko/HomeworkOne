package homeworkFour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Picture {

    private List<Figure> list = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();


    public void addToList(Figure figure) {
        list.add(figure);
    }

    public double sumPerimetersOfFigures() {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).periment();
        }
        return sum;
    }

    public double sumAreasOfFigures() {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).area();
        }
        return sum;
    }

    public String namesOfFigures() {
        String sum = "";
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getName() + " ";
        }
        return sum;
    }

    public Map<String, Integer> countDifferentFigures() {
        for (int i = 0; i < list.size(); i++) {
            Integer count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getName().equals(list.get(i).getName())) {
                    count += 1;
                }
            }
            map.put(list.get(i).getName(), count);
        }
        return map;
    }
}
