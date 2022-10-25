package Try2;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
class Try2MainTest {
    String testFile = "Testing/Try2/Customertest";
    Try2Main testProgram = new Try2Main();
    @Test
    void getName() {
        try (Scanner filescanner = new Scanner(new File(testFile))) {
            String line = filescanner.nextLine();
            assert(testProgram.getName(line).trim().equals("Alhambra Aromes"));
            assert!(testProgram.getName(line).trim().equals("7703021234"));
            assert!(testProgram.getName(line).trim().equals("7703021234, Alhambra Aromes"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getIdNumber() {
        try (Scanner filescanner = new Scanner(new File(testFile))){
            String firstLine = filescanner.nextLine();
            String secondLine = filescanner.nextLine();
            assert (testProgram.getIdNumber(firstLine).trim().equals("7703021234"));
            assert !(testProgram.getIdNumber(firstLine).trim().equals("Alhambra Aromes"));
            assert !(testProgram.getIdNumber(firstLine).trim().equals("7703021234, Alhambra Aromes"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    @Test
    void getLastPaymentDate() {
        try (Scanner filescanner = new Scanner(new File(testFile))){
            String firstLine = filescanner.nextLine();
            String secondLine = filescanner.nextLine();
            assert (testProgram.getLastPaymentDate(secondLine).equals(LocalDate.of(2022,7,1)));
            assert !(testProgram.getLastPaymentDate(secondLine).equals(LocalDate.of(2022,7,2)));
            assert !(testProgram.getLastPaymentDate(secondLine).equals(LocalDate.of(2021,7,1)));
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
    }

    @Test
    void isMember() {
        LocalDate date = LocalDate.now();
        assertTrue (testProgram.isMember(date));
        assertFalse(testProgram.isMember(date.minusYears(2)));
        assertFalse(testProgram.isMember(date.minusYears(1).minusDays(1)));

    }
}