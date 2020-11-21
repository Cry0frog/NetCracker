package sort.sortidcontract;

import contract.Contract;
import sort.isorter.ISort;

/**
 * Sorting class for comparing two Contract objects, inherits from the ISort interface.
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class SortIdContract implements ISort {

    /**
     * The method compares the unique identifier of two Contract
     * @param o1 an instance of the Contract class
     * @param o2 an instance of the Contract class
     * @return int value
     * */
    @Override
    public int compare(Contract o1, Contract o2) {
        return o1.getId() - o2.getId();
    }

    /**
     * The method sorts the Contract array using inserts
     * @param contracts
     */
    @Override
    public void sort(Contract[] contracts) {
        for (int left = 0; contracts[left] != null; left++) {
            Contract value = contracts[left];
            int i = left - 1;

            for (; i >= 0; i--) {
                if (compare(value, contracts[i]) < 0) {
                    contracts[i + 1] = contracts[i];
                } else {
                    break;
                }
            }
            contracts[i + 1] = value;
        }
    }
}
