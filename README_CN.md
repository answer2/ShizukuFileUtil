
# ShizukuFileUtil [English Version](README.md)

`ShizukuFileUtil` 是一个用于文件 I/O 控制的工具类。它依赖 `ShizukuExec` 来执行与文件操作相关的 Shell 命令，提供了一些常见的文件操作方法，如列出目录、读取文件内容、移动文件、删除文件等。

ShizukuFileUtil is a utility class used for file I/O control. It relies on `ShizukuExec` to execute shell commands related to file operations and provides several common file operation methods such as listing directories, reading file content, moving files, deleting files, etc.

## 类方法（Class Methods）

### `public static List<String> list(String path)`

**描述 (Description):**  
列出指定路径中的文件和目录。  
List files and directories in the specified path.

**参数 (Parameters):**  
- `path`: 要列出的目录路径。  
  The path of the directory to list.

**返回值 (Returns):**  
- `List<String>`: 文件和目录的列表。  
  A list of files and directories.

### `public static String read(String path)`

**描述 (Description):**  
读取指定文件的内容。  
Read the content of the specified file.

**参数 (Parameters):**  
- `path`: 要读取的文件路径。  
  The path of the file to read.

**返回值 (Returns):**  
- `String`: 文件内容。  
  The content of the file.

### `public static Future<Boolean> move(String oldfile, String newfile)`

**描述 (Description):**  
移动或重命名指定的文件。  
Move or rename the specified file.

**参数 (Parameters):**  
- `oldfile`: 原始文件路径。  
  The original file path.
- `newfile`: 目标文件路径。  
  The destination file path.

**返回值 (Returns):**  
- `Future<Boolean>`: 操作是否成功的异步结果。  
  An asynchronous result indicating whether the operation was successful.

### `public static Future<Boolean> remove(String path)`

**描述 (Description):**  
删除指定的文件。  
Remove the specified file.

**参数 (Parameters):**  
- `path`: 要删除的文件路径。  
  The path of the file to remove.

**返回值 (Returns):**  
- `Future<Boolean>`: 操作是否成功的异步结果。  
  An asynchronous result indicating whether the operation was successful.

### `public static Future<Boolean> removeDir(String path)`

**描述 (Description):**  
删除指定的目录。  
Remove the specified directory.

**参数 (Parameters):**  
- `path`: 要删除的目录路径。  
  The path of the directory to remove.

**返回值 (Returns):**  
- `Future<Boolean>`: 操作是否成功的异步结果。  
  An asynchronous result indicating whether the operation was successful.

### `public static Future<Boolean> copy(String directoryA, String directoryB)`

**描述 (Description):**  
复制文件或目录。  
Copy a file or directory.

**参数 (Parameters):**  
- `directoryA`: 源目录路径。  
  The source directory path.
- `directoryB`: 目标目录路径。  
  The destination directory path.

**返回值 (Returns):**  
- `Future<Boolean>`: 操作是否成功的异步结果。  
  An asynchronous result indicating whether the operation was successful.

### `private static Future<Boolean> runVoidCommmand(String commmand)`

**描述 (Description):**  
运行指定的 Shell 命令，并返回操作是否成功的异步结果。  
Run the specified shell command and return an asynchronous result indicating whether the operation was successful.

**参数 (Parameters):**  
- `command`: 要运行的 Shell 命令。  
  The shell command to run.

**返回值 (Returns):**  
- `Future<Boolean>`: 操作是否成功的异步结果。  
  An asynchronous result indicating whether the operation was successful.
