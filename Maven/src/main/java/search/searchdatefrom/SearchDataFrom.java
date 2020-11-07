package search.searchdatefrom;

import contract.Contract;
import org.joda.time.LocalDate;
import search.isearch.ISearch;

public class SearchDataFrom implements ISearch<Contract> {

    LocalDate dataFrom;

    public SearchDataFrom(LocalDate dataFrom) {
        this.dataFrom = dataFrom;
    }

    @Override
    public boolean search(Contract o) {
        return dataFrom.toDate().before(o.getDateStart().toDate());
    }
}
