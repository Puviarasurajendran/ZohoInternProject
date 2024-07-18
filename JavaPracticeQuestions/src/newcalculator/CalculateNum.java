package newcalculator;

import java.util.Iterator;

public class CalculateNum {

	abstract class IntegerCalci implements CalciOperation {

		@Override
		public int add(int... a) {
			int res = 0;
			for (int i = 0; i < a.length; i++) {
				res += a[i];
			}
			return res;
		}

		@Override
		public int sub(int... a) {
			int res = 0;
			for (int i = 0; i < a.length; i++) {
				res -= a[i];
			}
			return res;
		}

		@Override
		public int multi(int... a) {
			int res = 0;
			for (int i = 0; i < a.length; i++) {
				res *= a[i];
			}
			return res;
		}

		@Override
		public int div(int... a) {
			int res = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 0) {
					System.out.println("number can not divisible by zero");
					break;
				} else
					res += a[i];
			}
			return res;
		}
	}

	class DoubleCalci extends IntegerCalci {

		public double add(double... a) {
			double res = 0;
			for (int i = 0; i < a.length; i++) {
				res += a[i];
			}
			return res;
		}

		public double sub(double... a) {
			double res = 0;
			for (int i = 0; i < a.length; i++) {
				res -= a[i];
			}
			return res;
		}

		public double multi(double... a) {
			double res = 0;
			for (int i = 0; i < a.length; i++) {
				res *= a[i];
			}
			return res;
		}
		
		public double div(double... a) {
			double res = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 0) {
					System.out.println("number can not divisible by zero");
					break;
				} else
					res += a[i];
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		
		CalculateNum c= new CalculateNum();
		IntegerCalci calci= c.new DoubleCalci();
		
         System.out.println(calci.add(2.5,5.5,4.5));
         System.out.println(calci.add(2,5,4));
         
         
		
		
	}
}


