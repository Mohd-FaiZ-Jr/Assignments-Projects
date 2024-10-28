import java.util.Scanner;

class Member{
    private int MemberID;
    private String LastName;
    private String FirstName;
    private int Handicap;
    private char Gender;
    private String Team;
    private String MemberType;
    private int Coach;
    private long Phone;
    private Date JoinDate;

    Member(int memberID,String LastName, String FirstName, int Handicap,char Gender, String Team, String MemberType, int Coach,long Phone,Date JoinDate){
        this.MemberID = memberID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Handicap = Handicap;
        this.Gender = Gender;
        this.Team = Team;
        this.MemberType = MemberType;
        this.Coach = Coach;
        this.Phone = Phone;
        this.JoinDate = JoinDate;
    }
    protected char getGender(){
        return this.Gender;
    }
    protected String getTeam(){
        return this.Team;
    }
    protected int getHandicapScore(){
        return this.Handicap;
    }
    protected String getMemberType(){
        return this.MemberType;
    }
    protected Date getDate(){
        return this.JoinDate;
    }

    void display(){
        System.out.println("Member Id: "+this.MemberID);
        System.out.println("Last Name: "+this.LastName);
        System.out.println("First Name: "+this.FirstName);
        System.out.println("Handicap: "+this.Handicap);
        System.out.println("Gender: "+this.Gender);
        System.out.println("Team: "+this.Team);
        System.out.println("MemberType: "+this.MemberType);
        System.out.println("Coach: "+this.Coach);
        System.out.println("Phone No.: "+this.Phone);
        System.out.println("Join Date: "+this.JoinDate);
    }
}
class Date{
    private int day;
    private String month;
    private int year;
    Date(int day,String month,int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }
    public Date compareTo(Date d1){
        Date checkDate = new Date(07,"April",2009);
        if(d1.year<checkDate.year) return d1;  //checking the year first
        else if(d1.year == checkDate.year){
            //checking the month
            switch (d1.month) {
                case "January", "February", "March" -> {
                    return d1;
                }
            }
            if(d1.month.equalsIgnoreCase("April") && d1.day<7){
                checkDate = d1;
            }
            return checkDate;
        }
        else return checkDate;
    }
}

public class Database {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many members you want to add in the golf club? ");
        int size = sc.nextInt();
        Member [] arrayMember = new Member[size];
        int countMember = 1;
        for(int i=0;i<size;i++){
            System.out.print("Enter the details for Member "+ countMember++ + "\n");
            System.out.print("Member ID: ");
            int id = sc.nextInt();
            System.out.print("Last Name: ");
            String lastName = sc.next();
            System.out.print("First Name: ");
            String firstName = sc.next();
            System.out.print("Handicap: ");
            int handicap = sc.nextInt();
            System.out.print("Gender: ");
            char gender = sc.next().charAt(0);
            System.out.print("Team A or Team B? ");
            String team = sc.next();
            System.out.print("MemberType: ");
            String memberType = sc.next();
            System.out.print("Coach: ");
            int coach = sc.nextInt();
            System.out.print("Phone No.: ");
            long phone = sc.nextLong();
            System.out.print("JoinDate: ");
            int day = sc.nextInt();String month = sc.next();int year = sc.nextInt();
            Date date = new Date(day,month,year);
            Member clubMember = new Member(id,lastName,firstName,handicap,gender,team,memberType,coach,phone,date);
            arrayMember[i] = clubMember;
            System.out.println("Member added successfully! \n");
        }

        //display the records of all senior members whose handicap score is less than 12
        System.out.println("<--------------------- Records found for all senior members whose handicap score is less than 12 ---------------------> ");
        for(int i=0;i<size;i++){
            if(arrayMember[i].getMemberType().equalsIgnoreCase("Senior") && arrayMember[i].getHandicapScore() < 12){
                arrayMember[i].display();
                System.out.println();
            }
        }

        //display the records of all the female senior members who are part of TeamB
        System.out.println("<--------------------- Records found for all the female senior members who are part of TeamB ---------------------> ");
        for(int i=0;i<size;i++){
            if(arrayMember[i].getGender() == 'F' && arrayMember[i].getMemberType().equalsIgnoreCase("Senior") && arrayMember[i].getTeam().equalsIgnoreCase("TeamB")){
                arrayMember[i].display();
                System.out.println();
            }
        }

        //displaying the records where the members joindate is earlier than 07-Apr-09 --- pending
        System.out.println("<--------------------- Records found for all the member's JoinDate is earlier than 07-Apr-09 ---------------------> ");
        for(int i=0;i<size;i++){
            Date currentMember = arrayMember[i].getDate();
            Date res = currentMember.compareTo(currentMember);
            if(res == currentMember){
                arrayMember[i].display();
                System.out.println();
            }
        }
    }
}