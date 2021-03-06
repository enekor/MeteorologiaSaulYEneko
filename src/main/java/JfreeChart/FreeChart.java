package JfreeChart;

import Mapas.EstacionesMapas;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FreeChart {
    EstacionesMapas em = EstacionesMapas.getInstance();
    private static ChartUtilities ChartUtils;

    private FreeChart(){}
    private static FreeChart chart=null;
    public static FreeChart getInstance() {
        if(chart==null){
            chart = new FreeChart();
        }
        return chart;
    }

    /**
     * creamos una imagen a partir de los valores aportados
     * @param valores a poner en la grafica a exportar
     * @param nombre de la magnitud
     * @param uri donde guardar las imagenes
     * @return la strign de la uri de la imagen
     * @throws IOException si no consigue guardar la imagen
     */
    public String generarPng(List<Double> valores, String nombre,String uri, String municipio) throws IOException {

        String municipioNombre = em.getCodigoMunicipio().get(Integer.parseInt(municipio));
        crearCarpeta(uri+File.separator+"resources-"+municipioNombre);

        String path = uri+File.separator+"resources-"+municipioNombre+File.separator+nombre+".png";

        if (nombre.equalsIgnoreCase("precipitacion")) {
            HistogramDataset dataset = new HistogramDataset();
            double[] prueba = new double[valores.size()];
            for (int i = 0; i < valores.size(); i++) {
                prueba[i] = valores.get(i);
            }
            dataset.addSeries("key", prueba, 50);

            JFreeChart histograma = ChartFactory.createHistogram("Histograma Precipitación",
                    "Dias",
                    "Magnitud",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
            ChartUtilities.saveChartAsPNG(new File(path), histograma, 450, 400);
        } else {
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
            ChartUtilities.saveChartAsPNG(new File(path), chart, 450, 400);
        }
            return path;
        }

    private void crearCarpeta(String uri){
        File dir = new File(uri);
        if (!dir.exists()){
            dir.mkdirs();
        }
    }
}

