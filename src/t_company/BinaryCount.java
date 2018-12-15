package t_company;


// n 이라는 숫자를 주었을때 2진수로 변화했을경우 1의 개수 구하기
// toBinary  메서드 쓰지말고
class BinaryCount {

      public static void main(String[] args) {
    	  System.out.println(binaryCount(7));
    	  
      }
      static int binaryCount(int number) {
    	 
    	  int count=0;
    	  while (number>0) {
    		  int x = number%2;
    		  if(x==1) {
    			  count++;
    		  }
    		  number=number/2;
    	  }
    	  return count;
      }
      
      
}


