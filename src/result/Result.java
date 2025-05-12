package result;

import membership.Membership;

import java.util.ArrayList;

public class Result {
    protected int ID;
    protected String name;
    protected String date;
    protected int time;
    protected String group;
    protected String discipline;

    
    public Result(int ID, String name, String group, String discipline, int time, String date){
        this.ID = ID;
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

}

