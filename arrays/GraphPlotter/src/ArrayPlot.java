import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.Color;
import java.io.File;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;


public class ArrayPlot {

    // Find the next permutation breakpoint from the right
    private static int findBreakpoint(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        int[] array = {2, 1, 5, 4, 3, 0, 0};
        int n = array.length;

        // Main array plot
        XYSeries arraySeries = new XYSeries("Array Values");
        for (int i = 0; i < n; i++) {
            arraySeries.add(i, array[i]);
        }

        // Breakpoint marker
        XYSeries breakpointSeries = new XYSeries("Breakpoint");
        int bp = findBreakpoint(array);
        if (bp != -1) {
            breakpointSeries.add(bp, array[bp]);
        }

        // Combine series
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(arraySeries);
        dataset.addSeries(breakpointSeries);

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Array Plot with Breakpoint",
                "Index",
                "Value",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        // Customize colors
        // Customize colors and shapes
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Series 0: Array Line
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        // Series 1: Red Breakpoint Dot
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);
        Shape circle = new Ellipse2D.Double(-4, -4, 8, 8); // a larger red dot
        renderer.setSeriesShape(1, circle);

        plot.setRenderer(renderer);

        // Save as PNG
        ChartUtils.saveChartAsPNG(new File("array_plot.png"), chart, 800, 600);
        System.out.println("✅ array_plot.png saved successfully!");
    }
}
