public class Puppy{
	private Puppy(String name){
		System.out.println("Its name is: " + name);
	}

	public static void main(String args[]){
		Puppy dog = new Puppy("Toby");
	}
}


