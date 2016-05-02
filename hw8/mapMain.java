public class mapMain {
	public static void main(String[] args){
		Map<Integer,String> map = new AlphaMap();
		map.set(1, "hi");
		map.set(3, "im 3");
		map.set(5, "im 5");
		map.set(7, "im 7");
		map.set(9, "watch out 1");
		map.set(2, "hello");
		System.out.println(map.get(3));
		System.out.println(map.get(2));
		String name = map.get(4);
		if (name == null)
			System.out.println(" that was silly");
		else
			System.out.println("this is silly");
		System.out.println(map.size());
	}
}
