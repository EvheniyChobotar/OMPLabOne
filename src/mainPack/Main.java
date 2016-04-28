package mainPack;

import java.util.ArrayList;

public class Main
{  
    public static ArrayList<Double> parellelTimeList    = new ArrayList<Double>();
    public static ArrayList<Double> sequentialTimeList  = new ArrayList<Double>();   
    public static ArrayList         dimensionList       = new ArrayList();
    private native double nativeParallelMultiplyMatrixWithVector(int Dimension);
    private native double nativeSequentialMultiplyMatrixWithVector(int Dimension);

    static 
    {        
        System.load("/home/eugenej/NetBeansProjects/OMPLabOne/FolderForCFiles/JNIDLforLabOne/dist/libJNIforLabOne.so");
    }
    
    public static void main(String[] args) 
    {
       calculate();       
    }
    
    public static void calculate()
    {
        for(int i=100;i<=1000;i+=100)
        {  
           parellelTimeList.add(new Main().nativeParallelMultiplyMatrixWithVector(i));
           sequentialTimeList.add(new Main().nativeSequentialMultiplyMatrixWithVector(i));
           dimensionList.add(i);             
        }
        
        DrawGraphic draw = new DrawGraphic("Chobotar_OMPLabOne");
        draw.pack();
        draw.setVisible(true); 
        parellelTimeList.clear();
        sequentialTimeList.clear();
        dimensionList.clear();        
    }
}