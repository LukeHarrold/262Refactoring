import java.util.*;
/**
 *  Class that holds all bowler info
 *
 */

public class Bowler {

    private String fullName;
    private String nickName;
    private String email;
    private ArrayList<ArrayList<String>> scores;

    public Bowler( String nick, String full, String mail ) {
	nickName = nick;
	fullName = full;
  	email = mail;
    }


    public String getNickName() {

        return nickName;  

    }

	public String getFullName ( ) {
			return fullName;
	}
	
	public String getNick ( ) {
		return nickName;
	}

	public String getEmail ( ) {
		return email;	
	}
	
	public void recordScore(String score, String time){
		
	}
	
	public boolean equals ( Bowler b) {
		if ( !(nickName.equals(b.getNickName())) ) {
				return false;
		}
		else if ( !(fullName.equals(b.getFullName())) ) {
				return false;
		}	
		else if ( !(email.equals(b.getEmail())) ) {
				return false;
		}
		return true;
	}
}