import java.util.HashMap;
import java.util.Vector;

public class LaneEvent {

	private Vector<Bowler> p;
	int ball;
	Bowler bowler;
	int[][] cumulScore;
	HashMap<Bowler, int[]> score;
	int index;
	int frameNum;
	int[] curScores;
	boolean mechProb;
	
	public LaneEvent(Lane lane) {
		p = lane.getParty();
		index = lane.getIndex();
		bowler = lane.getBowler();
		cumulScore = lane.getCumulScore();
		score = lane.getScore();
		curScores = lane.getCurScores();
		frameNum = lane.getFrameNum();
		ball = lane.getBall();	
		mechProb = lane.isMechanicalProblem();
	}
	
	public boolean isMechanicalProblem() {
		return mechProb;
	}
	
	public int getFrameNum() {
		return frameNum;
	}
	
	public HashMap<Bowler, int[]> getScore( ) {
		return score;
	}


	public int[] getCurScores(){ 
		return curScores;
	}
	
	public int getIndex() {
		return index;
	}

	public int getBall( ) {
		return ball;
	}
	
	public int[][] getCumulScore(){
		return cumulScore;
	}

	public Vector<Bowler> getParty() {
		return p;
	}
	
	public Bowler getBowler() {
		return bowler;
	}

};
 
