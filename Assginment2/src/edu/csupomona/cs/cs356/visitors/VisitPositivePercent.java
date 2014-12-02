package edu.csupomona.cs.cs356.visitors;

import edu.csupomona.cs.cs356.assignment_2.GroupComposite;
import edu.csupomona.cs.cs356.assignment_2.User;

public class VisitPositivePercent implements Visitor{
	private int total, count;
	
	public VisitPositivePercent(){
		setTotal(0);
		setCount(0);
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getCount(){
		return count;
	}
	
	public int getTotal(){
		return total;
	}
	
	public double positivePercent(){
		System.out.println(total);
		return (double) count/total;
	}
	@Override
	public void visitUser(User user) {
		for (String tweet: user.tweet){
			if (tweet.toString().contains("good") || tweet.toString().contains("great") || tweet.toString().contains("awesome")){
				setCount(getCount() + 1);
			}
			setTotal(getTotal() + 1);
		}
	
	}

	@Override
	public void visitGroup(GroupComposite group) {
		return;
	}


}
