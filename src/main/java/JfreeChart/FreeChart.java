package JfreeChart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class FreeChart {
        private static ChartUtilities ChartUtils;

        private FreeChart(){}
        private static FreeChart chart=null;
        public static FreeChart getInstance() {
            if(chart==null){
                chart = new FreeChart();
            }
            return chart;
        }

        public String generarPng(List<Double> valores, String nombre) throws IOException {
            var prueba = new XYSeries("2021");
            for (int i = 0; i < valores.size(); i++) {
                prueba.add(i, valores.get(i));
            }
            var dataset = new XYSeriesCollection();
            dataset.addSeries(prueba);

            JFreeChart chart = ChartFactory.createXYLineChart(
                    nombre,
                    "Dias",
                    "Magnitud",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );
            String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"graficas"+File.separator+nombre+".png";
            ChartUtilities.saveChartAsPNG(new File(path), chart, 450, 400);
            return path;
        }
    }

