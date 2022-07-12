package application.model;

import java.util.Date;

public class Spending {
	private int id;
	private Date date;
	private int money;
	private String pupose;
	private String comment;
	/**
	 * @param id
	 * @param date
	 * @param money
	 * @param pupose
	 * @param comment
	 */
	public Spending(int id, Date date, int money, String pupose, String comment) {
		this.id = id;
		this.date = date;
		this.money = money;
		this.pupose = pupose;
		this.comment = comment;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	/**
	 * @return the pupose
	 */
	public String getPupose() {
		return pupose;
	}
	/**
	 * @param pupose the pupose to set
	 */
	public void setPupose(String pupose) {
		this.pupose = pupose;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Spending))
			return false;
		Spending other = (Spending) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Spending [id=" + id + ", date=" + date + ", money=" + money + ", pupose=" + pupose + ", comment="
				+ comment + "]";
	}
	
	
}
