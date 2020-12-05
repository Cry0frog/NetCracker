package repository;

import contract.Contract;
import search.isearch.ISearch;
import sort.isorter.ISort;

import java.util.Arrays;

/**
 * The repository class is analogous to an array.
 * @author Valuyskikh Nikita
 * @version 1.1
 */
public class Repository  {

    /** Field array of contracts. */
    private Contract[] contracts = new Contract[10];

    /** Number of contracts added. */
    private int numberContract = 0;

    /** Field ISort interface. */
    ISort iSort;

    /** The method returns the size of the array
     * @return size
     * */
    public int size(){
       return numberContract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Repository)) return false;
        Repository that = (Repository) o;
        return Arrays.equals(contracts, that.forEach());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(contracts);
    }

    /** The method adds a new Contract to the array
     * @param contract new contract
     */
    public void add(Contract contract){
        boolean check = false;
        for(int j = 0; j < numberContract; j++)
        {
            if (contracts[j].equals(contract))
            {
                check = true;
                break;
            }
        }
        if(!check)
        {
            if (numberContract == contracts.length) {
                Contract[] contracts1 = contracts;
                contracts = new Contract[numberContract + 5];
                for (int i = 0; i < numberContract; i++) {
                    contracts[i] = contracts1[i];
                }
            }
            contracts[numberContract] = contract;
            numberContract++;
        }
    }

    /** The method returns a contract with the specified id
     * @param id unique identifier
     * @return Contract
     */
    public Contract get(int id)
    {
        for(int j = 0; j < numberContract; j++)
        {
            if (contracts[j].getId() == id)
            {
                return contracts[j];
            }
        }
        return null;
    }

    /**
     * The method removes the Contract from the array with the specified id
     * @param id unique identifier
     */
    public void remove(int id){
        for(int j = 0; j < numberContract; j++)
        {
            if (contracts[j].getId() == id)
            {
                contracts[j] = null;
                if(contracts[j+1] != null){
                    for(int i = j; i < numberContract - 1; i++){
                        contracts[i] = contracts[i+1];
                        contracts[i+1] = null;
                    }
                }
                numberContract--;
                break;
            }
        }
    }

    /**
     * The method searches for specific criteria
     * @param c child class of the ISearch interface
     * @return Repository
     */
    public Repository search(ISearch c){
        Repository repository = new Repository();
        for (int i = 0; i < numberContract; i++) {
            if (c.search(contracts[i])) repository.add(contracts[i]);
        }
        return repository;
    }

    /**
     * The method sorts according to certain criteria
     * @param c child class of the ISort interface
     */
    public void sort(ISort c){
        iSort = c;
        iSort.sort(contracts);
    }

    /**
     * The method allows you to view the entire array
     */
    public void view(){
        for(int i = 0; i < numberContract; i++){
            System.out.println(contracts[i]);
        }
    }

    //Реализация foreach

    /**
     * The method allows you to use forEach.
     * @return array Contract
     */
    public Contract[] forEach() {
        if (numberContract>0) {
            Contract[] contractEach = new Contract[numberContract];
            for(int i = 0; i < numberContract; i++){
                contractEach[i] = contracts[i];
            }
            return contractEach;
        }
        else { return null; }

    }
}
