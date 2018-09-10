
public class BobaFett implements GameCharacter {
	
	public double x, y; // x and y coordinates, public for ease
	private double h, w; // height and width (for nearness to screen)
	private static int population = 0;
	
	public BobaFett() {
		this(0, 0, 1, 1);
		BobaFett.population++;
	}
	
	public BobaFett(double a, double b, double c, double d) {
		this.x = a;
		this.y = b;
		this.h = c > 0 ? c : 1;
		this.w = d > 0 ? d : 1;
		BobaFett.population++;
	}
	
	public void speak() {
		System.out.println("My backpack's got jets.");
	}
	
	public double calArea() {
		return this.h * this.w;
	}
	
	public double getH() {
		return this.h;
	}
	
	public double getW() {
		return this.w;
	}
	
	public void setH(double newH) {
		if (newH > 0)
			this.h = newH;
		else
			System.out.println("Illegal height");
	}
	
	public void setW(double newW) {
		if (newW > 0)
			this.w = newW;
		else
			System.out.println("Illegal width");
	}


	@Override
	public void drawOnScreen() {
		System.out.println("Character is at " + this.x + ", " + this.y);
	}

	@Override
	public void makeSound() {
		this.speak();
	}
	
	public static double calculateArea(double height, double width) {
		return height * width;
	}
	
	public static int getPopulation() {
		return BobaFett.population;
	}
}
