import java.io.*;
import java.util.ArrayList;

public class main {
	public static void main(String[] args){
		try{
			Reader r = new FileReader("1000-most-common-words.txt");
			ArrayList<String> wordList = new ArrayList<>();
			int character = r.read();

			while (character != -1) {
				String word = ""; 
				while ((char)character != '\n') {
					word = word +(char)character;
					character = r.read();
				}
				wordList.add(word);
				character = r.read();
			}
			r.close();
			int randomWordIndex = (int)(Math.random()*(wordList.size()-0)) + 0;
			String chosenWord = wordList.get(randomWordIndex);
			System.out.println(wordList.size());
			System.out.println(chosenWord);
			char[] userWord = new char[chosenWord.length()];
		}
		catch(Exception error){
			System.out.println("An error occurred: "+error.getMessage());
		}
	}
}
