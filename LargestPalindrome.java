import java.util.concurrent.TimeUnit;

public class LargestPalindrome {

	public static void main(String[] args) { //Created to find the largest palindrome from the multiplication of two 7 digit numbers.
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		 
		calculate();
		long endTime = System.nanoTime();
		long durationInNano = (endTime - startTime); 
		System.out.println(durationInNano + " nano seconds");
	}
	
	public static void calculate()
	{
		
		int x = 9999999;
		int y = 9999999;
		int remainder = 0;
		long total = 0;
		long largest = 0;
		long xLargest = 0;
		long yLargest = 0;
		long reversedInteger = 0;
		long orig = 0;
		boolean roundTurn = true;
		boolean foundFirst = false;
		
		while(x >= 1000000) //While x stays at 7 digits
		{
			total = (long)x * (long)y;
			orig = total;
			reversedInteger = 0;
			
			while( total != 0 ) //While until the total is flipped around
	        {
	            remainder = (int) (total % 10); //Flipping the number around
	            reversedInteger = reversedInteger * 10 + (long)remainder;
	             
	            total  /= 10; //Reduce original number by 1 digit so we can create the palindrome
	        }
			if(reversedInteger == orig) //If the total number is a palindrome
			{
				if(!foundFirst) //If this is the first palindrome found, reset x to highest 7 digit number
					x = 9999999;
				
				foundFirst = true; 
				
				if(orig>largest) //If this total is bigger than the the largest total found so far, update the largest x, y, and total
				{ 
					largest = orig;
					xLargest = x;
					yLargest = y;
				}
			}
			if(!foundFirst) //Use this to find the first palindrome dropping x and y one at a time. Vice versa.
			{
				if(roundTurn)
				{
					roundTurn = false;
					x--;
				}
				else
				{
					roundTurn = true;;
					y--;
				}
			}
			else //Once the first palindrome is found check through all numbers that multiply above the palindrome
			{		
				if(y < 1000001 || orig < largest) //If y is about to be less than 7 digits or the total is already smaller than the largest number found
				{								 //reset y and drop x by 1
					y = 9999999;
					x--;
				}
				else 
					y--;
			}
		}
		System.out.println("The largest palindrome made from the product of two 7 digit numbers is: " + xLargest + "*" + yLargest + "=" + largest);
	}

}