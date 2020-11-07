package search.searchdatefrom;

import contract.Contract;
import org.joda.time.LocalDate;
import search.isearch.ISearch;

/**
 * Search class for compares the entered date and the passed, inherits from the ISearch interface.
 * Has a unique property dataFrom
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class SearchDataFrom implements ISearch<Contract> {

    /** Date field */
    LocalDate dataFrom;

    public SearchDataFrom(LocalDate dataFrom) {
        this.dataFrom = dataFrom;
    }

    /**
     * The method compares the entered date and the passed
     * @param o an instance of the Contract class
     * @return boolean value
     * */
    @Override
    public boolean search(Contract o) {
        return dataFrom.toDate().before(o.getDateStart().toDate());
    }
}
