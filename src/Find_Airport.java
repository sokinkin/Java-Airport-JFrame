import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Find_Airport extends JFrame {
	
	private JPanel panel = new JPanel();
	private JTextField cityField = new JTextField("");
	private JButton findButton = new JButton("Find");
	
	ArrayList<Airport> airports;
	
	public Find_Airport(ArrayList<Airport> a) {
		
		airports = a;
		
		panel.add(cityField);
		cityField.setPreferredSize(new Dimension(140, 28));
		
		panel.add(findButton);
		
		this.setContentPane(panel);
		
		FindListener listener = new FindListener();
		findButton.addActionListener(listener);
		
		
		
		this.setVisible(true);
		this.setSize(400,250);
		this.setTitle("Find Airport");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public class FindListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String city_name = cityField.getText();
			String selected_city = null;
			
			for(Airport a : airports) {
				if(a.getCity().equals(city_name))
					selected_city = city_name;
			}
			
			
			
			if(selected_city == null) 
			{
				Icon icon = UIManager.getIcon("OptionPane.informationIcon");
				JOptionPane.showMessageDialog(null, city_name + " does not have an airport", "Error", JOptionPane.ERROR_MESSAGE, icon);
			}
			else 
			{
				new Airport_Page(airports, selected_city);
				dispose();
			}
			
			
			
			
		}
		
		
	}

}
