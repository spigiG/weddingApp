package com.wed.wedding.database;

import com.wed.wedding.FoodType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FoodTypeDao {
    private JdbcTemplate jdbcTemplate;

    public FoodTypeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createFoodType(int typeId, String type) {
        jdbcTemplate.update("insert into menutypes(type_id, name) values (?, ?)", typeId, type);
    }

    private static class FoodTypeRowMapper implements RowMapper<FoodType> {
        @Override
        public FoodType mapRow(ResultSet resultSet, int i) throws SQLException {
            int typeId = resultSet.getInt("type_id");
            String type = resultSet.getString("name");
            FoodType foodType = new FoodType(typeId, type);
            return foodType;
        }
    }

    public List<FoodType> listFoodTypes() {
        return jdbcTemplate.query("select type_id, name from menutypes where type_id > 0", new FoodTypeRowMapper());
    }
}
