package cs2410.assn7.model;

/**
 * Created by austin on 11/16/16.
 */
public class HourlyWorker extends Smarty{

    private String name;
    private String math;
    private String speak;
    private double income;
    private int IQ;
    private double hours;
    final String TYPE = "Hourly";


    public HourlyWorker( String nameP, String mathP, String speakP, double incomeP, int IQP, double hoursP){
        name = nameP;
        math = mathP;
        speak = speakP;
        income = incomeP;
        IQ = IQP;
        hours = hoursP;

    }
    public double getIncome(){
        return income;
    }
    public Integer getIQ() {return IQ;}
    public String getName(){
        return name;
    }
    public String doMath(){
        return math;
    }
    public String saySomethingSmart() {return speak;}
    public double getHours() {return hours;}
    public String getPersonType(){
        return TYPE;
    }

}
