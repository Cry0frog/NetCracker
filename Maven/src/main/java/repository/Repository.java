package repository;

import contract.Contract;
import search.isearch.ISearch;
import sort.isorter.ISort;

/**
 * The repository class is analogous to an array
 * @author Valuyskikh Nikita
 * @version 1.1
 */
public class Repository {

    /** Field array of contracts */
    private Contract[] contracts = new Contract[10];

    /** Number of contracts added */
    private int numberContract = 0;

    /** The method returns the size of the array
     * @return size
     * */
    public int size(){
       return numberContract;
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
    public Repository search(ISearch<? super Contract> c){
        Repository repository = new Repository();
        for (int i = 0; i < numberContract; i++) {
            if (c.search(contracts[i])) repository.add(contracts[i]);
        }
        return repository;
    }

    /**
     * The method sorts according to certain criteria
     * @param c child class of the Comparator interface
     */
    public void sort(ISort<? super Contract> c){
        Contract contractBubble;
        for (int i = 0; i < numberContract-1; i++) {
            for (int j = 1; j < numberContract; j++) {
                if (c.compare(contracts[i], contracts[j]) > 0) {
                    contractBubble = contracts[i];
                    contracts[i] = contracts[j];
                    contracts[j] = contractBubble;
                }
            }
        }
    }

    /**
     * The method allows you to view the entire array
     */
    public void view(){
        for(int i = 0; i < numberContract; i++){
            System.out.println(contracts[i]);
        }
    }
}
