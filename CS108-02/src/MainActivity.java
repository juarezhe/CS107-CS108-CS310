
public class MainActivity {
	
	public static void main(String args[]) {
		ArrayStack st1 = new ArrayStack();
		st1.push("Joe");
		st1.push("Jane");
		st1.push("John");

		System.out.println(st1);  //outputs John, Jane, Joe, in a column

		System.out.println(st1.size());      //3
		System.out.println(st1.isEmpty());   //false
		System.out.println(st1.toString());  //same as println'ing st1


		String s = (String) st1.pop();
		System.out.println(s);
		                        //John -- the most recently-added item
		                        //        is the item that's at the "top" of the stack,
		                        //        just like with a stack of bricks!

		s = (String) st1.pop();
		System.out.println(s);  //Jane

		s = (String) st1.pop();
		System.out.println(s);  //Joe


		s = (String) st1.pop(); //outputs: Out of items!
		System.out.println(s);  //Something... but what's an
		                        //excellent choice for this case?
	}

}
