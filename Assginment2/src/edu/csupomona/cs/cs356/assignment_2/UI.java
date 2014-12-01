package edu.csupomona.cs.cs356.assignment_2;
/**
 * CS 356: Objected Oriented Programming 
 * Professor: Yu Sun
 *
 * Project 2
 *
 * <The UI class allows the user to follow and tweet.>
 *
 * David V Luong
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;



public class UI{

	protected JFrame frame = new JFrame();
	protected UserManager manager;
	protected User user;
	protected DefaultMutableTreeNode selectNode;
	protected DefaultListModel<String> newsFeed = new DefaultListModel<String>();
	protected JList<String> listTweets = new JList<String>();
	
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public UI(UserManager manager, User user, DefaultMutableTreeNode selectNode) {

		this.manager = manager;
		this.user = user;
		this.selectNode = selectNode;
	}
		

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	protected void run(UI ui){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = ui;					
					window.initialize(newsFeed);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */

	protected void initialize(DefaultListModel<String> news) {				
		frame = new JFrame(selectNode.getUserObject().toString());
		frame.setName(selectNode.getUserObject().toString());
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				AdminCP.class.getResource("/image/naruto.jpg")));
		frame.getContentPane().setBackground(new Color(0, 204, 255));
		frame.setBackground(Color.CYAN);
		frame.setBounds(100, 100, 448, 499);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(214, 21, 210, 33);
		frame.getContentPane().add(textArea);
		DefaultListModel<String> list = new DefaultListModel<String>();				
		
		JButton btnFollow = new JButton("Follow User");
		btnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User temp = null;
				if (manager.getKeysArray(selectNode.getUserObject().toString())){
					temp = manager.getUser(selectNode.getUserObject().toString());
				}
				if (e.getSource() == btnFollow){
					String userID = textArea.getText();

					if (manager.userManager.containsKey(userID)) {
						temp.followUser(manager.getUser(userID));
						manager.getUser(userID).addFollower(temp);
						temp.notifyUser(temp, manager, manager.getUser(userID));
						list.addElement(userID);
						temp.addObserver(manager.getUser(userID));	
						return;
					} else {
				    	JOptionPane.showMessageDialog(null, "Non-existent User.");
				    	return;
					}
							
				}

			}
		});
		btnFollow.setBounds(10, 11, 194, 56);
		frame.getContentPane().add(btnFollow);
		
		list.addElement("List View (Current Following):");
		
		JList<String> listFollowers = new JList<String>(list);

		listFollowers.setBounds(10, 78, 414, 125);
		frame.getContentPane().add(listFollowers);
		

		
		listFollowers.setBounds(10, 78, 414, 125);
		frame.getContentPane().add(listFollowers);
		
		JTextArea textTweet = new JTextArea();
		textTweet.setBounds(214, 226, 210, 33);
		frame.getContentPane().add(textTweet);

		listTweets = new JList<String>(news);

		
	
		listTweets.setBounds(10, 280, 414, 169);
		frame.getContentPane().add(listTweets);
		
		JButton btnTweet = new JButton("Tweet");
		btnTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User temp = null;
				if (manager.getKeysArray(selectNode.getUserObject().toString())){
					temp = manager.getUser(selectNode.getUserObject().toString());
				}
				if(e.getSource() == btnTweet){

					String tweet = textTweet.getText();					
					Iterator<User> it = temp.followers.iterator();
					boolean isPrinted = false;
					while (it.hasNext()){
						User obj = it.next();						
						if (temp.followers.contains(obj)){
							temp.sendTweet(tweet);
							if(isPrinted == false){
								newsFeed.addElement(temp.getUser() + " tweeted: " + temp.getTweet());					
								isPrinted = true;
							}
							temp.update(temp, tweet, manager, obj);			
						}
					}	
				} 
			}
		});
			
		btnTweet.setBounds(10, 214, 194, 55);
		frame.getContentPane().add(btnTweet);
		
	}
	

}


