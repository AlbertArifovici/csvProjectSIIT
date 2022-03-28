package CSV;

public class Athlete {
    private String athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private String firstShootingResult;
    private String secondShootingResult;
    private String thirdShootingResult;
    private int totalTime;
    private int penalty;

    public Athlete(String athleteNumber, String athleteName, String countryCode, String skiTimeResult, String firstShootingResult, String secondShootingResult, String thirdShootingResult) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingResult = firstShootingResult;
        this.secondShootingResult = secondShootingResult;
        this.thirdShootingResult = thirdShootingResult;
        calculateTotalTime();
    }

    public String getAthleteName() {
        return athleteName;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void calculateTotalTime() {

        String[] tokens = skiTimeResult.split(":");
        int minutes = Integer.parseInt(tokens[0]);
        int seconds = Integer.parseInt(tokens[1]);
        penalty = 0;
        String shootResults = firstShootingResult + secondShootingResult + thirdShootingResult;
        for (int i=0; i<shootResults.length(); i++) {
            if (shootResults.charAt(i) == 'o') {
                penalty += 10;
            }
        }
        totalTime = minutes * 60 + seconds + penalty;
    }
}

