package Try2;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Try2Main {

    String CustomerFile = "src/Try2/Customers.txt";
    String CustomerLog = "src/Try2/CustomerLog.txt";

    public String getName(String line){
        String [] array = new String[2];
        array = line.split(",");
        return array[1];
        }
    public String getIdNumber(String line){
        String [] array = new String[2];
        array = line.split(",");
        return array[0];
    }

    public LocalDate getLastPaymentDate (String line){
        LocalDate date = LocalDate.parse(line);
        return date;
    }

    public Boolean isMember(LocalDate date){
        LocalDate currentDate = LocalDate.now();
        return currentDate.minusYears(1).minusDays(1).isBefore(date);
    }

    public Try2Main(){

            try (Scanner fileScanner = new Scanner(new File(CustomerFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(CustomerLog,true))) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("name or id number:");
                String input = scanner.nextLine();
                if (input.isBlank()){
                    System.out.println("Lämna inte fältet tomt!");
                    System.exit(0);
                }

                while(fileScanner.hasNext()) {
                    String firstLine = fileScanner.nextLine();
                    String secondLine = fileScanner.nextLine();
                    String name = getName(firstLine);
                    String idNumber = getIdNumber(firstLine);
                    LocalDate lastPayment = getLastPaymentDate(secondLine);
                    if (input.trim().equalsIgnoreCase(name.trim()) && isMember(lastPayment)
                            || input.trim().equalsIgnoreCase(idNumber.trim()) && isMember(lastPayment)){
                        writer.write(LocalDate.now() + "," + getName(firstLine) + "\n");
                        System.out.println("Active Gym member");
                        break;
                    } else if (input.trim().equalsIgnoreCase(name.trim()) && !isMember(lastPayment)
                            || input.trim().equalsIgnoreCase(idNumber.trim()) && !isMember(lastPayment)) {
                        System.out.println("Inactive Gym member");
                        break;
                    } else if (!fileScanner.hasNext()) {
                        System.out.println("Not a Gym member");
                    }
                }
                }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
}
        public static void main(String[] args){
        Try2Main test = new Try2Main();
    }
}
