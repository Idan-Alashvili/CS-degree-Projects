package Employee;

public record AttendanceRecord(String ID, int totalWorkingDays, int daysPresent) {
    @Override
    public String toString() {
        int presencePercent = (daysPresent * 100) / totalWorkingDays;

        return "Employee ID: " + ID +
                "\nTotal Working Days: " + totalWorkingDays +
                "\nDays Present: " + daysPresent +
                "\nPresence Percent: " + presencePercent;
    }
}
