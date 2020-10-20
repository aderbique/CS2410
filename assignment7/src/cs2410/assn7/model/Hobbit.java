package cs2410.assn7.model;

/**
 * Created by austin on 11/16/16.
 */
public class Hobbit implements PersonType, Simpleton{
    private String name;
    private String math;
    private String speak;
    private int carrots;
    final String TYPE = "Hobbit";

    /**
     *
     * @param nameP The name of the hobbit
     * @param mathP The math the hobbit can perform
     * @param speakP What the hobbit can say
     * @param carrotsP How many carrots the hobbit has
     */
    public Hobbit(String nameP, String mathP, String speakP, int carrotsP){
        name = nameP;
        math = mathP;
        speak = speakP;
        carrots = carrotsP;
    }

    /**
     *
     * @return Returns the name of the hobbit
     */
    public String getName(){ return name;}

    /**
     *
      * @return Returns the math of the hobbit
     */
    public String doMath(){ return math;}

    /**
     *
     * @return Returns what the hobbit can say
     */
    public String saySomethingSmart(){ return speak;}

    /**
     *
     * @return Returns how many carrots the hobbit has
     */
    public Integer getCarrots(){return carrots;}

    /**
     *
     * @return Returns how personType hobbit
     */
    public String getPersonType(){return TYPE;}

}
