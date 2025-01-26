
# ShizukuFileUtil 
[English Version](README.md)

`ShizukuFileUtil` 是一个用于文件 I/O 控制的工具类。它依赖 `ShizukuExec` 来执行与文件操作相关的 Shell 命令，提供了一些常见的文件操作方法，如列出目录、读取文件内容、移动文件、删除文件等。

ShizukuFileUtil is a utility class used for file I/O control. It relies on `ShizukuExec` to execute shell commands related to file operations and provides several common file operation methods such as listing directories, reading file content, moving files, deleting files, etc.

### ShizukuFileUtil 函数文档

#### 1. **`list(String path)`**
**描述**：使用 `ls` 命令列出指定路径中的所有文件和目录。
- **参数**：  
  `path` - 需要列出内容的目录路径。
- **返回值**：  
  包含文件和目录名称的 `List<String>`，如果出错则返回空列表。

---

#### 2. **`exist(String path)`**
**描述**：通过列出目录内容检查指定路径中的文件或目录是否存在。
- **参数**：  
  `path` - 要检查的路径。
- **返回值**：  
  如果文件或目录存在返回 `true`，否则返回 `false`。

---

#### 3. **`read(String path)`**
**描述**：使用 `cat` 命令读取指定路径中的文件内容。
- **参数**：  
  `path` - 要读取的文件路径。
- **返回值**：  
  文件内容作为 `String` 返回，如果出错则返回空字符串。

---

#### 4. **`readO(String path)`**
**描述**：从指定路径读取文件内容并将其写入 `OutputStream`。
- **参数**：  
  `path` - 要读取的文件路径。
- **返回值**：  
  包含文件内容的 `OutputStream`。

---

#### 5. **`readI(String path)`**
**描述**：读取指定路径中的文件内容，并以 `InputStream` 的形式返回。
- **参数**：  
  `path` - 要读取的文件路径。
- **返回值**：  
  包含文件内容的 `InputStream`。

---

#### 6. **`read(InputStream stream)`**
**描述**：通过反射获取 `FileInputStream` 的文件路径并读取内容。
- **参数**：  
  `stream` - 输入流（必须是 `FileInputStream` 类型）。
- **返回值**：  
  文件内容作为 `String` 返回，如果输入流不是 `FileInputStream` 或出错则返回 `null`。

---

#### 7. **`write(String path, InputStream stream)`**
**描述**：将 `InputStream` 中的内容写入文件，覆盖现有内容。
- **参数**：  
  `path` - 文件的路径。  
  `stream` - 包含要写入数据的 `InputStream`。
- **返回值**：  
  一个 `Future<Boolean>`，指示写入操作是否成功。

---

#### 8. **`write(String path, String content)`**
**描述**：将字符串内容写入文件，覆盖现有内容。
- **参数**：  
  `path` - 文件的路径。  
  `content` - 要写入的内容。
- **返回值**：  
  一个 `Future<Boolean>`，指示写入操作是否成功。

---

#### 9. **`move(String oldPath, String newPath)`**
**描述**：将文件或目录移动到新位置。
- **参数**：  
  `oldPath` - 源路径。  
  `newPath` - 目标路径。
- **返回值**：  
  一个 `Future<Boolean>`，指示移动操作是否成功。

---

#### 10. **`remove(String path)`**
**描述**：删除指定路径中的文件。
- **参数**：  
  `path` - 要删除的文件路径。
- **返回值**：  
  一个 `Future<Boolean>`，指示删除操作是否成功。

---

#### 11. **`runVoidCommand(String command)`**
**描述**：执行一个 shell 命令，并判断成功或失败。
- **参数**：  
  `command` - 要执行的命令。
- **返回值**：  
  一个 `Future<Boolean>`，指示命令执行是否成功。

