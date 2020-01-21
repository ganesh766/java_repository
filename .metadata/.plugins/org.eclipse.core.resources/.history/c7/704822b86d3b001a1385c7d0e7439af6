package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {
	private Integer eventId;
	private String venueName;
	private Date eventDate;
	private int numberOfGuest;
	private boolean status;

	public User user;

	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(Integer eventId, String venueName, Date eventDate, int numberOfGuest, boolean status) {
		super();
		this.eventId = eventId;
		this.venueName = venueName;
		this.eventDate = eventDate;
		this.numberOfGuest = numberOfGuest;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	@Column(length = 30)

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public int getNumberOfGuest() {
		return numberOfGuest;
	}

	public void setNumberOfGuest(int numberOfGuest) {
		this.numberOfGuest = numberOfGuest;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "event_date")
	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	@ManyToOne
	@JoinColumn(name = "userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", venueName=" + venueName + ", eventDate=" + eventDate
				+ ", numberOfGuest=" + numberOfGuest + ", status=" + status + "]";
	}

}
