package fin;

public class TollBoothLine_Test {
	public static void main(String args[]) {
		// 2 tollbooth object's
		// one automatic and one manual
		TollBoothLine tb1 =new TollBoothLine("A");
		TollBoothLine tb2 =new TollBoothLine("M");
		Vehicle [] vehicles = new Vehicle [2];
		vehicles[0] = new AutomaticVehicle(1,"A");
		vehicles[1] = new ManualVehicle(1,"M",8);
		if (tb1.isFull())
			System.out.println("The automatic tollbooth is full.");
		else 
			System.out.println("The automatic tollbooth is not full.");
		tb1.addVehicle(vehicles[0]);
		tb2.addVehicle(vehicles[1]);
		System.out.println("The automatic tollbooth line length is :"+ tb1.getLineLength());
		System.out.println("The automatic tollbooth line type is :"+ tb1.getLineType());
		System.out.println("The automatic tollbooth line queue is :"+ tb1.getQueue());
		System.out.println("The automatic tollbooth line queue at index 0 is :"+ tb1.getQueue(0));
		System.out.println("The automatic tollbooth max length reached is :"+ tb1.getMaxLengthReached());
		tb1.setLineType("M"); // change type from automatic to manual
		System.out.println("The manual tollbooth line length is :"+ tb2.getLineLength());
		System.out.println("The manual tollbooth line type is :"+ tb2.getLineType());
		System.out.println("The manual tollbooth line queue is :"+ tb2.getQueue());
		System.out.println("The manual tollbooth line queue at index 0 is :"+ tb2.getQueue(0));
		System.out.println("The manual tollbooth max length reached is :"+ tb2.getMaxLengthReached());
		tb2.setLineType("A"); // change type from manual to automatic
		tb1.next(1);
		tb2.next(1);
		}
}
