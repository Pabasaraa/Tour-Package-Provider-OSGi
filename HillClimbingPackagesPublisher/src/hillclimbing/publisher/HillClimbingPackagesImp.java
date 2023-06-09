package hillclimbing.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HillClimbingPackagesImp implements HillClimbingPackagesInterface {
	
	// Creating HashMaps to store different hiking categories
	HashMap<String, Double> dayMountaineering = new HashMap<String, Double>();
	HashMap<String, Double> overnightMountaineering = new HashMap<String, Double>();
	HashMap<String, Double> waterfallClimbing = new HashMap<String, Double>();
	HashMap<String, Double> alpineClimbing = new HashMap<String, Double>();
	
	public HillClimbingPackagesImp() {
		
			// Constructor to initialize the HashMaps with adventure packages
		dayMountaineering.put("Hiking in Hunnasgiriya within one day,Sri Lanka", 4000.00);
		dayMountaineering.put("Hiking in Dimbulagala within one day,Sri Lanka", 8000.00);
		dayMountaineering.put("Hiking in Yahangala within one day,Sri Lanka", 2000.00);
		dayMountaineering.put("Hiking in Kirigalpoththa within one day,Sri Lanka", 9000.00);

		
		overnightMountaineering.put("Hiking in Ella Rock,Sri Lanka", 1400.00);
		overnightMountaineering.put("Hiking in Narangala,Sri Lanka", 1900.00);
		overnightMountaineering.put("Hiking in RiverstonPeak,Sri Lanka", 2300.00);
		overnightMountaineering.put("Hiking in Knukles Mountain Range,Sri Lanka", 5400.00);

		
		waterfallClimbing.put("Water Climbing in Nuwara Eliya,Sri Lanka", 1000.00);
		waterfallClimbing.put("Water Climbing in Hortain Plains,Sri Lanka", 1800.00);
		waterfallClimbing.put("Water Climbing in Nuwara,Sri Lanka", 1500.00);
		waterfallClimbing.put("Water Climbing in Kegalle,Sri Lanka", 2000.00);

	
		alpineClimbing.put("Peacock Hills,Sri Lanka", 2800.00);
		alpineClimbing.put("Dolukanda,Sri Lanka", 3400.00);
		alpineClimbing.put("Kabaragala,Sri Lanka", 5000.00);
		alpineClimbing.put("Bopaththalawa,Sri Lanka ", 4200.00);
		
	}
	
	// Display hiking places based on the category number
	@Override
	public void displayHillClimbingsByCategory(int num) {
		int count = 1;
	    Map<String, Double> hillClimbingMap;
		  switch (num) {
	        case 1:
	            hillClimbingMap = dayMountaineering;
	            break;
	        case 2:
	            hillClimbingMap = overnightMountaineering;
	            break;
	        case 3:
	            hillClimbingMap = waterfallClimbing;
	            break;
	        case 4:
	            hillClimbingMap = alpineClimbing;
	            break;
	        default:
	            System.out.println("Invalid input");
	            return;
	    }
	    
	    for (Entry<String, Double> entry : hillClimbingMap.entrySet()) {
	        String key = entry.getKey();
	        Double value = entry.getValue();
	        System.out.println(count + ". " + key + " :- LKR " + value);
	        count++;
	    }   
	} 

// Get price of the hiking package based on category and place number
	@Override
	public double getHillClimbingsPrice(int category, int place) {
		Map<String, Double> selectedCategory = null;
		 switch (category) {
	        case 1:
	            selectedCategory = dayMountaineering;
	            break;
	        case 2:
	            selectedCategory = overnightMountaineering;
	            break;
	        case 3:
	            selectedCategory = waterfallClimbing;
	            break;
	        case 4:
	            selectedCategory = alpineClimbing;
	            break;
			default:
				return 0;
	    }
	    if (selectedCategory != null) {
	        String selectedPlace = selectedCategory.keySet().toArray()[place - 1].toString();
	        return selectedCategory.get(selectedPlace);
	    }
	    return 0;
	}

	// Get name of the hiking package based on category and place number
	@Override
	public String getHillClimbingCategory(int category, int place) {
		String name = "";
		
		if (category == 1) {
			switch (place) {
			case 1:
				name = "Hiking in Hunnasgiriya within one day,Sri Lanka";
				break;
			case 2:
				name = "Hiking in Dimbulagala within one day,Sri Lanka";
				break;
			case 3:
				name = "Hiking in Yahangala within one day,Sri Lanka";
				break;
			case 4:
				name = "Hiking in Kirigalpoththa within one day,Sri Lanka";
				break;
			}

		} else if (category == 2) {
			switch (place) {
			case 1:
				name = "Hiking in Ella Rock,Sri Lanka";
				break;
			case 2:
				name = "Hiking in Narangala,Sri Lanka";
				break;
			case 3:
				name = "Hiking in RiverstonPeak,Sri Lanka";
				break;
			case 4:
				name = "Hiking in Knukles Mountain Range,Sri Lanka";
				break;
			}

		} else if (category == 3) {
			switch (place) {
			case 1:
				name = "Water Climbing in Nuwara Eliya,Sri Lanka";
				break;
			case 2:
				name = "Water Climbing in Hortain Plains,Sri Lanka";
				break;
			case 3:
				name = "Water Climbing in Nuwara,Sri Lanka";
				break;
			case 4:
				name = "Water Climbing in Kegalle,Sri Lanka";
				break;
			}

		} else if (category == 4) {
			switch (place) {
			case 1:
				name = "Peacock Hills,Sri Lanka";
				break;
			case 2:
				name = "Dolukanda,Sri Lanka";
				break;
			case 3:
				name = "Kabaragala,Sri Lanka";
				break;
			case 4:
				name = "Bopaththalawa,Sri Lanka";
				break;
			}
		}
		return name;
	}

}
