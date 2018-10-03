
public class MainActivity {

	public static void main(String[] args) {
		ArrQueue q1 = new ArrQueue();
		q1.enqueue("Joe");
		q1.enqueue("Jane");
		q1.enqueue("John");

		System.out.println(q1);  //outputs: Joe Jane John, in a row

		System.out.println(q1.size());      //3
		System.out.println(q1.isEmpty());   //false
		System.out.println(q1.toString());  //same as println'ing q1


		String s = (String) q1.dequeue();
		System.out.println(s);
		                        //Joe -- the earliest-added item
		                        //       is the item that's at the "front" of the queue

		s = (String) q1.dequeue();
		System.out.println(s);  //Jane

		s = (String) q1.dequeue();
		System.out.println(s);  //John


		s = (String) q1.dequeue(); //outputs: Out of items!
		System.out.println(s);  //Something... but what's an
		                        //excellent choice for this case?
	}
}
