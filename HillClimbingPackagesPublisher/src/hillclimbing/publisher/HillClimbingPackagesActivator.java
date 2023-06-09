package hillclimbing.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class HillClimbingPackagesActivator implements BundleActivator {

	ServiceRegistration pubServiceReg;

	// The start Hiking Publisher
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hiking Publisher has Started");

		HillClimbingPackagesInterface HillClimbingPublisher = new HillClimbingPackagesImp();

		// Register service 
		pubServiceReg = bundleContext.registerService(HillClimbingPackagesInterface.class.getName(),
		       HillClimbingPublisher,
				null);
	}

	// The stop Hiking Publisher
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hiking Publisher has Stopped");

		// Unregister service 
		pubServiceReg.unregister();
	}

}
