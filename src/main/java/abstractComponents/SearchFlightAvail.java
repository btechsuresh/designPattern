package abstractComponents;

import java.util.HashMap;

public interface SearchFlightAvail {
	//Instead of hardcoded parameters in method use HashMap<>, we can pass n no. of parameters
	void checkAvail(String origin, String destination) throws InterruptedException;
	
	//void checkAvail(HashMap<String, String> reservationDetails) throws InterruptedException;

}
