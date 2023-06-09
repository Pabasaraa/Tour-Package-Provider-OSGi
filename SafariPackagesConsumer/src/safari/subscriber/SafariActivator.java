package safari.subscriber;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import safari.publisher.SafariPublisherInterface;


public class SafariActivator implements BundleActivator {

	ServiceReference serviceReferenceSafari;
	
	Scanner scan = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {

		int	publisherType,
			selected,
			safariType,  
			extraType;
		
		double total = 0;
		double discount = 0;
		double extraPrice = 0;
		float discountPercentage = (float) 0.05;
		
		ArrayList<String> selectPlaces = new ArrayList<String>();
		
		serviceReferenceSafari= bundleContext.getServiceReference(SafariPublisherInterface.class.getName());
		SafariPublisherInterface safariPublisher = (SafariPublisherInterface) bundleContext.getService(serviceReferenceSafari);

		System.out.println("\n********************** Welcome to Safari Packages !!!! ************************\n");
		System.out.println("Press 1 to continue with the Safari packages.");
		System.out.println("Would you like another package? press 0.");

		try {
			System.out.print("Choose a Type: ");
			publisherType = scan.nextInt();
			System.out.println("\n============================================================================");
			
			if (publisherType == 1) { 
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~ Categories Of Safari Places ~~~~~~~~~~~~~~~~~~~~~~");

				System.out.println("1. Bundala National Park Safaris");
				System.out.println("2. Wasgamuwa National Park Safaris");
				System.out.println("3. Udawalawe National Park Safaris");
				System.out.println("4. Gal Oya National Park Safaris");
			    System.out.println("______________________________________________________________________________");
				

				System.out.println("\n(To exit and get the total, press O.)");
				System.out.print("Select Your Safari Places: ");
				
				safariType = scan.nextInt();
				
				while (safariType != 0) {
					System.out.print("\nDo You Need Any Safari Equipments? (Y/N): \n");
					char isExtra = scan.next().charAt(0);

					if (isExtra == 'Y' || isExtra == 'y' ) {
						System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Extra Equipments ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
						System.out.println("1. Hiking boots                           \tLKR 3000.00");
						System.out.println("2. Waterproof backpack                    \tLKR 2500.00");
						System.out.println("3. Sleeping bag                            \tLKR 4000.00");
						System.out.println("4. Portable water filter                   \tLKR 1500.00");

						System.out.println("_________________________________________________________________________________");

						System.out.print("\nSelect extra: ");
						
						extraType = scan.nextInt();

						switch (extraType) {
							case 1:
								extraPrice = 3000;
								break;
							case 2:
								extraPrice = 2500;
								break;
							case 3:
								extraPrice = 4000;
								break;
							case 4:
								extraPrice = 1500;
								break;
						}
						
						total += extraPrice;
						System.out.println("_____________________________________________________________________________\n");
					}

					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Safari Places ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
					safariPublisher.displaySafPlaces(safariType);
					
					System.out.println("\nType -1 to end the current category.");
					System.out.print("Choose Your Places: ");
					selected = scan.nextInt();
					
					while (selected != -1) {
						total += safariPublisher.getPrice(safariType, selected);
						selectPlaces.add(safariPublisher.getPlace(safariType, selected));
						System.out.print("Choose Your Places: ");
						selected = scan.nextInt();
					}
					
					System.out.println();
					System.out.print("\nTo check your balance and launch the next package publisher, press 0!)");
					System.out.print("\nChoose the Next Category:");
					
					safariType = scan.nextInt();
				}
				
				discount = total * discountPercentage;
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Summary Report ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Your Selected Safari Places: " + selectPlaces);
				for (String place : selectPlaces) {
				    System.out.println("- " + place);
				}
				System.out.printf("\n%-20s %s", "Total Price                      :","LKR " + String.format("%.2f", total));
				System.out.printf("\n%-20s %s", "You Have Just Recieved A Discount: ","LKR " + String.format("%.2f", discount));
				System.out.printf("\n%-20s %s", "Final Price 					  :","LKR " +  String.format("%.2f", (total - discount))) ;
				System.out.println("\n___________________________________________________________________________________________________________");
				
			} else if (publisherType == 0) {
				this.stop(bundleContext);
			}
		} catch (InputMismatchException e) {
			System.out.println("The entered number is not a valid integer.!" + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Safari Subscriber Has Stopped.");
		bundleContext.ungetService(serviceReferenceSafari);
	}

}