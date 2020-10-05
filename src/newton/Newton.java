package newton;

public class Newton {
	
	private double delta = 0.0001;
	private int max_count = 200;
	private double x = 0.1;
	private boolean u;
	
	public static void main(String[] args) {
		Newton n = new Newton(true);
		n.calc();
	}
	
	public Newton(boolean u) {
		this.u = u;
	}
	
	public double calc() {
		//шаг
		for(int count = 1; (Math.abs(f(x)) > delta) && ( count < max_count); count++)  {
			x = x - f(x)/f1(x);
			System.out.println("Step "+count+": x="+x+" y="+f(x));
		}
		
		//вывод пересечения 0
		if(Math.abs(f(x)) <= delta) {
            System.out.println("f("+x+") = 0");
            return x;
        } else {
            System.out.println("Failed to find a zero");
            return 0;
        }
	}
	
	//функция
	private double f(double x) {
		if(u) {
			return 5*Math.sin(x) - x + 1;
		} else {
			return x*x*x + 3*x*x + 12*x + 3;
		}
	}
	
	//производная функции
	private double f1(double x) {
		if(u) {
			return 5*Math.cos(x) - 1;
		} else {
			return 3*x*x + 6*x + 12;
		}
	}
}
