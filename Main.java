//main class that is used to compile and run the program
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Display the picture
        new DisplayPicture();
        //Create the graph
        World w = new World("AmherstCampus");
        //Ask for starting and ending location
        String s = getUserString("What is the name of your starting location? Type it out exactly as it appears on the map", w);
        String e = getUserString("Which building do you want to end up at?", w);
        Building starting = null;
        Building ending = null;
        for (Building b : w.totalBuildings) {
            if (b.name.equals(s)) starting = b;
            if (b.name.equals(e)) ending = b;
        }
        //Run algorithm
        myDijkstra.createPaths(w, starting, ending);

    }

    //method that takes in user input
    public static String getUserString(String prompt, World w) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        ArrayList<String> buildingNames = new ArrayList<String>();
        for (Building b : w.totalBuildings) {
            buildingNames.add(b.name);
        }
        while (true) {
            try {
                System.out.println(prompt);
                String result = scan.nextLine();
                while (true) {
                    if (buildingNames.contains(result)) {
                        break;
                    } else {
                        //Makes sure user inputted acceptable building name
                        System.out.println("Not an acceptable building or typo, try again");
                        result = scan.nextLine();
                    }
                }
                return result;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Bad answer... try again.");
                scan.nextLine();
            }
        }
    }

}