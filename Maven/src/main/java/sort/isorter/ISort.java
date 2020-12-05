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
     * @param o1 Contract value
     * @param o2 Contract value
     * @return int value
     */
    int compare(Contract o1, Contract o2);

    /**
     * The method sort array Contract
     * @param contracts Array Contract
     */
    void sort(Contract[] contracts);
}
