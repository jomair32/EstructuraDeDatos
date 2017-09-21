package Practica3;

public class Main {
    
        public static boolean isPalindrome(String word){
            LinkedList<Character> letters=new LinkedList<Character>();
            for(int i=0;i<word.length();i++){
                char letter=word.charAt(i);
                if(Character.isLetter(letter)){
                    letters.addLast(Character.toLowerCase(letter));
                }
                
                
            }
            while(letters.size()>1){
                if(!letters.getFirst().equals(letters.getLast())){
                    return false;
                }
            letters.removeFirst();
            letters.removeLast();
            }
            return true;
        }
        public static void main(String[] args){
                LinkedList<String> iList=new LinkedList<String>();
                iList.addFirst("Juan");
                iList.addFirst("Pablo");
                iList.addFirst("jesus");
                iList.addFirst("Jose");
                iList.addFirst("carlos");
                iList.addFirst("pedro");
                System.out.println(iList);
                iList.josephus(4);
                System.out.println("");
                LinkedList<Integer> iList2 = new LinkedList<Integer>();
                for(int i=0;i<103;i++){
                    iList2.addLast(i);
                }
                System.out.println(iList2);
                iList2.josephus(4);
                
        
        } 
        public static void maind(String[] args) {
            System.out.println(isPalindrome("perro"));
            System.out.println(isPalindrome("ana"));
            System.out.println(isPalindrome("a na"));
            System.out.println(isPalindrome("ddddddd"));
        }
	public static void mainh(String[] args) {
		System.out.println("** TEST CIRCULAR DOUBLY-LINKEDLIST CLASS **");
		System.out.println("\t** USING INTEGERS **");
		LinkedList<Integer> iList = new LinkedList<Integer>();
		
		System.out.println("Testing: addFirst(i | i >= 0 && i < 10) + toString");
		System.out.println(iList);
		for(int i = 0; i < 10; i++) {
                        
			iList.addFirst(i);
                        
			System.out.println(iList);
		}
		System.out.println();
		
		System.out.println("Testing: isEmpty + removeFirst + toString");
		System.out.println(iList);
		while(!iList.isEmpty()) {
			iList.removeFirst();
                        
			System.out.println(iList);
		}
		System.out.println();
		
		System.out.println("Testing: addLast(i | i >= 0 && i < 10) + toString");
		System.out.println(iList);
		for(int i=0; i<10; i++) {
			iList.addLast(i);
			System.out.println(iList);	
		}
		System.out.println();

		System.out.println("Testing: isEmpty + removeLast + toString");
		System.out.println(iList);
		while(!iList.isEmpty()) {
			iList.removeLast();
			System.out.println(iList);
		}
		System.out.println();
		
		System.out.println("Testing: add(2 * i | i >= 0 && i < 10) + toString");
		System.out.println(iList);
		for(int i = 0; i < 10; i++) {
                    
			iList.addLast(i * 2);
                        
                        
			System.out.println(iList);
                        
                        
		}
		System.out.println("Testing: add(4, 7) + toString");
		iList.add(4, 7);
		System.out.println(iList);
		System.out.println("Testing: add(8, 13) + toString");
		iList.add(8, 13);
		System.out.println(iList);
		System.out.println("Testing: add(0, -1) + toString");
		iList.add(0, -1);
		System.out.println(iList);
		System.out.println("Testing: add(size(), 20) + toString");
		iList.add(iList.size(), 20);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing: remove(6) + toString");
		System.out.println(iList);
		iList.remove(6);
		System.out.println(iList);
		System.out.println("Testing: remove(new Integer(6)) + toString");
		iList.remove(new Integer(6));
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing: size + indexOf + get");
		for(int i=0; i<iList.size(); i++) {
			System.out.println("Get element at index " + iList.indexOf(iList.get(i)) + ": " + iList.get(i));
		}
		System.out.println();
		
		System.out.println("Testing: size + contains");
		for(int i=0; i<iList.size(); i++) {
			System.out.println("Is element " + i + " contained in the list? " + iList.contains(i));
		}
		System.out.println();
		
		System.out.println("Testing: getFirst + toString");
		System.out.println(iList);
		System.out.println(iList.getFirst());
		System.out.println();
		
		System.out.println("Testing: getLast + toString");
		System.out.println(iList);
		System.out.println(iList.getLast());
		System.out.println();
		
		System.out.println("Testing: set(3, 20) + toString");
		System.out.println(iList);
		iList.set(3, 20);
		System.out.println(iList);
		System.out.println();
		
		System.out.println("Testing: toArray");
		Object[] array = iList.toArray();
		System.out.println(array);
		if(array != null) {
			for(int i=0; i<array.length; i++)
				System.out.print(array[i] + " ");
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Testing: clear + toString");
		System.out.println(iList);
		iList.clear();
		System.out.println(iList);
		System.out.println();
		
		System.out.println("\t** USING STRINGS **");
		LinkedList<String> strLinkedList = new LinkedList<String>();
		strLinkedList.addLast("Hello");
		strLinkedList.addLast("World");
		System.out.println(strLinkedList);
		strLinkedList.remove("World");
		System.out.println(strLinkedList);
		System.out.println();
	}
}
