public enum TaskStatus {
    PENDING("در حال انتظار"),
    IN_PROGRESS("در حال انجام"),
    COMPLETED("تکمیل شده");

    private final String label;

    TaskStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
