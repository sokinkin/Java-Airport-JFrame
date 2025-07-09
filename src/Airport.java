import java.util.ArrayList;

public class Airport {
	private String name;
	private String code;
	private String city;
	private String country;
    private ArrayList<String> airlines = new ArrayList<>();
	private ArrayList<Airport> connected_airports = new ArrayList<>();
	
	
	public Airport(String name, String code, String city, String country) {
		super();
		this.name = name;
		this.code = code;
		this.city = city;
		this.country = country;
	}
	
	public void AddAirline(String anAirline) {
		boolean exists = false;
		for(String a : airlines) {
			if(a.equals(anAirline))
				exists = true;
		}
		
		if(exists == false)
			airlines.add(anAirline);
	}
	
	public void AddAirport(Airport anAirport) {
		connected_airports.add(anAirport);
	}
	
	public boolean isDirectlyConnectedTo(Airport anAirport) {
		for(Airport a: this.connected_airports) {
			if (a == anAirport)
				return true;
		}
		return false;
	}
	
	 public ArrayList<Airport> isInDirectlyConnectedTo(Airport anAirport) {
		 ArrayList<Airport> List = new ArrayList<>();
		 for(Airport a1: this.connected_airports) {
			 for(Airport a2: anAirport.connected_airports) {
				 if(a1 == a2)
					 List.add(a1);
					 
			 }
		 }
		 
		return List;
	 }
	 
	 public ArrayList<Airport> getCommonConnections(Airport anAirport) {
		 ArrayList<Airport> Common_airports = new ArrayList<>();
		 for(Airport a1: this.connected_airports) {
			 for(Airport a2: anAirport.connected_airports) {
				 if(a1 == a2)
					 Common_airports.add(a1);
			 }
		 }
		 
		 return Common_airports;
	 }
	 
	 public ArrayList<String> getAirlines(){
		 return airlines;
	 }

	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCode() {
		return code;
		
	}
	
	public String getCountry() {
		return country;
	}
	
	
	
	
	
	
	
}
