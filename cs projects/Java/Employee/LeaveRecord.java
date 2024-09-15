package Employee;

public record LeaveRecord(String ID, int totalLeaves, int leavesTaken) {
    @Override
    public String toString() {
        int leavesLeft = totalLeaves - leavesTaken;

        return "Employee ID: " + ID +
                "\nTotal Leaves: " + totalLeaves +
                "\nLeaves Taken: " + leavesTaken +
                "\nLeaves Left: " + leavesLeft;
    }
}
