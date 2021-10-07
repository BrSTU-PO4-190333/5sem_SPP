using System;
using System.IO;
using Newtonsoft.Json;
using System.Collections.Generic;

namespace task2_option5
{
    class Program
    {
        // Main function
        static void Main(string[] args)
        {
            String path = "../../../../files/file.json";
            FileSystem obj = new FileSystem();
            obj.open_file(path);
            obj.print_json();

            obj.add_folder("folder1");
            obj.add_folder("folder2");
            obj.add_file(500, "1", "txt");
            obj.add_file(500, "2", "txt");
            obj.add_file(800, "3", "txt");
            obj.add_file(800, "5", "txt");
            obj.add_file(100, "6", "txt");
            obj.add_file(100, "7", "txt");
            obj.add_file(100, "7", "txt");
            obj.add_file(41, "8", "txt");
            obj.add_file(40, "9", "txt");
            obj.print_json();

            obj.delete_file("start", "bat");
            obj.delete_file("styles", "css");
            obj.delete_file_on_folder("assets", "styles", "css");
            obj.delete_file("index", "php");
            obj.delete_file("form", "html");
            obj.delete_file("main", "js");
            obj.delete_file_on_folder("assets", "main", "js");
            obj.delete_folder("assets");
            obj.delete_file("1", "txt");
            obj.delete_file("3", "txt");
            obj.delete_file("5", "txt");
            obj.delete_file("7", "txt");
            obj.delete_file("9", "txt");
            obj.delete_file("8", "txt");
            obj.delete_file("6", "txt");
            obj.delete_file("4", "txt");
            obj.delete_file("2", "txt");
            obj.delete_folder("folder2");
            obj.delete_folder("someDirectory");
            obj.delete_folder("assets");
            obj.delete_folder("folder1");
            obj.delete_file("7", "txt");
            obj.print_json();
        }
        // Implementing classes for a file and folder
        class FileClass
        {
            public String type;
            public int size;
            public String name;
            public String extension;
            public List<FileClass> files = new List<FileClass>();
            // Constructor
            public FileClass()
            {
                this.type = "null";
                this.size = 0;
                this.name = "";
                this.extension = "";
                this.files = new List<FileClass>();
            }
            // Constructor
            public FileClass(
                string type,
                int size = 0,
                String name = "",
                String extension = ""
            )
            {
                this.type = type;
                this.size = size;
                this.name = name;
                this.extension = extension;
                this.files = new List<FileClass>();
            }
        } // end class FileClass

        class FileSystem
        {
            public List<FileClass> obj = new List<FileClass>();
            public int memorySize;
            public int occupiedSpace;
            // Constructor
            public FileSystem(int memorySize = 1440)
            {
                this.memorySize = memorySize;
                this.occupiedSpace = 0;
            }
            // A function that reads a JSON file
            public void open_file(String path)
            {
                try
                {
                    FileClass[] arr = JsonConvert.DeserializeObject<FileClass[]>(File.ReadAllText(path));
                    for (int i = 0; i < arr.Length; i += 1)
                    {
                        switch(arr[i].type)
                        {
                            case "file":
                                this.add_file(arr[i].size, arr[i].name, arr[i].extension);
                                break;
                            case "folder":
                                this.add_folder(arr[i].name);
                                break;
                        }

                        if (arr[i].type == "folder")
                        {
                            for (int j = 0; j < arr[i].files.Count; j += 1)
                            {
                                if (arr[i].files[j].type == "file")
                                {
                                    this.add_file_to_folder(
                                        arr[i].name,
                                        arr[i].files[j].size,
                                        arr[i].files[j].name,
                                        arr[i].files[j].extension
                                    );
                                }
                            }
                        }
                    }
                }
                catch (FileNotFoundException) 
                {
                    Console.WriteLine("[!] File not opened!");
                }
                catch (DirectoryNotFoundException)
                {
                    Console.WriteLine("[!] Directory not found!");
                }
                catch (Newtonsoft.Json.JsonSerializationException)
                {
                    Console.WriteLine("[!] Error JSON format!");
                }
            }
            // Function that prints JSON
            public void print_json()
            {
                Console.WriteLine();
                Console.WriteLine("JSON print");
                string strJson = JsonConvert.SerializeObject(this.obj, Formatting.Indented);
                Console.WriteLine(strJson);
                Console.WriteLine();
            }

            public void add_file(int size, String name, String extension)
            {
                this.occupiedSpace += size;

                if (this.occupiedSpace > this.memorySize)
                {
                    Console.WriteLine(
                        "[!] "
                        + "[" + this.occupiedSpace + "/" + this.memorySize + "] "
                        + "file " + name + "." + extension + " "
                        + "not added"
                    );
                    this.occupiedSpace -= size;
                    return;
                }
                FileClass f = new FileClass("file", size, name, extension);
                obj.Add(f);

                Console.WriteLine(
                    "[+] "
                    + "[" + this.occupiedSpace + "/" + this.memorySize + "] "
                    + "file " + name + "." + extension + " added"
                );
            }

            public void delete_file(String name, String extension)
            {
                for (int i = 0; i < obj.Count; i += 1)
                {
                    if (obj[i].name == name && obj[i].extension == extension)
                    {
                        this.occupiedSpace -= obj[i].size;
                        obj.RemoveAt(i);
                        Console.WriteLine("[-] File " + name + "." + extension + " deleted");
                        this.print_memory(this.occupiedSpace);
                        this.print_path(name, extension);
                        return;
                    }
                }
                Console.WriteLine("[!] File " + name + "." + extension
                    + " not deleted, because file is not found");
                this.print_memory(this.occupiedSpace);
                this.print_path(name, extension);
            }

            public void add_file_to_folder(String folderName, int size, String name, String extension)
            {
                this.occupiedSpace += size;
                if (this.occupiedSpace > this.memorySize)
                {
                    Console.WriteLine("[!] file " + name + "." + extension
                        + " not added to folder " + folderName);
                    this.print_memory(this.occupiedSpace);
                    this.print_path(name, extension);
                    this.occupiedSpace -= size;
                    return;
                }

                for (int i = 0; i < this.obj.Count; i += 1)
                {
                    if (this.obj[i].type == "folder")
                    {
                        if (this.obj[i].files == null)
                        {
                            this.obj[i].files = new List<FileClass>();
                        }

                        FileClass f = new FileClass("file", size, name, extension);
                        this.obj[i].files.Add(f);
                        break;
                    }
                }
                Console.WriteLine("[+] file " + name + "." + extension + " "
                    + "added to folder " + folderName);
                this.print_memory(this.occupiedSpace);
                this.print_path(folderName, name, extension);
            }

            public void add_folder(String name)
            {
                FileClass f = new FileClass("folder", 0, name, "");
                obj.Add(f);

                Console.WriteLine("[+] folder " + name + " " + "added");
                this.print_memory(this.occupiedSpace + 0);
                this.print_path(name);
            }

            public void delete_folder(String name)
            {
                for (int i = 0; i < obj.Count; i += 1)
                {
                    if (
                        this.obj[i].name == name
                        && obj[i].type == "folder"
                        && (obj[i].files == null || obj[i].files.Count == 0)
                    )
                    {
                        this.occupiedSpace -= obj[i].size;
                        obj.RemoveAt(i);
                        Console.WriteLine("[-] folder " + name + " " + "deleted");
                        this.print_memory(this.occupiedSpace);
                        this.print_path(name);
                        return;
                    }
                }

                Console.WriteLine("[!] folder " + name + " "
                    + "not deleted, because folder not found");
                this.print_memory(this.occupiedSpace);
                this.print_path(name);
            }

            public void delete_file_on_folder(String folderName, String name, String extension)
            {
                for (int i = 0; i < this.obj.Count; i += 1)
                {
                    if (
                        this.obj[i].type == "folder"
                        && (this.obj[i].files != null || this.obj[i].files.Count == 0)
                        && this.obj[i].name == folderName
                    )
                    {
                        for (int j = 0; j < this.obj[i].files.Count; j += 1)
                        {
                            if (
                                this.obj[i].files[j].name == name
                                && this.obj[i].files[j].extension == extension
                            )
                            {
                                this.obj[i].files.RemoveAt(j);
                            }
                        }
                    }
                }
            }
            // Out [123/1440]
            public void print_memory(int occupiedSpace)
            {
                Console.WriteLine(
                    "\t[{0}/{1}]",
                    occupiedSpace,
                    this.memorySize
                );
            }
            // Out: /file.extension
            public void print_path(String name, String extension)
            {
                Console.WriteLine(
                    "\t/{0}.{1}",
                    name, extension
                );
            }
            // Out: /someFolder/file.extension
            public void print_path(String folderName, String name, String extension)
            {
                Console.WriteLine(
                    "\t/{0}/{1}.{2}",
                    folderName,
                    name, extension
                );
            }
            // Out: /someFolder/
            public void print_path(String name)
            {
                Console.WriteLine(
                    "\t/{0}/",
                    name
                );
            }
        } // end class FileSystem
    } // end class Product
}
