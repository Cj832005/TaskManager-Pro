import java.util.Scanner;

public class TaskManager {

    private Scanner sc = new Scanner(System.in);

    public void showMainMenu() {
        int choice;
        do {
            clearScreen();
            printHeader("TASK MANAGER PRO");

            System.out.println(" 1. 📁 مدیریت پروژه‌ها");
            System.out.println(" 2. ✅ مدیریت کارها");
            System.out.println(" 3. 📊 مشاهده داشبورد");
            System.out.println(" 4. 🔍 جستجو و فیلتر");
            System.out.println(" 0. 🚪 خروج");
            System.out.println("\nانتخاب شما:");

            // دریافت ورودی کاربر
            choice = getIntInput();

            // بررسی انتخاب
            switch (choice) {
                case 1:
                    manageProjects();
                    break;
                case 2:
                    manageTasks();
                    break;
                case 3:
                    viewDashboard();
                    break;
                case 4:
                    searchFilterMenu();
                    break;
                case 0:
                    System.out.println("👋 خداحافظ!");
                    break;
                default:
                    System.out.println("❗ گزینه نامعتبر است، دوباره تلاش کنید.");
                    waitForEnter();
            }

        } while (choice != 0);
    }

    // 🧱 زیرمنوها (فعلاً خالی - بعداً پر می‌شن)
    private void manageProjects() {
        System.out.println("\n-- مدیریت پروژه‌ها --");
        waitForEnter();
    }

    private void manageTasks() {
        System.out.println("\n-- مدیریت کارها --");
        waitForEnter();
    }

    private void viewDashboard() {
        System.out.println("\n-- مشاهده داشبورد --");
        waitForEnter();
    }

    private void searchFilterMenu() {
        System.out.println("\n-- جستجو و فیلتر --");
        waitForEnter();
    }

    // 🎨 چاپ سربرگ منو با رنگ و قاب زیبا
    private void printHeader(String title) {
        String blue = "\u001B[34m", reset = "\u001B[0m";
        System.out.println(blue + "╔══════════════════════════════════════════════╗");
        System.out.printf("║%20s%-20s║%n", "", title);
        System.out.println("╚══════════════════════════════════════════════╝" + reset);
    }

    // 🔁 ابزار کمکی برای گرفتن عدد از کاربر
    private int getIntInput() {
        while (true) {
            try {
                System.out.print("> ");
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("ورودی عددی نیست، دوباره وارد کنید.");
            }
        }
    }

    // 🧹 پاک‌کردن صفحه ترمینال (روی بعضی محیط‌ها محدود)
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // ⏸️ توقف تا فشار دادن Enter
    private void waitForEnter() {
        System.out.println("\nبرای ادامه Enter را بزنید...");
        sc.nextLine();
    }

    // 🚀 تابع اصلی
    public static void main(String[] args) {
        TaskManager app = new TaskManager();
        app.showMainMenu();
    }
}











