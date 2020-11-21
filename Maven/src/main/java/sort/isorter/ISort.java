package sort.isorter;

import contract.Contract;


/**
 * Sort interface, has one comparison method
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public interface ISort {

    /**
     * The method compares two Contract
     * @param o1
     * @param o2
     * @return int value
     */
    int compare(Contract o1, Contract o2);

    /**
     * The method sort array Contract
     * @param contracts
     */
    void sort(Contract[] contracts);
}
