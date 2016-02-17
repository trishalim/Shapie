package shapiecompiler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

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
        
        Color basecol = new Color (0, 191, 165);
        //JPanel containing code and output panels
		container = new JPanel();
		container.setLayout(null);
		
		//Left JPanel for Code
		JPanel code = new JPanel();
		code.setLayout(null);
		code.setBackground(Color.white);
		code.setBounds(padding + 25, padding, width/2-50, height-70);
		code.setBorder(BorderFactory.createLineBorder(basecol));
		Font font = new Font("Courier New", Font.PLAIN, 14);
		codeArea = new JTextArea();
		codeArea.setFont(font);
		codeArea.setBorder(BorderFactory.createLineBorder(Color.white));
		codeArea.setBounds(padding, padding, 430,height-140);
		code.add(codeArea);
		error= new JLabel();
		error.setBounds(padding, 480, 340,40);
		error.setText(" ");
		error.setForeground(Color.RED);
		code.add(error);
		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(295, 480, 70, 40);
		saveBtn.addMouseListener(saveListener);
		saveBtn.setBorder(new LineBorder(Color.gray, 1));
		saveBtn.setFocusPainted(false);
		saveBtn.setBackground(Color.white);
		saveBtn.setForeground(basecol);
		saveBtn.setFont(new Font("Courier New", Font.BOLD, 18));
		code.add(saveBtn);
		JButton runBtn = new JButton("Run");
		runBtn.setBounds(370, 480, 70, 40);
		runBtn.addMouseListener(runListener);
		runBtn.setBorder(new LineBorder(Color.gray, 1));
		runBtn.setFocusPainted(false);
		runBtn.setBackground(Color.white);
		runBtn.setForeground(basecol);
		runBtn.setFont(new Font("Courier New", Font.BOLD, 18));
		code.add(runBtn);
		container.add(code);
		
		//Right JPanel for Output
		output = new Output();
		output.setBounds(width/2-5, padding, width/2-50, height-70);
		output.setBorder(BorderFactory.createLineBorder(basecol));		
		output.setBackground(Color.white);
		container.add(output);
		
		add(container);
		setSize(width,height-10);
		setVisible(true);
		setTitle("Shapie");
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
		output.redraw();
	}
	
	public static void setError(String err){
		error.setText(err);
	}
	
}
