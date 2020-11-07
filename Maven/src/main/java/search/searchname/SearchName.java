package search.searchname;

import contract.Contract;
import search.isearch.ISearch;

/**
 * Search class for compares the entered name and the passed, inherited from the ISearch interface.
 * Has a unique property name
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class SearchName implements ISearch<Contract> {

    /** Name field */
    String name;

    public SearchName(String name) {
        this.name = name;
    }

    /**
     * The method compares the entered name and the passed
     * @param o an instance of the Contract class
     * @return boolean value
     * */
    @Override
    public boolean search(Contract o) {
        return name.equals(o.getPerson().getName());
    }
}
