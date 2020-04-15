package pojo;

import be.ceau.chart.LineChart;

public class Parent {
    private LineChart chart;
    private int height;
    private int width;
    private String format;

    public void setChart(LineChart chart) {
        this.chart = chart;
    }

    public LineChart getChart() {
        return chart;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
