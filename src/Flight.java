
public class Flight {
	private Airport airportA;
	private Airport airportB;
	private int minutes_time;
	private String airline;
	
	
	public Flight(Airport airport_A, Airport airport_B, int minutes_time, String airline) {
		super();
		this.airportA = airport_A;
		this.airportB = airport_B;
		this.minutes_time = minutes_time;
		this.airline = airline;
	}
	
	
	public String toString() {
		String s = null;
		
		s = "Flight operated by " + this.airline + ", duration " + this.minutes_time + " minutes";
		
		
		return s;
		
	}
	
	

	public int getMinutes_time() {
		return minutes_time;
	}



	public String getAirline() {
		return airline;
	}


	public Airport getAirportA() {
		return airportA;
	}


	public Airport getAirportB() {
		return airportB;
	}
	
	

}
