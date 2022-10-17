import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    String path = "src/Customers";

    public int getIdNumber(String line){
        String[] stringArray = line.split(",");
        return Integer.parseInt(stringArray[0].trim());
    }

    public String getName(String line){
        String[] stringArray = line.split(",");
        return stringArray[1].trim();
    }

    public String getLastPaymentDate(Scanner scanner){

        String firstLine = "";
        String secondLine = "";
        if (scanner.hasNext()){
            firstLine = scanner.nextLine();
            if (scanner.hasNext()){
                secondLine = scanner.nextLine();
            }
        }
        return secondLine;
    }

    public Main(){

        String firstLine;
        String secondLine;
        try(Scanner scanner = new Scanner(new File(path)))
        {
            firstLine = scanner.nextLine();
            secondLine = scanner.nextLine();
            System.out.println(secondLine);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
         Main test = new Main();



    }
}