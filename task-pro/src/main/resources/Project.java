public class Project {
    private static int nextId = 1;
    private final int id;
    private String name;
    private String description;

    public Project(String name, String description) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return String.format("[%d] %s: %s", id, name, description);
    }
}
