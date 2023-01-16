package mulak.piotr.cities;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class AddCityGui extends VerticalLayout {

    private TextField textFieldId;
    private TextField textFieldName;
    private TextField textFieldCountry;
    private TextField textFieldPopulation;
    private TextField textFieldArea;
    private Button button;
    private CityDao cityDao;
    @Autowired
    public AddCityGui(CityDao cityDao) {
        this.textFieldId = new TextField("Id");
        this.textFieldName = new TextField("City name");
        this.textFieldCountry = new TextField("Country");
        this.textFieldPopulation = new TextField("Population");
        this.textFieldArea = new TextField("Area");
        this.button = new Button("Save", new Icon(VaadinIcon.PLUS_CIRCLE));
        this.cityDao = cityDao;

        button.addClickListener(buttonClickEvent -> {
            City city = new City(Long.parseLong(textFieldId.getValue()), textFieldName.getValue(),
                    textFieldCountry.getValue(), Integer.parseInt(textFieldPopulation.getValue()),
                    Integer.parseInt(textFieldArea.getValue()));
            cityDao.save(city);
        });

        add(textFieldId, textFieldName, textFieldCountry, textFieldPopulation, textFieldArea, button);
    }
}
