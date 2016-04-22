package mainPack;


import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DrawGraphic
{
   
        
    void Draw()
    {
        
        XYSeries    series  = new XYSeries("OPMLab");
        JFrame      frame   = new JFrame("OMPLabOne");
        frame.setSize(1300,750);
        
        for(int i=0;i<Main.dimensionList.size()-1;i++)
        {
            series.add((int)Main.dimensionList.get(i),Main.timeList.get(i+1)-Main.timeList.get(i));   
        }
        
        XYDataset xyDataset = new XYSeriesCollection(series);
        
        JFreeChart chart    = ChartFactory.createXYLineChart(  "График", "размер входньіх данньіх",  "ускорение",
                                                            xyDataset, 
                                                            PlotOrientation.VERTICAL,
                                                            true, true, true);
        
        frame.getContentPane().add(new ChartPanel(chart));
        
        frame.show();   
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
