package search.searchdatebefore;

import contract.Contract;
import org.joda.time.LocalDate;
import search.isearch.ISearch;

public class SearchDateBefore implements ISearch<Contract> {

    LocalDate dataBefore;

    public SearchDateBefore(LocalDate dataBefore) {
        this.dataBefore = dataBefore;
    }

    @Override
    public boolean search(Contract o) {
        return dataBefore.toDate().after(o.getDateStart().toDate());
    }
}
