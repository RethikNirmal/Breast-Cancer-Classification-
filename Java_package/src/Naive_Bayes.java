/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rethik Nirmal
 */
public class Naive_Bayes {
    int number_of_instances;
    int number_of_rows;
    int label_column;
    
    public Naive_Bayes(int n,int n_rows,int label)
    {
        this.number_of_instances = n;
        this.number_of_rows = n_rows;
        this.label_column = label;
    }
    
    public double predict(int data[][],int to_predict[])
    {
        double prob = 1;
        for(int i = 0;i < number_of_rows;i++)
        {
            double prob_category = 1;
            for(int j = 0;j<number_of_instances;j++)
            {
               if(data[j][label_column] == 1 &&  data[j][i] == to_predict[i])
               {
                   prob_category++;
               }
            }
            prob = prob *(prob_category/number_of_instances);
        }
        if(prob > 0.5)
              return 1;
        else
            return 0;
    }
}
