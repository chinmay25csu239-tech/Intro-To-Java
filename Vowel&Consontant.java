string s ="Java Programming";
int v=0;
int c=0;
s=s.ToLowerCase();
for(char ch:s.toCharArray()){
  if("aeiou".indexOf(ch) !=-1) v++;
  else if(ch>='a' && ch <='z') c++;
}
System.out.println("Vowels: " + v + "Constatnt: " + c);
}
