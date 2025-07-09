import java.util.ArrayList;


public class CentralRegistry {
	private static ArrayList<Airport> airports = new ArrayList<>();
	private static ArrayList<Flight> flights = new ArrayList<>();
	
	
	public static void addFlight(Flight aFlight) {
		flights.add(aFlight);
		aFlight.getAirportA().AddAirport(aFlight.getAirportB());
		aFlight.getAirportA().AddAirline(aFlight.getAirline());	
		aFlight.getAirportB().AddAirport(aFlight.getAirportA());
		aFlight.getAirportB().AddAirline(aFlight.getAirline());
	}
	
	public static void  addAirport(Airport anAirport) {
		airports.add(anAirport);
	}

	
	
	public static ArrayList<Airport> ArrayOfAirports(){
	
		return airports;
		
	}
	
	
	
	public Airport getAirport(String cityName) {
		Airport airport = null;
		for(Airport a : airports) {
			if(a.getCity().equals(cityName))
				airport = a;
		}
		
		return airport;
	}
	
	public static String getDirectFlightsDetails(Airport a, Airport b) {
	    StringBuilder s = new StringBuilder("Direct Flight Details\n");
	    int count = 1;
	    for(Flight f : flights) {
	        if((f.getAirportA()== a && f.getAirportB() == b) || ( f.getAirportA() == b && f.getAirportB() == a)){
	        	
	            s.append("[").append(count++).append("]"); //[1]
	            s.append(f.toString()).append("\n"); //Flight...
	        }
	    }
	    return s.toString();
	}
	
	
	
	public static String getInDirectFlightsDetails(Airport a, Airport b) {
		StringBuilder s = new StringBuilder("INDIRECT FLIGHTS through...\n");
		int count = 1;
		ArrayList<Airport> List = new ArrayList<>();
		List = a.isInDirectlyConnectedTo(b);
		for(Airport air : List) {
			
			s.append("[").append(count++).append("]"); //[1]
			s.append(air.getCity()).append(", ").append(air.getCode()).append(" airport\n");
		}
		
		return s.toString();
		
	}
	
	
}
