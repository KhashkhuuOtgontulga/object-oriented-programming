package fin;

public class Automatic_Vehicle_Test {
	public static void main(String args[]) {
	//2 automatic vehicle object's
	AutomaticVehicle av1=new AutomaticVehicle(1,"A");
	AutomaticVehicle av2=new AutomaticVehicle(8,"A");
	System.out.println(" passing time for automatic av1 :"+ av1.getPassingTime());
	System.out.println(" passing time for automatic av2 :"+ av2.getPassingTime());
	System.out.println(" av1 :"+ av1.toString());
	System.out.println(" av2 :"+ av2.toString());
	}
}
