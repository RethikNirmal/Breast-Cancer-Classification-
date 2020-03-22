/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rethik Nirmal
 */

public class KNN {
    int label_column,row_size,col_size,K_value;
    double K_neighbours[][];
    
    public KNN(int label_column,int row_size,int col_size,int k_value)
    {
        K_neighbours = new double [k_value][2];
        for(int i =0;i<k_value;i++)
        {
            K_neighbours[i][1] = Double.MAX_VALUE;
        }
        this.K_value = k_value;
        this.row_size = row_size;
        this.col_size = col_size;
        this.label_column = label_column;
    }

    double calc_euclidean_distance(int arr[],int to_classify[])
    {
        double dist = 0;
        for(int i =0; i< row_size;i++)
        {
            dist = dist + Math.pow((double)(arr[i] - to_classify[i]),(double)2);
        }
        return Math.sqrt(dist);
    }
    
    int classified_to_label(int unique_values)
    {
        int arr[] = new int[unique_values];
        for(int i =0 ;i<unique_values;i++)
        {
            arr[i]=0;
        }
        
        for(int i =0;i<K_value;i++)
        {
            arr[(int)K_neighbours[i][0]] = arr[(int)K_neighbours[i][0]] + 1;
        }
        
        int max = 0,pos =0;
        for(int i =0 ;i< unique_values;i++)
        {
            if(arr[i] > max)
            {
                max =arr[i];
                pos = i;
            }
        }
        
        return pos;
    }
    
    void replace_arr(double dist,int row_iter,int arr[][])
    {
        double max = 0;
        int pos = 0;
        for(int i =0 ;i< K_value;i++)
        {
            if(K_neighbours[i][1] > max)
            {
                max =K_neighbours[i][1];
                pos = i;
            }
        }
        
        if(max > dist)
        {
            K_neighbours[pos][1] = max;
            K_neighbours[pos][0] = arr[row_iter][label_column];
        }
    }
    public int classify(int arr[][],int to_classify[],int k,int unique_values)
    {
        for(int row_iter = 0;row_iter < row_size;row_iter++)
        {
            double dist = calc_euclidean_distance(arr[row_iter],to_classify);
            replace_arr(dist,row_iter,arr);
        }
        
        return classified_to_label(unique_values);
    }
}
