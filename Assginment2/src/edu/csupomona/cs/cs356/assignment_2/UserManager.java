package edu.csupomona.cs.cs356.assignment_2;
/**
 * CS 356: Objected Oriented Programming 
 * Professor: Yu Sun
 *
 * Project 2
 *
 * <The UserManager stores a list of users in a map with the key being 
 * of type String with the user's name. Also stores a map of the UI 
 * class with the key being of type String with the user's name.>
 *
 * David V Luong
 */
import java.util.HashMap;
import java.util.Map;

public class UserManager {
	Map<String, User> userManager;
	Map<String, UI> uiMap; 
	public UserManager(){
		userManager  = new HashMap<String, User>();
		uiMap = new HashMap<String, UI>();
	}
	public void add(String s, User user){
		userManager.put(s, user);
	}
	
	public String getID(String s){
		return userManager.get(s).toString();
	}
	
	public User getUser(String s){
		return userManager.get(s);
	}
	
	public boolean getKeysArray(String key) {
		return userManager.keySet().contains(key);
	}
	
	public void addUI(String s, UI ui){
		uiMap.put(s, ui);
	}
	
	public String getUIName(String s){
		return uiMap.get(s).toString();
	}
	
	public UI getUI(String s){
		return uiMap.get(s);
	}
	
	public boolean getKeysArrayUI(String key){
		return uiMap.keySet().contains(key);
	}

}
