package engine.CLI;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Console {
	
	/**
	 * Tag to be used when logging in Gdx.app.log()
	 */
	private String tag;
	private Scanner sc;

	public Console() {
		tag = "EConsole";
	}
	
	public Console(String _tag){
		tag = _tag;
		sc = new Scanner(System.in);
	}
	
	/**
	 * Prints a line to the screen and logs it
	 * 
	 * @param _toPrint message to print
	 */
	public void say(String _toPrint){
		System.out.println(_toPrint);
		Gdx.app.log(tag, _toPrint);
	}
	
	/**
	 * Prints a line to the screen, and logs it
	 * Waits for user input and returns it.
	 * 
	 * @param _toAsk question to ask
	 * @return user input
	 */
	public String ask(String _toAsk){
		System.out.println(_toAsk);
		Gdx.app.log(tag, _toAsk);
		
		while(!(sc.hasNextLine())){
			//creates a loop while we wait for input
		}
		String answer = sc.nextLine();
		Gdx.app.log(tag, answer);
		return answer;
	}
	
	public int askInt(String _toAsk, String requiredFormat, Vector2 range, Vector2 amountOfDigits){
		
		boolean sucseesful = true;
		String answer;
		int answerAsInt = 0;
		do{
			if(!sucseesful){ //first run
				System.out.println("That was not a number in the correct format");
				System.out.println("Rquired format is" + requiredFormat);
				Gdx.app.log(tag, "A string failed to conver to int, expected format: " + requiredFormat);
			}
			sucseesful = true;
			answer = ask(_toAsk);
			Gdx.app.log(tag, answer);
			
			
			try{
				answerAsInt = Integer.parseInt(answer);
			} catch(NumberFormatException e){
				sucseesful = false;
				Gdx.app.debug(tag, e.getMessage());
			}
			
			if(!sucseesful || answerAsInt < range.x || answerAsInt > range.y || String.valueOf(answerAsInt).length() < amountOfDigits.x || String.valueOf(answerAsInt).length() > amountOfDigits.y){
				if(answerAsInt < range.x){
					say("< x");
					
				} else if (answerAsInt > range.y) {
					
					Gdx.app.debug(tag, "> y");
				} else if (String.valueOf(answerAsInt).length() < amountOfDigits.x){
					Gdx.app.debug(tag, "String.valueOf(answerAsInt).length() < amountOfDigits.x");
				} else if (String.valueOf(answerAsInt).length() > amountOfDigits.y){
					Gdx.app.debug(tag, "String.valueOf(answerAsInt).length() > amountOfDigits.y");
				} else {
					Gdx.app.debug(tag, "oh shit");
				}
				sucseesful = false;
			} else {
				sucseesful = true;
			}
			
		} while (!sucseesful);
		return answerAsInt;
	}
	
	
	/**
	 * @return the Tag that will be used when logging in Gdx.app.log()
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the Tag to be used when logging in Gdx.app.log()
	 */
	public void setTag(String _tag) {
		Gdx.app.log("Tag Change", "tag changed from " + this.tag + " to " + _tag + "");
		this.tag = _tag;
	}

}
