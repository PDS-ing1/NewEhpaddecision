package fr.esipe.pds.ehpaddecision.frontend;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import fr.esipe.pds.ehpaddecision.backend.HomeBackEnd;

import javax.swing.JButton;
import javax.swing.JLabel;
public class HomePageFront extends JPanel {

	private JPanel firstpanel = new JPanel(new FlowLayout());
	
	private JLabel labelName = new JLabel("name :");
	private JTextField textfName  = new JTextField(10);

	private JButton buttonNew     = new JButton("New ");
	private JButton buttonDelete  = new JButton("Delete");
	private JButton buttonUpdate  = new JButton("Update");
	private JButton buttonDisplay = new JButton("Display");
	
	private JTextArea textArea = new JTextArea();
	
	private JScrollPane scrollTextArea;
	private HomeBackEnd homebackend;
	private Font textAreaF;
	
	
	public HomePageFront()
	{
		setLayout(new BorderLayout());
		textAreaF = new Font("Calibri", Font.PLAIN, 25);
		homebackend = new HomeBackEnd(this);
		buttonNew.addActionListener(homebackend);
		buttonDisplay.addActionListener(homebackend);
		buttonDelete.addActionListener(homebackend);
		buttonUpdate.addActionListener(homebackend);
		firstpanel.add(labelName);
		firstpanel.add(textfName);
		firstpanel.add(buttonNew);
		firstpanel.add(buttonDelete);
		firstpanel.add(buttonUpdate);
		this.add(firstpanel, BorderLayout.NORTH);
		
		textArea.setEditable(false);
		textArea.setFont(textAreaF);
		scrollTextArea = new JScrollPane(textArea);
		scrollTextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollTextArea, BorderLayout.CENTER);
		this.add(buttonDisplay, BorderLayout.SOUTH);
	}


	public JPanel getFirstpanel() {
		return firstpanel;
	}


	public void setFirstpanel(JPanel firstpanel) {
		this.firstpanel = firstpanel;
	}


	public JLabel getLabelName() {
		return labelName;
	}


	public void setLabelName(JLabel labelName) {
		this.labelName = labelName;
	}


	public JTextField getTextfName() {
		return textfName;
	}


	public void setTextfName(JTextField textfName) {
		this.textfName = textfName;
	}


	public JButton getButtonNew() {
		return buttonNew;
	}


	public void setButtonNew(JButton buttonNew) {
		this.buttonNew = buttonNew;
	}


	public JButton getButtonDelete() {
		return buttonDelete;
	}


	public void setButtonDelete(JButton buttonDelete) {
		this.buttonDelete = buttonDelete;
	}


	public JButton getButtonUpdate() {
		return buttonUpdate;
	}


	public void setButtonUpdate(JButton buttonUpdate) {
		this.buttonUpdate = buttonUpdate;
	}


	public JButton getButtonDisplay() {
		return buttonDisplay;
	}


	public void setButtonDisplay(JButton buttonDisplay) {
		this.buttonDisplay = buttonDisplay;
	}


	public JTextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


	public JScrollPane getScrollTextArea() {
		return scrollTextArea;
	}


	public void setScrollTextArea(JScrollPane scrollTextArea) {
		this.scrollTextArea = scrollTextArea;
	}


	public HomeBackEnd getHomebackend() {
		return homebackend;
	}


	public void setHomebackend(HomeBackEnd homebackend) {
		this.homebackend = homebackend;
	}


	public Font getTextAreaF() {
		return textAreaF;
	}


	public void setTextAreaF(Font textAreaF) {
		this.textAreaF = textAreaF;
	}

}
