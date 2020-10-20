package cs2410.assn7.model;

/**
 * Created by austin on 11/16/16.
 */
public class ContractWorker extends Smarty {

    private String name; //name
    private String math; //the math they can do
    private String speak; //what they can say
    private double income; //their income
    private int IQ; //their IQ
    private int contracts; //number of contracts completed
    final String TYPE = "Contractor"; //the type of PersonType they are


    /** This takes in arguments from the GUI and saves the information.
     *
     * @param nameP The name of the person
     * @param mathP The math that person can do
     * @param speakP What the person can speak
     * @param incomeP The person's income
     * @param IQP The income of that person
     * @param contractsP Number of contracts completed
     */
    public ContractWorker(String nameP, String mathP, String speakP, double incomeP, int IQP, int contractsP){

        name = nameP;
        math = mathP;
        speak = speakP;
        income = incomeP;
        IQ = IQP;
        contracts = contractsP;

    }

    /**
     *
     * @return returns the name of the Contract Worker
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return return the math of the Contract worker
     */
    public String doMath(){
        return math;
    }

    /**
     *
     * @return return whatever the contractor has to say
     */
    public String saySomethingSmart() {return speak;}

    /**
     *
     * @return returns the income of the contract worker
     */
    public double getIncome(){return income;}

    /**
     *
     * @return returns the IQ of the contract worker
     */
    public Integer getIQ() {return IQ;}

    /**
     *
     * @return recturns the number of contracts completed by the contract worker
     */
    public Integer getContracts(){ return contracts;}

    /**
     *
     * @return returns the type of person
     */
    public String getPersonType(){
        return TYPE;
    }

}
