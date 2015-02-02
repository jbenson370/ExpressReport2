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

import java.io.FileInputStream;

import com.google.gson.Gson;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Activity_claimInit extends Activity
{



	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.initialize_claim);
		ClaimList claimList = getIntent().getParcelableExtra("parsedClaimList");
		setupContinueClaimBtn(claimList);
		setupCancelClaimBtn();
		
		
	}
	
	private void setupContinueClaimBtn(final ClaimList claimList) {
		// Get reference to the button
		Button continueClaim = (Button) findViewById(R.id.generateBlankClaim);
		
		//Set the click listener to run my code
		continueClaim.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Claim claim = new Claim();
				EditText destination = (EditText) findViewById(R.id.destination_txt);
				EditText startDate = (EditText) findViewById(R.id.startDate_txt);
				EditText endDate = (EditText) findViewById(R.id.endDate_txt);
				EditText travelReason = (EditText) findViewById(R.id.travelReason_txt);
				claim.setDestination(destination.getText().toString());
				claim.setStartDate(startDate.getText().toString());
				claim.setEndDate(endDate.getText().toString());
				claim.setReasonForTravel(travelReason.getText().toString());
				//Toast.makeText(getApplicationContext(), 
                       // "Destination = "+claim.getDestination(), Toast.LENGTH_LONG).show();
				
				//claimList.addClaim(claim);
				Intent i = new Intent(Activity_claimInit.this, Activity_claimEdit.class);
				i.putExtra("parsedClaim", claim);
				i.putExtra("parsedClaimList", claimList);
				startActivity(i);
			    }	
			});
	}
	private void setupCancelClaimBtn(){
		// Get reference to the button
				Button cancelClaim = (Button) findViewById(R.id.cancelClaim);
				
		//Set the click listener to run the onClick Code
				cancelClaim.setOnClickListener(new View.OnClickListener(){
					@Override
					public void onClick(View v){
						finish();
					}
				});
	}
	
}
