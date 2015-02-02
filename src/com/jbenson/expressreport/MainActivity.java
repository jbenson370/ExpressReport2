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

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupNewClaimBtn();
	}

	private void setupNewClaimBtn() {
		// Get reference to the button
		Button NewClaimBtn = (Button) findViewById(R.id.newClaim_btn);
		
		//Set the click listener to run my code
		NewClaimBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ClaimList claimList = new ClaimList();
				Intent i = new Intent(MainActivity.this, Activity_claimInit.class);
				i.putExtra("parsedClaimList", claimList);
				startActivity(new Intent(MainActivity.this, Activity_claimInit.class));
				
			}
		});
	}

	
}
