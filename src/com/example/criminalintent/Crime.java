package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return mTittle;
	}
	private UUID mId;
	private String mTittle;
	private Date mDate;
	private boolean mSolved;
	public Crime(){
		mId=UUID.randomUUID();
		mDate=new Date();
	}
	public Date getDate() {
		return mDate;
	}
	public void setDate(Date date) {
		mDate = date;
	}
	public boolean isSolved() {
		return mSolved;
	}
	public void setSolved(boolean solved) {
		mSolved = solved;
	}
	public String getTittle() {
		return mTittle;
	}
	public void setTittle(String tittle) {
		mTittle = tittle;
	}
	public UUID getId() {
		return mId;
	}
	
}
