package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import java.awt.Choice;
import java.awt.ScrollPane;

public class Viewlist extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list;
	
	static App a = new App();
	static Folder folder = new Folder();
	static Filter filter = new Filter();
	static ISort sort ;
	
	Mail[] listofmails;
	String[] mails;
	int x=1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewlist frame = new Viewlist(a,folder,filter,sort);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void close(){
		 WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	 }

	/**
	 * Create the frame.
	 */
	public Viewlist(App a, Folder folder, Filter filter , ISort sort) {
		
		a.setViewingOptions(folder, filter, sort);
		if(a.maxpages==0) {
			JOptionPane.showMessageDialog(null, "No mails");
			close();
		}
		listofmails = (Mail[]) a.listEmails(1) ;
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 621, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    list = new JList();
		list.setVisibleRowCount(10);
		list.setBounds(57, 67, 409, 297);
		contentPane.add(list);
		
		mails = new String[listofmails.length];
		
		for(int i=0;i<mails.length;i++) {
			if(listofmails[i]!=null) {
				mails[i] = listofmails[i].subject +", "+listofmails[i].date;
			}
			else {
				mails[i]=null;
			}
		}
		
		list.setListData(mails);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = list.getSelectedIndex();
				if(listofmails[n]!=null) {
					SeeMessage s = new SeeMessage(listofmails[n]);
					s.setVisible(true);
					}
			}
		});
		btnNewButton.setBounds(286, 399, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] n =list.getSelectedIndices();
				DLinkedList d = new DLinkedList();
				for(int i=0;i<n.length;i++) {
					if(listofmails[n[i]]!=null) {
						d.add(listofmails[n[i]]);
					}
				}
				a.deleteEmails(d);
				
				listofmails= (Mail[]) a.listEmails(x);
				for(int i=0;i<mails.length;i++) {
					if(listofmails[i]!=null) {
						mails[i] = listofmails[i].subject +", "+listofmails[i].date;
					}
					else {
						mails[i]=null;
					}
				}
				list.setListData(mails);
				
			}
		});
		btnNewButton_2.setBounds(381, 399, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Mails");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 10f));
		lblNewLabel.setBounds(218, 24, 71, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setBounds(476, 75, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sort");
		btnNewButton_4.setBounds(476, 106, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Next Page");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x==a.maxpages) {
					JOptionPane.showMessageDialog(null, "Last Page");
				}
				else {
					x++; textField.setText(x+"");
					listofmails= (Mail[]) a.listEmails(x);
					for(int i=0;i<mails.length;i++) {
						if(listofmails[i]!=null) {
							mails[i] = listofmails[i].subject +", "+listofmails[i].date;
						}
						else {
							mails[i]=null;
						}
					}
					list.setListData(mails);
				}
			}
		});
		btnNewButton_5.setBounds(381, 374, 85, 21);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Prev Page");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x>1) {
					x--;textField.setText(x+"");
					listofmails= (Mail[]) a.listEmails(x);
					for(int i=0;i<mails.length;i++) {
						if(listofmails[i]!=null) {
							mails[i] = listofmails[i].subject +", "+listofmails[i].date;
						}
						else {
							mails[i]=null;
						}
					}
					list.setListData(mails);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "There is no page before it");
				}
			}
		});
		btnNewButton_6.setBounds(57, 374, 85, 21);
		contentPane.add(btnNewButton_6);
			
		JButton btnNewButton_7 = new JButton("Back");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFilesWindow u = new UserFilesWindow();
				a.mails.clear();
				close();
				u.setApp(a);
				u.show();
			}
		});
		btnNewButton_7.setBounds(476, 332, 85, 21);
		contentPane.add(btnNewButton_7);
				
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(202, 374, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("1");
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.mails.clear();
				a.setViewingOptions(folder, filter, sort);
				listofmails= (Mail[]) a.listEmails(x);
				for(int i=0;i<mails.length;i++) {
					if(listofmails[i]!=null) {
						mails[i] = listofmails[i].subject +", "+listofmails[i].date;
					}
					else {
						mails[i]=null;
					}
				}
				list.setListData(mails);
			}
		});
		btnNewButton_1.setBounds(476, 303, 85, 21);
		contentPane.add(btnNewButton_1);
		
	}
}
