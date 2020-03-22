import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
public class reader  
{  
    public static void main(String[] args)   
    {  
        int number_of_instances = 569;
        int number_of_columns = 31;
        double arr[][] = new double[number_of_instances][number_of_columns];
        String line = "";  
        String splitBy = ",";  
        int instance = 0;
        try   
        {  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader br = new BufferedReader(new FileReader("D:\\Study\\Sem 4\\Package\\Java\\Java_package\\Breast_cancer\\wdbc.DATA"));  
            while ((line = br.readLine()) != null)   //returns a Boolean value  
            {  
                String[] data = line.split(splitBy);    // use comma as separator  
                for(int i = 0;i < number_of_columns - 1;i++)
                {
                    arr[instance][i] = Double.parseDouble(data[i+1]);
                    //we skip the person id row
                }
                instance++;
            }  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
    }  
} 