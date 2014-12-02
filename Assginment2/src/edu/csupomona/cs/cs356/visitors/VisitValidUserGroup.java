package edu.csupomona.cs.cs356.visitors;

import java.util.Vector;

import edu.csupomona.cs.cs356.assignment_2.GroupComposite;
import edu.csupomona.cs.cs356.assignment_2.User;


public class VisitValidUserGroup implements Visitor {
	Vector<String> invalidUserGroup = new Vector<String>();
		
	@Override
	public void visitUser(User user) {
		if (user.getUser().contains(" ") || user.getUser().contains("\t")){
			invalidUserGroup.add(user.getUser());
		}
	}

	@Override
	public void visitGroup(GroupComposite group) {
		if (group.getGroup().contains(" ") || group.getGroup().contains("\t")){
			invalidUserGroup.add(group.getGroup());
		}
	}

	public Vector<String> totalInvalids(){
		if (invalidUserGroup.isEmpty()){
			invalidUserGroup.add("No invalid user(s) or group(s).");
		} else {
			invalidUserGroup.add(0, "List of invalid user(s) and group(s):");
		}
		return invalidUserGroup;
	}


}
