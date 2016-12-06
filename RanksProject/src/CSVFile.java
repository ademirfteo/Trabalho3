import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVFile {

	private Scanner scanner;

	
	// LÊ ARQUIVO
	
	public CSVFile(String filepath) throws FileNotFoundException {
		scanner = new Scanner(new FileReader(filepath));
		scanner.nextLine();
	}

	public boolean hasNext() {
		return scanner.hasNext();
	}

	public String[] next() {
		String linha = scanner.nextLine();
		String [] lista = linha.split(";");
		return lista;
	}
	
	
	// GRAVA ARQUIVO
	
	public BufferedWriter CreateFile(String namePath) throws IOException {
		try {
			File f = new File(namePath);
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);		
			return bw;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean AddLineFile(BufferedWriter bw, String word) {
		
		try {
			bw.write(word);
			bw.newLine();
			return true;
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean CloseFile(BufferedWriter bw) {
		try {
			bw.flush();
			bw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
