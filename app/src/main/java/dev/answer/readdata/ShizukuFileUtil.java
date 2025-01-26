package dev.answer.readdata;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static dev.answer.readdata.Exec.ShizukuExec;

import android.util.Log;

/**
 * Utility class for file operations using ShizukuExec.
 */
public class ShizukuFileUtil {

    /**
     * Lists all files and directories at the specified path.
     *
     * @param path The path to the directory.
     * @return A list of file names in the directory.
     */
    public static List<String> list(String path) {
        final ArrayList<String> files = new ArrayList<>();
        try {
            if (!files.isEmpty()) {
                files.clear();
            }
            ShizukuExec("ls " + path, new Function<String, String>() {
                @Override
                public String apply(String t) {
                    files.add(t);
                    return null;
                }
            }, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }

    /**
     * Checks if a file or directory exists at the specified path.
     *
     * @param path The path to check.
     * @return True if the file or directory exists, false otherwise.
     */
    public static boolean exist(String path) {
        List<String> files = list(path);
        return files != null && !files.isEmpty();
    }

    /**
     * Reads the content of the file at the specified path.
     *
     * @param path The path to the file.
     * @return The content of the file as a string.
     */
    public static String read(String path) {
        final StringBuilder builder = new StringBuilder();
        try {
            ShizukuExec("cat " + path, new Function<String, String>() {
                @Override
                public String apply(String t) {
                    builder.append(t);
                    return null;
                }
            }, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     * Reads the content of the file at the specified path and writes it to an OutputStream.
     *
     * @param path The path to the file.
     * @return The OutputStream containing the file content.
     */
    public static OutputStream readO(String path) {
        OutputStream os = System.out;
        try {
            String content = read(path);
            os.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return os;
    }

    /**
     * Reads the content of the file at the specified path and returns it as an InputStream.
     *
     * @param path The path to the file.
     * @return An InputStream containing the file content.
     */
    public static InputStream readI(String path) {
        InputStream is = null;
        try {
            String content = read(path);
            is = new ByteArrayInputStream(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }

    /**
     * Reads the content from a FileInputStream by reflecting the file path.
     *
     * @param stream The InputStream (must be a FileInputStream).
     * @return The content of the file as a string.
     */
    public static String read(InputStream stream) {
        if (!(stream instanceof FileInputStream)) {
            Log.e("ShizukuFile", "Unsupported InputStream type");
            return null;
        }
        try {
            FileInputStream is = (FileInputStream) stream;
            Field pathField = FileInputStream.class.getDeclaredField("path");
            pathField.setAccessible(true);
            String path = (String) pathField.get(is);
            return read(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Writes content from an InputStream to a file, overwriting existing content.
     *
     * @param path   The path to the file.
     * @param stream The InputStream containing the data to write.
     * @return True if the write operation succeeded, false otherwise.
     */
    public static Future<Boolean> write(String path, InputStream stream) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while ((i = stream.read()) != -1) {
                baos.write(i);
            }
            String content = baos.toString();
            String command = "echo \"" + content + "\" | cat > " + path;
            return runVoidCommand(command);
        } catch (Exception e) {
            e.printStackTrace();
            return Future.generate(false);
        }
    }

    /**
     * Writes a string content to a file, overwriting existing content.
     *
     * @param path    The path to the file.
     * @param content The content to write.
     * @return True if the write operation succeeded, false otherwise.
     */
    public static Future<Boolean> write(String path, String content) {
        try {
            String command = "echo \"" + content + "\" | cat > " + path;
            return runVoidCommand(command);
        } catch (Exception e) {
            e.printStackTrace();
            return Future.generate(false);
        }
    }

    /**
     * Moves a file or directory to a new location.
     *
     * @param oldPath The source path.
     * @param newPath The destination path.
     * @return True if the move operation succeeded, false otherwise.
     */
    public static Future<Boolean> move(String oldPath, String newPath) {
        return runVoidCommand("mv " + oldPath + " " + newPath);
    }

    /**
     * Deletes a file at the specified path.
     *
     * @param path The path to the file.
     * @return True if the delete operation succeeded, false otherwise.
     */
    public static Future<Boolean> remove(String path) {
        return runVoidCommand("rm -f " + path);
    }

    /**
     * Executes a shell command and determines success or failure.
     *
     * @param command The command to execute.
     * @return A Future indicating the success or failure of the command.
     */
    private static Future<Boolean> runVoidCommand(String command) {
        final Future<Boolean> future = new Future<>();
        try {
            ShizukuExec(command, new Function<String, String>() {
                @Override
                public String apply(String t) {
                    future.complete(true);
                    return null;
                }
            }, new Function<String, String>() {
                @Override
                public String apply(String t) {
                    future.complete(false);
                    return null;
                }
            }, new Function<String, String>() {
                @Override
                public String apply(String t) {
                    if (t.contains("0")) {
                        future.complete(true);
                    }
                    return null;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return future;
    }
}
