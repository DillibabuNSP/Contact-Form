package ReusableFiles;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class TestUtil {
    static Logger log= Logger.getLogger(TestUtil.class);

    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel(){
        ArrayList<Object[]> myData= new ArrayList<Object[]>();
        try{
            reader=new Xls_Reader("C:\\Users\\dillibabu.nsp\\Desktop\\ContactForm\\myContactForm\\src\\main\\resources\\Configuration\\MyContactForm.xlsx");
        }catch(Exception exception){
            exception.printStackTrace();
        }
        int Count =reader.getRowCount("Sheet1");
        log.info(Count);
        for(int rowNum=2; rowNum<=reader.getRowCount("Sheet1");rowNum++){
            String subject= reader.getCellData("Sheet1","subject",rowNum);
            String email= reader.getCellData("Sheet1","email",rowNum);
            String text= reader.getCellData("Sheet1","text",rowNum);
            String multipleText= reader.getCellData("Sheet1","multipleText",rowNum);
            String option= reader.getCellData("Sheet1","option",rowNum);
            /*String dateMonthYear= reader.getCellData("Sheet1","dateMonthYear",rowNum);*/
            String visibleText= reader.getCellData("Sheet1","visibleText",rowNum);
            String Countries= reader.getCellData("Sheet1","Countries",rowNum);
            String Canadian= reader.getCellData("Sheet1","Canadian",rowNum);
            String Prefix= reader.getCellData("Sheet1","Prefix",rowNum);
            String firstname= reader.getCellData("Sheet1","firstname",rowNum);
            String lastname= reader.getCellData("Sheet1","lastname",rowNum);
            String Day= reader.getCellData("Sheet1","Day",rowNum);
            String Month= reader.getCellData("Sheet1","Month",rowNum);
            String Year= reader.getCellData("Sheet1","Year",rowNum);
            Object ob[]={subject,email,text,multipleText,option,visibleText,Countries,Canadian,Prefix,firstname,lastname,Day,Month,Year};
            myData.add(ob);
        }
        return myData;
    }
}

