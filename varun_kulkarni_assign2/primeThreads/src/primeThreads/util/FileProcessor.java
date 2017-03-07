/*
 * FileProcessor reads one line from the input file based
 * on stream created.
 * Line read is returned as a string.
 */
package primeThreads.util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import primeThreads.util.Logger.DebugLevel;

public class FileProcessor {
	public static FileInputStream f_stream;
	public static BufferedReader input;
	public FileProcessor(String fileName) {
		Logger.writeMessage("In FileProcessor Constructor", DebugLevel.CONSTRUCTOR);
		try {
			f_stream = new FileInputStream(fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			input = new BufferedReader(new InputStreamReader(f_stream));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized String readLineFromFile() throws IOException {
		try {
			return input.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Exception found";
	}
}
