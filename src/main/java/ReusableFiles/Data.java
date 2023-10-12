package ReusableFiles;

import com.opencsv.CSVWriter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;


import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.util.*;

public class Data {

    static Logger log= Logger.getLogger(Data.class);
    public static HashMap<Integer, String> getData(List<WebElement> element,List<WebElement> locator){
    HashMap<Integer, String> finalProductsResult = new HashMap<Integer,String>();
        for(int productCount=1;productCount<locator.size();productCount++) {
            String productName = element.get(productCount).getText();//Iterate and fetch product name
            String productPrice = locator.get(productCount).getText();//Iterate and fetch product price
            productPrice = productPrice.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers
            int finalProductPrice = Integer.parseInt(productPrice);//Convert to Integer
            finalProductsResult.put(finalProductPrice,productName);//Add product and price in HashMap

        }return finalProductsResult;
}

    public static void getPriceDetails(List<WebElement> productName,List<WebElement> productPrice){

        HashMap<Integer, String> Result= Data.getData(productName,productPrice);
        Set<Integer> allResult = Result.keySet();
        ArrayList<Integer> listOfProductPrices = new ArrayList<Integer>(allResult);

        Result.forEach(( price, name) -> {
        log.info("Rs"+price+"=>"+name);
        });

        for(int i=0;i< listOfProductPrices.size();i++){
            log.info("======================Start===================");
            if(5000<listOfProductPrices.get(i)&&listOfProductPrices.get(i)<10000){
                int price= listOfProductPrices.get(i);
                log.info(price+" The price is greater than 5000 and less than 1000");
            }else{
                int price= listOfProductPrices.get(i);
                log.info(price+" The price is less than 5000 and greater than 1000");
            }
            log.info("======================*End*===================");
        }

        //Sort the Prices in Array List using Collections class
        //this will sort in ascending order lowest at the top and highest at the bottom

            Collections.sort(listOfProductPrices);

        //Low price is
        int lowPrice = listOfProductPrices.get(0);
        log.info("======================*Start*===================");
        log.info("Product name is: " + Result.get(lowPrice));
        log.info("Low Price is: " + lowPrice);
        log.info("======================*End*===================");
    }

    public static void csvFiles(List<WebElement> element, String outputFile){
        try{
            FileWriter data= new FileWriter(new File(outputFile));
            CSVWriter writer=new CSVWriter(data);

            for(int id=0;id<element.size();id++){

                String text=element.get(id).getText();

                String[] paragraphData={text};
                writer.writeNext(paragraphData);

            }
            writer.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void ListOfFiles() throws FileNotFoundException {
        File directoryPath = new File("D:\\Demo");
        //List of all files and directories
        File filesList[] = directoryPath.listFiles();
        System.out.println("List of files and directories in the specified directory:");
        Scanner sc = null;
        for(File file : filesList) {
            System.out.println("File name: "+file.getName());
            /*System.out.println("File path: "+file.getAbsolutePath());
            System.out.println("Size :"+file.getTotalSpace());*/
            //Instantiating the Scanner class
            sc= new Scanner(file);
            String input;
            StringBuffer sb = new StringBuffer();
            while (sc.hasNextLine()) {
                input = sc.nextLine();
                sb.append(input+" ");
            }
            sb.toString();
    }
    }
    
    public static String multipleMap() {
    	Map<String,String> multipleMap = Map.of("Saran","saran","Jeni","jeni","Divya","divya");
    	String finalReuslt=multipleMap.get("Saran")+multipleMap.get("Jeni")+multipleMap.get("Divya");
    return finalReuslt;
    }
}