package mulak.piotr.cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CityDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(City city) {
        String sql = "INSERT INTO City VALUES(?,?,?,?,?);";
        jdbcTemplate.update(sql, new Object[] {
                city.getId(),
                city.getName(),
                city.getCountry(),
                city.getPopulation(),
                city.getArea()
        });
    }

    public List<Map<String, Object>> showByCountry(String country) {
        String sql = "SELECT * FROM City WHERE country LIKE ?";
        return jdbcTemplate.queryForList(sql, new Object[] {country} );
    }

    public List<Map<String, Object>> showByName(String name) {
        String sql = "SELECT * FROM City WHERE name LIKE ?";
        return jdbcTemplate.queryForList(sql, new Object[] {name} );
    }

    public List<Map<String, Object>> showGreaterThen(int population) {
        String sql = "SELECT * FROM City WHERE population > ?";
        return jdbcTemplate.queryForList(sql, new Object[] {population} );
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
        /*first time init - create table
        String sql = "CREATE TABLE City(city_id int, name varchar(255), country varchar(255), population int, area int);";
        jdbcTemplate.update(sql);
         */
        // add some cities on start
        //save(new City(1, "Wrocław", "Poland", 650000, 292));
        //save(new City(2, "Warszawa", "Poland", 1765000, 517));
    }
}
