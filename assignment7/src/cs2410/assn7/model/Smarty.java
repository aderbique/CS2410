package cs2410.assn7.model;

/**
 * Created by austin on 11/16/16.
 */

public abstract class Smarty implements PersonType, Simpleton {
    int IQ; //IQ of the Smarty

    /**
     *
     * @return Returns the IQ of Smarty
     */
    public Integer getIQ() {
        return IQ;
    }

    /**
     *
     * @return The abstract method that contains income
     */
    public abstract double getIncome();
}
