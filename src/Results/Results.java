package Results;

import javax.xml.transform.Result;
import java.text.DateFormat;
import java.util.ArrayList;

public class Results {
    protected String date;
    protected int time;
    protected String group;
    protected String discipline;

    
    public Results(int time, String discipline, String group, DateFormat competetion){
        this.time = time;
        this.discipline = discipline;
        this.group = group;
        this.date = date;
        this.discipline = discipline;
    }

    private void disciplines() {
        disciplines.add("Butterfly");
        disciplines.add("Crawl");
        disciplines.add("Rygcrawl");
        disciplines.add("Brystsvømning");
    }

    public int getTime() {
        return time;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getGroup() {
        return group;
    }

    public DateFormat getCompetetion() {
        return competetion;
    }

        private ArrayList<Result> results = new ArrayList<>();
            public Results(){

            }
    private ArrayList<String> disciplines = new ArrayList<>();


}


