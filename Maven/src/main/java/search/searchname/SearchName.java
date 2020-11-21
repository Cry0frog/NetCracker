package search.searchname;

import contract.Contract;
import search.isearch.ISearch;

public class SearchName implements ISearch<Contract> {

    String name;

    public SearchName(String name) {
        this.name = name;
    }

    @Override
    public boolean search(Contract o) {
        return name.equals(o.getPerson().getName());
    }
}
