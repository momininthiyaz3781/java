package day23;
class Pair<T,U>
{
	private final T first ;
	private final U second;
	public Pair(T first, U second) {
		this.first=first;
		this.second=second;
	}
	public T getFirst() {
		return first;
	}
	public U getSecond() {
		return second;
	}
	public Pair<U,T> reverse(){
		return new Pair<>(second, first);
	}
}
public class Task8 {
	public static void main(String[]args) {
		Pair<String, Integer> pair=new Pair<>("Hello",123);
		System.out.println("org pair:" +pair.getFirst()+","+pair.getSecond());
		
		Pair<Integer, String> reversedPair= pair.reverse();
		System.out.println("reverse pair:" +reversedPair.getFirst()+","+reversedPair.getSecond());
}

}

