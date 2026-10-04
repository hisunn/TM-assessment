import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equals("END")) {                        
            
            System.out.print("Please enter your address (type 'END' to end program): ");

            userInput = scanner.nextLine();

            String input = userInput;
            
            Boolean isComma = input.contains(",");
            String regex = "";
            if(isComma){
                regex = ",\\s*|\\s+(?=\\b\\d{5}\\b)|(?<=\\b\\d{5}\\b)\\s+";
            }else{
                String cityRegex = "(?:Kuala Terengganu|Kuala Lumpur|Kajang|Bangi|Damansara|Petaling Jaya|Puchong|Subang Jaya|Cyberjaya|Putrajaya|Mantin|Kuching|Seremban)";
                String stateRegex = "(?:Selangor|Terengganu|Pahang|Kelantan|Melaka|Pulau Pinang|Kedah|Johor|Perlis|Sabah|Sarawak)";

                regex = ",\\s*"
                        + "|(?<!(?i)\\bKuala)\\s+(?=(?i)" + stateRegex + "\\s*$)" 
                        + "|\\s+(?=(?i)" + cityRegex + "\\b)"
                        + "|\\s+(?=\\b\\d{5}\\b)"
                        + "|(?<=\\b\\d{5}\\b)\\s+"
                        + "|(?<=\\b\\d+)\\s+(?=[A-Za-z])";   

            }

            String[] splitInput = input.split(regex);
            ArrayList<String> listOfInput = new ArrayList<>();

            Collections.addAll(listOfInput, splitInput);

            Address addressObj = new Address();

            // Process arrayList
            for (String addressInput : listOfInput) {
                System.out.println(addressInput.trim());

                if (addressInput.contains("No")) {
                    addressObj.setApt(addressInput.trim());
                } else if (City.fromString(addressInput) != null) {
                    addressObj.setCity(addressInput);
                } else if (State.fromString(addressInput) != null) {
                    addressObj.setState(addressInput);
                } else if (addressInput.matches("^\\d{5}$")) {
                    addressObj.setPostcode(addressInput);
                } else if (addressInput.contains("Jalan")) {
                    addressObj.setStreet(addressInput.trim());
                } else if (addressInput.contains("Jln")) {
                    addressObj.setStreet(addressInput.trim());
                } else if (addressInput.contains("Lorong")) {
                    addressObj.setStreet(addressInput.trim());
                } else if (addressInput.contains("Persiaran")) {
                    addressObj.setStreet(addressInput);
                } else {
                    addressObj.setSection(addressInput);
                }

            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String addressObjInString = gson.toJson(addressObj);
            System.out.println("\n" + addressObjInString);
        }
        scanner.close();
        
    }
}
