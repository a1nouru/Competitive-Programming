/*
Find the first non-repeating number in array. 
*/

int[] a = {5,7,8,9,2,3,5,2,7,0};
		LinkedHashMap<Integer, Boolean> m = new LinkedHashMap<>();
		for(int n : a){
			m.put(n, m.containsKey(n));
		}
		
		for (Entry<Integer, Boolean> e : m.entrySet()) {
			if(!e.getValue()){
				System.out.println(e.getKey());
				return;
			}
		}
