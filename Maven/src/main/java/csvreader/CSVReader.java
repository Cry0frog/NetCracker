package csvreader;

import contract.Contract;
import contract.internet.ContractInternet;
import contract.mobile.ContractMobile;
import contract.tv.ContractTV;
import org.joda.time.LocalDate;
import person.Person;
import repository.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The CSVReader class is designed to read the csv file and enter it into the Repository
 * CSVReader class with properties repository, fileReader, contract, person
 * @author Valuyskikh Nikita
 * @version 1.0
 */
public class CSVReader {
    /** repository field */
    Repository repository;
    /** repository fileReader */
    FileReader fileReader;
    /** repository contract */
    Contract contract;
    /** repository person */
    Person person;

    public CSVReader(Repository repository, FileReader fileReader) {
        this.repository = repository;
        this.fileReader = fileReader;

        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method reads the csv file and writes the data to the Repository
     * @throws IOException
     */
    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(fileReader);
        String line;

        while ((line = reader.readLine()) != null) {

            String[] lineArray = line.split(",");
            //если в стоке не хватает данных то она пропускается
            if(lineArray.length != 8 )continue;

            String[] lineDateStart = lineArray[1].split("\\.");
            int yearStart = Integer.parseInt(lineDateStart[2]);
            int monthStart = Integer.parseInt(lineDateStart[1]);
            int dayStart = Integer.parseInt(lineDateStart[0]);

            String[] lineDateFinish = lineArray[2].split("\\.");
            int yearFinish = Integer.parseInt(lineDateFinish[2]);
            int monthFinish = Integer.parseInt(lineDateFinish[1]);
            int dayFinish = Integer.parseInt(lineDateFinish[0]);

            String[] lineBirthday = lineArray[5].split("\\.");
            int yearBirthday = Integer.parseInt(lineBirthday[2]);
            int monthBirthday = Integer.parseInt(lineBirthday[1]);
            int dayBirthday = Integer.parseInt(lineBirthday[0]);

            int passport = Integer.parseInt(lineArray[6]);
            //Здесь берется последние пять цифр из паспорта как номер контракта
            int numberContract = passport%100000;

            person = checkPerson(lineArray[3],new LocalDate(yearBirthday,monthBirthday,dayBirthday),lineArray[4].charAt(0),passport);

            switch (lineArray[0]){
                case "internet":
                    int speed = Integer.parseInt(lineArray[7]);
                    contract = new ContractInternet(new LocalDate(yearStart,monthStart,dayStart),new LocalDate(yearFinish,monthFinish,dayFinish),numberContract,person,speed);
                    break;
                case "mobile":
                    String[] lineInformation = lineArray[7].split(";");
                    int minute = Integer.parseInt(lineInformation[0]);
                    int gigabyte = Integer.parseInt(lineInformation[1]);
                    int sms = Integer.parseInt(lineInformation[2]);
                    contract = new ContractMobile(new LocalDate(yearStart,monthStart,dayStart),new LocalDate(yearFinish,monthFinish,dayFinish),numberContract,person,minute,gigabyte,sms);
                    break;
                case "tv":
                    contract = new ContractTV(new LocalDate(yearStart,monthStart,dayStart),new LocalDate(yearFinish,monthFinish,dayFinish),numberContract,person,lineArray[7]);
                    break;
            }

            repository.add(contract);
        }

        //закрываем наш ридер
        reader.close();
    }

    /**
     * The method checks for the existence of identical Person
     * @param name name Person
     * @param birthday birthday Person
     * @param sex sex Person
     * @param passport passport Person
     * @return Person class
     */
    private Person checkPerson(String name, LocalDate birthday, char sex, int passport){
        for(Contract contract:repository.forEach()){
            if(contract != null)
                if(contract.getPerson().equals(name, birthday, sex, passport))return contract.getPerson();
        }
        return new Person(name, birthday, sex, passport);
    }
}
