package safari.publisher;

import java.util.HashMap;

import safari.publisher.SafariPublisherInterface;

public class SafariPublisherImp implements SafariPublisherInterface {
	
	// HashMaps use to store the Safari types
	HashMap<String, Double> BundalaSafaris = new HashMap<String, Double>();
	HashMap<String, Double> WasgamuwaSafaris = new HashMap<String, Double>();
	HashMap<String, Double> UdawalaweSafaris = new HashMap<String, Double>();
	HashMap<String, Double> GalOyaSafaris = new HashMap<String, Double>();

	// Locations can be saved with price based on their location by the constructor.
	public SafariPublisherImp() {
		BundalaSafaris.put("Bird watching safari", 6000.00);
		BundalaSafaris.put("Walking safari", 3500.00);
		BundalaSafaris.put("Night safari", 8000.00);
		BundalaSafaris.put("Beach safari", 80000.00);

		WasgamuwaSafaris.put("Jeep safari", 6000.00);
		WasgamuwaSafaris.put("Cultural safari", 7000.00);
		WasgamuwaSafaris.put("Photography safari", 5000.00);
		WasgamuwaSafaris.put("Bird watching safari", 6000.00);

		UdawalaweSafaris.put("Elephant safari", 8000.00);
		UdawalaweSafaris.put("Night safari", 7000.00);
		UdawalaweSafaris.put("Walking safari", 3000.00);
		UdawalaweSafaris.put("Bird watching safari", 3000.00);

		GalOyaSafaris.put("Boat safari", 9000.00);
		GalOyaSafaris.put("Jeep safari", 10000.00);
		GalOyaSafaris.put("Walking safar", 3000.00);
		GalOyaSafaris.put("Cultural safar", 5000.00);
	}

	@Override
	public void displaySafPlaces(int number) {
		// TODO Auto-generated method stub
		int count;
		switch (number) {
		case 1:
			count = 1;
			for (String safariName_1 : BundalaSafaris.keySet()) {
				String key_1 = safariName_1.toString();
				String value_1 = BundalaSafaris.get(safariName_1).toString();
				System.out.println(count + ". " + key_1 + " :- LKR " + value_1);
				count++;
			}
			;
			break;
		case 2:
			count = 1;
			for (String safariName_2 : WasgamuwaSafaris.keySet()) {
				String key_2 = safariName_2.toString();
				String value_2 = WasgamuwaSafaris.get(safariName_2).toString();
				System.out.println(count + ". " + key_2 + " :- LKR " + value_2);
				count++;
			}
			;
			break;

		case 3:
			count = 1;
			for (String safariName_3 : UdawalaweSafaris.keySet()) {
				String key_3 = safariName_3.toString();
				String value_3 = UdawalaweSafaris.get(safariName_3).toString();
				System.out.println(count + ". " + key_3 + " :- LKR " + value_3);
				count++;
			}
			;
			break;

		case 4:
			count = 1;
			for (String safariName_4 : GalOyaSafaris.keySet()) {
				String key_4 = safariName_4.toString();
				String value_4 = GalOyaSafaris.get(safariName_4).toString();
				System.out.println(count + ". " + key_4 + " :- LKR " + value_4);
				count++;
			}
			;
			break;
		}

	}
	

	@Override
	public double getPrice(int category, int place) {
		// TODO Auto-generated method stub
		double price = 0;
		if (category == 1) {
			switch (place) {
			case 1:
				price = BundalaSafaris.get("Bird watching safari");
				break;
			case 2:
				price = BundalaSafaris.get("Walking safari");
				break;
			case 3:
				price = BundalaSafaris.get("Night Safari");
				break;
			case 4:
				price = BundalaSafaris.get("Beach safari");
				break;
			default:
				price = 0;
			}
		} else if (category == 2) {
			switch (place) {
			case 1:
				price = WasgamuwaSafaris.get("Jeep safari");
				break;
			case 2:
				price = WasgamuwaSafaris.get("Cultural safari");
				break;
			case 3:
				price = WasgamuwaSafaris.get("Photography safari");
				break;
			case 4:
				price = WasgamuwaSafaris.get("Bird watching safari");
				break;
			default:
				price = 0;
			}

		} else if (category == 3) {
			switch (place) {
			case 1:
				price = UdawalaweSafaris.get("Elephant safari");
				break;
			case 2:
				price = UdawalaweSafaris.get("Night Safari");
				break;
			case 3:
				price = UdawalaweSafaris.get("Walking safari");
				break;
			case 4:
				price = UdawalaweSafaris.get("Bird watching  safari");
				break;
			default:
				price = 0;
			}

		} else if (category == 4) {
			switch (place) {
			case 1:
				price = GalOyaSafaris.get("Boat safari");
				break;
			case 2:
				price = GalOyaSafaris.get("Jeep safari");
				break;
			case 3:
				price = GalOyaSafaris.get("Walking safari");
				break;
			case 4:
				price = GalOyaSafaris.get("Cultural safari");
				break;
			default:
				price = 0;
			}
		}
		return price;
	}

	@Override
	public String getPlace(int category, int place) {
		// TODO Auto-generated method stub
		String name = "";
		if (category == 1) {
			switch (place) {
			case 1:
				name = "Bird watching safari";
				break;
			case 2:
				name = "Walking safari";
				break;
			case 3:
				name = "Night Safari";
				break;
			case 4:
				name = "Beach safari";
				break;
			}
		} else if (category == 2) {
			switch (place) {
			case 1:
				name = "Jeep safari";
				break;
			case 2:
				name = "Cultural safari";
				break;
			case 3:
				name = "Photography safari";
				break;
			case 4:
				name = "Bird watching safari";
				break;
			}

		} else if (category == 3) {
			switch (place) {
			case 1:
				name = "Elephant safari";
				break;
			case 2:
				name = "Night Safari";
				break;
			case 3:
				name = "Walking safari";
				break;
			}

		} else if (category == 4) {
			switch (place) {
			case 1:
				name = "Boat safari";
				break;
			case 2:
				name = "Jeep safari";
				break;
			case 3:
				name = "Walking safari";
				break;
			case 4:
				name = "Cultural safari";
				break;
			}
		}
		return name;
	}
}
