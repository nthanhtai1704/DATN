package Vd;
	class Employee{
		public int id;
		public Employee() {
			id =1;
		}
	}

public class BT_JavaCore {
	public static void main(String[] args) {
		//System.out.println(new Employee().id); // kq=1
	
		/*int s = 0;
		for(int i =3;i<10 ; i++) {
			s+=i;
		}
		System.out.println(s); // kq = 42 */ 
		
		/*System.out.println(new Employee().id); // kq = 1*/
		
		/*String seachMe = "peter piper picker a peck of pickled peppers";
		int max = seachMe.length();
		int numPs = 0;
		for(int i =0 ; i< max ; i++) {
			if(seachMe.charAt(i) !='p') continue;
			numPs++;
		}
		System.out.println("Found " + numPs);// kq = 9 
		
		/*String ex = "Expletive";
		String PG13 = "deleted";
		String mes = ex.substring(1,3) + PG13;
		System.out.println(mes); // kq  = xpdeleted :V */
		
		/*double x = 10000.0 / 3.0;
		System.out.println(x); //kq = 3333.3333333333335 */
		
		/*int i = 0;
		do {
			i+=1;
		}while(i==0);
		System.out.println(i); // kq =1*/
		
		/*int age = 13;
		String mes = "PG"+age;
		System.out.println(mes); // kq = PG13*/
		
		/*int arr[] = {32,87,3,589,12,1076,2000,8,622,127};
		int seach =12;
		int i ;
		boolean fountlt = false;
		for(i= 0 ; i< arr.length;i++) {
			if(arr[i] == seach) {
				fountlt = true;
				break;
			}
		}
		if(fountlt) {
			System.out.println("Found " + seach+ " at index " + i);
		}else {
			System.out.println(seach + "not in the array");
		}*/
		//kq = Found 12 at index 4	
		
		String str = "Yunlin universty";
		System.out.println(str.lastIndexOf("uni")); // kq = 7*/
		
		/*String greet = "Hello";
		String s = greet.substring(1,4);
		System.out.println(s);  // kq = ell 
*/		
		//int $final;
	}
}
