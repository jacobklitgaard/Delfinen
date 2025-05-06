package Results;

public abstract class trainingResults implements Comparable<trainingResults> {
    private String swimmerName;
    private String team;
    private double butterflyTime;
    private double crawlTime;
    private double backstrokeTime;
    private double breaststrokeTime;



    public trainingResults(String swimmerName, String team, double butterflyTime, double crawlTime, double backstrokeTime, double breaststrokeTime) {
        this.swimmerName = swimmerName;
        this.butterflyTime = butterflyTime;
        this.crawlTime = crawlTime;
        this.backstrokeTime = backstrokeTime;
        this.breaststrokeTime = breaststrokeTime;
        this.team = team;

    }

    public String getSwimmerName() {
        return swimmerName;
    }

    public String getTeam() {
        return team;
    }

    public double getButterflyTime() {
        return butterflyTime;
    }

    public double getCrawlTime() {
        return crawlTime;
    }

    public double getBackstrokeTime() {
        return backstrokeTime;
    }

    public double getBreaststrokeTime() {
        return breaststrokeTime;
    }
}

