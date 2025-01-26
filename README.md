
# ShizukuFileUtil 
[中文版本](README_CN.md)

## Overview
**ShizukuFileUtil** is a utility class that provides file I/O control through various methods using Shizuku, a service that allows regular apps to use system APIs with ADB/root privileges. The class contains several static methods for file operations such as listing, reading, moving, removing, and copying files.

### ShizukuFileUtil Function Documentation

#### 1. **`list(String path)`**
**Description**: Lists all files and directories in the specified path using the `ls` command.
- **Parameters**:  
  `path` - The path to the directory to list.
- **Returns**:  
  A `List<String>` containing file and directory names, or an empty list if an error occurs.

---

#### 2. **`exist(String path)`**
**Description**: Checks if a file or directory exists in the given path by listing its contents.
- **Parameters**:  
  `path` - The path to check for existence.
- **Returns**:  
  `true` if the file or directory exists, `false` otherwise.

---

#### 3. **`read(String path)`**
**Description**: Reads the content of a file at the specified path using the `cat` command.
- **Parameters**:  
  `path` - The file path to read.
- **Returns**:  
  The file content as a `String`, or an empty string if an error occurs.

---

#### 4. **`readO(String path)`**
**Description**: Reads file content from the specified path and writes it to an `OutputStream`.
- **Parameters**:  
  `path` - The file path to read.
- **Returns**:  
  The `OutputStream` containing the file content.

---

#### 5. **`readI(String path)`**
**Description**: Reads the content of the file at the specified path and returns it as an `InputStream`.
- **Parameters**:  
  `path` - The file path to read.
- **Returns**:  
  An `InputStream` containing the file content.

---

#### 6. **`read(InputStream stream)`**
**Description**: Reads the content from a `FileInputStream` by reflecting the file path.
- **Parameters**:  
  `stream` - The `InputStream` (must be a `FileInputStream`).
- **Returns**:  
  The file content as a `String`, or `null` if the input stream is not a `FileInputStream` or if an error occurs.

---

#### 7. **`write(String path, InputStream stream)`**
**Description**: Writes content from an `InputStream` to a file, overwriting existing content.
- **Parameters**:  
  `path` - The path to the file.  
  `stream` - The `InputStream` containing the data to write.
- **Returns**:  
  A `Future<Boolean>` indicating whether the write operation succeeded.

---

#### 8. **`write(String path, String content)`**
**Description**: Writes a string content to a file, overwriting existing content.
- **Parameters**:  
  `path` - The path to the file.  
  `content` - The content to write.
- **Returns**:  
  A `Future<Boolean>` indicating whether the write operation succeeded.

---

#### 9. **`move(String oldPath, String newPath)`**
**Description**: Moves a file or directory to a new location.
- **Parameters**:  
  `oldPath` - The source path.  
  `newPath` - The destination path.
- **Returns**:  
  A `Future<Boolean>` indicating whether the move operation succeeded.

---

#### 10. **`remove(String path)`**
**Description**: Deletes a file at the specified path.
- **Parameters**:  
  `path` - The path to the file.
- **Returns**:  
  A `Future<Boolean>` indicating whether the delete operation succeeded.

---

#### 11. **`runVoidCommand(String command)`**
**Description**: Executes a shell command and determines success or failure.
- **Parameters**:  
  `command` - The command to execute.
- **Returns**:  
  A `Future<Boolean>` indicating the success or failure of the command.
