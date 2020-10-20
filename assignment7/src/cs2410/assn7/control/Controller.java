package cs2410.assn7.control;

import cs2410.assn7.model.*;

import java.util.ArrayList;

/**
 * Created by austin on 11/16/16.
 */
public class Controller {
    private static ArrayList<Simpleton> list = new ArrayList<Simpleton>(); //creates an array list of Simpletons

    public static void addSamplePeople(){
        /**
         * This method is used for testing the code. addSamplePeople() adds people to list so that print functionalities be tested
         */
        Simpleton hourly1 = new HourlyWorker("Johnny", "multiply", "I know a lot about animals",20,5,15);
        Simpleton hourly2 = new HourlyWorker("Sally", "multiply better", "I know more about animals",15,10,100);
        Simpleton contract1 = new ContractWorker("Shark Boy", "divide!", "I like to watch stars",500,82, 3);
        Simpleton contract2 = new ContractWorker("Lava Girl", "sort of Divide", "I go to outerspace",250,17, 8);
        Simpleton hobbit1 = new Hobbit("Frodo Baggins", "add goooood", "I like potatoes but farm carrots", 4);
        Simpleton hobbit2 = new Hobbit("Odorf Sniggab", "add sometimes", "My name is Frodo Baggins backwards!", 9);

        list.add(hourly1);
        list.add(hourly2);
        list.add(contract1);
        list.add(contract2);
        list.add(hobbit1);
        list.add(hobbit2);
    }

    /** This method creates a new instance of Hourly Worker
     *
     * @param name The name of the hourly worker
     * @param math The math the hourly worker can perform
     * @param speak What the hourly worker can say
     * @param income The income of the hourly worker
     * @param iq The IQ of the hourly worker
     * @param hours How many hours the hourly worker worked
     */
    public static void addHourlyWorker(String name, String math, String speak, double income, int iq, double hours){
        Simpleton s = new HourlyWorker(name, math, speak, income, iq, hours); //creates a new Simpleton with the input parameters
        list.add(s); //adds worker to list
    }

    /**This method creates a new instance of Contract Worker
     *
     * @param name The name of the contract worker
     * @param math The math the contract worker can perform
     * @param speak What the contract worker can say
     * @param income The income of the contract worker
     * @param iq The iQ of the hourly worker
     * @param contracts How many contracts the contract worker compelted
     */
    public static void addContractWorker(String name, String math, String speak, double income, int iq, int contracts){
        Simpleton s = new ContractWorker(name, math, speak,income, iq, contracts);
        list.add(s);
    }

    /**
     *
     * @param name The name of the hobbit
     * @param math The math the hobbit can perform
     * @param speak What the hobbit can say
     * @param carrots How many carrots the hobbit has
     */
    public static void addHobbit(String name, String math, String speak, int carrots){
        Simpleton s = new Hobbit(name, math, speak, carrots);
        list.add(s);

    }

    //Math","Income", "Hours", "IQ", "Say", "Carrots", "Contracts"

    /**
     *
     * @return Returns an output string with math information for all Simpletons
     */
    public static String getMathList(){
        String output = "";
        for (Simpleton item : list) {
            output += item.getName() + " the " + ((PersonType) item).getPersonType() + " can " + item.doMath() + "\n";
        }
        return output;
    }

    /**
     *
     * @return Returns an output string with income information for all Smarties
     */
    public static String getIncomeList(){
        String output = "";
        for (Simpleton item : list){
            if(item instanceof Smarty){
                output += item.getName() + " the " + ((PersonType) item).getPersonType() + " has an income of $" + ((Smarty) item).getIncome() + "\n";
            }
        }
        return output;
    }
    /**
     *
     * @return Returns an output string of IQ information for all Smarties
     */
    public static String getIQList(){
        String output = "";
        for (Simpleton item : list){
            if(item instanceof Smarty){
                output += item.getName() + " the " + ((PersonType) item).getPersonType() + " has an IQ of " + ((Smarty) item).getIQ() + "\n";
            }
        }
        return output;
    }

    /**
     *
     * @return Returns an output string of say for all Simpletons
     */
    public static String getSayList(){
        String output = "";
        for (Simpleton item : list) {
            output += item.getName() + " the " + ((PersonType) item).getPersonType() + " says " + item.saySomethingSmart() + "\n";
        }
        return output;
    }

    /**
     *
     * @return Returns an output string of all hobbits with carrots for all hobbits
     */
    public static String getCarrotsList(){
        String output = "";
        for (Simpleton item : list){
            if(item instanceof Hobbit){
                output += item.getName() + " the hobbit has " + ((Hobbit) item).getCarrots() + " carrots\n";
            }
        }
        return output;
    }

    /**
     *
     * @return returns an output string of all contracts for all contract workers
     */
    public static String getContractsList(){
        String output = "";
        for (Simpleton item : list){
            if(item instanceof ContractWorker){
                output += item.getName() + " has completed " + ((ContractWorker) item).getContracts() + " contracts\n";
            }
        }
        return output;
    }

    /**
     *
     * @return Returns an output string of all hourly workers with hours for all hourly workers
     */
    public static String getHoursList(){
        String output = "";
        for (Simpleton item : list){
            if(item instanceof HourlyWorker){
                output += item.getName() + " has worked " + ((HourlyWorker) item).getHours() + " hours\n";
            }
        }
        return output;
    }

}
