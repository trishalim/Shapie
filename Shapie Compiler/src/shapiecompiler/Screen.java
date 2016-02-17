package shapiecompiler;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

public class Screen extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static int height = 600, width = 1000, padding = 10;
	static JTextArea codeArea;
	MouseAdapter runListener, saveListener;
	static JPanel container;
	static Output output;
	static JLabel error;
	JFileChooser fc;

	public Screen() {
		runListener = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	runBtnClicked(evt);
            }
        };
        saveListener = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	saveBtnClicked(evt);
            }
        };
		//saving code
        fc = new JFileChooser();
        
        //JPanel containing code and output panels
		container = new JPanel();
		container.setLayout(null);
		
		//Left JPanel for Code
		JPanel code = new JPanel();
		code.setLayout(null);
		code.setBackground(Color.white);
		code.setBounds(padding, padding, width/2-50, height-70);
		codeArea = new JTextArea();
		codeArea.setBorder(BorderFactory.createLineBorder(Color.PINK));
		codeArea.setBounds(padding, padding, 420,height-140);
		code.add(codeArea);
		error= new JLabel();
		error.setBounds(padding, 480, 340,40);
		error.setText(" ");
		error.setForeground(Color.RED);
		code.add(error);
		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(300, 480, 70, 40);
		saveBtn.addMouseListener(saveListener);
		code.add(saveBtn);
		JButton runBtn = new JButton("Run");
		runBtn.setBounds(370, 480, 70, 40);
		runBtn.addMouseListener(runListener);
		code.add(runBtn);
		container.add(code);
		
		//Right JPanel for Output
		output = new Output();
		
		
		add(container);
		setSize(width,height);
		setVisible(true);
	}
	
	public void runBtnClicked(MouseEvent evt) {
		setOutput();
		Output.ObjectList = new ArrayList<Object>();
		Shapie.checkCode(codeArea.getText());
	}
	public void saveBtnClicked(MouseEvent evt) {
		System.out.println("SAVING");
		 int returnVal = fc.showSaveDialog(this);
         if (returnVal == JFileChooser.APPROVE_OPTION) {
             File file = fc.getSelectedFile();
             //This is where a real application would save the file.
             System.out.println("Saving: " + file.getName() + "." + "\n");
         } else {
        	 System.out.println("Save command cancelled by user." + "\n");
         }

	}
	public void setOutput() {
		output.setBounds(width/2+padding, padding, width/2-50, height-70);
		container.add(output);
		output.redraw();
	}
	
	public static void setError(String err){
		error.setText(err);
	}
	
}
