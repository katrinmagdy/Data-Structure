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
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class ViewMessages extends JFrame {

	private JPanel contentPane;
	private JTextField sub1;
	private JTextField sub2;
	private JTextField sub3;
	private JTextField sub4;
	private JTextField sub5;
	private JTextField sub6;
	private JTextField sub7;
	private JTextField sub8;
	private JTextField d1;
	private JTextField d2;
	private JTextField d3;
	private JTextField d4;
	private JTextField d5;
	private JTextField d6;
	private JTextField d7;
	private JTextField d8;
	private JTextField sub9;
	private JTextField sub10;
	private JTextField d9;
	private JTextField d10;
	private JButton btnNewButton_3;
	
	
	static App a = new App();
	
	
	
	static Folder folder = new Folder();
	static Filter filter = new Filter();
	
	Mail[] listofmails;
	

	/**
	 * Launch the application.
	 */
	int x=1;
	private JTextField textField_20;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMessages frame = new ViewMessages(folder,filter,null,a);
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
	
	
	public ViewMessages(Folder folder,Filter filter,ISort sort,App a) {
		
		a.setViewingOptions(folder, filter, null);
		listofmails = (Mail[]) a.listEmails(1) ;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 940, 631);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back To User Folders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFilesWindow u=new UserFilesWindow();close();
				a.mails.clear();
				u.setApp(a);
				u.show();
			}
		});
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD));
		btnNewButton.setBounds(339, 549, 206, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewJgoodiesTitle =new JLabel("Emails");
		lblNewJgoodiesTitle.setFont(lblNewJgoodiesTitle.getFont().deriveFont(lblNewJgoodiesTitle.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle.getFont().getSize() + 4f));
		lblNewJgoodiesTitle.setBounds(10, 25, 88, 14);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = new JLabel("Subjects");
		lblNewJgoodiesTitle_1.setFont(lblNewJgoodiesTitle_1.getFont().deriveFont(lblNewJgoodiesTitle_1.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle_1.getFont().getSize() + 4f));
		lblNewJgoodiesTitle_1.setBounds(388, 25, 88, 14);
		contentPane.add(lblNewJgoodiesTitle_1);
		
		JButton email1 = new JButton("Click To Open EMail");
		email1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email1.setBounds(10, 72, 364, 32);
		contentPane.add(email1);
		
		JButton email2 = new JButton("Click To Open EMail");
		email2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email2.setBounds(10, 114, 364, 32);
		contentPane.add(email2);
		
		JButton email3 = new JButton("Click To Open EMail");
		email3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email3.setBounds(10, 156, 364, 32);
		contentPane.add(email3);
		
		JButton email4 = new JButton("Click To Open EMail");
		email4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email4.setBounds(10, 198, 364, 32);
		contentPane.add(email4);
		
		JButton email5 = new JButton("Click To Open EMail");
		email5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email5.setBounds(10, 240, 364, 32);
		contentPane.add(email5);
		
		JButton email6 = new JButton("Click To Open EMail");
		email6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email6.setBounds(10, 282, 364, 32);
		contentPane.add(email6);
		
		JButton email7 = new JButton("Click To Open EMail");
		email7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email7.setBounds(10, 324, 364, 32);
		contentPane.add(email7);
		
		JButton email8 = new JButton("Click To Open EMail");
		email8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email8.setBounds(10, 366, 364, 32);
		contentPane.add(email8);
		
		JButton email9 = new JButton("Click To Open EMail");
		email9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email9.setBounds(10, 408, 364, 32);
		contentPane.add(email9);
		
		JButton email10 = new JButton("Click To Open EMail");
		email10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		email10.setBounds(10, 450, 364, 32);
		contentPane.add(email10);
		
		sub1 = new JTextField();
		sub1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sub1.setBackground(new Color(255, 255, 255));
		sub1.setEnabled(false);
		sub1.setBounds(388, 73, 364, 32);
		contentPane.add(sub1);
		sub1.setColumns(10);
		if(listofmails[0]==null) {
			sub1.setVisible(false);
			email1.setVisible(false);
			
		}
		else {
			sub1.setText(listofmails[0].subject);
			email1.setVisible(true);
		}
		
		
		sub2 = new JTextField();
		sub2.setBackground(Color.WHITE);
		sub2.setEnabled(false);
		sub2.setColumns(10);
		sub2.setBounds(388, 115, 364, 32);
		contentPane.add(sub2);
		if(listofmails[1]==null) {
			sub2.setVisible(false);
			email2.setVisible(false);
		}
		else {
			sub2.setText(listofmails[1].subject);
			email2.setVisible(true);
		}
		
		
		sub3 = new JTextField();
		sub3.setBackground(Color.WHITE);
		sub3.setEnabled(false);
		sub3.setColumns(10);
		sub3.setBounds(388, 157, 364, 32);
		contentPane.add(sub3);
		if(listofmails[2]==null) {
			sub3.setVisible(false);
			email3.setVisible(false);
		}
		else {
			sub3.setText(listofmails[2].subject);
			email3.setVisible(true);
		}
		
		
		sub4 = new JTextField();
		sub4.setBackground(Color.WHITE);
		sub4.setEnabled(false);
		sub4.setColumns(10);
		sub4.setBounds(388, 199, 364, 32);
		contentPane.add(sub4);
		if(listofmails[3]==null) {
			sub4.setVisible(false);
			email4.setVisible(false);
		}
		else {
			sub4.setText(listofmails[3].subject);
			email4.setVisible(true);
		}
		
		sub5 = new JTextField();
		sub5.setBackground(Color.WHITE);
		sub5.setEnabled(false);
		sub5.setColumns(10);
		sub5.setBounds(388, 241, 364, 32);
		contentPane.add(sub5);
		if(listofmails[4]==null) {
			sub5.setVisible(false);
			email5.setVisible(false);
		}
		else {
			sub5.setText(listofmails[4].subject);
			email5.setVisible(true);
		}
		
		sub6 = new JTextField();
		sub6.setBackground(Color.WHITE);
		sub6.setEnabled(false);
		sub6.setColumns(10);
		sub6.setBounds(388, 283, 364, 32);
		contentPane.add(sub6);
		if(listofmails[5]==null) {
			sub6.setVisible(false);
			email6.setVisible(false);
		}
		else {
			sub6.setText(listofmails[5].subject);
			email6.setVisible(true);
		}
		
		sub7 = new JTextField();
		sub7.setBackground(Color.WHITE);
		sub7.setEnabled(false);
		sub7.setColumns(10);
		sub7.setBounds(388, 325, 364, 32);
		contentPane.add(sub7);
		if(listofmails[6]==null) {
			sub7.setVisible(false);
			email7.setVisible(false);
		}
		else {
			sub7.setText(listofmails[6].subject);
			email7.setVisible(true);
		}
		
		sub8 = new JTextField();
		sub8.setBackground(Color.WHITE);
		sub8.setEnabled(false);
		sub8.setColumns(10);
		sub8.setBounds(388, 367, 364, 32);
		contentPane.add(sub8);
		if(listofmails[7]==null) {
			sub8.setVisible(false);
			email8.setVisible(false);
		}
		else {
			sub8.setText(listofmails[7].subject);
			email8.setVisible(true);
		}
		
		
		
		JLabel lblNewJgoodiesTitle_2 = new JLabel("Dates");
		lblNewJgoodiesTitle_2.setFont(lblNewJgoodiesTitle_2.getFont().deriveFont(lblNewJgoodiesTitle_2.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle_2.getFont().getSize() + 4f));
		lblNewJgoodiesTitle_2.setBounds(757, 27, 88, 14);
		contentPane.add(lblNewJgoodiesTitle_2);
		
		d1 = new JTextField();
		d1.setBackground(Color.WHITE);
		d1.setEnabled(false);
		d1.setBounds(762, 73, 132, 32);
		contentPane.add(d1);
		d1.setColumns(10);
		if(listofmails[0]==null) {
			d1.setVisible(false);
		}
		else {
			d1.setText(listofmails[0].date);
		}
		
		d2 = new JTextField();
		d2.setBackground(Color.WHITE);
		d2.setEnabled(false);
		d2.setColumns(10);
		d2.setBounds(762, 115, 132, 32);
		contentPane.add(d2);
		if(listofmails[1]==null) {
			d2.setVisible(false);
		}
		else {
			d2.setText(listofmails[1].date);
		}
		
		d3 = new JTextField();
		d3.setBackground(Color.WHITE);
		d3.setEnabled(false);
		d3.setColumns(10);
		d3.setBounds(762, 157, 132, 32);
		contentPane.add(d3);
		if(listofmails[2]==null) {
			d3.setVisible(false);
		}
		else {
			d3.setText(listofmails[2].date);
		}
		
		d4 = new JTextField();
		d4.setBackground(Color.WHITE);
		d4.setEnabled(false);
		d4.setColumns(10);
		d4.setBounds(762, 199, 132, 32);
		contentPane.add(d4);
		if(listofmails[3]==null) {
			d4.setVisible(false);
		}
		else {
			d4.setText(listofmails[3].date);
		}
		
		d5 = new JTextField();
		d5.setBackground(Color.WHITE);
		d5.setEnabled(false);
		d5.setColumns(10);
		d5.setBounds(762, 241, 132, 32);
		contentPane.add(d5);
		if(listofmails[4]==null) {
			d5.setVisible(false);
		}
		else {
			d5.setText(listofmails[4].date);
		}
		
		d6 = new JTextField();
		d6.setBackground(Color.WHITE);
		d6.setEnabled(false);
		d6.setColumns(10);
		d6.setBounds(762, 283, 132, 32);
		contentPane.add(d6);
		if(listofmails[5]==null) {
			d6.setVisible(false);
		}
		else {
			d6.setText(listofmails[5].date);
		}
		
		d7 = new JTextField();
		d7.setBackground(Color.WHITE);
		d7.setEnabled(false);
		d7.setColumns(10);
		d7.setBounds(762, 325, 132, 32);
		contentPane.add(d7);
		if(listofmails[6]==null) {
			d7.setVisible(false);
		}
		else {
			d7.setText(listofmails[6].date);
		}
		
		d8 = new JTextField();
		d8.setBackground(Color.WHITE);
		d8.setEnabled(false);
		d8.setColumns(10);
		d8.setBounds(762, 367, 132, 32);
		contentPane.add(d8);
		if(listofmails[7]==null) {
			d8.setVisible(false);
		}
		else {
			d8.setText(listofmails[7].date);
		}
		
		
		
		sub9 = new JTextField();
		sub9.setBackground(Color.WHITE);
		sub9.setEnabled(false);
		sub9.setColumns(10);
		sub9.setBounds(388, 409, 364, 32);
		contentPane.add(sub9);
		if(listofmails[8]==null) {
			sub9.setVisible(false);
			email9.setVisible(false);
		}
		else {
			sub9.setText(listofmails[8].subject);
			email9.setVisible(true);
		}
		
		sub10 = new JTextField();
		sub10.setBackground(Color.WHITE);
		sub10.setEnabled(false);
		sub10.setColumns(10);
		sub10.setBounds(388, 451, 364, 31);
		contentPane.add(sub10);
		if(listofmails[9]==null) {
			sub10.setVisible(false);
			email10.setVisible(false);
		}
		else {
			sub10.setText(listofmails[9].subject);
			email10.setVisible(true);
		}
		
		d9 = new JTextField();
		d9.setBackground(Color.WHITE);
		d9.setEnabled(false);
		d9.setColumns(10);
		d9.setBounds(762, 409, 132, 32);
		contentPane.add(d9);
		if(listofmails[8]==null) {
			d9.setVisible(false);
		}
		else {
			d9.setText(listofmails[8].date);
		}
		
		d10 = new JTextField();
		d10.setBackground(Color.WHITE);
		d10.setEnabled(false);
		d10.setColumns(10);
		d10.setBounds(762, 451, 132, 32);
		contentPane.add(d10);
		if(listofmails[9]==null) {
			d10.setVisible(false);
		}
		else {
			d10.setText(listofmails[9].date);
		}
		
		
		JButton btnNewButton_2 = new JButton("Next page");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x==a.maxpages) {
					JOptionPane.showMessageDialog(null, "Last Page");
				}
				else {
					x++;textField_20.setText(x+"");
					listofmails= (Mail[]) a.listEmails(x);
					//1
					if(listofmails[0]==null) {
						sub1.setVisible(false);
						email1.setVisible(false);
						d1.setVisible(false);
						
					}
					else {
						sub1.setText(listofmails[0].subject);
						email1.setVisible(true);
						d1.setText(listofmails[0].date);
					}
					//2
					if(listofmails[1]==null) {
						sub2.setVisible(false);
						email2.setVisible(false);
						d2.setVisible(false);
						
					}
					else {
						sub2.setText(listofmails[1].subject);
						email2.setVisible(true);
						d2.setText(listofmails[1].date);
					}
					//3
					if(listofmails[2]==null) {
						sub3.setVisible(false);
						email3.setVisible(false);
						d3.setVisible(false);
						
					}
					else {
						sub3.setText(listofmails[2].subject);
						email3.setVisible(true);
						d3.setText(listofmails[2].date);
					}
					//4
					if(listofmails[3]==null) {
						sub4.setVisible(false);
						email4.setVisible(false);
						d4.setVisible(false);
						
					}
					else {
						sub4.setText(listofmails[3].subject);
						email4.setVisible(true);
						d4.setText(listofmails[3].date);
					}
					//5
					if(listofmails[4]==null) {
						sub5.setVisible(false);
						email5.setVisible(false);
						d5.setVisible(false);
						
					}
					else {
						sub5.setText(listofmails[4].subject);
						email5.setVisible(true);
						d5.setText(listofmails[4].date);
					}
					//6
					if(listofmails[5]==null) {
						sub6.setVisible(false);
						email6.setVisible(false);
						d6.setVisible(false);
						
					}
					else {
						sub6.setText(listofmails[5].subject);
						email6.setVisible(true);
						d6.setText(listofmails[5].date);
					}
					//7
					if(listofmails[6]==null) {
						sub7.setVisible(false);
						email7.setVisible(false);
						d7.setVisible(false);
						
					}
					else {
						sub7.setText(listofmails[6].subject);
						email7.setVisible(true);
						d7.setText(listofmails[6].date);
					}
					//8
					if(listofmails[7]==null) {
						sub8.setVisible(false);
						email8.setVisible(false);
						d8.setVisible(false);
						
					}
					else {
						sub4.setText(listofmails[7].subject);
						email4.setVisible(true);
						d4.setText(listofmails[7].date);
					}
					//9
					if(listofmails[8]==null) {
						sub9.setVisible(false);
						email9.setVisible(false);
						d9.setVisible(false);
						
					}
					else {
						sub9.setText(listofmails[8].subject);
						email9.setVisible(true);
						d9.setText(listofmails[8].date);
					}
					//10
					if(listofmails[9]==null) {
						sub10.setVisible(false);
						email10.setVisible(false);
						d10.setVisible(false);
						
					}
					else {
						sub10.setText(listofmails[9].subject);
						email10.setVisible(true);
						d10.setText(listofmails[9].date);
					}
					
				}
				
			}
		});
		btnNewButton_2.setBackground(Color.PINK);
		btnNewButton_2.setFont(btnNewButton_2.getFont().deriveFont(btnNewButton_2.getFont().getStyle() | Font.BOLD));
		btnNewButton_2.setBounds(733, 516, 149, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Previous page");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x>1) {
				x--;textField_20.setText(x+"");
				listofmails= (Mail[]) a.listEmails(x);
				//1
				if(listofmails[0]==null) {
					sub1.setVisible(false);
					email1.setVisible(false);
					d1.setVisible(false);
					
				}
				else {
					sub1.setVisible(true);
					d1.setVisible(true);
					sub1.setText(listofmails[0].subject);
					email1.setVisible(true);
					d1.setText(listofmails[0].date);
				}
				//2
				if(listofmails[1]==null) {
					sub2.setVisible(false);
					email2.setVisible(false);
					d2.setVisible(false);
					
				}
				else {
					sub2.setVisible(true);
					d2.setVisible(true);
					sub2.setText(listofmails[1].subject);
					email2.setVisible(true);
					d2.setText(listofmails[1].date);
				}
				//3
				if(listofmails[2]==null) {
					sub3.setVisible(false);
					email3.setVisible(false);
					d3.setVisible(false);
					
				}
				else {
					sub3.setVisible(true);
					d3.setVisible(true);
					sub3.setText(listofmails[2].subject);
					email3.setVisible(true);
					d3.setText(listofmails[2].date);
				}
				//4
				if(listofmails[3]==null) {
					sub4.setVisible(false);
					email4.setVisible(false);
					d4.setVisible(false);
					
				}
				else {
					sub4.setVisible(true);
					d4.setVisible(true);
					sub4.setText(listofmails[3].subject);
					email4.setVisible(true);
					d4.setText(listofmails[3].date);
				}
				//5
				if(listofmails[4]==null) {
					sub5.setVisible(false);
					email5.setVisible(false);
					d5.setVisible(false);
					
				}
				else {
					sub5.setVisible(true);
					d5.setVisible(true);
					sub5.setText(listofmails[4].subject);
					email5.setVisible(true);
					d5.setText(listofmails[4].date);
				}
				//6
				if(listofmails[5]==null) {
					sub6.setVisible(false);
					email6.setVisible(false);
					d6.setVisible(false);
					
				}
				else {
					sub6.setVisible(true);
					d6.setVisible(true);
					sub6.setText(listofmails[5].subject);
					email6.setVisible(true);
					d6.setText(listofmails[5].date);
				}
				//7
				if(listofmails[6]==null) {
					sub7.setVisible(false);
					email7.setVisible(false);
					d7.setVisible(false);
					
				}
				else {
					sub7.setVisible(true);
					d7.setVisible(true);
					sub7.setText(listofmails[6].subject);
					email7.setVisible(true);
					d7.setText(listofmails[6].date);
				}
				//8
				if(listofmails[7]==null) {
					sub8.setVisible(false);
					email8.setVisible(false);
					d8.setVisible(false);
					
				}
				else {
					sub8.setVisible(true);
					d8.setVisible(true);
					sub8.setText(listofmails[7].subject);
					email8.setVisible(true);
					d4.setText(listofmails[7].date);
				}
				//9
				if(listofmails[8]==null) {
					sub9.setVisible(false);
					email9.setVisible(false);
					d9.setVisible(false);
					
				}
				else {
					sub9.setVisible(true);
					d9.setVisible(true);
					sub9.setText(listofmails[8].subject);
					email9.setVisible(true);
					d9.setText(listofmails[8].date);
				}
				//10
				if(listofmails[9]==null) {
					sub10.setVisible(false);
					email10.setVisible(false);
					d10.setVisible(false);
					
				}
				else {
					sub10.setVisible(true);
					d10.setVisible(true);
					sub10.setText(listofmails[9].subject);
					email10.setVisible(true);
					d10.setText(listofmails[9].date);
				}
				
				}else {
					JOptionPane.showMessageDialog(null, "There is no page before it");
				}
			}
		});
		btnNewButton_3.setBackground(Color.PINK);
		btnNewButton_3.setFont(btnNewButton_3.getFont().deriveFont(btnNewButton_3.getFont().getStyle() | Font.BOLD));
		btnNewButton_3.setBounds(733, 549, 149, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewJgoodiesTitle_3 = new JLabel("Page number");
		lblNewJgoodiesTitle_3.setFont(lblNewJgoodiesTitle_3.getFont().deriveFont(lblNewJgoodiesTitle_3.getFont().getStyle() | Font.BOLD));
		lblNewJgoodiesTitle_3.setBounds(414, 518, 81, 18);
		contentPane.add(lblNewJgoodiesTitle_3);
		
		textField_20 = new JTextField();
		textField_20.setBackground(Color.WHITE);
		textField_20.setEnabled(false);
		textField_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_20.setFont(textField_20.getFont().deriveFont(textField_20.getFont().getStyle() | Font.BOLD));
		textField_20.setText("1");
		textField_20.setBounds(505, 512, 86, 31);
		contentPane.add(textField_20);
		textField_20.setColumns(10);
		
		
	}

}
