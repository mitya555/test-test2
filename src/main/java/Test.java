

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
//import java.util.List;
import java.util.List;
//import java.util.function.BiConsumer;
//import java.util.stream.Collectors;

//import org.springframework.util.CollectionUtils;

public class Test {

	public static boolean hasDupes (int[] arr) {
//		List<Integer> l = CollectionUtils.arrayToList(arr);
//		Arrays.stream(arr)
		System.out.println(Arrays.toString(Arrays.stream(arr).distinct().toArray()));
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (!set.add(arr[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean intersect (int[] a, int[] b) {
		if (a == null || b == null || a.length != 2 || b.length != 2) {
			return false;
		}
		int[] c = Arrays.copyOf(a, 2), d = Arrays.copyOf(b, 2);
		Arrays.sort(c);
		Arrays.sort(d);
		return  (d[0]<=c[0]&&c[0]<=d[1])||
				(d[0]<=c[1]&&c[1]<=d[1])||
				(c[0]<=d[0]&&d[0]<=c[1])||
				(c[0]<=d[1]&&d[1]<=c[1]);
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,23,11,534,2,18,3,5};
		System.out.println(Arrays.toString(a));
		System.out.println("has dupes: " + hasDupes(a));
		int[] b={1,5}, c={6,8};
		System.out.println(Arrays.toString(b) + " and " + Arrays.toString(c) + (intersect(b,c)?"":" do not") + " intersect");
		b=new int[]{1,5}; c=new int[]{8,0};
		System.out.println(Arrays.toString(b) + " and " + Arrays.toString(c) + (intersect(b,c)?"":" do not") + " intersect");

		class NV {public String name, value;@Override public String toString(){return name+":"+value;}}
		List<NV> l = Arrays.asList(
				new NV() {{name="a";value="1";}},
				new NV() {{name="k";value="15";}},
				new NV() {{name="c";value="3";}},
				new NV() {{name="b";value="2";}});
		
		System.out.println(l.stream()
				.sorted((o1,o2) -> Integer.parseInt(o1.value)-Integer.parseInt(o2.value))
				.map(/*Object::toString*/ (NV nv) -> nv.toString())
//				.collect(Collectors.joining(", ", "[", "]")));
				.collect(StringBuilder::new,
						(StringBuilder _a, String _s)->{if(_a.length()>0){_a.append(", ").append(_s);}else{_a.append(_s);}},
//						new BiConsumer<StringBuilder, String>() {
//							@Override
//							public void accept(StringBuilder t, String u) {
//								StringBuilder tmp = t.length()>0?t.append(", ").append(u):t.append(u);
//							}
//						},
						StringBuilder::append)
				.insert(0, "[").append("]"));
		
		l.sort(new Comparator<NV>() {
			@Override
			public int compare(NV o1, NV o2) {
				return Integer.parseInt(o1.value) - Integer.parseInt(o2.value);
			}
		});

		System.out.println(Arrays.toString(l.toArray()));
	}
	

}
