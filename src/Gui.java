import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/*
 * Created by JFormDesigner on Fri Oct 19 11:57:05 MSK 2018
 */



/**
 * @author ANTON AVRAMENKO
 */
public class Gui {
    public Gui() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ANTON AVRAMENKO
        Plots = new JFrame();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        MathUnit mathUnit= new MathUnit();

        //======== Plots ========
        {
            Plots.setTitle("Plots");
            Plots.setVisible(true);
            Plots.setDefaultCloseOperation(3);
            Container PlotsContentPane = Plots.getContentPane();
            PlotsContentPane.setLayout(new BorderLayout());

            //======== tabbedPane1 ========
            {

                //======== panel1 ========
                {

                    // JFormDesigner evaluation mark

                    panel1.setLayout(new FlowLayout());
                    panel1.add(drawPlot(getDots(mathUnit.Line(Lab2.Pl)),getDotsDef(Lab2.Pl)));
                }
                tabbedPane1.addTab("\u041b\u0438\u043d\u0435\u0439\u043d\u0430\u044f", panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(new FlowLayout());
                    panel2.add(drawPlot(getDots(mathUnit.quadratic(Lab2.Pl)),getDotsDef(Lab2.Pl)));
                }
                tabbedPane1.addTab("\u041f\u043e\u043b\u0438\u043d\u043e\u043c\u0438\u0430\u043b\u044c\u043d\u0430\u044f", panel2);

                //======== panel3 ========
                {
                    panel3.setLayout(new FlowLayout());
                    panel3.add(drawPlot(getDots(mathUnit.Exp(Lab2.Pl)),getDotsDef(Lab2.Pl)));
                }
                tabbedPane1.addTab("\u042d\u043a\u0441\u043f\u043e\u0442\u0435\u043d\u0446\u0438\u0430\u043b\u044c\u043d\u0430\u044f", panel3);

                //======== panel4 ========
                {
                    panel4.setLayout(new FlowLayout());
                    panel4.add(drawPlot(getDots(mathUnit.Log(Lab2.Pl)),getDotsDef(Lab2.Pl)));
                }
                tabbedPane1.addTab("\u041b\u043e\u0433\u0430\u0440\u0438\u0444\u043c\u0438\u0447\u0435\u0441\u043a\u0430\u044f", panel4);

                //======== panel5 ========
                {
                    panel5.setLayout(new FlowLayout());
                    panel5.add(drawPlot(getDots(mathUnit.Power(Lab2.Pl)),getDotsDef(Lab2.Pl)));
                }
                tabbedPane1.addTab("\u0421\u0442\u0435\u043f\u0435\u043d\u043d\u0430\u044f", panel5);
            }
            PlotsContentPane.add(tabbedPane1, BorderLayout.CENTER);
            Plots.pack();
            Plots.setLocationRelativeTo(Plots.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ANTON AVRAMENKO
    private JFrame Plots;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private XYSeries getDots(String func)
    {
        XYSeries series = new XYSeries(func);
        for(double i =-1 ; i < 10; i= i+0.1)
        {
            series.add(i, MathUnit.getY(i,func));
        }
        return series;
    }
    private XYSeries getDotsDef(ArrayList<Point> list)
    {
        XYSeries series = new XYSeries("Исходные точки");
        for (Point p:
             list) {
            series.add(p.getX(), p.getY());

        }
        return series;
    }

    private ChartPanel drawPlot(XYSeries series,XYSeries defseries)
    {
        XYSeriesCollection xyDataset = new XYSeriesCollection();
        xyDataset.addSeries(defseries);
        xyDataset.addSeries(series);

        JFreeChart chart = ChartFactory
                .createXYLineChart("", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        // Помещаем график на фрейм
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
//              legend.setDisplaySeriesShapes(true);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
//            plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // OPTIONAL CUSTOMISATION COMPLETED.

        return new ChartPanel(chart);

    }
}

