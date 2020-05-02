package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Filters extends JFrame {

	private JPanel contentPane;
	App a = new App();
	Folder folder = new Folder();
	Filter filter = new Filter();

	/**
	 * Launch the application.
	 */
	static Filters frame = new Filters();
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public void setfolder(Folder a) {
		   this.folder=a;
		   
	   }
	public void setfilter(Filter a) {
		   this.filter=a;
		   
	   }
	
	public Filters() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new JButton("Sender");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sender = textField.getText();
				filter.filtersender=sender;
				a.setViewingOptions(folder, filter, null);
				Mail[] listofmails = (Mail[]) a.listEmails(1) ;
				if(listofmails[0]==null) {
					JOptionPane.showMessageDialog(null, "No Emails for this Filter");
				}
				else {
					a.mails.clear();
					ViewMessages files=new ViewMessages(folder,filter,null,a);close();
		    		files.show();
				}
				
			}
		});
		btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(btnNewButton_1.getFont().getStyle() | Font.BOLD, btnNewButton_1.getFont().getSize() + 14f));
		btnNewButton_1.setBounds(233, 136, 173, 70);
		
		JButton btnNewButton = new JButton("Subject");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String subject = textField.getText();
				filter.filtersubject=subject;
				a.setViewingOptions(folder, filter, null);
				Mail[] listofmails = (Mail[]) a.listEmails(1) ;
				if(listofmails[0]==null) {
					JOptionPane.showMessageDialog(null, "No Emails for this Filter");
				}
				else {
					a.mails.clear();
					ViewMessages files=new ViewMessages(folder,filter,null,a);close();
		    		files.show();
				}
				
			}
		});
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD, btnNewButton.getFont().getSize() + 14f));
		btnNewButton.setBounds(10, 136, 173, 70);
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		
		JLabel lblNewJgoodiesTitle = new JLabel("Filters");
		lblNewJgoodiesTitle.setFont(lblNewJgoodiesTitle.getFont().deriveFont(lblNewJgoodiesTitle.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle.getFont().getSize() + 14f));
		lblNewJgoodiesTitle.setBounds(171, 0, 202, 41);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = new JLabel("According to :");
		lblNewJgoodiesTitle_1.setFont(lblNewJgoodiesTitle_1.getFont().deriveFont(lblNewJgoodiesTitle_1.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle_1.getFont().getSize() + 4f));
		lblNewJgoodiesTitle_1.setBounds(0, 107, 202, 19);
		contentPane.add(lblNewJgoodiesTitle_1);
		
		JButton btnNewButton_2 = new JButton("Back to User Folders");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {close();
				UserFilesWindow u=new UserFilesWindow();
				a.mails.clear();
				u.setApp(a);
				u.setVisible(true);
				
				
			}
		});
		btnNewButton_2.setFont(btnNewButton_2.getFont().deriveFont(btnNewButton_2.getFont().getStyle() | Font.BOLD));
		btnNewButton_2.setBounds(273, 222, 137, 28);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(114, 47, 202, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Filter");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(51, 47, 53, 23);
		contentPane.add(lblNewLabel);
	}
} 