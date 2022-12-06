package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BasicStatsModel;
import gui.view.View;


public class UndoNumberViewController implements View
{
    private BasicStatsGUI gui;
    
    /** The 'Undo' view/controller allows the user to undo the input of a number */
    /* package */ JButton jbUndo;

    
    public UndoNumberViewController(BasicStatsGUI gui, JPanel jpInput) {
	this.gui = gui;
	jbUndo = new JButton("Undo");

	jpInput.add(jbUndo);
	
	jbUndo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    gui.undoNumber();
		}
	    });
    }

    public void update(BasicStatsModel model) {
	// Button enabled when some numbers are inserted/The number list is not empty. Else disabled
	if (model.getArrayDouble().length == 0) {
        jbUndo.setEnabled(false);
	}
    else{
        jbUndo.setEnabled(true);
    }
    }

    public String getStringValue() {	
	// This is a snapshot of the current value to support
	// testability and debuggability without breaking the encapsulation.
    return "";
    }
}
