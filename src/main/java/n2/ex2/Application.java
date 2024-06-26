package n2.ex2;

import n2.ex1.models.Restaurant;

import java.util.*;
import java.lang.*;
import java.util.Map.Entry;

public class Application {

    private static int keyCounter = 0;

    public static void testApp() {
        HashMap<Integer, Restaurant> restaurantsMap = new HashMap<>();
        Restaurant restaurant1 = new Restaurant("Wok", 4);
        addRestaurant(restaurantsMap, restaurant1);

        Restaurant restaurant2 = new Restaurant("Trattoria", 10);
        addRestaurant(restaurantsMap, restaurant2);


        Restaurant restaurant3 = new Restaurant("Wok", 2);
        addRestaurant(restaurantsMap, restaurant3);

        Restaurant restaurant4 = new Restaurant("Trattoria", 7);
        addRestaurant(restaurantsMap, restaurant4);


        Restaurant restaurant5 = new Restaurant("Burger", 10);
        addRestaurant(restaurantsMap, restaurant5);


        Restaurant restaurant6 = new Restaurant("Burger", 5);
        addRestaurant(restaurantsMap, restaurant6);


        Restaurant restaurant7 = new Restaurant("Trattoria", 6);
        addRestaurant(restaurantsMap, restaurant7);


        Restaurant restaurant8 = new Restaurant("Burger", 8);
        addRestaurant(restaurantsMap, restaurant8);


        Restaurant restaurant9 = new Restaurant("Wok", 9);
        addRestaurant(restaurantsMap, restaurant9);

        //Print the map to check how is sorted.
        printMap(restaurantsMap);

        //Method that sorts the restaurants from the Map and prints it.
        printSortedRestaurants(restaurantsMap);


    }

    public static boolean checkIsSame(HashMap<Integer, Restaurant> restaurantsMap, Restaurant restaurant) {
        boolean isSame = false;
        Iterator<Entry<Integer, Restaurant>> iterator = restaurantsMap.entrySet().iterator();
        while (iterator.hasNext() && !isSame) {
            Entry<Integer, Restaurant> entry = iterator.next();
            if (entry.getValue().getName().equalsIgnoreCase(restaurant.getName()) &&
                    entry.getValue().getScore() == restaurant.getScore()) {
                isSame = true;
            }
        }
        return isSame;
    }

    public static void addRestaurant(HashMap<Integer, Restaurant> restaurantsMap, Restaurant restaurant) {
        Boolean isSame = checkIsSame(restaurantsMap, restaurant);
        if (!isSame) {
            keyCounter++;
            restaurantsMap.put(keyCounter, restaurant);
        } else {
            System.out.println("The restaurant cannot be added to the list.");
        }
    }

    public static void printMap(HashMap<Integer, Restaurant> restaurantsMap) {
        for (Entry<Integer, Restaurant> entry : restaurantsMap.entrySet()) {
            System.out.println(entry.getKey() + " - Name: " + entry.getValue().getName() +
                    ", score: " + entry.getValue().getScore());
        }
    }

    public static void printSortedRestaurants(HashMap<Integer, Restaurant> restaurantsMap) {
        List<Map.Entry<Integer, Restaurant>> entries = new ArrayList<>(restaurantsMap.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<Integer, Restaurant>>() {

            public int compare(Map.Entry<Integer, Restaurant> entry1, Map.Entry<Integer, Restaurant> entry2) {
                int nameCompare = entry1.getValue().getName().compareTo(entry2.getValue().getName());
                if (nameCompare == 0) {
                    return Integer.compare(entry1.getValue().getScore(), entry2.getValue().getScore());
                }
                return nameCompare;
            }
        });

        for(Map.Entry<Integer, Restaurant> entry : entries){
            System.out.println(entry.getKey()+" - Name: "+entry.getValue().getName()+
                    ", score: "+entry.getValue().getScore());

    }

    }

}


