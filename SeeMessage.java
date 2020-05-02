package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.InputMethodListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;

public class SeeMessage extends JFrame {

	private JPanel contentPane;
	private JTextArea Message;
	private JTextField From;
	private JTextField Subject;
	private JTextField To;
	private JComboBox Attach;
	
	static Mail e;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeMessage frame = new SeeMessage(e);
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
	public SeeMessage(Mail m) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 890, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = new JLabel("From");
		lblNewJgoodiesTitle.setFont(lblNewJgoodiesTitle.getFont().deriveFont(lblNewJgoodiesTitle.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle.getFont().getSize() + 4f));
		lblNewJgoodiesTitle.setBounds(10, 11, 88, 31);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 =new JLabel("Subject");
		lblNewJgoodiesTitle_1.setFont(lblNewJgoodiesTitle_1.getFont().deriveFont(lblNewJgoodiesTitle_1.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle_1.getFont().getSize() + 4f));
		lblNewJgoodiesTitle_1.setBounds(10, 73, 71, 31);
		contentPane.add(lblNewJgoodiesTitle_1);
		
		Message = new JTextArea();
		Message.setLineWrap(true);
		Message.setEnabled(false);
		Message.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			                                                                                                                                                                                                                    public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		Message.setBounds(20, 11, 98, 280);
		contentPane.add(Message);
		
		Message.setText(m.content);
		
		JLabel lblNewJgoodiesTitle_2 = new JLabel("Message");
		lblNewJgoodiesTitle_2.setFont(lblNewJgoodiesTitle_2.getFont().deriveFont(lblNewJgoodiesTitle_2.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle_2.getFont().getSize() + 2f));
		lblNewJgoodiesTitle_2.setBounds(390, 159, 98, 22);
		contentPane.add(lblNewJgoodiesTitle_2);
		
		From = new JTextField();
		From.setEnabled(false);
		From.setBounds(124, 18, 740, 20);
		contentPane.add(From);
		From.setColumns(10);
		From.setText(m.sender);
		
		Subject = new JTextField();
		Subject.setEnabled(false);
		Subject.setBounds(124, 80, 740, 20);
		contentPane.add(Subject);
		Subject.setColumns(10);
		
		Subject.setText(m.subject);
		
		JLabel lblNewJgoodiesTitle_3 = new JLabel("To");
		lblNewJgoodiesTitle_3.setFont(lblNewJgoodiesTitle_3.getFont().deriveFont(lblNewJgoodiesTitle_3.getFont().getStyle() | Font.BOLD, lblNewJgoodiesTitle_3.getFont().getSize() + 4f));
		lblNewJgoodiesTitle_3.setBounds(20, 48, 44, 14);
		contentPane.add(lblNewJgoodiesTitle_3);
		
		To = new JTextField();
		To.setEnabled(false);
		To.setBounds(124, 49, 740, 20);
		contentPane.add(To);
		To.setColumns(10);
		
		String[] receivers = new String[m.listreceivers.size()];
		for(int i=0;i<receivers.length;i++) {
			receivers[i]=(String) m.listreceivers.dequeue();
		}
		
		for(int i=0;i<receivers.length;i++) {
		 m.listreceivers.enqueue(receivers[i]);;
		}
		
		String t = receivers[0];
		for(int i=1;i<receivers.length;i++) {
			t=t+", "+receivers[i];
		}
		
		To.setText(t);
		
		JButton btnNewButton_3 = new JButton("View Attachments");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String v = (String) Attach.getSelectedItem();
				File f=null;
				for(int i=0;i<m.attach.size();i++) {
					f = new File((String)m.attach.get(i));
					if(v.equals(f.getName())) {
						break;
					}
				}
				Desktop desktop = Desktop.getDesktop();  
				try {
					desktop.open(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton_3.setBackground(Color.BLUE);
		btnNewButton_3.setFont(btnNewButton_3.getFont().deriveFont(btnNewButton_3.getFont().getStyle() | Font.BOLD, btnNewButton_3.getFont().getSize() + 3f));
		btnNewButton_3.setBounds(648, 117, 174, 32);
		contentPane.add(btnNewButton_3);
		
	     Attach = new JComboBox();
		Attach.setBounds(124, 124, 514, 21);
		contentPane.add(Attach);
		
		String[] a = new String[m.attach.size()];
		for(int i=0;i<m.attach.size();i++) {
			File f = new File((String) m.attach.get(i));
			a[i]=f.getName();
			
		}
		final DefaultComboBoxModel model = new DefaultComboBoxModel(a);
		Attach.setModel(model);
		
		JLabel lblNewLabel = new JLabel("Attachments");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD, lblNewLabel.getFont().getSize() + 4f));
		lblNewLabel.setBounds(10, 122, 104, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane(Message);
		scrollPane.setBounds(20, 191, 833, 280);
		contentPane.add(scrollPane);
	}
}