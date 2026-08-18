public class Main
{
	public static void main(String[] args) {
		Scanner s = new scanner (main);
		int atm = newInt();
		int sum =0;
		int count =0;
		int temp = acc;
		int max =0; 
		int min = max;
		while(atm > 0){
		    int digit = atm % 10;
		    sum = sum + digit;
		    if(digit > max){max = digit;}
		    if(digit < min){min = digit;}
		    rev = rev*10 + digit; 
		    atm = atm/10; 
		}
		
		// Divisbilty test
		if(sum % 3  ==0 && sum % 5 ==0){System.out.println("Divisble by 3 & 5");}
		else if(sum % 3  ==0){System.out.println("Divisble by 3");}
		else if(sum % 5 ==0){System.out.println("Divisble by 5");}
		else{System.out.println("Not Divisble by 3 & 5");}
		
		//Plaindrome check
		if(rev == temp){System.out.println("Palindrome");}
		else{System.out.println("Not a palindrome");}
		
		//Even Number or not?
		if(rev % 2 == 0){System.out.println("Even");}
		else{System.out.println("Odd");} 
	}
}
