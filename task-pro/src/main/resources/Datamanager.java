import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static final String DATA_FILE = "data.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveData(List<Project> projects) {
        try (FileWriter writer = new FileWriter(DATA_FILE)) {
            gson.toJson(projects, writer);
            System.out.println("✅ داده‌ها با موفقیت در فایل ذخیره شدند.\n");
        } catch (IOException e) {
            System.out.println("❌ خطا در ذخیره داده‌ها: " + e.getMessage());
        }
    }

    public static List<Project> loadData() {
        try (FileReader reader = new FileReader(DATA_FILE)) {
            Project[] loadedProjects = gson.fromJson(reader, Project[].class);
            if (loadedProjects != null) {
                System.out.println("📦 داده‌ها از فایل بارگذاری شدند.\n");
                List<Project> projectList = new ArrayList<>();
                for (Project p : loadedProjects) {
                    projectList.add(p);
                }
                return projectList;
            }
        } catch (IOException e) {
            System.out.println("⚠️ فایل داده یافت نشد، داده‌ی جدید ساخته می‌شود.\n");
        }
        return new ArrayList<>();
    }
}
