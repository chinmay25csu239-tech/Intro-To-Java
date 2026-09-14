import java.util.Scanner;
class Student{
    int RollNum;
    String Name;
    String Course; 
    double TotalFees;
    String Category;
    public Student(int RollNum, String Name, String Course){this.RollNum = RollNum; this.Name = Name; this.Course = Course;}
    public double CalculateTotal(){return TotalFees;}
    public double Fees(){return TotalFees;}
    public String getCategory(){return Category;}
    public double getExamFee(){return 0;}
    public double getLabFee(){return 0;} 
    public double getConcession(){return 0;}
    public double getAdditionalFee(){return 0;} 
    public double CalculateTotalFees(){return (getExamFee() - getConcession()) + getLabFee() + getAdditionalFee();}
    public void display(){
        System.out.println("RollNum: " + RollNum);
        System.out.println("Name: "+ Name);
        System.out.println("Course: " + Course);
        System.out.println("Exam Fee: " + (int)getExamFee());
        if(getConcession() >0){System.out.println("Concession: " + getConcession());}
        System.out.println("Lab Fee: " + (int)getLabFee());
        if(getAdditionalFee() > 0){System.out.println("AdditionalFee: " + getAdditionalFee());}
        System.out.println("Final Amount: " + (int)CalculateTotalFees());
        System.out.println();
    }
}
class Regular extends Student{
    public Regular(int RollNum,String Name, String Course){super(RollNum,Name,Course);}
    @Override public String getCategory(){return "Regular";}
    @Override public double getExamFee(){return 1200;}
    @Override public double getLabFee(){return 300;} 
    @Override public double getConcession(){return 0;}
    @Override public double getAdditionalFee(){return 0;} 
}
class Scholarship extends Student{
    public Scholarship(int RollNum,String Name,String Course){super(RollNum,Name,Course);}
    @Override public String getCategory(){return "Scholarship";}
    @Override public double getExamFee(){return 1200;}
    @Override public double getLabFee(){return 300;} 
    @Override public double getConcession(){return 0.5*getExamFee();}
    @Override public double getAdditionalFee(){return 0;} 
}
class Supplementary extends Student{
    public Supplementary(int RollNum,String Name,String Course){super(RollNum,Name,Course);}
    @Override public String getCategory(){return "Supplementary";}
    @Override public double getExamFee(){return 1500;}
    @Override public double getLabFee(){return 300;} 
    @Override public double getConcession(){return 0;}
    @Override public double getAdditionalFee(){return 200;} 
}

public class Main{
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		Student[] stu = new Student[2];
		for(int i = 0; i<2;i++){
		    System.out.println("Enter the rollnum: ");
		    int RollNum = obj.nextInt();
		    obj.nextLine(); 
		    System.out.print("Enter the name: ");
		    String Name = obj.nextLine();
		    System.out.print("Enter Course: ");
		    String Course = obj.nextLine();
		    System.out.print("Enter the Student Category(1-Regular / 2-Scholarship / 3 - Supplementary): ");
		    int ch = obj.nextInt();
		    switch(ch){
		        case 1 : stu[i] = new Regular(RollNum,Name,Course); break;
		        case 2 : stu[i] = new Scholarship(RollNum,Name,Course); break;
		        case 3 : stu[i] = new Supplementary(RollNum,Name,Course); break; 
		    }
		}
		System.out.println("==========================================");
        System.out.println("           FEE BREAKUP DETAILS            ");
        System.out.println("==========================================");
        Student maxStudent = stu[0];
        for (Student s : stu) {
            if (s != null) {
                s.display();

                if (s.CalculateTotalFees() > maxStudent.CalculateTotalFees()) {
                    maxStudent = s;
                }
            }
        }
        System.out.println("==========================================");
        System.out.println("   STUDENT WITH HIGHEST PAYABLE AMOUNT    ");
        System.out.println("==========================================");
        System.out.println("Roll No: " + maxStudent.RollNum);
        System.out.println("Name: " + maxStudent.Name);
        System.out.println("Category: " + maxStudent.getCategory());
        System.out.println("Highest Payable Amount: Rupees" + (int)maxStudent.CalculateTotalFees());

        obj.close();
    }
}
