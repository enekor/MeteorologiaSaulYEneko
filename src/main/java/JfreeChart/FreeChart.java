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

        public static void main(String[] args) throws IOException {
            List<Double>totalmenteAlteatoria = new ArrayList<>();
            for(double i =0; i<=27;i++){
                double numero = (int)(Math.random() *300+1);
                totalmenteAlteatoria.add(numero);
            }
            var prueba = new XYSeries("2021");
            for (int i = 0; i < totalmenteAlteatoria.size(); i++) {
                prueba.add(i, totalmenteAlteatoria.get(i));
            }
            var dataset = new XYSeriesCollection();
            dataset.addSeries(prueba);

            JFreeChart chart = ChartFactory.createXYLineChart(
                    "FreeChart Prueba",
                    "Dias",
                    "Magnitud",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );
            String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"graficas"+File.separator+"algo.png";
            ChartUtilities.saveChartAsPNG(new File(path), chart, 450, 400);
        }
    }

