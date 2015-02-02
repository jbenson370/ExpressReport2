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

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;


public class Item implements Parcelable
{
	public Date PurchaseDate;
	public int Cost;
	public String Currency;
	public String Description;
	public String Category;
	
	
	protected Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Date getPurchaseDate() {
		return PurchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		PurchaseDate = purchaseDate;
	}

	public int getCost() {
		return Cost;
	}

	public void setCost(int cost) {
		Cost = cost;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	protected Item(Parcel in) {
	        long tmpPurchaseDate = in.readLong();
	        PurchaseDate = tmpPurchaseDate != -1 ? new Date(tmpPurchaseDate) : null;
	        Cost = in.readInt();
	        Currency = in.readString();
	        Description = in.readString();
	        Category = in.readString();
	    }

	@Override
	public int describeContents() {
	        return 0;
	    }
	@Override
	public void writeToParcel(Parcel dest, int flags) {
	        dest.writeLong(PurchaseDate != null ? PurchaseDate.getTime() : -1L);
	        dest.writeInt(Cost);
	        dest.writeString(Currency);
	        dest.writeString(Description);
	        dest.writeString(Category);
	    }

	public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
	        @Override
	        public Item createFromParcel(Parcel in) {
	            return new Item(in);
	        }

	        @Override
	        public Item[] newArray(int size) {
	            return new Item[size];
	        }
	    };
}
