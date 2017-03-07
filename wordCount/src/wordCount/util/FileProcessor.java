package wordCount.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;
/**
 * Class to do all the file processing
 * @author Rishi Sanas,Varun Kulkarni
 *
 */
public class FileProcessor {
	public static FileInputStream f_Istream;
	public static FileOutputStream f_Ostream;
	public static BufferedReader input;
	
	/**
	 * Constructor for FileProcessor Class
	 * @param fileName
	 * @param mode
	 */
	public FileProcessor(String fileName,boolean mode) {
		if(!mode)
		{
			try {
				f_Istream = new FileInputStream(fileName);
			} catch (FileNotFoundException e1) {
				
				System.err.println(e1.toString());
				System.exit(1);
			}catch (Exception e) {
				System.err.println(e.toString());
				System.exit(1);
			}
			try {
				input = new BufferedReader(new InputStreamReader(f_Istream));
			}
			catch (Exception e) {
				System.err.println(e.toString());
				System.exit(1);
			}
		}
		else
		{
			File yourFile = new File(fileName);
			if(!yourFile.exists()) {
			    try {
					yourFile.createNewFile();
				} catch (IOException e) {
					
					System.out.println(e.toString());
					System.exit(1);
				}
			} 
			
			try {
				f_Ostream = new FileOutputStream(fileName,true);
			} catch (FileNotFoundException e) {
				
				System.out.println(e.toString());
				System.exit(1);
			}
		}
	}
	
	/**
	 * Method to read line from the file
	 * @return
	 * @throws IOException
	 */
	public String readLineFromFile() throws IOException {
		String lineRead="";
		try {
			lineRead=input.readLine();
		} catch (Exception e) {
			System.err.println(e.toString());
			System.exit(1);
		}
		return lineRead;
	}
	
	
	/**
	 * Method to write to a file 
	 * @param line
	 * @throws IOException
	 */
	public void writeToFile(String line) throws IOException {
		
		try {
			f_Ostream.write(line.getBytes(Charset.forName("UTF-8")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			System.exit(1);
		}
	}
	
	
	/**
	 * Method to close file
	 */
	public void closeFile() 
	{
		
		try {
			f_Istream.close();
			f_Ostream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
}
