package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;


public class ChooseWhichToFilter extends JFrame {

	private JPanel contentPane;
	App a = new App();
	Folder folder = new Folder();
	Filter filter = new Filter();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseWhichToFilter frame = new ChooseWhichToFilter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void close(){
		 WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	 }
	public void setApp(App a) {
		   this.a=a;
		   
	   }
	
	public ChooseWhichToFilter() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Inbox");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filters f = new Filters();
				folder.folder="Inbox";
				f.setfolder(folder);
				f.setApp(a);
				close();
				f.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD, btnNewButton.getFont().getSize() + 14f));
		btnNewButton.setBounds(0, 0, 158, 250);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sent Mails");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filters f = new Filters();
				folder.folder="sent";
				f.setfolder(folder);
				f.setApp(a);
				close();
				f.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(btnNewButton_1.getFont().getStyle() | Font.BOLD, btnNewButton_1.getFont().getSize() + 14f));
		btnNewButton_1.setBounds(157, 0, 164, 250);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Trash");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filters f = new Filters();
				folder.folder="Trash";
				f.setfolder(folder);
				f.setApp(a);
				close();
				f.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setFont(btnNewButton_2.getFont().deriveFont(btnNewButton_2.getFont().getStyle() | Font.BOLD, btnNewButton_2.getFont().getSize() + 14f));
		btnNewButton_2.setBounds(321, 0, 158, 250);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back To User Folders");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFilesWindow u=new UserFilesWindow();close();
				a.mails.clear();
				u.setApp(a);
				u.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setFont(btnNewButton_3.getFont().deriveFont(btnNewButton_3.getFont().getStyle() | Font.BOLD, btnNewButton_3.getFont().getSize() + 14f));
		btnNewButton_3.setBounds(479, 0, 304, 250);
		contentPane.add(btnNewButton_3);
	}

}
