import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Project {
    private final UUID projectId;
    private String name;
    private final List<Task> tasks;

    public Project(String name) {
        this.projectId = UUID.randomUUID();
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    // --- Getters ---
    public UUID getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks); // بازگشت یک نسخه کپی شده برای امنیت
    }

    // --- مدیریت وظایف ---

    public Task addTask(String title, String description, TaskPriority priority, LocalDate dueDate) {
        Task newTask = new Task(title, description, priority, dueDate);
        this.tasks.add(newTask);
        return newTask;
    }

    public Task editTask(UUID taskId, String title, String description, TaskPriority priority, TaskStatus status, LocalDate dueDate) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                if (title != null) task.setTitle(title);
                if (description != null) task.setDescription(description);
                if (priority != null) task.setPriority(priority);
                if (status != null) task.setStatus(status);
                if (dueDate != null) task.setDueDate(dueDate);
                return task;
            }
        }
        return null; // وظیفه پیدا نشد
    }

    public List<Task> searchTasksByTitle(String keyword) {
        String lowerCaseKeyword = keyword.toLowerCase();
        return tasks.stream()
                .filter(task -> task.getTitle().toLowerCase().contains(lowerCaseKeyword))
                .collect(Collectors.toList());
    }

    public List<Task> filterTasks(TaskStatus statusFilter, TaskPriority priorityFilter) {
        return tasks.stream()
                .filter(task -> statusFilter == null || task.getStatus() == statusFilter)
                .filter(task -> priorityFilter == null || task.getPriority() == priorityFilter)
                .collect(Collectors.toList());
    }

    public List<Task> sortTasks(Comparator<Task> comparator) {
        return tasks.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("پروژه: %s (ID: %s) - تعداد وظایف: %d",
                name,
                projectId.toString().substring(0, 8),
                tasks.size());
    }
}

