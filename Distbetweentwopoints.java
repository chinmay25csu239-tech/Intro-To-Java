import java.util.Scanner;
class Point{
private float x1;
private float x2;
float dis;

Point(){this.x1=0;this.x2=0;}
Point(float x1 , float x2){this.x1=x1;this.x2=x2;}
void setValue1(float x1){this.x1=x1;}
float getValue1(){return x1;}
void setValue2(float x2){this.x2=x2;}
float getValue2(){return x2;}
Point distance(Point b){
Point y = new Point();
   y.dis = (float) Math.sqrt(Math.pow((this.getValue1()-b.getValue1()),2) + Math.pow((this.getValue2()-b.getValue2()),2 ));
return y;
}
}
class PointDemo{
public static void main(String args[]){
float x1;
float x2;
float y1;
float y2;
Scanner s = new Scanner (System.in);
System.out.println("Enter the first coordinates ");
x1 = s.nextFloat();
x2 = s.nextFloat();
System.out.println("Enter the second coordinates ");
y1 = s.nextFloat();
y2 = s.nextFloat();

Point a = new Point(x1,x2);
Point b = new Point(y1,y2);
Point y = a.distance(b);
 System.out.println("The distance between two given points is ");
    System.out.println(y.dis);
}
}
