import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileUtility {

    // 1. Create a new file
    public static boolean createFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                System.out.println("File already exists.");
                return false;
            }
            return file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
            return false;
        }
    }

    // 2. Write content to a file (overwrite)
    public static boolean writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            return false;
        }
    }

    // 3. Append content to a file
    public static boolean appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine();
            writer.write(content);
            return true;
        } catch (IOException e) {
            System.out.println("Error appending file: " + e.getMessage());
            return false;
        }
    }

    // 4. Read all lines from a file
    public static void readFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // 5. Delete a file
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return file.delete();
        } else {
            System.out.println("File not found.");
            return false;
        }
    }

    // 6. Check if file exists
    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    // 7. Get file size
    public static long getFileSize(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return file.length(); // size in bytes
        } else {
            System.out.println("File not found.");
            return -1;
        }
    }
}