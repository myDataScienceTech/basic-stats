package gui.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.BasicStatsModel;


public class NumbersView implements View
{
    /** TextArea that shows all the numbers */
    private JTextArea jtaNumbers;

    
    public NumbersView(JFrame jfMain) {
	super();

	jtaNumbers = new JTextArea(10, 5);
	jtaNumbers.setEditable(false);

	jfMain.getContentPane().add(jtaNumbers, BorderLayout.SOUTH);
    }

    public void update(BasicStatsModel model) {
	// Reset
	if (model.getArrayDouble().length == 0) {
	    jtaNumbers.setText("");
	}
	else {
	    // Update the displayed list of numbers
		String numbers = "";
		int numbers_len = model.getArrayDouble().length;
		for(int i=0;i<numbers_len;i++){
			Double num = model.getArrayDouble()[i];
			numbers += Double.toString(num);
			numbers += ',';
		}
		jtaNumbers.setText(numbers);
	}
    }

    public String getStringValue() {
	// This is a snapshot of the current value to support
	// testability and debuggability without breaking the encapsulation.
	return jtaNumbers.getText();
    }
}
