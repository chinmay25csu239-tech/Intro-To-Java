import java.util.Scanner;
class Hospital{
    int PatientId;
    String Name;
    int days;
    String Category;
    public Hospital(int PatientId, String Name, int days, String Category){this.PatientId = PatientId; this.Name = Name; this.days = days; this.Category = Category;}
    public String getCategory(){return Category;}
    public double getConsultation(){return 0;}
    public double getHospitalCharge(){return 0;} 
    public double getEmergency(){return 0;}
    public double getMonitorCharge(){return 0;} // To be multipled based on 'days'
    public double getICUCharge(){return 0;} // To be multipled based on 'days'
    public double CalculateTotalFees(){return (getConsultation() + getHospitalCharge() + getEmergency() + getMonitorCharge() + getICUCharge());}
    public void display(){
        System.out.println("Patient Id: " + PatientId);
        System.out.println("Name: "+ Name);
        System.out.println("Category: " + Category);
        System.out.println("Consulation: " + getConsultation());
        System.out.println("Daily Hospital Charge: " + getHospitalCharge()); 
        if(getEmergency() > 0){System.out.println("Emergency: " + getEmergency());}
        if(getMonitorCharge() > 0){System.out.println("Monitor Charge: " + getMonitorCharge());}
        if(getICUCharge() > 0){System.out.println("ICU Charge: " + getICUCharge());}
        System.out.println("Final Amount: " + (int)CalculateTotalFees());
        System.out.println();
    }
}
class General extends Hospital{
    public General(int PatientId, String Name, int days, String Category){super(PatientId,Name,days,Category);}
    @Override public String getCategory(){return "General";}
    @Override public double getConsultation(){return 500;}
    @Override public double getHospitalCharge(){return 1000*days;}
}
class Emergency extends Hospital{
    public Emergency(int PatientId, String Name, int days, String Category){super(PatientId,Name,days,Category);}
    @Override public String getCategory(){return "Emergency";}
    @Override public double getConsultation(){return 1000;}
    @Override public double getHospitalCharge(){return 2000*days;} 
    @Override public double getEmergency(){return 2500;}
}
class ICU extends Hospital{
   public ICU(int PatientId, String Name, int days, String Category){super(PatientId,Name,days,Category);}
   @Override public String getCategory(){return "ICU";}
   @Override public double getConsultation(){return 1500;}
   @Override public double getMonitorCharge(){return 2000*days;}
   @Override public double getICUCharge(){return 5000*days;} 
}

public class Main{
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		Hospital[] pat = new Hospital[2];
		for(int i = 0; i<2;i++){
		    System.out.println("Enter the PatientId: ");
		    int PatientId = obj.nextInt();
		    obj.nextLine();
		    System.out.print("Enter the name: ");
		    String Name = obj.nextLine();
		    System.out.print("Enter number of days: ");
		    int days = obj.nextInt();
		    System.out.print("Enter the Patient Category(1-General / 2-SOS / 3 - ICU): ");
		    int ch = obj.nextInt();
		    obj.nextLine();
		    switch(ch){
		        case 1 : pat[i] = new General(PatientId,Name,days,"General"); break;
		        case 2 : pat[i] = new Emergency(PatientId,Name,days,"Emergency"); break;
		        case 3 : pat[i] = new ICU(PatientId,Name,days,"ICU"); break; 
		    }
		}
		System.out.println("==========================================");
        System.out.println("           FEE BREAKUP DETAILS            ");
        System.out.println("==========================================");
        Hospital maxpatient = pat[0];
        for (Hospital p : pat) {
            if (p != null) {
                p.display();
                if (p.CalculateTotalFees() > maxpatient.CalculateTotalFees()) {
                    maxpatient = p;
                }
            }
        }
        System.out.println("==========================================");
        System.out.println("   Patient WITH HIGHEST PAYABLE AMOUNT    ");
        System.out.println("==========================================");
        System.out.println("Patient Id: " + maxpatient.PatientId);
        System.out.println("Name: " + maxpatient.Name);
        System.out.println("Category: " + maxpatient.getCategory());
        System.out.println("Highest Payable Amount: Rupees" + (int)maxpatient.CalculateTotalFees());

        obj.close();
    }
}

