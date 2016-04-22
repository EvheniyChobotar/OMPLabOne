package mainPack;

import java.util.ArrayList;


public class Main
{  
    public static ArrayList<Double> timeList = new ArrayList<Double>();
    public static ArrayList dimensionList = new ArrayList();
    private native double nativeMultiplyMatrixWithVector(int Dimension);
    static 
    {        
        System.load("/home/eugenej/NetBeansProjects/OMPLabOne/FolderForCFiles/JNIDLforLabOne/dist/libJNIforLabOne.so");
    }
    
    public static void main(String[] args) 
    {
        DrawGraphic draw = new DrawGraphic();
        
        for(int i=10;i<=1000;i+=10)
        {
           double time = new Main().nativeMultiplyMatrixWithVector(i);
           timeList.add(time);
           dimensionList.add(i);             
            
        }
        
        draw.Draw();
        timeList.clear();
        dimensionList.clear();
    }
   
    
}