package search.searchdatebefore;

import contract.Contract;
import org.joda.time.LocalDate;
import search.isearch.ISearch;

/**
 * Search class for compares the entered date and the passed, inherits from the ISearch interface.
 * Has a unique property dataBefore
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class SearchDateBefore implements ISearch<Contract> {

    /** Date field */
    LocalDate dataBefore;

    public SearchDateBefore(LocalDate dataBefore) {
        this.dataBefore = dataBefore;
    }

    /**
     * The method compares the entered date and the passed
     * @param o an instance of the Contract class
     * @return boolean value
     * */
    @Override
    public boolean search(Contract o) {
        return dataBefore.toDate().after(o.getDateStart().toDate());
    }
}
