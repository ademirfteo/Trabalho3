import java.util.ArrayList;
import java.util.regex.Pattern;


public class Dictionary {
	
	private ArrayList<String> arrayWord;
	
	public Dictionary() {
		this.arrayWord = new ArrayList<String>();
	}
	
	public void AddArray(String word) {		
		arrayWord.add(word);
	}
	
	public boolean ConsultaArray(String word) {		
				
		for (String w : arrayWord) {
			if (w.equals(word)) {
				return true;
			}
		}
		return false;
	}
	
	public String ClearWord(String word) {
		String w;	
		w = word.replaceAll(Pattern.quote("("), "");
		w = w.replaceAll(Pattern.quote(")"), "");
		w = w.replaceAll(Pattern.quote("."), "");
		w = w.replaceAll(Pattern.quote(","), "");
		w = w.replaceAll(Pattern.quote("/"), "");
		w = w.replaceAll(Pattern.quote("'"), "");
		w = w.replaceAll("\"", "");
		return w;
	}
	
	public boolean FilterWord(String word) {
		
		if (word.length() <= 2) {
			return true;
		}
		if (!word.replaceAll("[^0-9]", "").equals("")) {
			return true;
		}
		return false;
	}
	
	public ArrayList<String> getArrayWord() {
		return arrayWord;
	}
}
