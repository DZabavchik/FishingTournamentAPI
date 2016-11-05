package com.lodenrogue.fishingtournament.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "catches")
public class Catch {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "fish_id")
	private long fishId;

	@Column(name = "user_id")
	private long userId;

	private Calendar date;
	private String location;

	@Column(name = "reviewer_fish_id")
	private long reviewerFishId;

	@Column(name = "review_date")
	private Calendar reviewDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getFishId() {
		return fishId;
	}

	public void setFishId(long fishId) {
		this.fishId = fishId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getReviewerFishId() {
		return reviewerFishId;
	}

	public void setReviewerFishId(long reviewerFishId) {
		this.reviewerFishId = reviewerFishId;
	}

	public Calendar getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Calendar reviewDate) {
		this.reviewDate = reviewDate;
	}

}
