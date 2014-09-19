public class MysteryClass {

	public static void main(String args[])
	{
		System.out.println(mysteryMethod(12));
	}

	public static int mysteryMethod(int n) {
		boolean array [] = new boolean[n];
		
		for (int i = 0; i < n; i++)
		{
			array[i] = true;
		}
	
		for (int i = 2; i < n; i++)
		{	
			for(int j = 2*i; j<n; j=j+i)
				array[j] = false;
		}

		int count = 0;
		for (int i = 2; i < n; i++)
			if(array[i])
				count++;

		return count;
	}

}
