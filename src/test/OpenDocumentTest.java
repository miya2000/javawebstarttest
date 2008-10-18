package test;

import java.awt.event.ActionEvent;
import java.net.URL;
import javax.jnlp.*;
import javax.swing.*;

public class OpenDocumentTest extends JFrame {

	private static final long serialVersionUID = 1L;
	public OpenDocumentTest(){
        JButton button = new JButton("Open");
        button.addActionListener(new AbstractAction(){
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = showURL("http://www.google.co.jp/");
				if (!success){
					JOptionPane.showMessageDialog(OpenDocumentTest.this, "Open failed.");
				}
			}
        });
        getContentPane().add(button);
        setBounds(100, 100, 400, 300);
        setVisible(true);
    }
	
	boolean showURL(String url) { 
		try {
			URL location = new URL(url);
			BasicService bs = (BasicService)ServiceManager.lookup("javax.jnlp.BasicService"); 
			return bs.showDocument(location); 
		} catch(Exception ue) { 
			return false; 
		}
	}
	
	public static void main(String[] args) {
		OpenDocumentTest frame = new OpenDocumentTest();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}
