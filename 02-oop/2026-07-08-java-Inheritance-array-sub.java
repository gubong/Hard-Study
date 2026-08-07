package e_method;

public class Java_03_sub {
	int getTotal(int[] a) {
		//arr:{85.89.75.86}
		int total = 0;
		for( int k=0; k<a.length; k++) {
			total += a[k];
		}
		
		return total;
	}
	
	
	double getAve(int[] a) {
		int total = getTotal(a);
		return (double)total/a.length;
	}
	
	
	String getResult(int[] a) {
		double ave = getAve(a);
		String ok = "";
		if (ave>80) {
			ok = "합격";
		}
		else {
			ok = "불합격";
		}
		return ok;
	}
	
	
	String getResult(int[] a, int b) {
		if(b==1 || b==2 || b==3) {
			double ave = getAve(a);
			String ok = "";
			if (ave>60) {
				ok = "합격";
			}
			else {
				ok = "불합격";
			}
			return ok;
		}
		else {
			return getResult(a);
		}
		
	}
	
	
	
	
	
	
	
	
}
