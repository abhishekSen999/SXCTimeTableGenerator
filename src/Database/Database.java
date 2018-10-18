package Database;
public class Database {
    
    static public String[] ancillary;
    static public int[] classesAncillary;
    static public String[] courses;
    static public String[][] classes;
    static public int[][] noOfClasses;
    static public String[] timeSlots;
    static public String[] rooms;
    static public int offDay[];
    static public String[] dayName;
    static public int recess;
    
    public Database(){
        recess=2;
        dayName=new String[]{"Mon","Tue","Wed","Thurs","Fri","Sat",""};
        offDay=new int[]{5,5,5,5,5,3,3};
        timeSlots=new String[]{"10:10","11:05","12:00","1:15","2:10","3:05","4:00"};
        rooms=new String[]{"10","11","12","13","14","20","21","22","23","24","24A","24B","25","26","28","29","31","32","33","34","35","36","37","38","40","41","43","44","LHW","LSW","LPH","LCH","LMB"};
        
        ancillary   =new String[]{"CE","A11","A11","A12","A12","A13","A13","A21","A21","A22","A22","A23","A23"};
        classesAncillary=new int[]{ 1,    2,   2,    2,     2,   2,    2,    2,    2,     2,   2,     2,   2    };
    
        courses= new String[]{"MTMA2","PHSA2","CEMA2","CMSA2","MCBA2","ECOA2","STSA2","MTMA4","PHSA4","CEMA4","CMSA4","MCBA4","ECOA4","STSA4","MTMA6","PHSA6","CEMA6","CMSA6","MCBA6","ECOA6","STSA6"};
        classes=new String[21][];
        noOfClasses=new int[21][];
    
        classes[0]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","HFDNC"};
        noOfClasses[0]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1};
        classes[1]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","LPH1" ,"LPH1" ,"LPH1" ,"HFDNC"};
        noOfClasses[1]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   3,    3,    3,    1};
        classes[2]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","LCH1" ,"LCH1" ,"LCH1" ,"LCH1","HFDNC"};
        noOfClasses[2]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   4,    4,    4,    4,   1};
        classes[3]=new String[]{"H1","H2","H3","H4","H5","H6","LHW1","LHW1","LHW1","LSW2" ,"LSW2" ,"LSW2" ,"HFDNC"};
        noOfClasses[3]=new int[]{ 1,   1,   1,   1,   1,   1,   3,   3,   3,   3,    3,    3,    1};
        classes[4]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","LMB1","LMB1" ,"LMB2" ,"LMB2" ,"HFDNC"};
        noOfClasses[4]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   2,   2,    2,    2,    1};
        classes[5]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","HFDNC"};
        noOfClasses[5]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1};
        classes[6]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","LSW1","LSW1" ,"LSW2" ,"LSW2" ,"HFDNC"};
        noOfClasses[6]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   2,   2,    2,    2,    1};

        classes[7]=new String[]{"HENVS","H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13","H14","H15","H16","H17","H18","H19","H20","H21","H22","H23","H24"};
        noOfClasses[7]=new int[]{1, 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1};
        classes[8]=new String[]{"HENVS","H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13","H14","H15","H16","H17","H18","LPH1","LPH1","LPH1","LPH2","LPH2","LPH2"};
        noOfClasses[8]=new int[]{1, 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1,    1,    1,    1,    1,    1,    3,   3,   3,   3,   3,   3};
        classes[9]=new String[]{"HENVS","H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13","H14","H15","H16","H17","H18","LCH1","LCH1","LCH2","LCH2","LCH2","LCH2"};
        noOfClasses[9]=new int[]{1, 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1,    1,    1,    1,    1,    1,    2,   2,   4,   4,   4,   4};
        classes[10]=new String[]{"HENVS","H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13","H14","H15","H16","H17","H18","LSW1","LSW1","LSW1","LSW2","LSW2","LSW2"};
        noOfClasses[10]=new int[]{1, 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1,    1,    1,    1,    1,    1,    3,   3,   3,   3,   3,   3};
        classes[11]=new String[]{"HENVS","H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","LMB1","LMB1","LMB2","LMB2","LMB3","LMB3","LMB4","LMB4","LMB5","LMB5","LMB6","LMB6"};
        noOfClasses[11]=new int[]{1, 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2,   2};
        classes[12]=new String[]{"HENVS","H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13","H14","H15","H16","H17","H18","H19","H20","H21","H22","H23","H24"};
        noOfClasses[12]=new int[]{1, 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1};
        classes[13]=new String[]{"HENVS","H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13","H14","H15","H16","H17","H18","LSW1","LSW1","LSW2","LSW2","LSW3","LSW3"};
        noOfClasses[13]=new int[]{1, 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1,    1,    1,    1,    1,    1,    2,   2,   2,   2,   2,   2};

        classes[14]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13","H14","H15","H16","H17","H18"};
        noOfClasses[14]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1,    1,    1,    1,    1,    1};
        classes[15]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","LSW1","LSW1","LPH1","LPH1","LPH1","LPH2","LPH2","LPH2"};
        noOfClasses[15]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    2,   2,   3,   3,   3,   3,   3,   3};
        classes[16]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13","LCH1","LCH1","LCH2","LCH2","LCH3","LCH3","LCH3","LCH3"};
        noOfClasses[16]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1,     2,   2,   2,   2,   4,   4,   4,   4};
        classes[17]=new String[]{"H1","H2","H3","H4","H5" ,"H6","H7","H8","H9","H10","H11","H12","LSW1","LSW1","LSW1","LSW2","LSW2","LSW2"};
        noOfClasses[17]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    3,   3,   3,   3,   3,   3};
        classes[18]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","LMB1","LMB1","LMB2","LMB2","LMB3","LMB3"};
        noOfClasses[18]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    2,   2,   2,   2,   2,   2};
        classes[19]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","H11","H12","H13","H14","H15","H16","H17","H18"};
        noOfClasses[19]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,    1,    1,    1,    1,    1,    1,    1};
        classes[20]=new String[]{"H1","H2","H3","H4","H5","H6","H7","H8","H9","H10","LSW1","LSW1","LSW2","LSW2","LSW3","LSW3","LSW4","LSW4"};
        noOfClasses[20]=new int[]{ 1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    2,   2,    2,   2,   2,   2,   2,   2};
    
    } 
    
}
