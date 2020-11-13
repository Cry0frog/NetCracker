package sort.sortdatestart;

import contract.Contract;
import sort.isorter.ISort;

/**
 * Sorting class for comparing two Contract objects, inherits from the ISort interface.
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class SortDateStart implements ISort<Contract> {

    /**
     * The method compares the start date of two Contract
     * @param o1 an instance of the Contract class
     * @param o2 an instance of the Contract class
     * @return int value
     * */
    @Override
    public int compare(Contract o1, Contract o2) {
        return o1.getDateStart().compareTo(o2.getDateStart());
    }
}
