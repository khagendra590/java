import java.util.Scanner;
abstract class Shape{
int l;
int b;

abstract void printarea();
}

class Rectangle extends Shape{
public Rectangle(int length ,int breadth){
this.l=length;
this.b=breadth;
}


void printarea()
{
System.out.println("area of rectangle is"+ (l*b));
}
}

class Triangle extends Shape{
public Triangle(int base,int height){
this.l=base;
this.b=height;
}

void printarea()
{
System.out.println("area of triangle is"+ (l*b/2));
}
}

class Circle extends Shape{
public Circle(int radius){
this.l=radius;
}

void printarea()
{
System.out.println("area of circle is:"+ (3.14*l*l));
}
}


class Main{
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
System.out.println("enter length and breadth of rectangle:");
int l = sc.nextInt();
int b = sc.nextInt();
Rectangle area_rec = new Rectangle(l,b);
area_rec.printarea();


System.out.println("enter base and height of triangle:");
int x = sc.nextInt();
int y = sc.nextInt();
Triangle area_tr = new Triangle(x,y);
area_tr.printarea();


System.out.println("entyer radius of circle:");
int r = sc.nextInt();
Circle area_cr = new Circle(r);
area_cr.printarea();
}
}



