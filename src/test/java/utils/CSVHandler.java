package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSVHandler {
    public static void main(String[] args) throws InterruptedException,
            IOException, CsvValidationException {

        // object of CSVReader class
        CSVReader r = new CSVReader(new FileReader("C:\\Users\\gvinukumar\\IdeaProjects\\nytimes-bdd-test\\src\\test\\resources\\testdata\\testdata.csv"));

        // store csv data in string array
        String [] csvValues;

        // iterate through csv till the end of the values
        while ((csvValues = r.readNext())!= null){

            // iterate through rows
            for (String csvValue : csvValues){
                System.out.println(csvValue);
            }
        }
    }

}
