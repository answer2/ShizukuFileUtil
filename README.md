
# ShizukuFileUtil 
[中文版本](README_CN.md)

## Overview
**ShizukuFileUtil** is a utility class that provides file I/O control through various methods using Shizuku, a service that allows regular apps to use system APIs with ADB/root privileges. The class contains several static methods for file operations such as listing, reading, moving, removing, and copying files.

## Methods

### 1. list(String path)
Lists the files in the specified directory.

- **Parameters:**
  - `path`: The path of the directory to list files from.
- **Returns:**
  - A `List<String>` containing the names of the files in the specified directory.

### 2. read(String path)
Reads the contents of the specified file.

- **Parameters:**
  - `path`: The path of the file to read.
- **Returns:**
  - A `String` containing the contents of the specified file.

### 3. move(String oldfile, String newfile)
Moves (renames) a file from the old path to the new path.

- **Parameters:**
  - `oldfile`: The current path of the file.
  - `newfile`: The new path where the file should be moved.
- **Returns:**
  - A `Future<Boolean>` indicating the success or failure of the operation.

### 4. remove(String path)
Removes the specified file.

- **Parameters:**
  - `path`: The path of the file to remove.
- **Returns:**
  - A `Future<Boolean>` indicating the success or failure of the operation.

### 5. removeDir(String path)
Removes the specified directory.

- **Parameters:**
  - `path`: The path of the directory to remove.
- **Returns:**
  - A `Future<Boolean>` indicating the success or failure of the operation.

### 6. copy(String directoryA, String directoryB)
Copies a file from one directory to another.

- **Parameters:**
  - `directoryA`: The source directory path.
  - `directoryB`: The destination directory path.
- **Returns:**
  - A `Future<Boolean>` indicating the success or failure of the operation.

### 7. runVoidCommand(String command)
Executes a command using Shizuku and returns the success status.

- **Parameters:**
  - `command`: The command to execute.
- **Returns:**
  - A `Future<Boolean>` indicating the success or failure of the command.
