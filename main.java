import java.io.*;
import java.util.*;

public class main {
	static void gameLoop(Scanner sc, String chosenWord, String userWord){
		for(int i=0; i<chosenWord.length(); i++){
			System.out.println("\nEnter your guess number "+(i+1));
			userWord = sc.next();

			String greenBackdrop = "\033[30;102m";
			String yellowBackdrop = "\033[30;103m";
			String whiteBackdrop = "\033[30;107m";
			String resetColor =  "\033[0m";

			int gotRight = 0;
			for(int j=0; j<chosenWord.length(); j++){
				if(chosenWord.charAt(j) == userWord.charAt(j)){
					System.out.print(greenBackdrop+" "+Character.toUpperCase(userWord.charAt(j))+" "+resetColor);
					gotRight++;
				}else{
					int found = 0;
					for(int k=0; k<chosenWord.length(); k++){
						if(userWord.charAt(j) == chosenWord.charAt(k)){
							found = 1;
							break;
						}
					}
					if(found == 1){
						System.out.print(yellowBackdrop+" "+Character.toUpperCase(userWord.charAt(j))+" "+resetColor);
					}else{
						System.out.print(whiteBackdrop+" "+Character.toUpperCase(userWord.charAt(j))+" "+resetColor);
					}
				}
				if(gotRight == chosenWord.length()){
					System.out.println("\nYOU GUESSED THE WORD CORRECTLY: "+chosenWord);
					return;
				}
			}
		}
		System.out.println("\nYOU ARE OUT OF ATTEMPTS, THE WORD WAS: "+chosenWord);
	}
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
			String userWord = "";
			Scanner sc = new Scanner(System.in);

			System.out.println("The word is "+chosenWord.length()+" letters long");
			gameLoop(sc, chosenWord, userWord);
		}
		catch(Exception error){
			System.out.println("An error occurred: "+error.getMessage());
		}
	}
}
