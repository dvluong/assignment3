package edu.csupomona.cs.cs356.visitors;

import edu.csupomona.cs.cs356.assignment_2.GroupComposite;
import edu.csupomona.cs.cs356.assignment_2.User;

public class VisitGroups implements Visitor{

	private int count = 0;
	
	public VisitGroups(){
		setCounter(0);
	}
	
	public void setCounter(int count) {
		this.count = count;
	}
	
	public int getCounter(){
		return count;
	}
	@Override
	public void visitUser(User user) {
		return;
	}

	@Override
	public void visitGroup(GroupComposite group) {
		this.setCounter(getCounter() + 1);		
	}

}
