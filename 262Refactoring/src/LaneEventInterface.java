import java.util.HashMap;
import java.util.Vector;

public interface LaneEventInterface extends java.rmi.Remote {
	public int getFrameNum( ) throws java.rmi.RemoteException;
	public HashMap<Bowler, int[]> getScore( ) throws java.rmi.RemoteException;
	public int[] getCurScores( ) throws java.rmi.RemoteException;
	public int getIndex() throws java.rmi.RemoteException;
	public int getFrame() throws java.rmi.RemoteException;
	public int getBall() throws java.rmi.RemoteException;
	public int[][] getCumulScore() throws java.rmi.RemoteException;
	public Vector<Bowler> getParty() throws java.rmi.RemoteException;
	public Bowler getBowler() throws java.rmi.RemoteException;

}

