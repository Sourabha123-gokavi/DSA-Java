import java.util.HashMap;

public class Tickets {


    public static String Start(HashMap<String,String>Map){
        HashMap<String,String>revMap=new HashMap<>();
        for (String city : Map.keySet()) {
            revMap.put(Map.get(city), city);
        }
        for (String city : Map.keySet()){
            if(!revMap.containsKey(city)){
                return city;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        HashMap<String ,String> map=new HashMap<>();
        map.put("chennai", "bangaluru");
        map.put("mumbai", "delhi");
        map.put("goa", "chennai");
        map.put("delhi", "goa");
        String start=Start(map);
        System.out.print(start);
        for (String key : map.keySet()) {
            System.out.print("-> "+map.get(start));
            start=map.get(start);
        }

    }
}
