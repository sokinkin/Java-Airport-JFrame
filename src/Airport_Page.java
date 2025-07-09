import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Airport_Page extends JFrame {
	
	private ArrayList<Airport> airports;
	
	private JPanel panel = new JPanel();
	
	private JTextField nameField = new JTextField();
	private JTextField codeField = new JTextField();
	private JTextField cityField = new JTextField();
	private JTextField countryField = new JTextField();
	private JList companyList = new JList();
	
	private JTextField flightField = new JTextField();
	private JButton findButton = new JButton("Find");
	
	private JTextArea direct_flights = new JTextArea();
	private JTextArea indirect_flights = new JTextArea();
	
	private JButton backButton = new JButton("Back to Search Screen");
	
	Airport selected_airport ;
	
	public Airport_Page(ArrayList<Airport> airports, String selected_city) {
		
		this.airports = airports;
		
		for(Airport a : airports) {
			if(a.getCity().equals(selected_city))
				selected_airport = a;
		}
		
		DefaultListModel model = new DefaultListModel();
		
		 ArrayList<String> sortedCompanies = new ArrayList<>(selected_airport.getAirlines());
	        Collections.sort(sortedCompanies);

	        for (String companies : sortedCompanies) {
	            model.addElement(companies);
	        }

	        companyList.setModel(model);
		

		//-------------------
		
		nameField.setPreferredSize(new Dimension(140, 24));
		nameField.setText(selected_airport.getName());
		
		codeField.setPreferredSize(new Dimension(140, 24));
		codeField.setText(selected_airport.getCode());
		
		cityField.setPreferredSize(new Dimension(140, 24));
		cityField.setText(selected_airport.getCity());
		
		countryField.setPreferredSize(new Dimension(140, 24));
		countryField.setText(selected_airport.getCountry());
		

		
		JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row1.add(nameField);
		row1.add(codeField);
		row1.add(cityField);
		row1.add(countryField);
		row1.add(companyList);
		panel.add(row1);
		
		//---------------
		
		flightField.setPreferredSize(new Dimension(140, 28));
		
		JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		row2.add(flightField);
		row2.add(findButton);
		panel.add(row2);
		
		//----------------
	
		JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JPanel spacePanel = new JPanel();
		spacePanel.setPreferredSize(new Dimension(1, 1));
	
		direct_flights.setPreferredSize(new Dimension(350,250));

		indirect_flights.setPreferredSize(new Dimension(350,250));
		
		
		row3.add(direct_flights);
		row3.add(spacePanel);
		row3.add(indirect_flights);
		panel.add(row3);
		
		//-----------------
				
		JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		row4.add(backButton);
		panel.add(row4);
		
		
		
		//-----------------
		
		this.setContentPane(panel);

		
		FindListener findlistener = new FindListener();
		findButton.addActionListener(findlistener);
		BackListener backlistener = new BackListener();
		backButton.addActionListener(backlistener);
		
		
		
		this.setVisible(true);
		this.setSize(800,600);
		this.setTitle("Airport Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	
	public class FindListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(selected_airport.getCity().equals(flightField.getText())) {
				//same city
				Icon icon = UIManager.getIcon("OptionPane.informationIcon");
				JOptionPane.showMessageDialog(null, "Arrival and departure city cannot be the same!", "Error", JOptionPane.ERROR_MESSAGE, icon);
			}
				
			else {
				String flight = flightField.getText();
				Airport destination = null;
				for(Airport a : airports) {
					if(a.getCity().equals(flight))
						destination = a;
				
				}
				
				if(destination == null) {
					//city doesn't exist
					Icon icon = UIManager.getIcon("OptionPane.informationIcon");
					JOptionPane.showMessageDialog(null, "This place doesn't exist", "Error", JOptionPane.ERROR_MESSAGE, icon);
				}
					
				
				if (destination != null) {
					//found the city
					direct_flights.setText(CentralRegistry.getDirectFlightsDetails(selected_airport, destination));
					indirect_flights.setText(CentralRegistry.getInDirectFlightsDetails(selected_airport, destination));
				}
			}
			
		}
		
		
	}
	
	public class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new Find_Airport(airports);
			
		}
		
		
	}
	
	
	
}
