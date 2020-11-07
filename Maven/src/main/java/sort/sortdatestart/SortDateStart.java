package sort.sortdatestart;

import contract.Contract;

import java.util.Comparator;

public class SortDateStart implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        return o1.getDateStart().compareTo(o2.getDateStart());
    }
}
