import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.util.*;

public class EndGameReport implements ActionListener, ListSelectionListener {

	private JFrame win;
	private JButton printButton, finished;
	private JList memberList;
	private Vector myVector;
	private Vector<String> retVal;

	private int result;

	private String selectedMember;

	public EndGameReport( String partyName, Vector<Bowler> party ) {
	
		result =0;
		retVal = new Vector<String>();
		win = new JFrame("End Game Report for " + partyName + "?" );
		win.getContentPane().setLayout(new BorderLayout());
		((JPanel) win.getContentPane()).setOpaque(false);

		JPanel colPanel = new JPanel();
		colPanel.setLayout(new GridLayout( 1, 2 ));

		// Member Panel
		JPanel partyPanel = new JPanel();
		partyPanel.setLayout(new FlowLayout());
		partyPanel.setBorder(new TitledBorder("Party Members"));
		
		Vector myVector = new Vector();
		Iterator iter = party.iterator();
		while (iter.hasNext()){
			myVector.add( ((Bowler)iter.next()).getNick() );
		}	
		memberList = new JList(myVector);
		memberList.setFixedCellWidth(120);
		memberList.setVisibleRowCount(5);
		memberList.addListSelectionListener(this);
		JScrollPane partyPane = new JScrollPane(memberList);
		partyPanel.add(partyPane);

		partyPanel.add( memberList );

		// Button Panel
		// Button Panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1));

		Insets buttonMargin = new Insets(4, 4, 4, 4);

		printButton = new JButton("Print Report");
		JPanel printButtonPanel = new JPanel();
		printButtonPanel.setLayout(new FlowLayout());
		printButton.addActionListener(this);
		printButtonPanel.add(printButton);

		finished = new JButton("Finished");
		JPanel finishedPanel = new JPanel();
		finishedPanel.setLayout(new FlowLayout());
		finished.addActionListener(this);
		finishedPanel.add(finished);

		buttonPanel.add(printButton);
		buttonPanel.add(finished);

		// Clean up main panel
		colPanel.add(partyPanel);
		colPanel.add(buttonPanel);

		win.getContentPane().add("Center", colPanel);

		win.pack();

		// Center Window on Screen
		Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
		win.setLocation(
			((screenSize.width) / 2) - ((win.getSize().width) / 2),
			((screenSize.height) / 2) - ((win.getSize().height) / 2));
		win.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(printButton)) {		
			//Add selected to the vector.
			retVal.add(selectedMember);
		}
		if (e.getSource().equals(finished)) {		
			win.setVisible(false);
			result = 1;
		}

	}

	public void valueChanged(ListSelectionEvent e) {
		selectedMember =
			((String) ((JList) e.getSource()).getSelectedValue());
	}

	public Vector<String> getResult() {
		while ( result == 0 ) {
			try {
				Thread.sleep(10);
			} catch ( InterruptedException e ) {
				System.err.println( "Interrupted" );
			}
		}
		return retVal;	
	}
	
	public void destroy() {
		win.setVisible(false);
	}
	
}

