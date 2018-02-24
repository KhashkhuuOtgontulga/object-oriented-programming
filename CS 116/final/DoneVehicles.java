package fin;

import java.util.*;
public class DoneVehicles {
	private List<ManualVehicle> manualList = new ArrayList<ManualVehicle>();
	private List<AutomaticVehicle> autoList = new ArrayList<AutomaticVehicle>();
	private int maxManualWait = 0;
	private int maxAutoWait = 0;
	private double avgManualWait = 0;
	private double avgAutoWait = 0;
	//Constructor
	public DoneVehicles(){}
	//access lists directly
	public List<ManualVehicle> getManualList() { return manualList; }
	public List<AutomaticVehicle> getAutomaticList() { return autoList; }
	//list info methods
	public int getMaxManualWait(){
		int maxWaitTime = 0;
		for (ManualVehicle vehicle : manualList) {
			maxWaitTime = vehicle.getWaitingTime();
			if (maxManualWait<maxWaitTime) { maxManualWait = maxWaitTime; }
		} return maxWaitTime;
	}
	public double getAverageManualWait(){
		double totalWaitTime = 0;
		for (ManualVehicle vehicle : manualList) { 
			totalWaitTime += vehicle.getWaitingTime();
		} return (double)(totalWaitTime)/(double)(this.manualCount());
	}

	public int getMaxAutomaticWait(){
		int maxWaitTime = 0;
		for (AutomaticVehicle vehicle : autoList) {
			maxWaitTime = vehicle.getWaitingTime();
			if(maxAutoWait<maxWaitTime) { maxAutoWait = maxWaitTime; }
		} return maxWaitTime;
	}
	public double getAverageAutomaticWait(){
		double totalWaitTime = 0;
		for (AutomaticVehicle vehicle : autoList) {
			totalWaitTime += vehicle.getWaitingTime();
		} return (double)(totalWaitTime)/(double)(this.automaticCount());
	}

	public int manualCount(){ return manualList.size()-1; }
	public int automaticCount(){ return autoList.size()-1; }

	//add to list methods by type
	public void addManual(ManualVehicle vehicle){ manualList.add(vehicle); vehicle.passTollBooth(); }
	public void addAutomatic(AutomaticVehicle vehicle){ autoList.add(vehicle); vehicle.passTollBooth(); }
}