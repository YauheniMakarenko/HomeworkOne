package homeworkFour;

import java.util.List;
import java.util.Map;

public class Mathematics {


    public Mathematics(){
    }

    public int add (int a, int b){
        return a += b;
    }

    public double add (double a, double b){
        return a += b;
    }

    public String add (String a, String b){
        return a.concat(b);
    }

    public int[] add (int[] givenArrayOne, int[] givenArrayTwo){
        int[] rezult = new int[givenArrayOne.length + givenArrayTwo.length];
        System.arraycopy(givenArrayOne, 0, rezult, 0, givenArrayOne.length);
        System.arraycopy(givenArrayTwo, 0, rezult, givenArrayOne.length, givenArrayTwo.length);
        return rezult;
    }

    public List add (List listOne, List listTwo){
        listOne.addAll(listTwo);
        return listOne;
    }

    public Map add (Map mapOne, Map mapTwo){
        mapOne.putAll(mapTwo);
        return mapOne;
    }

}
