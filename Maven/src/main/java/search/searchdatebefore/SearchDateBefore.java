package search.searchdatebefore;

import contract.Contract;
import org.joda.time.LocalDate;
import search.isearch.ISearch;

public class SearchDateBefore implements ISearch {

    /**
     * Field LocalDate.
     */
    LocalDate dataBefore;

    /**
     * The method compares the having object with the incoming one.
     * @param dataBefore LocalDate
     */
    public SearchDateBefore(LocalDate dataBefore) {
        this.dataBefore = dataBefore;
    }

    @Override
    public boolean search(Contract o) {
        return dataBefore.toDate().after(o.getDateStart().toDate());
    }
}
