public class CharFrequency{
public static void main(String[] args){
  String s ="banana";
  for(char ch : s.toCharArray()){
    long count = s.chars().filter(c-> c == ch).count();
    System.out.println(ch + "-->" + c); 
  }
}
}
