package com.google.android.gcm.server.test;

import java.io.IOException;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class Test {
	
	public static final void main(String[] args) {
		
		
		// send a single message using plain post
		Sender sender = new Sender("AIzaSyBZxRmM7PubbJIZe3Ue_jpvOm-NXAxKNSM");
        String registrationId = "APA91bH7GNMu1KRbTSB1WbMTekvXayXzkEz0Z_o2RGsHykf5g6G7B9v_jVJyRAks8x9bK-cI3MaRQpFxoyfT2Zs15xDEyplAohgq1HUhl-ibEoJ1SqXHg7o35XT1mjZL-SnPH2340jsaGHamOvf0LU0dJYzxeWHq4A";
        //Message message = new Message.Builder().build();
        Message message = new Message.Builder()
				.collapseKey("push_gcm")
				.timeToLive(600)
				.delayWhileIdle(true)
				.addData("message", "title 123")
				//.addData("id", "" + prid)
				.build();
        Result result;
		try {
			result = sender.send(message, registrationId, 5);
			String status = "Sent message to one device: " + result;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
