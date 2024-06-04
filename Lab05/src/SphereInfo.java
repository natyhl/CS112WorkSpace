
class Sphere{
	private double diameter;
	
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	public double radius() {
		return diameter/2;
	}
	public double diameter() {
		return diameter;
	}
	public double surfaceArea() {
		return 4*Math.PI*radius()*radius();
		
	}
	public double volume() {
		return (4.0/3.0)*Math.PI*radius()*radius()*radius();
		
	}
}


public class SphereInfo {
	public static void main(String[] args) {
		double inputDiameter = Double.parseDouble(args[0]);
		Sphere mySphere = new Sphere();
		mySphere.setDiameter(inputDiameter);
		System.out.print("A sphere of radius "+mySphere.radius()+" has surface area "+mySphere.surfaceArea()+ " and volume "+mySphere.volume());
		
	}
}//done
