package search.isearch;

import contract.Contract;

@FunctionalInterface
public interface ISearch {

    /**
     * Method compares two objects.
     * @param o Contract value
     * @return boolean value
     */
    boolean search(Contract o);

}
