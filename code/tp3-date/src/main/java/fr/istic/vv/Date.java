package fr.istic.vv;

class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    private static int[] _daysInMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private static int daysInMonthOf(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            }
        }
        return _daysInMonth[month - 1];
    }

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalStateException("Attempt to create a date which is not valid");
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < 0) {
            return false;
        }
        if (month <= 0 || month > 12) {
            return false;
        }
        int _daysInMonth = Date.daysInMonthOf(month, year);
        return 1 <= day && day <= _daysInMonth;
    }

    public static boolean isLeapYear(int year) { return !((year % 4 != 0) || (year % 400 != 0 && year % 100 == 0)); }

    public Date nextDate() {
        if (this.month == 12 && this.day == 31) {
            return new Date(1, 1, this.year + 1);
        } else {
            int _daysInMonth = Date.daysInMonthOf(this.month, this.year);
            if (_daysInMonth == this.day) {
                return new Date(1, this.month + 1, this.year);
            } else {
                return new Date(this.day + 1, this.month, this.year);
            }
        }
    }

    public Date previousDate() {
        if (this.month == 1 && this.day == 1) {
            return new Date(31, 12, this.year - 1);
        } else {
            if (this.day == 1) {
                int _lastUpperBound = Date.daysInMonthOf(this.month - 1, this.year);
                return new Date(_lastUpperBound, this.month - 1, this.year);
            } else {
                return new Date(this.day - 1, this.month, this.year);
            }
        }
    }

    private boolean isLessThan(Date other) {
        if (this.year < other.year) {
            return true;
        } else if (this.year == other.year) {
            if (this.month < other.month) {
                return true;
            } else if (this.month == other.month) {
                return this.day < other.day;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int compareTo(Date other) {
        if (this.day == other.day && this.month == other.month && this.year == other.year) {
            return 0;
        } else if (isLessThan(other)) {
            return -1;
        } else {
            return 1;
        }
    }

}