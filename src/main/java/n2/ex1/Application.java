package n2.ex1;

import n2.ex1.models.Restaurant;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Application {
    private static int keyCounter = 0;

  public static void testApp(){
      HashMap<Integer, Restaurant> restaurantsMap = new HashMap<>();
      Restaurant restaurant1 = new Restaurant("Wok", 20);
      addRestaurant(restaurantsMap, restaurant1);

      Restaurant restaurant2 = new Restaurant("Trattoria", 10);
      addRestaurant(restaurantsMap, restaurant2);

      Restaurant restaurant3 = new Restaurant("Wok", 25);
      addRestaurant(restaurantsMap, restaurant3);

      Restaurant restaurant4 = new Restaurant("Trattoria", 10);
      addRestaurant(restaurantsMap, restaurant4);
      printMap(restaurantsMap);


  }
    public static boolean checkIsSame(HashMap<Integer, Restaurant> restaurantsMap, Restaurant restaurant){
        boolean isSame = false;
        Iterator<Map.Entry<Integer, Restaurant>> iterator = restaurantsMap.entrySet().iterator();
        while(iterator.hasNext() && !isSame){
            Map.Entry<Integer, Restaurant> entry = iterator.next();
            if(entry.getValue().getName().equalsIgnoreCase(restaurant.getName()) &&
                entry.getValue().getScore() == restaurant.getScore()){
                isSame = true;
            }

        }

      return isSame;
    }
    public static void addRestaurant(HashMap<Integer, Restaurant> restaurantsMap, Restaurant restaurant) {
      Boolean isSame = checkIsSame(restaurantsMap, restaurant);
      //Poner el nombre y decir que las puntuaciones son iguales
      if(!isSame){
          keyCounter++;
          restaurantsMap.put(keyCounter, restaurant);
      } else {
          System.out.println("The restaurant cannot be added to the list.");
      }

    }
    public static void printMap(HashMap<Integer, Restaurant> restaurantsMap){
        for(Map.Entry<Integer, Restaurant> entry : restaurantsMap.entrySet()){
            System.out.println(entry.getKey()+" - Name: "+entry.getValue().getName()+
                    ", score: "+entry.getValue().getScore());
        }
    }
}
