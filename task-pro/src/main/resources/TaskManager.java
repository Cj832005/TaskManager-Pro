import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private final Scanner sc = new Scanner(System.in);
    // 🆕 اضافه شدن لیست پروژه‌ها
    private final List<Project> projects = new ArrayList<>();

    // ... (سایر توابع مثل clearScreen, printHeader, waitForEnter, getIntInput) ...

    public void run() {
        showMainMenu();
    }

    private void showMainMenu() {
        int choice;
        while (true) {
            clearScreen();
            printHeader("TASK MANAGER PRO - منوی اصلی");
            System.out.println("1. مدیریت پروژه‌ها");
            System.out.println("2. مدیریت وظایف");
            System.out.println("3. داشبورد و آمار");
            System.out.println("4. جستجو و فیلتر");
            System.out.println("0. خروج");

            System.out.println("\nلطفا یک گزینه را انتخاب کنید:");
            choice = getIntInput();

            switch (choice) {
                case 1:
                    manageProjectsMenu(); // ➡️ فراخوانی زیرمنو جدید
                    break;
                case 2:
                    System.out.println("بخش مدیریت وظایف در دست ساخت است.");
                    waitForEnter();
                    break;
                case 3:
                    System.out.println("بخش داشبورد در دست ساخت است.");
                    waitForEnter();
                    break;
                case 4:
                    System.out.println("بخش جستجو در دست ساخت است.");
                    waitForEnter();
                    break;
                case 0:
                    System.out.println("از این که از Task Manager Pro استفاده کردید، متشکریم!👋");
                    sc.close();
                    return; // خروج از حلقه و تابع
                default:
                    System.out.println("گزینه‌ی نامعتبر. لطفا دوباره تلاش کنید.");
                    waitForEnter();
            }
        }
    }

    // ==========================================================
    // 🆕 متد جدید: زیرمنوی مدیریت پروژه‌ها
    // ==========================================================
    private void manageProjectsMenu() {
        int choice;
        while (true) {
            clearScreen();
            printHeader("مدیریت پروژه‌ها");
            System.out.println("1. ایجاد پروژه جدید");
            System.out.println("2. مشاهده همه پروژه‌ها");
            System.out.println("3. ویرایش پروژه");
            System.out.println("4. حذف پروژه");
            System.out.println("0. بازگشت به منوی اصلی");

            System.out.println("\nلطفا یک گزینه را انتخاب کنید:");
            choice = getIntInput();

            switch (choice) {
                case 1:
                    createProject();
                    break;
                case 2:
                    viewProjects();
                    break;
                case 3:
                    editProject();
                    break;
                case 4:
                    deleteProject();
                    break;
                case 0:
                    return; // بازگشت به showMainMenu
                default:
                    System.out.println("گزینه‌ی نامعتبر. لطفا دوباره تلاش کنید.");
                    waitForEnter();
            }
        }
    }

    // ==========================================================
    // 🆕 متد جدید: ایجاد پروژه
    // ==========================================================
    private void createProject() {
        clearScreen();
        printHeader("ایجاد پروژه جدید");

        System.out.print("نام پروژه: ");
        String name = sc.nextLine().trim();

        System.out.print("توضیحات پروژه: ");
        String description = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("نام پروژه نمی‌تواند خالی باشد.");
        } else {
            Project newProject = new Project(name, description);
            projects.add(newProject);
            System.out.println("\n✅ پروژه با موفقیت ایجاد شد:");
            System.out.println(newProject);
        }
        waitForEnter();
    }

    // ==========================================================
    // 🆕 متد جدید: مشاهده پروژه‌ها
    // ==========================================================
    private void viewProjects() {
        clearScreen();
        printHeader("همه پروژه‌ها");

        if (projects.isEmpty()) {
            System.out.println("شما هیچ پروژه‌ای تعریف نکرده‌اید.");
        } else {
            for (Project project : projects) {
                System.out.println(project);
            }
        }
        waitForEnter();
    }

    // ==========================================================
    // 🆕 متد جدید: ویرایش پروژه (منطق جزیی بعدا تکمیل می‌شود)
    // ==========================================================
    private void editProject() {
        clearScreen();
        printHeader("ویرایش پروژه");

        viewProjects();

        if (projects.isEmpty()) {
            // viewProjects پیغام خالی بودن را نمایش داده است
            waitForEnter();
            return;
        }

        System.out.println("\nID پروژه‌ای که می‌خواهید ویرایش کنید را وارد کنید:");
        int idToEdit = getIntInput();

        // پیدا کردن پروژه
        Project projectToEdit = findProjectById(idToEdit);

        if (projectToEdit == null) {
            System.out.println("❗ پروژه‌ای با این ID پیدا نشد.");
        } else {
            System.out.println("\nدر حال ویرایش: " + projectToEdit.getName());

            System.out.print("نام جدید (Enter برای تغییر نکردن): ");
            String newName = sc.nextLine().trim();
            if (!newName.isEmpty()) {
                projectToEdit.setName(newName);
            }

            System.out.print("توضیحات جدید (Enter برای تغییر نکردن): ");
            String newDescription = sc.nextLine().trim();
            if (!newDescription.isEmpty()) {
                projectToEdit.setDescription(newDescription);
            }

            System.out.println("\n✅ پروژه با موفقیت به‌روزرسانی شد.");
            System.out.println(projectToEdit);
        }

        waitForEnter();
    }

    // ==========================================================
    // 🆕 متد جدید: حذف پروژه
    // ==========================================================
    private void deleteProject() {
        clearScreen();
        printHeader("حذف پروژه");

        viewProjects();

        if (projects.isEmpty()) {
            waitForEnter();
            return;
        }

        System.out.println("\nID پروژه‌ای که می‌خواهید حذف کنید را وارد کنید:");
        int idToDelete = getIntInput();

        Project projectToDelete = findProjectById(idToDelete);

        if (projectToDelete == null) {
            System.out.println("❗ پروژه‌ای با این ID پیدا نشد.");
        } else {
            projects.remove(projectToDelete);
            System.out.println("\n✅ پروژه '" + projectToDelete.getName() + "' با موفقیت حذف شد.");
        }

        waitForEnter();
    }

    // ==========================================================
    // 🆕 متد کمکی: پیدا کردن پروژه با ID
    // ==========================================================
    private Project findProjectById(int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                return project;
            }
        }
        return null; // اگر پیدا نشد
    }

    // ==========================================================
    // توابع کمکی قبلی (برای تکمیل کد):
    // ==========================================================
    private void clearScreen() {
        try {
            // برای ویندوز و سیستم‌های Unix
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // اگر نشد، حداقل چند خط خالی چاپ شود
            for (int i = 0; i < 50; ++i) System.out.println();
        }
    }

    private void printHeader(String title) {
        String blue = "\u001B[34m", reset = "\u001B[0m";
        System.out.println(blue + "╔══════════════════════════════════════════════╗");
        System.out.printf("║%20s%-20s║%n", "", title);
        System.out.println("╚══════════════════════════════════════════════╝" + reset);
    }

    private void waitForEnter() {
        System.out.println("\n(فشار دهید ENTER برای ادامه...)");
        try {
            sc.nextLine();
        } catch (Exception e) {
            // در صورت بروز خطا در اسکنر
        }
    }

    private int getIntInput() {
        while (true) {
            try {
                System.out.print("> ");
                // از nextLine().trim() استفاده می کنیم تا باگ های احتمالی بعد از nextInt را حذف کنیم
                String input = sc.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("ورودی عددی نیست، دوباره وارد کنید.");
            }
        }
    }
}











