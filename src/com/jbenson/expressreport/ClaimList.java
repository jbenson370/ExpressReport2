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
import java.util.Collection;

import android.os.Parcel;
import android.os.Parcelable;


public class ClaimList implements Parcelable{
	
	public ArrayList<Claim> claimList = new ArrayList<Claim>();
	
	protected ClaimList() {
		super();	
	}


	public void addClaim(Claim testClaim) {
		claimList.add(testClaim);
	}

	
	public void removeClaim(Claim testClaim) {
		claimList.remove(testClaim);
	}

	public int size() {
		return claimList.size();
	}

	public boolean contains(Claim testClaim) {
		return claimList.contains(testClaim);
	}

	 protected ClaimList(Parcel in) {
	        if (in.readByte() == 0x01) {
	            claimList = new ArrayList<Claim>();
	            in.readList(claimList, Claim.class.getClassLoader());
	        } else {
	            claimList = null;
	        }
	    }

	    @Override
	    public int describeContents() {
	        return 0;
	    }

	    @Override
	    public void writeToParcel(Parcel dest, int flags) {
	        if (claimList == null) {
	            dest.writeByte((byte) (0x00));
	        } else {
	            dest.writeByte((byte) (0x01));
	            dest.writeList(claimList);
	        }
	    }

	    @SuppressWarnings("unused")
	    public static final Parcelable.Creator<ClaimList> CREATOR = new Parcelable.Creator<ClaimList>() {
	        @Override
	        public ClaimList createFromParcel(Parcel in) {
	            return new ClaimList(in);
	        }

	        @Override
	        public ClaimList[] newArray(int size) {
	            return new ClaimList[size];
	        }
	    };
}
