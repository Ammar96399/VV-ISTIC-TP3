package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void NegativeDateIsInvalid() {
        assertFalse(Date.isValidDate(-9, 11, 1937));
        assertFalse(Date.isValidDate(13, -5, 1226));
        assertFalse(Date.isValidDate(30, 12, -4951));
    }

    @Test
    void Normal31DaysMonthsHas31Days() {
        assertTrue(Date.isValidDate(31, 3, 2043));
        assertFalse(Date.isValidDate(32, 5, 2043));
    }

    @Test
    void Normal30DaysMonthsHas30Days() {
        assertTrue(Date.isValidDate(30, 9, 1920));
        assertFalse(Date.isValidDate(31, 9, 1920));
    }

    @Test
    void FebInLeapYearHas29Days() {
        assertTrue(Date.isValidDate(29, 2, 2004));
    }

    @Test
    void FebInNotLeapYearHas28Days() {
        assertFalse(Date.isValidDate(29, 2, 2003));
    }

    @Test
    void NegativeYearInvalid() {
        assertFalse(Date.isLeapYear(-2930));
    }

    @Test
    void NormalDividableBy4AreLeapYears() {
        assertTrue(Date.isLeapYear(2012));
    }
    @Test
    void IfDividableBy100ShouldAlsoBeDividableBy400ToBeLeapYear() {
        assertFalse(Date.isLeapYear(1900));
    }
    @Test
    void DividableBy400AreLeapYears() {
        assertTrue(Date.isLeapYear(2000));
    }

    @Test
    void DateValueMustBeValid() {
        assertThrows(IllegalStateException.class, () -> {
            new Date(-59, 37, 9402);
        });
    }

    @Test
    void NextDateOfCase31_12() {
        var next = new Date(31, 12, 1930).nextDate();
        assertEquals(0, next.compareTo(new Date(1, 1, 1931)));
    }

    @Test
    void NextDateOfCaseEndOfMonth() {
        var next = new Date(30, 4, 1930).nextDate();
        assertEquals(0, next.compareTo(new Date(1, 5, 1930)));
    }

    @Test
    void NextDateOfCaseOtherDays() {
        var next = new Date(12, 4, 1930).nextDate();
        assertEquals(0, next.compareTo(new Date(13, 4, 1930)));
    }

    @Test
    void PrevDateOfCase1_1() {
        var next = new Date(1, 1, 1930).previousDate();
        assertEquals(0, next.compareTo(new Date(31, 12, 1929)));
    }

    @Test
    void PrevDateOfCase1OfMonth() {
        var next = new Date(1, 4, 1930).previousDate();
        assertEquals(0, next.compareTo(new Date(31, 3, 1930)));
    }

    @Test
    void PrevDateOfCaseOtherDays() {
        var next = new Date(12, 4, 1930).previousDate();
        assertEquals(0, next.compareTo(new Date(11, 4, 1930)));
    }

    @Test
    void CompareToDatePriorToAnother1() {
        var date1 = new Date(13, 12, 1229);
        var date2 = new Date(7, 1, 1349);
        assertTrue(date1.compareTo(date2) < 0);
    }

    @Test
    void CompareToDatePriorToAnother2() {
        var date1 = new Date(13, 11, 1349);
        var date2 = new Date(7, 12, 1349);
        assertTrue(date1.compareTo(date2) < 0);
    }

    @Test
    void CompareToDatePriorToAnother3() {
        var date1 = new Date(1, 12, 1349);
        var date2 = new Date(7, 12, 1349);
        assertTrue(date1.compareTo(date2) < 0);
    }

    @Test
    void CompareToDateGreaterToAnother1() {
        var date1 = new Date(13, 11, 2033);
        var date2 = new Date(7, 5, 1045);
        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    void CompareToDateGreaterToAnother2() {
        var date1 = new Date(13, 11, 2033);
        var date2 = new Date(7, 5, 2033);
        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    void CompareToDateGreaterToAnother3() {
        var date1 = new Date(13, 11, 2033);
        var date2 = new Date(7, 11, 2033);
        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    void CompareToDateEqualToAnother() {
        var date1 = new Date(22, 11, 2033);
        var date2 = new Date(22, 11, 2033);
        assertEquals(0, date1.compareTo(date2));
    }

}