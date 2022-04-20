package com.dsandalgo.pattern.p0.general;

public class RateLimiter {

	/*
	 	rate = 5.0; // unit: messages
		per  = 8.0; // unit: seconds
		allowance = rate; // unit: messages
		last_check = now(); // floating-point, e.g. usec accuracy. Unit: seconds
		
		when (message_received):
		  current = now();
		  time_passed = current - last_check;
		  last_check = current;
		  allowance += time_passed * (rate / per);
		  if (allowance > rate):
		    allowance = rate; // throttle
		  if (allowance < 1.0):
		    discard_message();
		  else:
		    forward_message();
		    allowance -= 1.0;
	 */
	
	public static void main(String[] args) {
		
		float rate = 5.0f;
		float per = 8.0f;
		
		for (int i=0; i< 1000; i++) 
		{
			rateLimiter("i", rate, per);
	
		}
	}

	private static void rateLimiter(String messagrecieved, float rate, float per) {
		float allowance = rate;
		long lastCheck = System.currentTimeMillis();
		
		if (messagrecieved != null) {
			long current = System.currentTimeMillis();
			
			long timePassed = current - lastCheck;
			
			allowance += timePassed * (rate/per);
			
			if (allowance > rate) {
				allowance = rate;
			} 
			if (allowance < 1.0) {
				//discard message
				System.out.println("discard message");
			} else {
				//forward_message();
				System.out.println("forward message");
				allowance -= 1.0;
			}
		}
	}
}
