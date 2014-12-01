package edu.csupomona.cs.cs356.visitors;

import edu.csupomona.cs.cs356.assignment_2.GroupComposite;
import edu.csupomona.cs.cs356.assignment_2.User;

public class VisitMessages implements Visitor{
	private int counter = 0;

	public VisitMessages() {
		setCounter(0);
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public int getCounter() {
		return counter;
	}


	@Override
	public void visitUser(User user) {
		System.out.println(user.tweet.size());
		this.setCounter(getCounter() + user.tweet.size());
	}

	@Override
	public void visitGroup(GroupComposite group) {
		return;
	}

}
