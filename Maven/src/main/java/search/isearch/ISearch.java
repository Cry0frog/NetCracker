package search.isearch;

import contract.Contract;

@FunctionalInterface
public interface ISearch {

    /**
     *
     * @param o
     * @return
     */
    boolean search(Contract o);

}
