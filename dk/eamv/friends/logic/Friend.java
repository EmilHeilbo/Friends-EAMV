package dk.eamv.friends.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Friend implements Serializable {
	private static final long serialVersionUID = 10L;

	private String name, email, cellNo;
	private FriendType type;
	private ArrayList<Interests> interests = new ArrayList<Interests>();

	public Friend(String name, String email, String cellNo, FriendType type) {
		this.name = name;
		this.email = email;
		this.cellNo = cellNo;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCellNo() {
		return cellNo;
	}

	public FriendType getType() {
		return type;
	}

	public ArrayList<String> getInterests() {
		var list = new ArrayList<String>();
		for (Interests enumInterests : interests)
			switch(enumInterests) {
				case CHESS -> list.add("Chess");
				case FISHING -> list.add("Fishing");
				case COOKING -> list.add("Cooking");
				case GAMING -> list.add("Gaming");
				case SPORTS -> list.add("Sports");
				case ANIMALS -> list.add("Animals");
				case PHOTOGRAPHY -> list.add("Photography");
			}
		return list;
	}
}
