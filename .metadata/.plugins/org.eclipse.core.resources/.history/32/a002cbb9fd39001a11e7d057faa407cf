package com.app.pojos;


import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
	private Integer bookingId;
	private User user;
	private Packages packages;
public Booking() {
	// TODO Auto-generated constructor stub
}

public Booking(Integer bookingId) {
	super();
	this.bookingId = bookingId;
}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public Integer getBookingId() {
	return bookingId;
}
public void setBookingId(Integer bookingId) {
	this.bookingId = bookingId;
}

@ManyToOne
@JoinColumn(name = "userid")

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
@OneToOne
@JoinColumn(name="p_id")
public Packages getPackages() {
	return packages;
}

public void setPackages(Packages packages) {
	this.packages = packages;
}

@Override
public String toString() {
	return "Booking [bookingId=" + bookingId + "]";
}

}
