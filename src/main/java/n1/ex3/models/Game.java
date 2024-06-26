package n1.ex3.models;

import java.io.*;
import java.util.*;


public class Game {
    private static HashMap<String, String> countryList;

    public Game(HashMap<String, String> countryList) {
        this.countryList = countryList;
    }

    public static void testApp(){
        countryList = new HashMap<>();
        readFile(countryList);
        printHashMap(countryList);
        HashMap<String, Integer> score = capitalQuiz(countryList);
        createFile(score);

    }
    public static void readFile(HashMap<String, String> countryList){

        try {
            File fr = new File("src/main/resources/countries.txt");
            BufferedReader bf = new BufferedReader( new FileReader("src/main/resources/countries.txt"));
            String line;

            while((line = bf.readLine()) != null){
                if (line != null){
                    String[] parts = line.split(" ");
                    if(parts.length >=2){
                        String country = parts[0];
                        String capital = parts[1];
                        if(!country.equals("") && !capital.equals("")){
                            countryList.put(country, capital);
                        }
                    }
                }
            }
            bf.close();
            System.out.println("File created successfully.");

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Failed or interrupted operation");
        }
    }
    //Prove that the HashMap is correct.
    public static void printHashMap(HashMap<String, String> countryList){
        for(Map.Entry<String, String> entry : countryList.entrySet()){
            System.out.println("Country: "+ entry.getKey()+", Capital: "+entry.getValue());
        }
    }
    public static HashMap<String, Integer> capitalQuiz(HashMap<String, String> countryList){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> score = new HashMap<>();

        System.out.println("Enter your name: ");
        String userName = sc.nextLine();
        int i = 1;
        int points = 0;
        System.out.println("Write the capital from each country that it will appear below:");

        while(i<=10){
            String randomCountry = randomKey(countryList);
            System.out.println("Country "+i+" :"+randomCountry);
            String capitalAnswer = sc.nextLine();
            boolean isCorrect = checkAnswer(countryList, capitalAnswer);
            if(isCorrect){
                points++;
                i++;
            } else {
                i++;
            }
        }
        score.put(userName, points);
        return score;

    }
    public static String randomKey(HashMap<String, String> countryList){
        Random r = new Random();
        Object[] keys = countryList.keySet().toArray();
        String randomCountry = (String) keys[r.nextInt(keys.length)];
        return randomCountry;
    }
    public static boolean checkAnswer(HashMap<String, String> countryList, String capitalAnswer){
        boolean isCorrect = false;
        Iterator<Map.Entry<String, String>> iterator = countryList.entrySet().iterator();
        while(iterator.hasNext() && !isCorrect){
            Map.Entry<String, String> entry = iterator.next();
                if(capitalAnswer.equalsIgnoreCase(entry.getValue())){
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }
            }
        return isCorrect;
    }
    public static void createFile(HashMap<String, Integer> score){
        String outputFilePath = ("src/main/resources/score.txt");
        File scoreFile = new File(outputFilePath);
        BufferedWriter bfr = null;
        try{
            bfr = new BufferedWriter(new FileWriter(scoreFile));

            for(Map.Entry<String, Integer> entry : score.entrySet()) {
                bfr.write(entry.getKey()+" : "+entry.getValue());

                bfr.newLine();
            }
            bfr.flush();
        } catch(IOException e){
            e.printStackTrace();
        }
        finally{
           try{
               bfr.close();
           } catch(Exception e){

           }
        }
    }
}
