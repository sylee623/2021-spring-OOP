package lab4;

import java.util.Random;

public class City {
	private String name;
	private int locationX;
	private int locationY;
	
	Random rnd = new Random(System.currentTimeMillis());
	
	public City(String name, int locationX, int locationY) {
		this.name = name;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	public City(String name) {
		this.name = name;
		this.locationX = rnd.nextInt(361);
		this.locationY = rnd.nextInt(361);
	}
	//getter
    public String getName(){return name;}
    public int locationX(){return locationX;}
    public int locationY(){return locationY;}
    
    //equals
    public boolean equals(City anotherCity){
        if((this.name == anotherCity.name) && (this.locationX == anotherCity.locationX) && (this.locationY == anotherCity.locationY)){return true;}
        else{return false;}
    //toString
    public String toString(){
        return name + ", "+locationX+", "+locationY;
    }
    
    public static double Distance(City city1, City city2) {
    	double distance =  Math.pow(Math.pow(city1.locationX-city2.locationX, 2) + Math.pow(city1.locationY- city2.locationY, 2), 0.5);
    	return distance;
    }
}


