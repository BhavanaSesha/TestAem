package com.mindtree.Project_O2Store.core.entity;

public class DebitCard {
	private String cardnumber;
	private String name;
	private String expiry;
	private String cvv;

	public DebitCard() {
		super();
	}

	public DebitCard(String cardnumber, String name, String expiry, String cvv) {
		super();
		this.cardnumber = cardnumber;
		this.name = name;
		this.expiry = expiry;
		this.cvv = cvv;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
