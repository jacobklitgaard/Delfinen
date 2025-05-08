package result;

import membership.Membership;

import java.util.ArrayList;

public class Result {
    protected Membership member;
    protected String date;
    protected int time;
    protected String group;
    protected String discipline;

    
    public Result(Membership member, int time, String group, String date, String discipline){
        this.member = member;
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

