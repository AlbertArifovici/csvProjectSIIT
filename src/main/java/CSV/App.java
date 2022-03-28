package CSV;

import java.io.*;
import java.util.TreeSet;


public class App {
    TreeSet<Athlete> athletes = new TreeSet<>(new AthletesComparator());

    public void readAthletes() {

        File f = new File("/Users/albertarifovici/IdeaProjects/csvProject/src/main/resources/Athletes.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] input = line.split(",");
                athletes.add(new Athlete(input[0], input[1], input[2], input[3], input[4], input[5], input[6]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not accessible");
        }
    }

    public void printResults() {

        System.out.println("Results: ");
        int i = 1;
        for (Athlete athlete : athletes) {
            System.out.println("Ranking " + i + ": " + athlete.getAthleteName());
            i++;
        }
    }

    public static void main(String[] args) {
        App leaderboard = new App();
        leaderboard.readAthletes();
        leaderboard.printResults();
    }
}