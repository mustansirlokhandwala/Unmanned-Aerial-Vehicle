package UserInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFactory;

public class InfoPage extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton button;
	
	public InfoPage(JButton b) {
		setLayout(new BorderLayout(0, 0));
		this.button = b;
		JPanel panel = new JPanel();
	
		add(panel, BorderLayout.CENTER);
		
final Browser browser = BrowserFactory.create();
final JFrame frame = new JFrame("JxBrowser Google Maps");
frame.setExtendedState(frame.MAXIMIZED_BOTH);

final JTextArea area = new JTextArea("asdasasssssd");
JScrollPane scroll = new JScrollPane();
scroll.setAutoscrolls(true);
scroll.add(area);
scroll.setMinimumSize(new Dimension(50,800));



JButton StartButton = new JButton("start");
StartButton.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0 ; i <1000 ; i++){
		area.append(""+i+"");
		for(int j = 0 ; j < 1000000 ;j++){
			
		}
		}
	}
});

JButton ExitButton = new JButton(" Exit ");
ExitButton.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		browser.dispose();
		button.setEnabled(true);
		frame.dispose();
		
		
		
	}
});


JPanel toolbar = new JPanel();

toolbar.add(ExitButton);
toolbar.add(StartButton);
frame.setResizable(false);
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
frame.getContentPane().add(browser.getView().getComponent(), BorderLayout.CENTER);
frame.getContentPane().add(toolbar, BorderLayout.NORTH);
frame.getContentPane().add(scroll,BorderLayout.EAST);
frame.setSize(700, 500);
frame.setResizable(true);
frame.setVisible(true);
browser.loadURL("http://maps.google.com");
panel.add(frame,BorderLayout.CENTER);
		
		

	}
}
