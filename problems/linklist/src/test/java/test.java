public class test {
	public static  void main(String args[]){
		String name = "你哈";
			int n = 0;
			for(int i = 0; i < name.length(); i++) {
				n = (int)name.charAt(i);
				if(!(19968 <= n && n <40869)) {
					System.out.println(false);;
				}
			}
			System.out.println(true);
		}
}

