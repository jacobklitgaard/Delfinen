package Results;

import Membership.Membership;

import javax.xml.transform.Result;
import java.util.ArrayList;

public class Results {
    protected String date;
    protected int time;
    protected String group;
    protected String discipline;

    
    public Results(int time, String group, String date, String discipline){
        this.time = time;
        this.group = group;
        this.date = date;
        this.discipline = discipline;
    }

    public int getTime() {
        return time;
    }

    public String getGroup() {
        return group;
    }

    public String getDate(){
        return date;
    }

    public String getDiscipline(){
        return discipline;
    }

        private ArrayList<Result> results = new ArrayList<>();
            public Results(){

            }
}

