/**
 * 
 */
package org.javabuilders.swing.samples;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import org.javabuilders.BuildResult;
import org.javabuilders.annotations.DoInBackground;
import org.javabuilders.event.BackgroundEvent;
import org.javabuilders.event.CancelStatus;
import org.javabuilders.swing.SwingJavaBuilder;

/**
 * @author jacek
 *
 */
@SuppressWarnings("serial")
public class MigLayoutPanel2 extends SamplePanel {

	@SuppressWarnings("unused")
	private BuildResult result = SwingJavaBuilder.build(this);
	
	/**
	 * @throws Exception
	 */
	public MigLayoutPanel2() throws Exception {
	
	}
	
	@SuppressWarnings("unused")
	private void doAdd(JComponent c, ActionEvent evt) {
		JOptionPane.showMessageDialog(this,"btnAdd => private void doAdd(JComponent c, ActionEvent evt)");
	}
	
	@SuppressWarnings("unused")
	private void delete(ActionEvent evt) {
		JOptionPane.showMessageDialog(this,"btnDelete => private void delete(ActionEvent evt) ");
	}
	
	@SuppressWarnings("unused")
	private void edit(JButton button) {
		JOptionPane.showMessageDialog(this,"btnEdit => private void edit(JButton button)");
	}
	
	@SuppressWarnings("unused")
	private void advanced() {
		JOptionPane.showMessageDialog(this,"btnAdanced  => private void advanced()");
	}
	
	@SuppressWarnings("unused")
	private void cancel() {
		JOptionPane.showMessageDialog(this,"btnCancel => private void cancel()");
	}

	@SuppressWarnings("unused")
	@DoInBackground(indeterminateProgress=false,cancelable=true,progressStart=1,progressEnd=100)
	private void save(BackgroundEvent evt) {
		for(int i = 1; i  <= 100; i++) {
			evt.setProgressValue(i);
			if (evt.getCancelStatus() != CancelStatus.REQUESTED) {
				try {
					evt.setProgressMessage("Processing " + i + " of " + " 100");
					Thread.sleep(200);
				} catch (InterruptedException e) {}
			} else {
				evt.setCancelStatus(CancelStatus.PROCESSING);
				
				try {
					evt.setProgressMessage("Cancelling process....please wait.");
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				
				evt.setCancelStatus(CancelStatus.COMPLETED);
				break;
			}
		}
	}

	
	@SuppressWarnings("unused")
	private void finishSave() {
		JOptionPane.showMessageDialog(this,"Save was successfully completed!");
	}

}
