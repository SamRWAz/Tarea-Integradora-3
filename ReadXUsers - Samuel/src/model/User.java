package model;

public class User {

	private String id;
	private String name;
	private String nickname;
	private String signUpDate;


	public User(String id, String name, String nickname, String signUpDate) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.signUpDate = signUpDate;


	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(String signUpDate) {
		this.signUpDate = signUpDate;
	}




}
