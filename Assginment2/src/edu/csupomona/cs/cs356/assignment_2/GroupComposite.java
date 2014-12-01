package edu.csupomona.cs.cs356.assignment_2;

/**
 * CS 356: Objected Oriented Programming 
 * Professor: Yu Sun
 *
 * Project 2
 *
 * <Composite pattern. Also stores a list of components that contain User and
 * GroupComposite.>
 *
 * David V Luong
 */
import java.util.ArrayList;

import java.util.List;

import edu.csupomona.cs.cs356.visitors.Visitor;

public class GroupComposite implements TwitterComponent {
	List<TwitterComponent> list = new ArrayList<TwitterComponent>();

	String group;
	private static final GroupComposite instance = new GroupComposite();

	public GroupComposite() {

	}

	public static GroupComposite getInstance() {
		return instance;
	}

	public GroupComposite(String newGroup) {
		group = newGroup;
	}

	public String getGroup() {
		return group;
	}

	public void add(TwitterComponent component) {
		list.add(component);
	}

	public String toString() {
		return group;

	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitGroup(this);
		for (TwitterComponent element : list) {
			element.accept(visitor);
		}
	}

}
