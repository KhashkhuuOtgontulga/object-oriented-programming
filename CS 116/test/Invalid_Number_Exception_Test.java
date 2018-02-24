package fin;

public class Invalid_Number_Exception_Test {
	public static void main (String[] args) {
		Vehicle [] vehicles = new Vehicle [2];
		vehicles[0] = new AutomaticVehicle(1,"A");
		vehicles[1] = new ManualVehicle(1,"M",8);
		vehicles[0].setTimeIn(2); // calls the vehicle method setTimeIn which does the invalid number exception test. It should change the timeIn to 2
		vehicles[1].setTimeIn(-4); // test an invalid time which should go to the catch block with the invalid number exception class
		vehicles[0].setTimeOut(10); // calls the vehicle method setTimeIn which does the invalid number exception test. It should change the timeOut to 10
		vehicles[1].setTimeOut(-30); // test an invalid time which should go to the catch block with the invalid number exception class
	}
}
