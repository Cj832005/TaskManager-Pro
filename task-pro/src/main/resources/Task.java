import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private final UUID taskId;
    private String title;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;
    private LocalDate dueDate;

    public Task(String title, String description, TaskPriority priority, LocalDate dueDate) {
        this.taskId = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING; // به صورت پیش‌فرض معلق است
        this.dueDate = dueDate;
    }

    // --- Getters ---
    public UUID getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // --- Setters (برای ویرایش) ---
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | عنوان: %s | اولویت: %s | وضعیت: %s | سررسید: %s",
                taskId.toString().substring(0, 8), // نمایش 8 کاراکتر اول ID
                title,
                priority.getLabel(),
                status.getLabel(),
                dueDate.toString());
    }
}
