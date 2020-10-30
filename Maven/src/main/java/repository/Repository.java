package repository;

import contract.Contract;

/**
 * Класс репозиторий, является аналогом массива
 * @author Валуйских Никита
 * @version 1.0
 */
public class Repository {

    private Contract[] contracts = new Contract[10];
    private static int numberContract = 0;

    public int size(){
       return numberContract;
    }

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
        if(check){
            System.out.println("Такой контракт уже есть в репозитории!");
        }
        else {
            if(contract.getId()<numberContract){
                contract.setId(numberContract);
            }
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

    public Contract get(int id)
    {
        for(int j = 0; j < numberContract; j++)
        {
            if (contracts[j].getId() == id)
            {
                return contracts[j];
            }
        }
        System.out.println("Контракта с таким Id не существует!");
        return null;
    }

    public void remove(int id){
        boolean check = false;
        for(int j = 0; j < numberContract; j++)
        {
            if (contracts[j].getId() == id)
            {
                check = true;
                contracts[j] = null;
                if(contracts[j+1] != null){
                    for(int i = j; i < numberContract - 1; i++){
                        contracts[i+1].setId(i);
                        contracts[i] = contracts[i+1];
                    }
                }
                numberContract--;
                break;
            }
        }
        if (!check){
            System.out.println("Контракта с таким Id не существует!");
        }
    }
}
