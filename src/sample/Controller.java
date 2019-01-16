package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private TextField aField, fField, fiField;

    @FXML
    private TextField pA1, pA2, pA3, pA4, pA5;
    @FXML
    private TextField pF1, pF2, pF3, pF4, pF5;
    @FXML
    private TextField pFi1, pFi2, pFi3, pFi4, pFi5;

    @FXML
    private CheckBox of1, of2, of3, of4, of5;

    @FXML
    private LineChart harmLinaChart, polyLineChart;


    @FXML
    public void onClickGoBtn() {

        int A = Integer.parseInt(this.aField.getText());
        int F = Integer.parseInt(this.fField.getText());
        int Fi = Integer.parseInt(this.fiField.getText());

        int N = 1024;

        harmLinaChart.setCreateSymbols(false);
        XYChart.Series series1 = new XYChart.Series();
        for (int n = 1; n <= 2 * N - 1; n++) {
            series1.getData().add(new XYChart.Data(n, A * Math.sin(2 * Math.PI * F * n / N + (double) Fi / 180 * Math.PI)));
        }
        harmLinaChart.getData().add(series1);
    }


    public void clearBtnClick(MouseEvent mouseEvent) {
        harmLinaChart.getData().clear();
    }

    public void polyGo(MouseEvent mouseEvent) {

        int pA1 = Integer.parseInt(this.pA1.getText());
        int pA2 = Integer.parseInt(this.pA2.getText());
        int pA3 = Integer.parseInt(this.pA3.getText());
        int pA4 = Integer.parseInt(this.pA4.getText());
        int pA5 = Integer.parseInt(this.pA5.getText());

        int pF1 = Integer.parseInt(this.pF1.getText());
        int pF2 = Integer.parseInt(this.pF2.getText());
        int pF3 = Integer.parseInt(this.pF3.getText());
        int pF4 = Integer.parseInt(this.pF4.getText());
        int pF5 = Integer.parseInt(this.pF5.getText());

        int pFi1 = Integer.parseInt(this.pFi1.getText());
        int pFi2 = Integer.parseInt(this.pFi2.getText());
        int pFi3 = Integer.parseInt(this.pFi3.getText());
        int pFi4 = Integer.parseInt(this.pFi4.getText());
        int pFi5 = Integer.parseInt(this.pFi5.getText());


        polyLineChart.setCreateSymbols(false);
        XYChart.Series series1 = new XYChart.Series();

        int N = 1024;
        for (int n = 1; n <= 2*N - 1; n++) {
            double y = 0;

            if (of1.isSelected()) {
                y += pA1 * Math.sin(2 * Math.PI * pF1 * n / N + (double) pFi1 / 180 * Math.PI);
            }
            if (of2.isSelected()) {
                y += pA2 * Math.sin(2 * Math.PI * pF2 * n / N + (double) pFi2 / 180 * Math.PI);
            }
            if (of3.isSelected()) {
                y += pA3 * Math.sin(2 * Math.PI * pF3 * n / N + (double) pFi3 / 180 * Math.PI);
            }
            if (of4.isSelected()) {
                y += pA4 * Math.sin(2 * Math.PI * pF4 * n / N + (double) pFi4 / 180 * Math.PI);
            }
            if (of5.isSelected()) {
                y += pA5 * Math.sin(2 * Math.PI * pF5 * n / N + (double) pFi5 / 180 * Math.PI);
            }

            series1.getData().add(new XYChart.Data(n, y));
        }


        polyLineChart.getData().add(series1);
    }

    public void polyClear(MouseEvent mouseEvent) {
        polyLineChart.getData().clear();
    }
}
