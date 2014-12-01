package edu.csupomona.cs.cs356.assignment_2;

import edu.csupomona.cs.cs356.visitors.Visitor;

public interface TwitterComponent {
	public void accept(Visitor visitor);
}
