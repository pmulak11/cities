package mulak.piotr.cities;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


@Route
@StyleSheet("/css/style.css")
public class ShowGui extends VerticalLayout {

    private TextField textFieldCountry;
    private TextField textFieldName;
    private TextField textFieldGreaterThen;
    private TextArea textArea;
    private Button buttonShowByCountry;
    private Button buttonShowByName;
    private Button buttonShowGreaterThen;
    private CityDao cityDao;
    @Autowired
    public ShowGui(CityDao cityDao) {
        this.textFieldCountry = new TextField("Country:");
        this.textFieldName = new TextField("Name:");
        this.textFieldGreaterThen = new TextField("Greater then:");
        this.buttonShowByCountry = new Button("Show by Country", new Icon(VaadinIcon.GLOBE));
        this.buttonShowByName = new Button("Show by City name", new Icon(VaadinIcon.BUILDING));
        this.buttonShowGreaterThen = new Button("Show Cities greater then", new Icon(VaadinIcon.ANGLE_RIGHT));
        this.textArea = new TextArea();

        this.cityDao = cityDao;

        buttonShowByCountry.addClickListener(buttonClickEvent -> {
            List<Map<String, Object>> maps = cityDao.showByCountry(textFieldCountry.getValue());
            textArea.setValue(maps.toString());
        });

        buttonShowByName.addClickListener(buttonClickEvent -> {
            List<Map<String, Object>> maps = cityDao.showByName(textFieldName.getValue());
            textArea.setValue(maps.toString());
        });

        buttonShowGreaterThen.addClickListener(buttonClickEvent -> {
            List<Map<String, Object>> maps = cityDao.showGreaterThen(Integer.parseInt(textFieldGreaterThen.getValue()));
            textArea.setValue(maps.toString());
        });


        add(textFieldCountry, buttonShowByCountry, textFieldName, buttonShowByName, textFieldGreaterThen,
                buttonShowGreaterThen, textArea);
    }
}
