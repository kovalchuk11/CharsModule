import be.ceau.chart.LineChart;
import be.ceau.chart.color.Color;
import be.ceau.chart.data.LineData;
import be.ceau.chart.dataset.LineDataset;
import be.ceau.chart.options.elements.Fill;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import pojo.Parent;
import stat.Place;

import java.util.List;

public class JsonCreator {
    private static final String FORMAT_TYPE = "png";
    private static final String SICK_LABEL = "Хворих";
    private static final String DEAD_LABEL = "Смертей";
    private static final int HEIGHT = 200;
    private static final int WIDTH = 300;

    public String createJson(List<Place> placesList) {
        Parent parent = new Parent();
        parent.setFormat(FORMAT_TYPE);
        parent.setHeight(HEIGHT);
        parent.setWidth(WIDTH);

        LineChart chart = new LineChart();

        LineDataset sickCount = setCommonlySettings();
        sickCount.setLabel(SICK_LABEL);
        sickCount.setBorderColor(Color.BLUE);

        LineDataset deadCount = setCommonlySettings();
        deadCount.setLabel(DEAD_LABEL);
        deadCount.setBorderColor(Color.RED);

        LineData data = new LineData();

        for (Place place : placesList) {
            sickCount.addData(place.getSick());
            deadCount.addData(place.getDead());
            data.addLabel(place.getData());
        }

        data.addDataset(sickCount).addDataset(deadCount);
        chart.setData(data);
        parent.setChart(chart);

        return toJson(parent);
    }

    private LineDataset setCommonlySettings() {
        return new LineDataset().addPointRadius(1)
                .addPointHitRadius(10)
                .setSpanGaps(false)
                .setFill(new Fill(false));
    }

    public String toJson(Parent parent) {
        try {
            return WRITER.writeValueAsString(parent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static final ObjectWriter WRITER = new ObjectMapper()
            .writerWithDefaultPrettyPrinter()
            .forType(Parent.class);
}
