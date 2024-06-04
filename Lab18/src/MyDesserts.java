abstract class Dessert{
		abstract String ingredients();
		abstract String name();
		abstract String where();
		public String toString() {
			return name()+" contains "+ingredients()+" and the best comes from "+where();
		}
	}
	class Tiramisu extends Dessert{
		String ingredients() {
			return "coffee, eggs and mascarpone";
		}
		String name() {
			return "Tiramisu";
		}
		String where() {
			return "Italy";
		}
	}
	class Cheesecake extends Dessert{
		String ingredients() {
			return "cream cheese, sugar and eggs";
		}
		String name() {
			return "Cheesecake";
		}
		String where() {
			return "Greece";
		}
	}
	class CremeBrulee extends Dessert{
		String ingredients() {
			return "egg yolks, cream and vanilla bean";
		}
		String name() {
			return "Creme brulee";
		}
		String where() {
			return "Spain";
		}
	}

public class MyDesserts {
	
	
	public static void main(String args[]) {
		double random = Math.random();
		if(random<0.3) {
			Tiramisu aTiramisu = new Tiramisu();
			System.out.println(aTiramisu.toString());
		}else if(random>0.3 && random<0.6) {
			Cheesecake aCheesecake = new Cheesecake();
			System.out.println(aCheesecake.toString());
		}else {
			CremeBrulee aCremeBrulee= new CremeBrulee();
			System.out.println(aCremeBrulee.toString());
		}
	}

}
