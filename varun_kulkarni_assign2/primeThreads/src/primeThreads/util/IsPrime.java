
package primeThreads.util;

public class IsPrime {
	public boolean isPrime(String num) {

		return (Integer.parseInt(num) % 2 != 0) ? true : false;
	}
}
