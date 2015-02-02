/*
 Express Report: Generate travel expense claims
 
 Copyright (C) 2015 Jordan Benson jbenson@ualberta.ca
 
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 This program is distributed in the hope that it will be useful, 
 but WITHOUT NY WARRANTY; without even the implied warranty of
 MERCHANT ABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 GNU General Public License for more details. 
 You should have received a copy of the GNU General Public License
 along with this program. If not, see <http://www.gnu.org/licenses/>.
 
 */

package com.jbenson.expressreport;

import java.util.ArrayList;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;


public class Claim implements Parcelable
{
	public String Destination;
	public String ReasonForTravel;
	public ArrayList<Item> ClaimItems = new ArrayList<Item>();
	public String StartDate;
	public String EndDate;
	
	
	
	protected Claim() {
		super();
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public String getReasonForTravel() {
		return ReasonForTravel;
	}
	public void setReasonForTravel(String reasonForTravel) {
		ReasonForTravel = reasonForTravel;
	}
	public ArrayList<Item> getClaimItems() {
		return ClaimItems;
	}
	public void addClaimItem(Item item){
		this.ClaimItems.add(item);
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	protected Claim(Parcel in) {
        Destination = in.readString();
        ReasonForTravel = in.readString();
        if (in.readByte() == 0x01) {
            ClaimItems = new ArrayList<Item>();
            in.readList(ClaimItems, Item.class.getClassLoader());
        } else {
            ClaimItems = null;
        }
        StartDate = in.readString();
        EndDate = in.readString();
        
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Destination);
        dest.writeString(ReasonForTravel);
        if (ClaimItems == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(ClaimItems);
        }
        dest.writeString(StartDate);
        dest.writeString(EndDate);
        
    }
	public static final Parcelable.Creator<Claim> CREATOR = new Parcelable.Creator<Claim>() {
        @Override
        public Claim createFromParcel(Parcel in) {
            return new Claim(in);
        }

        @Override
        public Claim[] newArray(int size) {
            return new Claim[size];
        }
    };
	
	
}
