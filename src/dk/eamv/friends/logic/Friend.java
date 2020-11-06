package dk.eamv.friends.logic;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Friend {
	private String name, email, cellNo;
	private LocalDate birthday;
	private FriendType type;
	private ArrayList<Interests> interests = new ArrayList<>();

	public Friend(String name, String email, String cellNo,
			LocalDate birthday, FriendType type) {
		this.name = name;
		this.email = email;
		this.cellNo = cellNo;
		this.birthday = birthday;
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public int getAge() {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	public FriendType getType() {
		return type;
	}

	public ArrayList<String> getInterests() {
		var list = new ArrayList<String>();
		for (Interests i : interests)
			switch(i) {
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
