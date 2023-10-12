package DataProvider;/*
user:
Description:
*/

import ReusableFiles.TestUtil;


import java.util.ArrayList;
import java.util.Iterator;

public class GetData {

    public Iterator<Object[]> getTestData(){
        ArrayList<Object[]> testData= TestUtil.getDataFromExcel();
        return testData.iterator();
    }
}
