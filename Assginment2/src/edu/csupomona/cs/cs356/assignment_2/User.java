package edu.csupomona.cs.cs356.assignment_2;
/**
 * CS 356: Objected Oriented Programming 
 * Professor: Yu Sun
 *
 * Project 2
 *
 * <The user class stores a list of users and tweets. Implements Observer pattern.>
 *
 * David V Luong
 */



/**
 * CS 356: Objected Oriented Programming 
 * Professor: Yu Sun
 *
 * Project 2
 *
 * <The user class stores a list of users and tweets. Implements Observer pattern.>
 *
 * David V Luong
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import edu.csupomona.cs.cs356.visitors.Visitor;
public class User extends Observable implements TwitterComponent, Observer {

	String user;
	List<User> followers = new ArrayList<User>();
	List<User> following = new ArrayList<User>();
	public List<String> tweet = new ArrayList<String>();
	String tweets;



	private static final User instance = new User();

	public User() {

	}

	public static User getInstance() {
		return instance;
	}

	public User(String newUser) {
		user = newUser;
	}

	public String getUser() {
		return user;
	}

	public String toString() {
		return user;
	}

	public void addFollower(User user) {
		followers.add(user);
	}

	public void followUser(User userId) {
		User userToFollow = userId;
		this.following.add(userToFollow);
		setChanged();
		addObserver(userToFollow);
		notifyObservers(userToFollow);
		clearChanged();
	}

	public void sendTweet(String tweets) {
		this.tweets = tweets;
		tweet.add(tweets);
		setChanged();
		notifyObservers(this.tweets);
		clearChanged();
	}
	
	public String getTweet(){
		return tweets;
	}

	public void update(User user, String tweets, UserManager UM, User follower) {
		DefaultListModel<String> listModel = new DefaultListModel<String>();	
		if (UM.getKeysArrayUI(follower.getUser())){
			listModel = UM.getUI(follower.getUser()).newsFeed;
			listModel.addElement(user.getUser() + " tweeted: " + tweets);
			UM.getUI(follower.getUser()).initialize(listModel);
		}
	}
	
	public void notifyUser(User user, UserManager UM, User following) {
		DefaultListModel<String> listModel = new DefaultListModel<String>();	
		if (UM.getKeysArrayUI(following.getUser())){
			listModel = UM.getUI(following.getUser()).newsFeed;
			listModel.addElement(user.getUser() + " followed you.");
			UM.getUI(following.getUser()).initialize(listModel);
		}
	}
	

	public void update(Observable arg0, Object arg1) {
		if (arg0 instanceof User && arg1 instanceof User) {
			System.out.println((User) arg0 + " followed " + arg1);
		}
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitUser(this);
	}

}