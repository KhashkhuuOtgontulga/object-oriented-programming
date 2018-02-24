package fin;

public class Manual_Vehicle_Test {
	public static void main(String args[]) {
		//2 manual vehicle object's
		ManualVehicle mv1=new ManualVehicle(2,"M",14);
		ManualVehicle mv2=new ManualVehicle(15,"M",14);
		System.out.println(" passing time for automatic mv1 :"+ mv1.getPassingTime());
		System.out.println(" passing time for automatic mv2 :"+ mv2.getPassingTime());
		mv1.setPassingTime(5);
		mv2.setPassingTime(8);
		System.out.println(" mv1 :"+ mv1.toString());
		System.out.println(" mv2 :"+ mv2.toString());
		}
}
