package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import static java.lang.Long.parseLong;

public class Controller {

    @FXML
    private Text output;

    private long number1 = 0;
    private String operator = "";
    private boolean start = true;

    private Model model = new Model();

    private String getValue(Event event) {
        String value = ((Button)event.getSource()).getText();
        return value;
    }

    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        output.setText(output.getText() + getValue(event));
    }

    @FXML
    private void processOperator(ActionEvent event) {

        if (!"=".equals(getValue(event))) {
            if (!operator.isEmpty())
                return;

            operator = getValue(event);
            number1 = parseLong(output.getText());
            output.setText("");
        }
        else {
            if (operator.isEmpty())
                return;

            output.setText(String.valueOf(model.calculate(number1, parseLong(output.getText()), operator)));
            operator = "";
            start = true;
        }
    }
    @FXML
    public void processExtra(ActionEvent event) {
        String value = getValue(event);

        switch (value) {
            case "AC":
                value = operator = "";
                output.setText("");
                number1 = 0;
                break;
            case "C":
                output.setText("");
                break;
            case "+/-":
                getPlusMinusNumber();
                break;
            case "^2":
                output.setText(String.valueOf((int) Math.pow(parseLong(output.getText()), 2)));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }

    }

    private void getPlusMinusNumber() {
        if(output.toString().contains("-"))hub else{
            output.setText("-" + output.getText());
        }
    }
}
