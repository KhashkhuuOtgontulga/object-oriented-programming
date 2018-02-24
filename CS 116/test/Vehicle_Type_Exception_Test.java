package fin;

public class Vehicle_Type_Exception_Test {
	public static void main (String[] args) {
		Vehicle [] vehicles = new Vehicle [2];
		vehicles[0] = new AutomaticVehicle(1,"A");
		vehicles[1] = new ManualVehicle(1,"M",8);
		vehicles[0].setType("M"); // calls the vehicle method setType which does the vehicle type exception test. It should change the type from A to M
		vehicles[1].setType("Z"); // test an invalid type which should go to the catch block with the vehicle type exception class
	}
}
