// _ _ _ *
// _ _ * *
//_ * * *
// * * * *

// Row 1 -> 1 star & 3 spaces
// Row 2 -> 2 star & 2 spaces
// Row 3 -> 3 star & 1 spaces
// Row 4 -> 4 star & 0 spaces

for(int i=1; i<=rows;i++){
  for(int j=1;j<=rows-i;j++){System.out.print(" ");}
  for(int  k=1;k<=i;k++){System.out.print("*");}
  System.out.println(" ");
}

    
