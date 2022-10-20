package Try2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class Try2MainTest {

    Try2Main testProgram = new Try2Main();

    @Test
    void getName() {
        String line = "7703021234, Alhambra Aromes";
        assert (testProgram.getName(line).trim()).equals("Alhambra Aromes");
        assert !(testProgram.getName(line)).equals("7703021234");
        assert !(testProgram.getName(line)).equals("7703021234, Alhambra Aromes");
    }

    @Test
    void getIdNumber() {
        String line = "7703021234, Alhambra Aromes";
        assert (testProgram.getIdNumber(line).trim().equals("7703021234"));
        assert !(testProgram.getIdNumber(line).equals("Alhambra Aromes"));
        assert !(testProgram.getIdNumber(line).equals("7703021234, Alhambra Aromes"));

    }

    @Test
    void getLastPaymentDate() {
        String line = "2022-07-01";
        assert (testProgram.getLastPaymentDate(line).equals(LocalDate.of(2022,7,1)));
        assert !(testProgram.getLastPaymentDate(line).equals(LocalDate.of(2022,7,2)));
        assert !(testProgram.getLastPaymentDate(line).equals(LocalDate.of(2022,2,2)));

    }

    @Test
    void isMember() {
        LocalDate date = LocalDate.of(2022,7,1);
        assertTrue (testProgram.isMember(date));
        assertFalse(testProgram.isMember(date.minusYears(2)));

    }
}