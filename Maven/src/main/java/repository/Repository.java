package repository;

import contract.Contract;

/**
 * The repository class is analogous to an array
 * @author Valuyskikh Nikita
 * @version 1.1
 */
public class Repository {

    /** Field array of contracts */
    private Contract[] contracts = new Contract[10];

    /** Number of contracts added */
    private static int numberContract = 0;

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
}
