package com.reader;
import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class ReadFile {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String actionClassLine = null;
		String data = null;
		try {
			System.out.print("Enter file  Path- ");
			String path = scanner.next();
			// E://struct2Spring//LoginExampleStruts1//src//com//example//action
			// D://fileread//input
			File filePath = new File(path);
			File[] listOfFiles = filePath.listFiles();
			Scanner pathReader = null;
			String fileName = null;
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println("File " + listOfFiles[i].getName());
					fileName = listOfFiles[i].getName();
					System.out.println(" File Nme" + fileName);
				}
				File filePath2 = new File(path + "\\" + fileName);
				pathReader = new Scanner(filePath2);
				// Removing .java from action class fileName
				String removeLastChar = fileName.substring(0, fileName.length() - 5);
				actionClassLine = "public class" + " " + removeLastChar + " " + "extends Action {";
				if (actionClassLine.contains(removeLastChar)) {
					while (pathReader.hasNextLine()) {
						data = pathReader.nextLine();
						System.out.println(data);
						String inputTextPath = "Please Enter" + " " + removeLastChar + " " + "Path";
						System.out.print(inputTextPath);
						String controlerPath = scanner.next();
						System.out.println("controlerPath "+controlerPath);
						@SuppressWarnings("resource")
						FileInputStream fileInputStream = new FileInputStream(
								controlerPath + "//" + removeLastChar + ".txt");
						int in = 0;
						String s = "";
						while ((in = fileInputStream.read()) != -1) {
							s = s + String.valueOf((char) in);
						}
						String outPutControllerName = removeLastChar + "Controller.java";
						System.out.println("outPutControllerName "+outPutControllerName);
						FileOutputStream fileOut = new FileOutputStream(
								"D:\\fileread\\output\\" + outPutControllerName);
						byte[] b = s.getBytes();
						fileOut.write(b);
						fileOut.close();
						System.out.println("Done reading and writing!!");
						break;
					}
				}
			}
			pathReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}