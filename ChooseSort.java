package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class ChooseSort extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton Sender;
	private JRadioButton Importance;
	private JRadioButton Subject;
	private JRadioButton Reciever;
	private JRadioButton Attachments;
	private JRadioButton Body;
	private JLabel lblNewJgoodiesTitle;
	private JButton btnNewButton;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseSort frame = new ChooseSort();
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
	public ChooseSort() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 340);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("Inbox");
		rdbtnNewRadioButton.setFont(rdbtnNewRadioButton.getFont().deriveFont(rdbtnNewRadioButton.getFont().getStyle() | Font.BOLD, rdbtnNewRadioButton.getFont().getSize() + 1f));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()==true) {
					Sender.setSelected(false);Reciever.setSelected(false);
					Body.setSelected(false);Subject.setSelected(false);Attachments.setSelected(false);
					Sender.show();
					Reciever.hide();
					rdbtnNewRadioButton_1.setSelected(false);rdbtnNewRadioButton_2.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton.setBackground(Color.CYAN);
		rdbtnNewRadioButton.setBounds(6, 25, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Sent Mails");
		rdbtnNewRadioButton_1.setFont(rdbtnNewRadioButton_1.getFont().deriveFont(rdbtnNewRadioButton_1.getFont().getStyle() | Font.BOLD, rdbtnNewRadioButton_1.getFont().getSize() + 1f));
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()==true) {Sender.setSelected(false);Reciever.setSelected(false);
				Body.setSelected(false);Subject.setSelected(false);Attachments.setSelected(false);
				Importance.setSelected(false);
					Reciever.show();
					Sender.hide();
					rdbtnNewRadioButton.setSelected(false);rdbtnNewRadioButton_2.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setBackground(Color.CYAN);
		rdbtnNewRadioButton_1.setBounds(297, 25, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Trash");
		rdbtnNewRadioButton_2.setFont(rdbtnNewRadioButton_2.getFont().deriveFont(rdbtnNewRadioButton_2.getFont().getStyle() | Font.BOLD, rdbtnNewRadioButton_2.getFont().getSize() + 1f));
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_2.isSelected()==true) {
					Sender.setSelected(false);Reciever.setSelected(false);
					Body.setSelected(false);Subject.setSelected(false);Attachments.setSelected(false);
					Reciever.show();Sender.show();
					rdbtnNewRadioButton_1.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_2.setBackground(Color.CYAN);
		rdbtnNewRadioButton_2.setBounds(569, 25, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 11, 656, 52);
		contentPane.add(separator);
		
		lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Sort According To");
		lblNewJgoodiesTitle.setFont(lblNewJgoodiesTitle.getFont().deriveFont(lblNewJgoodiesTitle.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle.getFont().getSize() + 4f));
		lblNewJgoodiesTitle.setBounds(27, 126, 147, 20);
		contentPane.add(lblNewJgoodiesTitle);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 110, 251, 191);
		contentPane.add(separator_3);
		
		Sender = new JRadioButton("Sender");
		Sender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Sender.isSelected()==true) {
					Reciever.setSelected(false);Subject.setSelected(false);Attachments.setSelected(false);Body.setSelected(false);Importance.setSelected(false);
					if(rdbtnNewRadioButton.isSelected()==false&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false) {
						JOptionPane.showMessageDialog(null, "You Must Choose First Where Do You Want To Seach In......");Sender.setSelected(false);
					}
				}
				
			}
		});
		Sender.setBackground(Color.CYAN);
		Sender.setFont(Sender.getFont().deriveFont(Sender.getFont().getStyle() | Font.BOLD, Sender.getFont().getSize() + 1f));
		Sender.setBounds(27, 219, 109, 27);
		contentPane.add(Sender);
		
		Reciever = new JRadioButton("Reciever");
		Reciever.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Reciever.isSelected()==true) {
					Importance.setSelected(false);Subject.setSelected(false);Attachments.setSelected(false);Body.setSelected(false);Sender.setSelected(false);
					if(rdbtnNewRadioButton.isSelected()==false&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false) {
						JOptionPane.showMessageDialog(null, "You Must Choose First Where Do You Want To Seach In......");Reciever.setSelected(false);
					}
				}
				
			}
		});
		Reciever.setBackground(Color.CYAN);
		Reciever.setFont(Reciever.getFont().deriveFont(Reciever.getFont().getStyle() | Font.BOLD, Reciever.getFont().getSize() + 1f));
		Reciever.setBounds(138, 216, 109, 33);
		contentPane.add(Reciever);
		
		Subject = new JRadioButton("Subject");
		Subject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Subject.isSelected()==true) {
					Reciever.setSelected(false);Importance.setSelected(false);Attachments.setSelected(false);Body.setSelected(false);Sender.setSelected(false);
					if(rdbtnNewRadioButton.isSelected()==false&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false) {
						JOptionPane.showMessageDialog(null, "You Must Choose First Where Do You Want To Seach In......");Subject.setSelected(false);
					}
				}
				
			}
		});
		Subject.setBackground(Color.CYAN);
		Subject.setFont(Subject.getFont().deriveFont(Subject.getFont().getStyle() | Font.BOLD, Subject.getFont().getSize() + 1f));
		Subject.setBounds(138, 153, 109, 33);
		contentPane.add(Subject);
		
		Body = new JRadioButton("Body");
		Body.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Body.isSelected()==true) {
					Reciever.setSelected(false);Subject.setSelected(false);Attachments.setSelected(false);Importance.setSelected(false);Sender.setSelected(false);
					if(rdbtnNewRadioButton.isSelected()==false&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false) {
						JOptionPane.showMessageDialog(null, "You Must Choose First Where Do You Want To Seach In......");Body.setSelected(false);
					}
				}
				
			}
		});
		Body.setBackground(Color.CYAN);
		Body.setFont(Body.getFont().deriveFont(Body.getFont().getStyle() | Font.BOLD, Body.getFont().getSize() + 1f));
		Body.setBounds(138, 186, 109, 33);
		contentPane.add(Body);
		
		Attachments = new JRadioButton("Attachments");
		Attachments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Attachments.isSelected()==true) {
					Reciever.setSelected(false);Subject.setSelected(false);Importance.setSelected(false);Body.setSelected(false);Sender.setSelected(false);
					if(rdbtnNewRadioButton.isSelected()==false&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false) {
						JOptionPane.showMessageDialog(null, "You Must Choose First Where Do You Want To Seach In......");Attachments.setSelected(false);
					}
				}
				
				
			}
		});
		Attachments.setBackground(Color.CYAN);
		Attachments.setFont(Attachments.getFont().deriveFont(Attachments.getFont().getStyle() | Font.BOLD, Attachments.getFont().getSize() + 1f));
		Attachments.setBounds(27, 153, 109, 36);
		contentPane.add(Attachments);
		
		Importance = new JRadioButton("Importance");
		Importance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Importance.isSelected()==true) {
					Reciever.setSelected(false);Subject.setSelected(false);Attachments.setSelected(false);Body.setSelected(false);Sender.setSelected(false);
					if(rdbtnNewRadioButton.isSelected()==false&&rdbtnNewRadioButton_1.isSelected()==false&&rdbtnNewRadioButton_2.isSelected()==false) {
						JOptionPane.showMessageDialog(null, "You Must Choose First Where Do You Want To Seach In......");Importance.setSelected(false);
					}
				}
				
			}
		});
		Importance.setBackground(Color.CYAN);
		Importance.setFont(Importance.getFont().deriveFont(Importance.getFont().getStyle() | Font.BOLD, Importance.getFont().getSize() + 1f));
		Importance.setBounds(27, 189, 116, 27);
		contentPane.add(Importance);
		
		JButton Back = new JButton("Back To User Folders");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {close();
			UserFilesWindow u=new UserFilesWindow();u.show();
			}
		});
		Back.setBackground(Color.PINK);
		Back.setFont(Back.getFont().deriveFont(Back.getFont().getStyle() | Font.BOLD, Back.getFont().getSize() + 4f));
		Back.setBounds(434, 254, 222, 36);
		contentPane.add(Back);
		
		btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Sender.isSelected()==false&&Reciever.isSelected()==false&&Body.isSelected()==false
						&&Attachments.isSelected()==false&&Importance.isSelected()==false&&Subject.isSelected()==false)
						||(rdbtnNewRadioButton.isSelected()==false&&rdbtnNewRadioButton_1.isSelected()==false&&
						rdbtnNewRadioButton_2.isSelected()==false)) {
					JOptionPane.showMessageDialog(null, "There is a field Empty");
				}else {
				//here there will be the code of sorting
				//we will make list of results of sorting and view it
				//close();
				//ViewMessages v=new ViewMessages(constructor);//list of results
				//v.show();	
				}
			}
		});
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD, btnNewButton.getFont().getSize() + 4f));
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(332, 256, 92, 32);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(278, 110, 251, 116);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Filters");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 4f));
		lblNewLabel.setBounds(295, 126, 68, 20);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Subject", "Sender"}));
		comboBox.setBounds(297, 159, 147, 21);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(297, 193, 222, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
