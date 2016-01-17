package shapiecompiler;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Screen extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static int height = 600, width = 1000, padding = 10;
	static JTextArea codeArea;
	MouseAdapter listener;
	static Output output = new Output();
	static JPanel code = new JPanel();
	static JPanel container = new JPanel();
	public Screen() {
		listener = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	runBtnClicked(evt);
            }
        };
		
        //JPanel containing code and output panels
		
		container.setLayout(null);
		
		//Left JPanel for Code
		
		code.setLayout(null);
		code.setBackground(Color.white);
		code.setBounds(padding, padding, width/2-50, height-70);
		codeArea = new JTextArea();
		codeArea.setBorder(BorderFactory.createLineBorder(Color.red));
		codeArea.setBounds(padding, padding, 420,height-140);
		code.add(codeArea);
		JButton runBtn = new JButton("Run");
		runBtn.setBounds(370, 480, 70, 40);
		runBtn.addMouseListener(listener);
		code.add(runBtn);
		container.add(code);
		
		add(container);
		setSize(width,height);
		setVisible(true);
	}
	
	public void runBtnClicked(MouseEvent evt) {
		Shapie.checkCode(codeArea.getText());
		output.setBackground(Color.white);
		output.setBounds(width/2+padding, padding, width/2-50, height-70);
		container.add(output);
	}
}
